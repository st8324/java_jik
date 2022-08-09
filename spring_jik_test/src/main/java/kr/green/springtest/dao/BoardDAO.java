package kr.green.springtest.dao;

import java.util.ArrayList;

import kr.green.springtest.vo.BoardVO;

public interface BoardDAO {

	ArrayList<BoardVO> selectBoardList();

}
