package kr.green.springtest.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.springtest.pagination.Criteria;
import kr.green.springtest.vo.BoardVO;
import kr.green.springtest.vo.CommentVO;
import kr.green.springtest.vo.FileVO;
import kr.green.springtest.vo.LikesVO;

public interface BoardDAO {

	ArrayList<BoardVO> selectBoardList(@Param("cri")Criteria cri);

	BoardVO selectBoard(@Param("bd_num")int bd_num);

	void updateViews(@Param("bd_num")int bd_num);

	void insertBoard(@Param("b")BoardVO board);

	void updateBoard(@Param("b")BoardVO board);

	int selectTotalCount(@Param("cri")Criteria cri);

	LikesVO selectLikes(@Param("li")LikesVO likes);

	void insertLikes(@Param("li")LikesVO likes);

	void updateLikes(@Param("li")LikesVO dbLikes);

	void updateBoardLikes(@Param("bd_num")int li_bd_num);

	void insertComment(@Param("co")CommentVO comment);

	ArrayList<CommentVO> selectCommetList(@Param("bd_num")int bd_num, @Param("cri")Criteria cri);

	int selectCommentTotalCount(@Param("bd_num")int bd_num);

	CommentVO selectComment(@Param("co_num")int co_num);

	void deleteComment(@Param("co_num")int co_num);

	void updateComment(@Param("co")CommentVO comment);

	void insertFile(@Param("fi")FileVO file);

}
