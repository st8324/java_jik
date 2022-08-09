package kr.green.springtest.service;

import java.util.ArrayList;

import kr.green.springtest.vo.BoardVO;

public interface BoardService {

	ArrayList<BoardVO> getBoardList();

	BoardVO getBoard(int bd_num);

	void updateViews(int bd_num);

}
