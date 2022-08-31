package kr.green.springtest.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.springtest.service.MemberService;
import kr.green.springtest.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	MemberService memberService;
	
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
	    ModelMap modelMap = modelAndView.getModelMap();
	    MemberVO user = (MemberVO)modelMap.get("user");
	   // MemberVO user = (MemberVO)modelAndView.getModelMap().get("user");
	    if(user != null) {
	        HttpSession session = request.getSession();
	        session.setAttribute("user", user);
	        //request.getSession().setAttribute("user", user);
	        if(user.isAutoLogin()) {
	        	Cookie loginCookie = new Cookie("loginCookie", session.getId());
	        	loginCookie.setPath("/");
	        	int second = 60 * 60 * 24 * 7;
	        	loginCookie.setMaxAge(second);
	        	response.addCookie(loginCookie);
	        	Date session_limit = new Date(System.currentTimeMillis() + second * 1000);
	        	memberService.updateMemberSession(user.getMe_id(), session.getId(), session_limit);
	        }
	    }
	}
}
