package kr.green.spring.service;

import java.util.ArrayList;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.MemberVO;

public interface BoardService {

	void insertBoard(BoardVO board, MemberVO user);

	ArrayList<BoardVO> getBoardList(Criteria cri);

	void updateViews(Integer bd_num);

	BoardVO getBoard(Integer bd_num);

	void updateBoard(BoardVO board, MemberVO user);

	void deleteBoard(Integer bd_num, MemberVO user);

	int getTotalCount();

}
