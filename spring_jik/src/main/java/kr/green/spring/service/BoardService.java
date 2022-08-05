package kr.green.spring.service;

import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.MemberVO;

public interface BoardService {

	void insertBoard(BoardVO board, MemberVO user);

}
