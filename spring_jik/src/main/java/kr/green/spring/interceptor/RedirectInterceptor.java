package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RedirectInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user");

		String redirectURL = (String)session.getAttribute("redirectURL");
		if(user != null && redirectURL != null) {
			response.sendRedirect(redirectURL);
			session.removeAttribute("redirectURL");
			return false;
		}
		return true;
	}
}
