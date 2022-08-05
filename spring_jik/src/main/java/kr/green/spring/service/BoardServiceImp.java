package kr.green.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.BoardDAO;
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
	public ArrayList<BoardVO> getBoardList() {
		return boardDao.selectBoardList();
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

	
}
