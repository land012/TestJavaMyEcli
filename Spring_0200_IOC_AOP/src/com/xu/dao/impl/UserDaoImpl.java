package com.xu.dao.impl;

import org.springframework.stereotype.Component;

import com.xu.dao.UserDao;
import com.xu.model.User;

@Component("userDao")
public class UserDaoImpl implements UserDao {

	@Override
	public void save(User user) {
		System.out.println("save user " + user.getName() + " !");
	}

}
