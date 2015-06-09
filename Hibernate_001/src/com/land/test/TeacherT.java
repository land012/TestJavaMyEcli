package com.land.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.land.model.Student;
import com.land.model.Teacher;

public class TeacherT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		Teacher t1 = new Teacher();
		t1.setId(1);
		t1.setName("tom");
		t1.setAge(19);
		t1.setTitle("½ÌÊÚ");
		session.beginTransaction();
		session.save(t1);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

}
