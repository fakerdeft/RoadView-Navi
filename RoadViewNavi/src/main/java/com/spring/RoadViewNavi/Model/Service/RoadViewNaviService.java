package com.spring.RoadViewNavi.Model.Service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.RoadViewNavi.Model.Repository.RoadViewNaviDao;
import com.spring.RoadViewNavi.Model.VO.User;

@Service
public class RoadViewNaviService {
	@Autowired
	private RoadViewNaviDao roadViewNaviDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int insertUser(User user) {
		return roadViewNaviDao.insertUser(sqlSession, user);
	}

	public User loginUser(User user) {
		return roadViewNaviDao.loginUser(sqlSession, user);
	}
}






















