package com.land.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.land.bbs.vo.Category;
import com.land.bbs.vo.Msg;
import com.land.bbs.vo.Topic;
import com.land.optimistic.Account;
import com.land.util.HibernateUtil;
import com.land.util.RecursionUtil;


public class TransactionTest {
	private static SessionFactory sf;
	
	@BeforeClass
	public static void beforeClass() {
		try {
			new SchemaExport(new Configuration().configure()).create(true, true);
			sf = HibernateUtil.getSessionFactory();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public static void afterClass() {
		sf.close();
	}
	
	@Test
	public void testSave1() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		
		Account ac = new Account();
		ac.setBalance(1000);
		session.save(ac);
		session.getTransaction().commit();
	}
	
	/**
	 * 乐观锁
	 */
	@Test
	public void testOptimistic1() {
		testSave1();
		
		Session sen1 = sf.openSession(); // 如果使用 getCurrentSession 会提示不支持 嵌套Session
		sen1.beginTransaction();
		Account ac1 = (Account)sen1.load(Account.class, 1);
		ac1.setBalance(ac1.getBalance()-100);
		
		Session sen2 = sf.openSession(); // 如果使用 getCurrentSession 会提示不支持 嵌套Session
		sen2.beginTransaction();
		Account ac2 = (Account)sen2.load(Account.class, 1);
		ac2.setBalance(ac2.getBalance()+100);
		
		sen1.getTransaction().commit();
		sen1.close();
		
		sen2.getTransaction().commit();
		sen2.close();
		
	}
	
	
	
}



















