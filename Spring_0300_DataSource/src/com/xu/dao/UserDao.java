package com.xu.dao;

import com.xu.model.Student;
import com.xu.model.User;

public interface UserDao {
	public void save(User user);
	public void save(Student s);
}
