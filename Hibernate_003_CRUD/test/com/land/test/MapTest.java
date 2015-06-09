package com.land.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.land.model.many2onebi.Grade;
import com.land.model.many2onebi.Student;
import com.land.util.HibernateUtil;


public class MapTest {
	private static SessionFactory sf;
	
	@BeforeClass
	public static void beforeClass() {
		new SchemaExport(new Configuration().configure()).create(true, true);
		sf = HibernateUtil.getSessionFactory();
	}
	
	@AfterClass
	public static void afterClass() {
		sf.close();
	}
	
	@Test
	public void testSave1() {
		Student s1 = new Student();
		s1.setName("s1");
		Student s2 = new Student();
		s2.setName("s2");
		
		Grade g = new Grade();
		g.setName("g1");
		
		Map<Integer, Student> map = new HashMap<Integer, Student>();
		map.put(new Integer(5), s1);
		map.put(new Integer(6), s2);
		g.setStudents(map);
		
		s1.setGrade(g);
		s2.setGrade(g);
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(g);
		session.getTransaction().commit();
	}
	
	@Test
	public void testGet1() {
		testSave1();
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Grade g = (Grade)session.get(Grade.class, 1);
		for(Map.Entry<Integer, Student> entry : g.getStudents().entrySet()) {
			System.out.println(entry.getValue().getName());
		}
		session.getTransaction().commit();
	}
	
}



















