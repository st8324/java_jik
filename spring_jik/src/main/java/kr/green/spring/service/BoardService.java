package kr.green.spring.service;

import java.util.ArrayList;

import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.MemberVO;

public interface BoardService {

	void insertBoard(BoardVO board, MemberVO user);

	ArrayList<BoardVO> getBoardList();

}
