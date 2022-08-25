package kr.green.springtest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springtest.pagination.Criteria;
import kr.green.springtest.pagination.PageMaker;
import kr.green.springtest.service.BoardService;
import kr.green.springtest.vo.BoardVO;
import kr.green.springtest.vo.CommentVO;
import kr.green.springtest.vo.FileVO;
import kr.green.springtest.vo.LikesVO;
import kr.green.springtest.vo.MemberVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv, Criteria cri){
		cri.setPerPageNum(2);
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		int totalCount = boardService.getTotalCount(cri);
		PageMaker pm = new PageMaker(totalCount, 5, cri);
		mv.addObject("pm", pm);
		mv.addObject("list", list);
    mv.setViewName("/board/list");
    return mv;
	}
	@RequestMapping(value="/board/select/{bd_num}", method=RequestMethod.GET)
	public ModelAndView boardSelectGet(ModelAndView mv,
			@PathVariable("bd_num")int bd_num, HttpSession session){
		boardService.updateViews(bd_num);
		BoardVO board = boardService.getBoard(bd_num);
		
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		LikesVO likes = boardService.getLikes(bd_num, user);
		
		ArrayList<FileVO> fileList = boardService.getFileList(bd_num);
		
		mv.addObject("fileList", fileList);
		mv.addObject("likes", likes);
		mv.addObject("board", board);
    mv.setViewName("/board/select");
    return mv;
	}
	@RequestMapping(value="/board/insert", method=RequestMethod.GET)
	public ModelAndView boardInsertGet(ModelAndView mv){
		mv.setViewName("/board/insert");
    return mv;
	}
	@RequestMapping(value="/board/insert", method=RequestMethod.POST)
	public ModelAndView boardInsertPost(ModelAndView mv, BoardVO board, HttpSession session
		,MultipartFile[] files){
		MemberVO user = (MemberVO)session.getAttribute("user");
		boardService.insertBoard(board,user, files);
		mv.setViewName("redirect:/board/list");
    return mv;
	}
	@RequestMapping(value="/board/update/{bd_num}", method=RequestMethod.GET)
	public ModelAndView boardUpdateGet(ModelAndView mv,
			@PathVariable("bd_num")int bd_num){
		BoardVO board = boardService.getBoard(bd_num);
		ArrayList<FileVO> fileList = boardService.getFileList(bd_num);
		mv.addObject("fileList",fileList);
		mv.addObject("board",board);
    mv.setViewName("/board/update");
    return mv;
	}
	@RequestMapping(value="/board/update/{bd_num}", method=RequestMethod.POST)
	public ModelAndView boardUpdatePost(ModelAndView mv,
			@PathVariable("bd_num")int bd_num, BoardVO board, HttpSession session,
			MultipartFile []files, int[] nums) {
		MemberVO user = (MemberVO) session.getAttribute("user");
		boardService.updateBoard(board, user, files, nums);
    mv.setViewName("redirect:/board/select/"+bd_num);
    return mv;
	}
	@RequestMapping(value="/board/delete/{bd_num}", method=RequestMethod.GET)
	public ModelAndView boardDeleteGet(ModelAndView mv,
			@PathVariable("bd_num")int bd_num, HttpSession session){
		MemberVO user = (MemberVO) session.getAttribute("user");
		boardService.deleteBoard(bd_num, user);
    mv.setViewName("redirect:/board/list");
    return mv;
	}
	@RequestMapping(value="/check/likes")
	@ResponseBody
	public Map<Object,Object> checkLikse(@RequestBody LikesVO likes, 
			HttpSession session){
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		MemberVO user = (MemberVO)session.getAttribute("user");
		//state : 1, -1, 10, -10, 0
    String state = boardService.getLikesState(likes, user);
    map.put("state", state);
    return map;
	}
	
	@RequestMapping(value="/ajax/comment/insert")
	@ResponseBody
	public Map<Object,Object> ajaxCommentInsert(
			@RequestBody CommentVO comment,HttpSession session){
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = boardService.insertComment(comment,user);
		map.put("res", res);
    return map;
	}
	@RequestMapping(value="/ajax/comment/list/{bd_num}")
	@ResponseBody
	public Map<Object,Object> ajaxCommentInsert(
			@RequestBody Criteria cri, @PathVariable("bd_num") int bd_num){
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		ArrayList<CommentVO> list = boardService.getCommentList(bd_num, cri);
		int totalCount = boardService.getCommentTotalCount(bd_num);
		PageMaker pm = new PageMaker(totalCount, 5, cri);
		map.put("pm", pm);
		map.put("list", list);
    return map;
	}
	@RequestMapping(value="/ajax/comment/delete")
	@ResponseBody
	public Map<Object,Object> ajaxCommentDelete(
			@RequestBody CommentVO comment,HttpSession session){
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = boardService.deleteComment(comment, user);
		map.put("res", res);
    return map;
	}
	@RequestMapping(value="/ajax/comment/update")
	@ResponseBody
	public Map<Object,Object> ajaxCommentUpdate(
			@RequestBody CommentVO comment,HttpSession session){
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = boardService.updateComment(comment,user);
		map.put("res", res);
    return map;
	}
}
