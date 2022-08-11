package kr.green.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.BoardDAO;
import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDAO boardDao;

	@Override
	public void insertBoard(BoardVO board, MemberVO user) {
		if(board == null || board.getBd_title() == null || board.getBd_content() == null)
			return;
		//제목에 공백만 있는 경우
		if(board.getBd_title().trim().length() == 0)
			return;
		//내용에 공백만 있는 경우
		if(board.getBd_content().trim().length() == 0)
			return;
		//로그인 안한 경우
		if(user == null || user.getMe_id() == null)
			return;
		
		//게시글 작성자로 회원 아이디를 저장
		board.setBd_me_id(user.getMe_id());
		boardDao.insertBoard(board);
	}

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		if(cri == null)
			return null;
		return boardDao.selectBoardList(cri);
	}

	@Override
	public void updateViews(Integer bd_num) {
		if(bd_num == null)
			return;
		boardDao.updateViews(bd_num);
	}

	@Override
	public BoardVO getBoard(Integer bd_num) {
		if(bd_num == null)
			return null;
		return boardDao.selectBoard(bd_num);
	}

	@Override
	public void updateBoard(BoardVO board, MemberVO user) {
		if(user == null)
			return;
		
		if(board == null)
			return;
		
		//제목에 공백만 있는 경우
		if(board.getBd_title().trim().length() == 0)
			return;
		//내용에 공백만 있는 경우
		if(board.getBd_content().trim().length() == 0)
			return;
		
		BoardVO dbBoard = boardDao.selectBoard(board.getBd_num());
		
		//작성자와 로그인한 회원이 다르면
		if(!user.getMe_id().equals(dbBoard.getBd_me_id()))
			return;
		
		boardDao.updateBoard(board);
		
	}

	@Override
	public void deleteBoard(Integer bd_num, MemberVO user) {
		if(bd_num == null)
			return;
		if(user == null)
			return;
		
		BoardVO board = boardDao.selectBoard(bd_num);
		//해당 게시글이 없으면 
		if(board == null)
			return;
		
		//삭제하려는 게시글의 작성자와 회원 아이디가 다르고, 관리자가 아닐때
		if(!board.getBd_me_id().equals(user.getMe_id()) && user.getMe_authority() != 10)
			return;
		char del = 'Y';
		if(user.getMe_authority() == 10)
			del = 'A';
		boardDao.deleteBoard(bd_num, del);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		if(cri == null)
			return 0;
		return boardDao.selectTotalCount(cri);
	}
}
