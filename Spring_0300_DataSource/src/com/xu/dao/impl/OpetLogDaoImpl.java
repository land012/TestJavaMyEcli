package com.xu.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.xu.dao.OpetLogDao;
import com.xu.model.OpetLog;

@Component("opetLogDao")
public class OpetLogDaoImpl implements OpetLogDao {
	
	private SessionFactory mySessionFactory;

	public SessionFactory getMySessionFactory() {
		return mySessionFactory;
	}
	
	@Resource
	public void setMySessionFactory(SessionFactory mySessionFactory) {
		this.mySessionFactory = mySessionFactory;
	}

	@Override
	public void save(OpetLog l) {
		Session session = mySessionFactory.getCurrentSession();
		session.save(l);
//		throw new NullPointerException();
	}

}
