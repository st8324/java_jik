package kr.green.lg.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.lg.dao.BoardDAO;
import kr.green.lg.pagination.Criteria;
import kr.green.lg.vo.BoardVO;
import kr.green.lg.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService {
	@Autowired
	BoardDAO boardDao;

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user, String bd_type) {
		if(board == null || 
				board.getBd_title() == null || 
				board.getBd_title().length() == 0 ||
				board.getBd_content() == null)
			return false;
		if(user == null)
			return false;
		board.setBd_me_email(user.getMe_email());
		board.setBd_type(bd_type);
		return boardDao.insertBoard(board) == 1 ? true : false;
	}

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri, String bd_type) {
		if(bd_type == null)
			return null;
		if(cri == null)
			cri = new Criteria();
		
		return boardDao.selectBoardList(cri,bd_type);
	}

	@Override
	public int getTotalCount(Criteria cri, String bd_type) {
		if(bd_type == null)
			return 0;
		if(cri == null)
			cri = new Criteria();
		return boardDao.selectBoardTotalCount(cri,bd_type);
	}

	@Override
	public boolean deleteBoard(Integer bd_num, MemberVO user) {
		if(bd_num == null || user == null)
			return false;
		BoardVO board = boardDao.selectBoard(bd_num);
		if(board == null)
			return false;
		if(user.getMe_authority() != 10 && !board.getBd_me_email().equals(user.getMe_email()))
			return false;
		
		return boardDao.deleteBoard(bd_num) == 1 ? true : false;
	}

	@Override
	public String getDeleteRedirectURL(String bd_type) {
		if(bd_type.equals("NOTICE"))
			return "/lg/admin/notice/list";
		else if(bd_type.equals("QNA"))
			return "";
		return null;
	}
}
