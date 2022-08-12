package kr.green.springtest.service;

import java.util.ArrayList;

import kr.green.springtest.pagination.Criteria;
import kr.green.springtest.vo.BoardVO;
import kr.green.springtest.vo.MemberVO;

public interface BoardService {

	ArrayList<BoardVO> getBoardList(Criteria cri);

	BoardVO getBoard(int bd_num);

	void updateViews(int bd_num);

	void insertBoard(BoardVO board, MemberVO user);

	void updateBoard(BoardVO board, MemberVO user);

	void deleteBoard(int bd_num, MemberVO user);

	int getTotalCount(Criteria cri);

}
