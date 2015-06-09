package com.xyz.service.impl;

import com.xyz.dao.UserDao;
import com.xyz.model.User;
import com.xyz.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean save(User u) {
		return userDao.save(u);
	}

}
