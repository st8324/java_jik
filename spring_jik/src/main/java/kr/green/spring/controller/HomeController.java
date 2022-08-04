package kr.green.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.MemberService;
import kr.green.spring.vo.MemberVO;


@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	/* 접근제한자 : public - 고정
	 * 리턴타입 : ajax(나중에 배움)를 이용한 경우는 제외하고는 기본적으로 ModleAndView
	 * 메소드명 : url 경로와 처리 방식(GET/POST)에서 따오는게 편함
	 *          예로, url /login이고 get방식이면 loginGet으로 짓는게 편함
	 * 매개변수 : ajax를 제외하고는 기본적으로 ModelAndView mv는 들어가고, 다른 매개변수는 추가로 올수 있음
	 * 예외처리 : 안해도 됨
	 * */
	/* mv.setViewName(문자열)
	 *   - ViewResolver로 보낼 문자열을 설정
	 *   - redirect, forward가 있는 경우는 url로 이동
	 *     예 : "redirect:/" 또는 "forward:/"
	 * mv.addObject("화면에서 사용할 이름", 변수/객체)
	 *   - 화면에서 사용할 데이터를 이름과 함께 추가 
	 * */
	/* @RequestMapping
	 * value : 처리할 url, {"url1", "url2"}을 이용하여 여러 url을 하나로 처리할 수 있다
	 * method: url 요청 방식, RequestMethod.GET/RequestMethod.POST 등
	 *         생략하면 둘다 처리
	 * */
	/* 화면에서 hobby와 time을 안보내면, null이 자동으로 들어감
	 * 이 때, hobby와 time의 타입이 null을 처리할 수 없는 타입이면 에러가 발생
	 * */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home(ModelAndView mv){
	    mv.setViewName("/main/home");
	    return mv;
	}
		
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv){
	    mv.setViewName("/main/login");
	    return mv;
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO member){
			MemberVO dbMember = memberService.login(member);
			System.out.println("로그인 중 : " + dbMember);
			mv.addObject("user", dbMember);
	    mv.setViewName("redirect:/");
	    return mv;
	}
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv) {
		mv.setViewName("/main/signup");
		return mv;
	}
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO member) {
		if(memberService.signup(member)) {
			mv.setViewName("redirect:/");
		}else {
			mv.setViewName("redirect:/signup");
		}
		return mv;
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public ModelAndView logoutGet(ModelAndView mv, HttpSession session) {
		session.removeAttribute("user");
		mv.setViewName("redirect:/");
		return mv;
	}
}
