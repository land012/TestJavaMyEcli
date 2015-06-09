package com.land.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.land.model.Student;

public class StudentTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		Student s1 = new Student();
		s1.setId(1);
		s1.setName("tom");
		s1.setAge(19);
		session.beginTransaction();
		session.save(s1);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

}
