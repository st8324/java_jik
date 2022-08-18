package kr.green.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.BoardDAO;
import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.CommentVO;
import kr.green.spring.vo.LikesVO;
import kr.green.spring.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDAO boardDao;

	@Override
	public void insertBoard(BoardVO board, MemberVO user) {
		if(board == null || board.getBd_title() == null || board.getBd_content() == null)
			return;
		//제목에 공백만 있는 경우
		if(board.getBd_title().trim().length() == 0)
			return;
		//내용에 공백만 있는 경우
		if(board.getBd_content().trim().length() == 0)
			return;
		//로그인 안한 경우
		if(user == null || user.getMe_id() == null)
			return;
		
		//답글인 경우 순서를 업데이트
		if(board.getBd_ori_num() != 0)
			boardDao.updateBoardOrder(board);
		
		//게시글 작성자로 회원 아이디를 저장
		board.setBd_me_id(user.getMe_id());
		boardDao.insertBoard(board);
		
	}

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		if(cri == null)
			return null;
		return boardDao.selectBoardList(cri);
	}

	@Override
	public void updateViews(Integer bd_num) {
		if(bd_num == null)
			return;
		boardDao.updateViews(bd_num);
	}

	@Override
	public BoardVO getBoard(Integer bd_num) {
		if(bd_num == null)
			return null;
		return boardDao.selectBoard(bd_num);
	}

	@Override
	public void updateBoard(BoardVO board, MemberVO user) {
		if(user == null)
			return;
		
		if(board == null)
			return;
		
		//제목에 공백만 있는 경우
		if(board.getBd_title().trim().length() == 0)
			return;
		//내용에 공백만 있는 경우
		if(board.getBd_content().trim().length() == 0)
			return;
		
		BoardVO dbBoard = boardDao.selectBoard(board.getBd_num());
		
		//작성자와 로그인한 회원이 다르면
		if(!user.getMe_id().equals(dbBoard.getBd_me_id()))
			return;
		
		boardDao.updateBoard(board);
		
	}

	@Override
	public void deleteBoard(Integer bd_num, MemberVO user) {
		if(bd_num == null)
			return;
		if(user == null)
			return;
		
		BoardVO board = boardDao.selectBoard(bd_num);
		//해당 게시글이 없으면 
		if(board == null)
			return;
		
		//삭제하려는 게시글의 작성자와 회원 아이디가 다르고, 관리자가 아닐때
		if(!board.getBd_me_id().equals(user.getMe_id()) && user.getMe_authority() != 10)
			return;
		char del = 'Y';
		if(user.getMe_authority() == 10)
			del = 'A';
		boardDao.deleteBoard(bd_num, del);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		if(cri == null)
			return 0;
		return boardDao.selectTotalCount(cri);
	}

	@Override
	public String updateLikes(LikesVO likes) {
		if(likes == null)
			return "";
		//조회 => 로그인한 사용자가 해당 게시물에 한 추천/비추천 정보를 가져옴
		LikesVO dbLikes = boardDao.selectLikes(likes);
		try {
			//해당 게시물에 추천/비추천이 처음이면 insert
			if(dbLikes == null) {
				boardDao.insertLikes(likes);
				return ""+likes.getLi_state();
			//이전 한적이 있으면 update
			}else {
				//이전 추천/비추천 상태와 현재 추천/비추천 상태가 다른 경우
				//이전 추천=> 현재 비추천, 이전 비추천=> 현재 추천
				if(dbLikes.getLi_state() != likes.getLi_state()) {
					dbLikes.setLi_state(likes.getLi_state());
				}
				//이전 추천/비추천 상태가 현재와 같은 경우 => 상태가 0
				//이전 추천=> 현재 추천, 이전 비추천=> 현재 비추천
				else {
					dbLikes.setLi_state(0);
				}
				boardDao.updateLikes(dbLikes);
				return likes.getLi_state()+(dbLikes.getLi_state() == 0 ? "0" : "");//-10, 10
			}
		}catch(Exception e) {}
		finally {
			boardDao.updateBoardLikes(likes.getLi_bd_num());
		}
		return "";
	}

	@Override
	public LikesVO getLikes(BoardVO board, MemberVO user) {
		if(board == null || board.getBd_del() != 'N')
			return null;
		
		if(user == null)
			return null;
		LikesVO likes = new LikesVO();
		likes.setLi_bd_num(board.getBd_num());
		likes.setLi_me_id(user.getMe_id());
		return boardDao.selectLikes(likes);
	}

	@Override
	public String insertComment(CommentVO comment, MemberVO user) {
		if(comment == null || comment.getCo_content() == null) 
			return "댓글 정보가 없습니다.";
		
		if(user == null)
			return "로그인한 회원만 댓글 작성이 가능합니다.";
		
		BoardVO board = boardDao.selectBoard(comment.getCo_bd_num()); 
		if( board == null || board.getBd_del() != 'N')
			return "잘못된 게시글입니다. 댓글을 작성할 수 없습니다.";
		
		comment.setCo_me_id(user.getMe_id());
		boardDao.insertComment(comment);
			
		return "댓글을 등록했습니다.";
	}

	@Override
	public ArrayList<CommentVO> getCommentList(int co_bd_num, Criteria cri) {
		if(cri == null)
			return null;
		return boardDao.selectCommentList(co_bd_num, cri);
	}

	@Override
	public int getTotalCountComment(int co_bd_num) {
		return boardDao.selectTotalCountComment(co_bd_num);
	}

	@Override
	public boolean deleteComment(CommentVO comment, MemberVO user) {
		if(comment == null || user == null)
			return false;
		
		//로그인한 사용자가 작성한 댓글인지 아닌지 확인하는 작업
		CommentVO dbComment = boardDao.selectComment(comment.getCo_num());
		if(dbComment == null || !dbComment.getCo_me_id().equals(user.getMe_id()))
			return false;
		
		boardDao.deleteComment(comment.getCo_num());
		
		return true;
	}

	@Override
	public boolean updateComment(CommentVO comment, MemberVO user) {
		if(comment == null || user == null)
			return false;
		
		//로그인한 사용자가 작성한 댓글인지 아닌지 확인하는 작업
		CommentVO dbComment = boardDao.selectComment(comment.getCo_num());
		if(dbComment == null || !dbComment.getCo_me_id().equals(user.getMe_id()))
			return false;
		
		boardDao.updateComment(comment);
		
		return true;
	}
}
