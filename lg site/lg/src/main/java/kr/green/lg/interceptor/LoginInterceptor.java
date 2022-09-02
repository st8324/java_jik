package kr.green.lg.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.lg.service.MemberService;
import kr.green.lg.vo.MemberVO;

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

    if(user != null) {
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        if(user.isAutoLogin()) {
        	Cookie cookie = new Cookie("lgCookie", session.getId());
        	int time = 60 * 60 * 24 * 7;
        	cookie.setPath("/");
        	cookie.setMaxAge(time);
        	response.addCookie(cookie);
        	Date date = new Date(System.currentTimeMillis() + time*1000);
        	user.setMe_s_id(session.getId());
        	user.setMe_s_limit(date);
        	memberService.updateMemberSession(user);
        }
    }
	}
}
