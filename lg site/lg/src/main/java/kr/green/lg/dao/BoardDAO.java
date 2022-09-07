package kr.green.lg.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.lg.pagination.Criteria;
import kr.green.lg.vo.BoardVO;

public interface BoardDAO {

	int insertBoard(BoardVO board);

	ArrayList<BoardVO> selectBoardList(@Param("cri")Criteria cri, @Param("bd_type")String bd_type);

	int selectBoardTotalCount(@Param("cri")Criteria cri, @Param("bd_type")String bd_type);

}
