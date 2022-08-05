package kr.green.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.BoardVO;

public interface BoardDAO {

	void insertBoard(@Param("b")BoardVO board);

	ArrayList<BoardVO> selectBoardList();

	void updateViews(@Param("bd_num")Integer bd_num);

	BoardVO selectBoard(@Param("bd_num")Integer bd_num);

}
