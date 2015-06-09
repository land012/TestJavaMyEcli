package com.xyz.dao.impl;

import com.xyz.dao.UserDao;
import com.xyz.model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean save(User user) {
		System.out.println(user.getUsername() + " has saved!");
		return true;
	}

}
