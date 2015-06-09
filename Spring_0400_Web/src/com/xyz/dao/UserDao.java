package com.xyz.dao;

import java.util.List;

import com.xyz.model.User;

public interface UserDao {
	public User get(User u);
	public boolean exsits(User u);
	public boolean add(User u);
	public List<User> getUserList();
	public User getUser(int id);
}
