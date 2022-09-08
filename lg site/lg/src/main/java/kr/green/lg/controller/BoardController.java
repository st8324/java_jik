package kr.green.lg.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.lg.pagination.Criteria;
import kr.green.lg.pagination.PageMaker;
import kr.green.lg.service.BoardService;
import kr.green.lg.service.MessageService;
import kr.green.lg.vo.BoardVO;
import kr.green.lg.vo.FileVO;
import kr.green.lg.vo.MemberVO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	@Autowired
	MessageService messageService;
	
	@RequestMapping(value = "/board/delete", method = RequestMethod.POST)
	public ModelAndView boardDeletePost(ModelAndView mv, Integer bd_num, HttpSession session,
			HttpServletResponse response, String bd_type) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		String redirectUrl = boardService.getDeleteRedirectURL(bd_type, bd_num);
		boolean res = boardService.deleteBoard(bd_num, user);
		
		if(res)
			messageService.message(response, "게시글이 삭제되었습니다.", redirectUrl);
		else
			messageService.message(response, "게시글 삭제에 실패했습니다.", redirectUrl);
		return mv;
	}
	@RequestMapping(value = "/board/select", method = RequestMethod.GET)
	public ModelAndView boardSelectGet(ModelAndView mv, Integer bd_num) {
		BoardVO board = boardService.getBoard(bd_num);
		mv.addObject("bo", board);
		mv.setViewName("/board/select");
		return mv;
	}
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv, String bd_type, Criteria cri) {
		ArrayList<BoardVO> list = boardService.getBoardList(cri, bd_type);
		int totalCount = boardService.getTotalCount(cri, bd_type);
		PageMaker pm = new PageMaker(totalCount, 5, cri);
		
		mv.addObject("pm", pm);
		mv.addObject("list", list);
		mv.addObject("bd_type", bd_type);
		mv.setViewName("/board/list");
		return mv;
	}
	@RequestMapping(value = "/board/insert", method = RequestMethod.GET)
	public ModelAndView boardInsertGet(ModelAndView mv) {
		mv.setViewName("/board/insert");
		return mv;
	}
	@RequestMapping(value = "/board/insert", method = RequestMethod.POST)
	public ModelAndView boardSelectGet(ModelAndView mv, BoardVO board, HttpSession session, 
			MultipartFile []files, HttpServletResponse response) {
		MemberVO user = (MemberVO) session.getAttribute("user");
		boolean res = boardService.insertBoard(board, user, files);
		if(res)
			messageService.message(response, "게시글을 등록했습니다.", "/lg/product/select?pr_code="+board.getBd_pr_code());
		else
			messageService.message(response, "게시글 등록에 실패했습니다.", "/lg/product/select?pr_code="+board.getBd_pr_code());
		return mv;
	}
	
	@RequestMapping(value = "/board/update", method = RequestMethod.GET)
	public ModelAndView boardUpdateGet(ModelAndView mv, Integer bd_num, HttpSession session,
			HttpServletResponse response) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		BoardVO board = boardService.getBoard(bd_num);
		ArrayList<FileVO> fileList = boardService.getFileList(bd_num);
		mv.addObject("fileList", fileList);
		mv.addObject("bo", board);
		if(boardService.isWriter(board,user)) {
			mv.setViewName("/board/update");
		}else {
			messageService.message(response, "", "/lg/board/select?bd_num="+bd_num);
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/board/update", method = RequestMethod.POST)
	public ModelAndView boardUpdatePost(ModelAndView mv, BoardVO board, HttpSession session, 
			MultipartFile []files, HttpServletResponse response, int[]nums) {
		MemberVO user = (MemberVO) session.getAttribute("user");
		boolean res = boardService.updateBoard(board, user, files, nums);
		if(res)
			messageService.message(response, "게시글을 등록했습니다.", "/lg/product/select?pr_code="+board.getBd_pr_code());
		else
			messageService.message(response, "게시글 등록에 실패했습니다.", "/lg/product/select?pr_code="+board.getBd_pr_code());
		return mv;
	}
	@RequestMapping(value="/qna/list", method = RequestMethod.POST)
	@ResponseBody
	public Map<Object,Object> qnaList(@RequestBody Criteria cri) {
		HashMap<Object,Object> map = new HashMap<Object, Object>();
		ArrayList<BoardVO> list = boardService.getBoardList(cri, "QNA");
		int totalCount = boardService.getTotalCount(cri, "QNA");
		PageMaker pm = new PageMaker(totalCount, 5, cri);
		map.put("pm", pm);
		map.put("list", list);
		return map;
	}
}
