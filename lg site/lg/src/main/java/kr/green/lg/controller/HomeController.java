package kr.green.lg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.lg.service.MemberService;

@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
		mv.addObject("title","LG 가전");
		mv.setViewName("/main/home");
		return mv;
	}
	
}
