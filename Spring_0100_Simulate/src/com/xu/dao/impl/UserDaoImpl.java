package com.xu.dao.impl;

import com.xu.dao.UserDao;
import com.xu.model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void save(User user) {
		System.out.println("save user " + user.getName() + " !");
	}

}
