package kr.green.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.CommentVO;
import kr.green.spring.vo.LikesVO;

public interface BoardDAO {

	void insertBoard(@Param("b")BoardVO board);

	ArrayList<BoardVO> selectBoardList(@Param("cri")Criteria cri);

	void updateViews(@Param("bd_num")Integer bd_num);

	BoardVO selectBoard(@Param("bd_num")Integer bd_num);

	void updateBoard(@Param("b")BoardVO board);

	void deleteBoard(@Param("bd_num")Integer bd_num, @Param("bd_del")char del);

	int selectTotalCount(@Param("cri")Criteria cri);

	LikesVO selectLikes(@Param("li")LikesVO likes);

	void insertLikes(@Param("li")LikesVO likes);

	void updateLikes(@Param("li")LikesVO likes);

	void updateBoardLikes(@Param("bd_num")int li_bd_num);

	void insertComment(@Param("co")CommentVO comment);

	ArrayList<CommentVO> selectCommentList(@Param("co_bd_num")int co_bd_num, @Param("cri")Criteria cri);

	int selectTotalCountComment(@Param("co_bd_num")int co_bd_num);

	CommentVO selectComment(@Param("co_num")int co_num);

	void deleteComment(@Param("co_num")int co_num);

	void updateComment(@Param("co")CommentVO comment);

}
