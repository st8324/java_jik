package kr.green.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVO;

public interface BoardDAO {

	void insertBoard(@Param("b")BoardVO board);

	ArrayList<BoardVO> selectBoardList(@Param("cri")Criteria cri);

	void updateViews(@Param("bd_num")Integer bd_num);

	BoardVO selectBoard(@Param("bd_num")Integer bd_num);

	void updateBoard(@Param("b")BoardVO board);

	void deleteBoard(@Param("bd_num")Integer bd_num, @Param("bd_del")char del);

	int selectTotalCount(@Param("cri")Criteria cri);

}
