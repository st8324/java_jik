package kr.green.springtest.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.springtest.pagination.Criteria;
import kr.green.springtest.vo.BoardVO;

public interface BoardDAO {

	ArrayList<BoardVO> selectBoardList(@Param("cri")Criteria cri);

	BoardVO selectBoard(@Param("bd_num")int bd_num);

	void updateViews(@Param("bd_num")int bd_num);

	void insertBoard(@Param("b")BoardVO board);

	void updateBoard(@Param("b")BoardVO board);

	int selectTotalCount();

}
