package kr.green.lg.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.lg.service.BoardService;
import kr.green.lg.service.MessageService;
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
		boolean res = boardService.deleteBoard(bd_num, user);
		String redirectUrl = boardService.getDeleteRedirectURL(bd_type);
		
		if(res)
			messageService.message(response, "게시글이 삭제되었습니다.", redirectUrl);
		else
			messageService.message(response, "게시글 삭제에 실패했습니다.", redirectUrl);
		return mv;
	}
}
