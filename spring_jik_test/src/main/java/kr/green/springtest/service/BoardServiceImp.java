package kr.green.springtest.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.springtest.dao.BoardDAO;
import kr.green.springtest.vo.BoardVO;
import kr.green.springtest.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{

	@Autowired
	BoardDAO boardDao;

	@Override
	public ArrayList<BoardVO> getBoardList() {
		return boardDao.selectBoardList();
	}

	@Override
	public BoardVO getBoard(int bd_num) {
		return boardDao.selectBoard(bd_num);
	}

	@Override
	public void updateViews(int bd_num) {
		boardDao.updateViews(bd_num);
	}

	@Override
	public void insertBoard(BoardVO board, MemberVO user) {
		if(board == null)
			return ;
		if(user == null || user.getMe_id() == null)
			return ;
		board.setBd_me_id(user.getMe_id());
		boardDao.insertBoard(board);
	}

	@Override
	public void updateBoard(BoardVO board, MemberVO user) {
		if(board == null || user == null)
			return ;
		/*  - 게시글 번호에 맞는 게시글 정보를 가져옴
		 *  - 게시글이 없으면 종료(삭제된 게시글도 고려)
		 *  - 게시글의 작성자와 회원 아이디가 같은지 확인하여 다르면 종료
		 *  - 보드다오에게 게시글 정보를 주면서 수정하라고 시킴
		 * */
		//이 때 가져온 게시글은 삭제된 게시글도 포함
		BoardVO dbBoard = boardDao.selectBoard(board.getBd_num());
		if(dbBoard == null || !dbBoard.getBd_del().equals("N"))
			return;
		
		if(!dbBoard.getBd_me_id().equals(user.getMe_id()))
			return;
		
		boardDao.updateBoard(board);
	}

	@Override
	public void deleteBoard(int bd_num, MemberVO user) {
		if(user == null)
			return;
		BoardVO dbBoard = boardDao.selectBoard(bd_num);
		
		if(dbBoard == null || !dbBoard.getBd_del().equals("N"))
			return;
		
		if(!dbBoard.getBd_me_id().equals(user.getMe_id()))
			return;
		dbBoard.setBd_del("Y");
		boardDao.updateBoard(dbBoard);
	}
}
