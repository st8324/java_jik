package kr.green.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.MemberService;
import kr.green.spring.vo.BoardVO;
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
	public ModelAndView loginGet(ModelAndView mv, HttpServletRequest request){
		String url = request.getHeader("Referer");
		//로그인 화면을 url을 직접 입력하지 않고, url에 /login이 없으면 => 돌아가야할 url이 있으면
		if(url != null && !url.contains("/login"))
			request.getSession().setAttribute("redirectURL", url);
    mv.setViewName("/main/login");
    return mv;
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO member){
		MemberVO dbMember = memberService.login(member);
		
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
	public ModelAndView logoutGet(ModelAndView mv, HttpServletRequest request, 
			HttpServletResponse response) {
		memberService.logout(request, response);
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@RequestMapping(value ="/test")
	@ResponseBody
	public BoardVO test(@RequestBody BoardVO board){
		board.setBd_reg_date(new Date());
		board.setBd_up_date(new Date());
    return board;
	}
	@RequestMapping(value ="/test2")
	@ResponseBody
	public ArrayList<BoardVO> test2(@RequestBody BoardVO board){
		board.setBd_reg_date(new Date());
		board.setBd_up_date(new Date());
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		list.add(board);
    return list;
	}
	@RequestMapping(value ="/test3")
	@ResponseBody
	public Map<Object,Object> test3(@RequestBody BoardVO board){
		board.setBd_reg_date(new Date());
		board.setBd_up_date(new Date());
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("board", board);
		map.put("name", "홍길동");
    return map;
	}
	
	@RequestMapping(value ="/id/check")
	@ResponseBody
	public boolean idCheck(@RequestBody MemberVO member){
		return memberService.checkId(member);
	}
	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public ModelAndView logoutGet(ModelAndView mv, String type) {
		
		mv.addObject("type", type);
		mv.setViewName("/main/find");
		return mv;
	}
	@RequestMapping(value ="/find/id", method=RequestMethod.POST)
	@ResponseBody
	public Map<Object,Object> findId(@RequestBody MemberVO member){
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		ArrayList<String> idList = memberService.getIdList(member);
		map.put("idList", idList);
		return map;
	}
	@RequestMapping(value ="/find/pw", method=RequestMethod.POST)
	@ResponseBody
	public Map<Object,Object> findPw(@RequestBody MemberVO member){
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		//memberService.sendEmail("제목", "내용", "stajun@naver.com");
		boolean res = false;
		boolean exception = false;
		try {
			res = memberService.findPw(member);
		}catch(Exception e) {
			exception = true;
		}
		map.put("res", res);
		map.put("exception", exception);
		return map;
	}
	@RequestMapping(value="/user/update", method=RequestMethod.GET)
	public ModelAndView userUpdateGet(ModelAndView mv) {
		mv.setViewName("/main/update");
		return mv;
	}
	@RequestMapping(value="/user/update", method=RequestMethod.POST)
	public ModelAndView userUpdatePost(ModelAndView mv,MemberVO member, 
			HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		memberService.updateMember(member,user);
		mv.setViewName("/main/update");
		return mv;
	}
}
