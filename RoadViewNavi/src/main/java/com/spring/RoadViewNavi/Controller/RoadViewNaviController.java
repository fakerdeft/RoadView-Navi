package com.spring.RoadViewNavi.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.RoadViewNavi.Model.Service.RoadViewNaviService;
import com.spring.RoadViewNavi.Model.VO.User;

@Controller
public class RoadViewNaviController {
	@Autowired
	private RoadViewNaviService roadViewNaviService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//회원가입 메서드
	@PostMapping("insert.do")
	public String insertUser(User user,HttpSession session,Model model) {
		
		// 1. 한글 깨짐 - web.xml에서 encodingFilter를 통해 해결
		// 2. 나이에 빈값이 들어오면 typeMismatchException 발생
		//	  -User VO에 age필드를 String자료형으로 변경하여 해결 (lombok활용)
		// 3. 비밀번호가 사용자가 입력한 그대로 저장되는 문제
		//	  -BCypt 방식의 암호화를 통해 암호문으로 변경
		//	  -spring security module에서 제공하는 라이브러리 (pom.xml에 추가)
		//	  -BCryptPasswordEncoding 클래스를 사용하기 위해 xml파일에 등록
		//	  -web.xml에 spring-security.xml 파일을 로딩할 수 있게 작업
		String encPwd = bCryptPasswordEncoder.encode(user.getUserPwd());
		user.setUserPwd(encPwd);
		int result = roadViewNaviService.insertUser(user);
		if(result > 0) {
			session.setAttribute("alertMsg","회원 가입 성공!");
		} else if (result <= 0){
			model.addAttribute("alertMsg","회원 가입 실패!");
		}
		return "redirect:/";
	}
	
	@GetMapping("map.do") //지도 페이지로 이동
	public ModelAndView GoMapPage(HttpSession session, ModelAndView mv) {
		User loginUser = (User)session.getAttribute("loginUser");
		mv.addObject("loginUser", loginUser).setViewName("Views/MapView");
		return mv;
	}
	
}




















