package com.spring.RoadViewNavi.Model.Service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.RoadViewNavi.Model.Repository.RoadViewNaviDao;

@Service
public class RoadViewNaviService {
	@Autowired
	private RoadViewNaviDao roadViewNaviDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
}






















