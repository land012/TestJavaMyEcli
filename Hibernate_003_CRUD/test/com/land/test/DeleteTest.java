package com.land.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.land.model.many2onebi.Group;
import com.land.model.many2onebi.User;
import com.land.model.tree.Tree;
import com.land.util.HibernateUtil;
import com.land.util.RecursionUtil;


public class DeleteTest {
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
	public void testSave3() {
		User u1 = new User();
		u1.setName("u1");
		User u2 = new User();
		u2.setName("u2");
		
		Group g = new Group();
		g.setName("g1");
		
		Set<User> set = new HashSet<User>();
		set.add(u1);
		set.add(u2);
		g.setUsers(set);
		
		u1.setGroup(g);
		u2.setGroup(g);
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(g);
		session.getTransaction().commit();
	}
	
	/**
	 * ���쳣
	 * org.hibernate.exception.ConstraintViolationException: 
	 * Cannot delete or update a parent row: 
	 * a foreign key constraint fails 
	 * (`test`.`t_user`, CONSTRAINT `FKCB63CCB6AA319B28` FOREIGN KEY (`gid`) REFERENCES `t_group` (`id`))
	 */
	@Test
	public void testDelete1() {
		testSave3();
		
		User u = new User();
		u.setId(2);
		Group g = new Group();
		g.setId(1);
		u.setGroup(g);
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.delete(u);
		session.getTransaction().commit();
		
	}
	
	/**
	 * �����������쳣��ɾ���� u1,u2 �� group
	 */
	@Test
	public void testDelete2() {
		testSave3();
		
		User u1 = new User();
		u1.setId(1);
		Group g = new Group();
		g.setId(1);
		u1.setGroup(g);
		
		User u2 = new User();
		u2.setId(2);
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.delete(u2);
		session.delete(u1);
		session.getTransaction().commit();
		
	}
	
	/**
	 * ��Ϊ�����ϵ��ɾ��ʧ��
	 */
	@Test
	public void testDelete3() {
		testSave3();
		
		Group g = new Group();
		g.setId(1);
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.delete(g);
		session.getTransaction().commit();
	}
	
	/**
	 * ��Ϊ�����ϵ���ἶ��ɾ�� u1,u2
	 */
	@Test
	public void testDelete4() {
		testSave3();
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Group g = (Group)session.get(Group.class, 1);
		session.delete(g);
		session.getTransaction().commit();
	}
	
	/**
	 * ���쳣���� testDelete3 �׵��쳣��ͬ��
	 * ��ԭ���Ŷ�����Ϊ���
	 */
	@Test
	public void testDelete5() {
		testSave3();
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Group g = (Group)session.get(Group.class, 1);
		g.setUsers(null);
		session.delete(g);
		session.getTransaction().commit();
	}
	
	/**
	 * ֻɾ���� Group����û��ɾ�� u1,u2
	 */
	@Test
	public void testDelete6() {
		testSave3();
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Group g = (Group)session.get(Group.class, 1);
		for(User u : g.getUsers()) {
			u.setGroup(null);
		}
		g.setUsers(null); // ������һ�䣬��Ȼ�ἶ��ɾ�� u1,u2
		session.delete(g);
		session.getTransaction().commit();
	}
	
}



















