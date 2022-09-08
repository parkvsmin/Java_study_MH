package com.iu.home.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("bankmembers");
		
		if(obj !=null) {
			System.out.println("로그인 함");
			return true;
		}else {
			System.out.println("로그인 안함");
			response.sendRedirect("../../../../../bankmembers/login");
			return false;
		}
		
		
	}
	
	
	
}
