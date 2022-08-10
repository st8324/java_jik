package kr.green.springtest.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springtest.service.BoardService;
import kr.green.springtest.vo.BoardVO;
import kr.green.springtest.vo.MemberVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv){
		ArrayList<BoardVO> list = boardService.getBoardList();
		mv.addObject("list", list);
    mv.setViewName("/board/list");
    return mv;
	}
	@RequestMapping(value="/board/select/{bd_num}", method=RequestMethod.GET)
	public ModelAndView boardSelectGet(ModelAndView mv,
			@PathVariable("bd_num")int bd_num){
		boardService.updateViews(bd_num);
		BoardVO board = boardService.getBoard(bd_num);
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
	public ModelAndView boardInsertPost(ModelAndView mv, BoardVO board, HttpSession session){
		MemberVO user = (MemberVO)session.getAttribute("user");
		boardService.insertBoard(board,user);
		mv.setViewName("redirect:/board/list");
    return mv;
	}
	@RequestMapping(value="/board/update/{bd_num}", method=RequestMethod.GET)
	public ModelAndView boardUpdateGet(ModelAndView mv,
			@PathVariable("bd_num")int bd_num){
		BoardVO board = boardService.getBoard(bd_num);
		mv.addObject("board",board);
    mv.setViewName("/board/update");
    return mv;
	}
	@RequestMapping(value="/board/update/{bd_num}", method=RequestMethod.POST)
	public ModelAndView boardUpdatePost(ModelAndView mv,
			@PathVariable("bd_num")int bd_num, BoardVO board, HttpSession session) {
		MemberVO user = (MemberVO) session.getAttribute("user");
		boardService.updateBoard(board, user);
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
}
