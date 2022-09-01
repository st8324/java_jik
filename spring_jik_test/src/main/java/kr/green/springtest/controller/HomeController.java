package kr.green.springtest.controller;

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

import kr.green.springtest.service.BoardService;
import kr.green.springtest.service.MemberService;
import kr.green.springtest.vo.MemberVO;

@Controller
public class HomeController {
	
	@Autowired
  MemberService memberService;
	
	@RequestMapping(value="/")
	public ModelAndView openTilesView(ModelAndView mv){
    mv.setViewName("/main/home");
    return mv;
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv){
    mv.setViewName("/main/signup");
    return mv;
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO member){
    if(memberService.signup(member)) {
    	mv.setViewName("redirect:/");
    }else {
    	mv.setViewName("redirect:/signup");
    }
    return mv;
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv, HttpServletRequest request){
		String url = request.getHeader("Referer");
		if(url != null && !url.contains("/login")) {
			request.getSession().setAttribute("prevURL", url);
		}
    mv.setViewName("/main/login");
    return mv;
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO member){
		MemberVO user = memberService.login(member);
		if(user != null)
			mv.setViewName("redirect:/");
		else
			mv.setViewName("redirect:/login");
		mv.addObject("user", user);
    return mv;
	}
	@RequestMapping(value="/logout")
	public ModelAndView logout(ModelAndView mv, HttpServletRequest request, HttpServletResponse response){
		memberService.logout(request, response);
    mv.setViewName("redirect:/");
    return mv;
	}
	@RequestMapping(value="/id/check")
	@ResponseBody
	public Map<Object,Object> idCheck(@RequestBody MemberVO member){
		HashMap<Object, Object> map = new HashMap<Object, Object>();
    map.put("check", memberService.idCheck(member));
    return map;
	}
	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public ModelAndView findGet(ModelAndView mv, String type){
		mv.addObject("type", type);
    mv.setViewName("/main/find");
    return mv;
	}
	
	@RequestMapping(value="/ajax/find/id")
	@ResponseBody
	public Map<Object,Object> findId(@RequestBody MemberVO member){
		HashMap<Object, Object> map = new HashMap<Object, Object>();
    String id = memberService.getId(member);
    map.put("id", id);
    return map;
	}
	@RequestMapping(value="/ajax/find/pw")
	@ResponseBody
	public Map<Object,Object> findPw(@RequestBody MemberVO member){
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		boolean res = memberService.findPw(member);
		map.put("res", res);
    return map;
	}
	
	@RequestMapping(value="/member/update", method=RequestMethod.GET)
	public ModelAndView memberUpdateGet(ModelAndView mv){
		
    mv.setViewName("/main/update");
    return mv;
	}
	@RequestMapping(value="/member/update", method=RequestMethod.POST)
	public ModelAndView memberUpdatePost(ModelAndView mv, MemberVO member
			, HttpSession session){
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = memberService.updateMember(member, user);
    mv.setViewName("redirect:/member/update");
    return mv;
	}
}
