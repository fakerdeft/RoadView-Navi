package com.spring.RoadViewNavi.Model.Repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.RoadViewNavi.Model.VO.User;

@Repository
public class RoadViewNaviDao {

	public int insertUser(SqlSessionTemplate sqlSession, User user) {
		return sqlSession.insert("RoadViewNaviMapper.insertUser", user);
	}

	public User loginUser(SqlSessionTemplate sqlSession, User user) {
		return sqlSession.selectOne("memberMapper.loginUser", user);
	}
	
}























