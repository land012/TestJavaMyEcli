package com.land.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.land.model.scs.Course;
import com.land.model.scs.Score;
import com.land.model.scs.Student;
import com.land.util.HibernateUtil;


public class SCSTest {
	private static SessionFactory sf;
	
	@BeforeClass
	public static void beforeClass() {
		try {
			new SchemaExport(new Configuration().configure()).create(true, true);
			sf = HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@AfterClass
	public static void afterClass() {
		sf.close();
	}
	
	@Test
	public void testSave1() {
		Student s1 = new Student();
		s1.setName("s1");
		Course c1 = new Course();
		c1.setName("c1");
		Score sc1 = new Score();
		sc1.setStudent(s1);
		sc1.setCourse(c1);
		sc1.setScore(80);
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.persist(sc1);
		session.getTransaction().commit();
		
		System.out.println(c1.getId());
		
		Student s2 = new Student();
		s2.setName("s2");
		Score sc2 = new Score();
		sc2.setStudent(s2);
		sc2.setScore(88);
		
		Session session2 = sf.getCurrentSession();
		session2.beginTransaction();
		// 直接使用 c1而不get()会出错
		c1 = (Course)session2.get(Course.class, 1);
		sc2.setCourse(c1);
		session2.persist(sc2);
		session2.getTransaction().commit();
	}
	
}



















