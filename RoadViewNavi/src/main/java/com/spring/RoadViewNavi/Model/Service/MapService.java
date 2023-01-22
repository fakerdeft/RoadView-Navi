package com.spring.RoadViewNavi.Model.Service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.RoadViewNavi.Model.Repository.MapDao;

@Service
public class MapService {
	@Autowired
	private MapDao mapDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	
}






















