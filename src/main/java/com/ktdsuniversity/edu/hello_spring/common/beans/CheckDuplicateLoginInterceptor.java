package com.ktdsuniversity.edu.hello_spring.common.beans;

import org.springframework.web.servlet.HandlerInterceptor;

import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * 로그인 되어있는 상태에서 로그인 페이지에 접근하면 /board/list로 이동시키는 interceptor
 */
public class CheckDuplicateLoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		MemberVO memberVO = (MemberVO) session.getAttribute("_LOGIN_USER");
		if(memberVO != null) {
			response.sendRedirect("/board/list");
			return false;
		}
		return true;
	}
}
