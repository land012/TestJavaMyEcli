package com.xyz.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyz.model.User;
import com.xyz.util.HibernateUtil;

public interface UserManager {
	
//	// Hibernate ²âÊÔ
//	
//	public boolean exists(User u) {
//		SessionFactory sf = HibernateUtil.getSessionFactory();
//		Session session = sf.getCurrentSession();
//		session.beginTransaction();
//		String sql = "select count(*) from User t where t.username = :username";
//		Query query = session.createQuery(sql).setString("username", u.getUsername());
//		long count = (Long)query.uniqueResult();
//		session.getTransaction().commit();
//		System.out.println("ÓÃ»§Êý:" + count);
//		if(count>0) return true;
//		return false;
//	}
//	
//	public boolean add(User u) {
//		if(!exists(u)) {
//			SessionFactory sf = HibernateUtil.getSessionFactory();
//			Session session = sf.getCurrentSession();
//			session.beginTransaction();
//			session.save(u);
//			session.getTransaction().commit();
//			return true;
//		}
//		return false;
//	}
	
	public boolean exsits(User u);
	public boolean add(User u);
	public void fn1();
	public List<User> getUserList();
	public User getUser(int id);
}
