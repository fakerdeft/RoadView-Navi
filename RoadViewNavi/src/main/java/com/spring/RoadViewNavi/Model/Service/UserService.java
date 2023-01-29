package com.spring.RoadViewNavi.Model.Service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.RoadViewNavi.Model.Repository.UserDao;
import com.spring.RoadViewNavi.Model.VO.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int insertUser(User user) {
		return userDao.insertUser(sqlSession, user);
	}

	public User loginUser(User user) {
		return userDao.loginUser(sqlSession, user);
	}

	public int updateUser(User user) {
		return userDao.updateUser(sqlSession, user);
	}

	public int deleteUser(String userId) {
		return userDao.deleteUser(sqlSession, userId);
	}

	public User validateDuplicationId(String userId) {
		return userDao.validateDuplicationId(sqlSession,userId);
	}

	public User validateDuplicationPhone(String userPhone) {
		return userDao.validateDuplicationPhone(sqlSession,userPhone);
	}
}
