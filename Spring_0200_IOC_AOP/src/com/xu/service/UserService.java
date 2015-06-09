package com.xu.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xu.dao.UserDao;
import com.xu.model.User;

@Component
public class UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}
	
	//@Autowired
	@Resource(name="userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void save(User user) {
		userDao.save(user);
	}
}
