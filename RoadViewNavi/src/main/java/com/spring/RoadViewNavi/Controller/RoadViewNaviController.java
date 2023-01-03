package com.spring.RoadViewNavi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import com.spring.RoadViewNavi.Model.Service.RoadViewNaviService;

@Controller
public class RoadViewNaviController {
	@Autowired
	private RoadViewNaviService roadViewNaviService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
}




















