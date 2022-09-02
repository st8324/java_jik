package kr.green.lg.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.lg.service.MemberService;
import kr.green.lg.vo.MemberVO;

@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
		mv.setViewName("/main/home");
		return mv;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv) {
		mv.addObject("title","회원가입");
		mv.setViewName("/main/signup");
		return mv;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO member) {
		boolean res = memberService.signup(member);
		if(res)
			mv.setViewName("redirect:/signup/success");
		else
			mv.setViewName("redirect:/signup");
		return mv;
	}
	@RequestMapping(value = "/signup/success", method = RequestMethod.GET)
	public ModelAndView signupSuccessGet(ModelAndView mv) {
		mv.addObject("title","회원가입완료");
		mv.setViewName("/main/signupSuccess");
		return mv;
	}
	
	@RequestMapping(value = "/signup/check", method = RequestMethod.GET)
	public ModelAndView signupCheckGet(ModelAndView mv, MemberVO member) {
		boolean res = memberService.emailActive(member);
		mv.addObject("title","회원가입완료");
		mv.setViewName("/main/signupCheck");
		return mv;
	}
	
	//ajax
	@RequestMapping(value="/check/email", method = RequestMethod.POST)
	@ResponseBody
	public Map<Object,Object> checkEmail(@RequestBody MemberVO member) {
		HashMap<Object,Object> map = new HashMap<Object, Object>();
		boolean res = memberService.isUser(member);
		map.put("res", res);
		return map;
	}
}
