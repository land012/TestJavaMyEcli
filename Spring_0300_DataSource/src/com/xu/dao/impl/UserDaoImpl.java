package com.xu.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.xu.dao.UserDao;
import com.xu.model.Student;
import com.xu.model.User;

@Component("userDao")
public class UserDaoImpl implements UserDao {
	
	private DataSource mysqlDs;
	private SessionFactory mySessionFactory;

	public DataSource getMysqlDs() {
		return mysqlDs;
	}
	
	@Resource
	public void setMysqlDs(DataSource mysqlDs) {
		this.mysqlDs = mysqlDs;
	}

	public SessionFactory getMySessionFactory() {
		return mySessionFactory;
	}
	@Resource
	public void setMySessionFactory(SessionFactory mySessionFactory) {
		this.mySessionFactory = mySessionFactory;
	}

	/**
	 * 直接使用 DataSource
	 */
	@Override
	public void save(User user) {
		try {
			Connection conn = mysqlDs.getConnection();
			Statement stmt = conn.createStatement();
			
			String sql = "insert into student values(null, 'tom')";
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("save user " + user.getName() + " !");
	}
	
	/**
	 * 使用 SessionFactory
	 * 由 Spring 在 Service 中控制事务
	 */
	@Override
	public void save(Student s) {
//		Session session = mySessionFactory.openSession();
//		session.beginTransaction();
//		session.save(s);
//		session.getTransaction().commit();
//		session.close();
		
		Session session = mySessionFactory.getCurrentSession();
		session.save(s);
	}

}
