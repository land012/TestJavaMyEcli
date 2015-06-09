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
import com.land.util.HibernateUtil;
import com.land.util.RecursionUtil;


public class CacheTest {
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
		
		for(int i=1; i<=10; i++) {
			Category c = new Category();
			c.setName("c" + i);
			session.save(c);
		}
		
		for(int i=1; i<=10; i++) {
			Category c = new Category();
			c.setId(1);
			Topic t = new Topic();
			t.setName("t" + i);
			t.setCategory(c);
			session.save(t);
		}
		
		for(int i=1; i<=10; i++) {
			Topic t = new Topic();
			t.setId(1);
			
			Msg m = new Msg();
			m.setCont("m" + i);
			m.setTopic(t);
			session.save(m);
		}
		
		session.getTransaction().commit();
	}
	
	/**
	 * ∂˛º∂ª∫¥Ê
	 * EhCache
	 */
	@Test
	public void testCache1() {
		testSave1();
		
		Session sen1 = sf.getCurrentSession();
		sen1.beginTransaction();
		Category c1 = (Category)sen1.load(Category.class, 1);
		System.out.println(c1.getName());
		sen1.getTransaction().commit();
		
		Session sen2 = sf.getCurrentSession();
		sen2.beginTransaction();
		Category c2 = (Category)sen2.load(Category.class, 1);
		System.out.println(c2.getName());
		sen2.getTransaction().commit();
	}
	
	@Test
	public void testCache2() {
		testSave1();
		
		Session sen1 = sf.getCurrentSession();
		sen1.beginTransaction();
		List<Category> list1 = sen1.createQuery("from Category").list();
		sen1.getTransaction().commit();
		
		Session sen2 = sf.getCurrentSession();
		sen2.beginTransaction();
		Category c2 = (Category)sen2.load(Category.class, 1);
		System.out.println(c2.getName());
		sen2.getTransaction().commit();
		
	}
	
	/**
	 * ≤È—Øª∫¥Ê
	 */
	@Test
	public void testCache3() {
		testSave1();
		
		Session sen1 = sf.getCurrentSession();
		sen1.beginTransaction();
		List<Category> list1 = sen1.createQuery("from Category").setCacheable(true).list();
		sen1.getTransaction().commit();
		
		Session sen2 = sf.getCurrentSession();
		sen2.beginTransaction();
		List<Category> list2 = sen2.createQuery("from Category").setCacheable(true).list();
		sen2.getTransaction().commit();
		
	}
	
	public static void main(String[] args) {
		beforeClass();
	}
	
}



















