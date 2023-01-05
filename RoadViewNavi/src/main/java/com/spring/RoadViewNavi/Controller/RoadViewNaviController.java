package com.spring.RoadViewNavi.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.RoadViewNavi.Model.Service.RoadViewNaviService;
import com.spring.RoadViewNavi.Model.VO.User;

@Controller
public class RoadViewNaviController {
	@Autowired
	private RoadViewNaviService roadViewNaviService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("map.do") //지도 페이지로 이동
	public ModelAndView GoMapPage(HttpSession session, ModelAndView mv) {
		User loginUser = (User)session.getAttribute("loginUser");
		mv.addObject("loginUser", loginUser).setViewName("Views/MapView");
		return mv;
	}
	
}




















