package com.cray.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cray.dao.UserDao;
import com.cray.dao.entity.User;
import com.cray.service.UserService;

@Service

public class UserServiceImpl implements UserService{

	//注入UserDao
	@Autowired
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Transactional
	@Override
	public User login(User user) {
		// 调用Dao层Login函数
		return userDao.login(user);
	}
	
	
}
