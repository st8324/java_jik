package kr.green.lg.service;

import java.util.ArrayList;

import kr.green.lg.pagination.Criteria;
import kr.green.lg.vo.BoardVO;
import kr.green.lg.vo.MemberVO;

public interface BoardService {

	boolean insertBoard(BoardVO board, MemberVO user, String bd_type);

	ArrayList<BoardVO> getBoardList(Criteria cri, String bd_type);

	int getTotalCount(Criteria cri, String bd_type);

	boolean deleteBoard(Integer bd_num, MemberVO user);

	String getDeleteRedirectURL(String bd_type);

	BoardVO getBoard(Integer bd_num);

	boolean updateBoard(BoardVO board, MemberVO user);

}
