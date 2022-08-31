package kr.green.springtest.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.green.springtest.service.MemberService;
import kr.green.springtest.vo.MemberVO;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	MemberService meberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user == null) {
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			if(loginCookie != null) {
				String session_id = loginCookie.getValue();
				user = meberService.getMember(session_id);
				if(user != null)
					session.setAttribute("user", user);
			}
		}
		return true;
	}
}
