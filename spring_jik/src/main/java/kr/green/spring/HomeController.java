package kr.green.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	/* url에 ?로 데이터를 전송하는 경우
	 * http://localhost:8080/spring?age=20&hobby=운동&id=abc123&pw=qwe123 
	 * */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv, Integer age, String hobby, String id, String pw) {
		//mv.addObject("화면에서 사용할 이름", "보낼변수/객체");
		System.out.println("나이는 "+age+"입니다");
		System.out.println("취미는 "+hobby+"입니다");
		System.out.println("아이디는 "+id+"입니다");
		System.out.println("비번은 "+pw+"입니다");
		mv.addObject("name", "홍길동");
		mv.setViewName("home");	
		return mv;
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) {
		
		mv.setViewName("member/login");
		return mv;
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv) {
		
		mv.setViewName("member/login");
		return mv;
	}
	/* url 경로에 전달하려는 값이 있는 경우 
	 * http://localhost:8080/spring/member/20/운동 
	 * */
	@RequestMapping(value="/member/{age1}/{hobby1}", method=RequestMethod.GET)
	public ModelAndView ageHobbyGet(ModelAndView mv,
			@PathVariable("age1") int age, 
			@PathVariable("hobby1") String hobby) {
		System.out.println("나이는 "+age+"입니다");
		System.out.println("취미는 "+hobby+"입니다");
		mv.setViewName("home");
		return mv;
	}
}
