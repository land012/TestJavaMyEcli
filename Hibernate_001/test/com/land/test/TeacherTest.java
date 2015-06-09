package com.land.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.land.model.A002Vo;
import com.land.model.Gender;
import com.land.model.Student;
import com.land.model.Teacher;


public class TeacherTest {
	private static SessionFactory sf;
	
	@BeforeClass
	public static void beforeClass() {
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	@AfterClass
	public static void afterClass() {
		sf.close();
	}
	
	@Test
	public void testTeacherSave() {
		Teacher t = new Teacher();
		for(int i=6; i<11; i++) {
			t.setName("David" + i);
			t.setAge(12 + i);
			t.setTitle("������");
			t.setGender(Gender.MALE);
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(t);
			System.out.println("id=" + t.getId()); // 3
			session.getTransaction().commit();
			session.close();
			System.out.println("id=" + t.getId()); // 3
		}
	}
	
	@Test
	public void testStudentSave() {
		Student s = new Student();
		for(int i=1; i<6; i++) {
			s.setName("David" + i);
			s.setAge(18 + i);
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(s);
			session.getTransaction().commit();
			session.close();
		}
		
	}
	
	/**
	 * ��������
	 */
	@Test
	public void testA002Vo() {
		A002Vo vo = new A002Vo();
		vo.setF1("2");
		vo.setF2("jim");
		vo.setF3("19");
//		Session session = sf.openSession();
		// org.hibernate.HibernateException: No CurrentSessionContext configured!
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(vo);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * �����쳣
	 */
	@Test
	public void testLoad1() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Teacher t = (Teacher)s.load(Teacher.class, 1);
		s.getTransaction().commit();
		/*
		 * �쳣
		 * org.hibernate.LazyInitializationException: could not initialize proxy - no Session
		 */
		System.out.println(t.getName()); // commit ֮ǰû��ȡ���������Դ˴�ȡ������
	}
	/**
	 * �������쳣������ʦ���Ĳ�һ��
	 * ��Ϊ �� commit ֮ǰ�ó��˶���
	 */
	@Test
	public void testLoad2() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Teacher t = (Teacher)s.load(Teacher.class, 1);
		System.out.println(t.getName()); // �� commit ֮ǰ�ó��˶���
		s.getTransaction().commit();
		System.out.println(t.getName());
	}
	
	/**
	 * ���ݿ��в����ڵļ�¼
	 */
	@Test
	public void testLoad3() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
//		Teacher t = (Teacher)s.load(Teacher.class, 1); // �������
		Teacher t = (Teacher)s.load(Teacher.class, 0);
//		System.out.println(t.getName());
		s.getTransaction().commit();
		/*
		 * class com.land.model.Teacher_$$_javassist_1
		 * ���ݿ���û�м�¼ʱ���������쳣����Ȼ�ᴴ���������
		 */
//		System.out.println(t.getClass());
	}
	
	@Test
	public void testGet() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Teacher t = (Teacher)s.get(Teacher.class, 1);
//		Teacher t = (Teacher)s.get(Teacher.class, 0);
//		System.out.println(t.getName());
		s.getTransaction().commit();
		System.out.println(t.getName());
		/*
		 * class com.land.model.Teacher
		 * �����ݿ���û�м�¼ʱ���� NullPointerException
		 */
//		System.out.println(t.getClass());
	}
	
}



















