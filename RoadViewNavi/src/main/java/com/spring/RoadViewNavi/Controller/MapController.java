package com.spring.RoadViewNavi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.RoadViewNavi.Model.Service.MapService;

@Controller
public class MapController {
	@Autowired
	private MapService mapService;
	
	// 지도 페이지로 이동
	@GetMapping("map.do")
	public ModelAndView goMapPage(ModelAndView mv) {
		mv.setViewName("MapView");
		return mv;
	}
	
	// 
	
}




















