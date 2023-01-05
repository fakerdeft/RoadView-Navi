package com.spring.RoadViewNavi.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.spring.RoadViewNavi.Model.VO.User;

public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//비로그인 상태에서 url입력으로 접근 제한하는 기능
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		try {// 로그인 되어있는지 아닌지 확인하는 작업
			if(loginUser != null){// 로그인 되어 있는 경우 - Controller 요청 실행
				if(loginUser.getUserId().equals("admin")) {//관리자 계정일 경우
					session.setAttribute("alertMsg", "관리자님 안녕하세요.");
				}
				if(!loginUser.getUserId().equals("admin")){//관리자 계정이 아닐 경우
					session.setAttribute("alertMsg", loginUser.getUserName() + "님 안녕하세요.");
				}
				return true;
			}
		} catch(NullPointerException e){// 로그인 되어 있지 않는 경우 - Controller 요청 처리 하지 않음
			e.printStackTrace();
			session.setAttribute("alertMsg", "로그인 후 가능한 서비스입니다.");
			response.sendRedirect(request.getContextPath());
		}
		return false;
	}
}



















