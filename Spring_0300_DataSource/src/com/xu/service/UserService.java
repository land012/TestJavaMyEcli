package com.xu.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xu.dao.OpetLogDao;
import com.xu.dao.UserDao;
import com.xu.model.OpetLog;
import com.xu.model.Student;
import com.xu.model.User;

@Component
public class UserService {
	private UserDao userDao;
	private OpetLogDao opetLogDao;

	public OpetLogDao getOpetLogDao() {
		return opetLogDao;
	}
	
	@Resource
	public void setOpetLogDao(OpetLogDao opetLogDao) {
		this.opetLogDao = opetLogDao;
	}

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
	
	@Transactional
	public void save(Student s) {
		userDao.save(s);
		OpetLog l = new OpetLog();
		l.setMsg("student " + s.getName() + " saved");
		l.setAddtime(new Date());
		opetLogDao.save(l);
	}
}
