package com.spring.RoadViewNavi.Model.Repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.RoadViewNavi.Model.VO.User;

@Repository
public class UserDao {
	public int insertUser(SqlSessionTemplate sqlSession, User user) {
		return sqlSession.insert("UserMapper.insertUser", user);
	}

	public User loginUser(SqlSessionTemplate sqlSession, User user) {
		return sqlSession.selectOne("UserMapper.loginUser", user);
	}

	public int updateUser(SqlSessionTemplate sqlSession, User user) {
		return sqlSession.update("UserMapper.updateUser", user);
	}

	public int deleteUser(SqlSessionTemplate sqlSession, String userId) {
		return sqlSession.update("UserMapper.deleteUser", userId);
	}

	public User validateDuplicationId(SqlSessionTemplate sqlSession, String userId) {
		return sqlSession.selectOne("UserMapper.validateDuplicationId", userId);
	}

	public User validateDuplicationPhone(SqlSessionTemplate sqlSession, String userPhone) {
		return sqlSession.selectOne("UserMapper.validateDuplicationPhone", userPhone);
	}
}
