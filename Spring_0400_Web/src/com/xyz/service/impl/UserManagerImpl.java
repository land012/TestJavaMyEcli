package com.xyz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.xyz.dao.UserDao;
import com.xyz.model.User;
import com.xyz.service.UserManager;
@Component("userManager")
public class UserManagerImpl implements UserManager {
	
	private static Logger log = Logger.getLogger("logs");
	
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}
	
//	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean exsits(User u) {
		return userDao.exsits(u);
	}

	@Override
	public boolean add(User u) {
		return userDao.add(u);
	}
	
	@Override
	public void fn1() {
		log.info("this is fn1()");
	}

	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}

	@Override
	public User getUser(int id) {
		return userDao.getUser(id);
	}

}
