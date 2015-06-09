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


public class CRUDTest {
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
		Group g = new Group();
		g.setName("g1");
		User u = new User();
		u.setName("u1");
		u.setGroup(g);
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
	}
	
	@Test
	public void testSave2() {
		User u = new User();
		u.setName("u1");
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Group g = (Group)session.load(Group.class, 1);
		u.setGroup(g);
		session.save(u);
		session.getTransaction().commit();
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
	 * �� Group �� ָ�� FetchType.EAGER ʱ����ȡ�� Set<User>
	 */
	@Test
	public void testGet1() {
		testSave3();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Group g = (Group)session.get(Group.class, 1);
		System.out.println(g.getUsers().size()); // 2
		session.getTransaction().commit();
	}
	
	/**
	 * User EAGER
	 *   �� Group �� ָ�� FetchType.EAGER ʱ���ᷢ����sql����һ��ȡ User���ڶ���ȡ User��Group�� Set<User>
	 *   �� Group �� ָ�� FetchType.LAZY ʱ��ֻ��һ��sql��ȡ User
	 * 
	 * 
	 */
	@Test
	public void testGet2() {
		testSave3();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		User u = (User)session.get(User.class, 1);
		session.getTransaction().commit();
	}
	
	/**
	 * Group EAGER
	 *   User EAGER ��ȡ User������Group����ȡ  Group �µ�����User
	 *   User LAZY ��ȡ User����ȡ Group ������ User
	 */
	@Test
	public void testGet3() {
		testSave3();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		User u = (User)session.get(User.class, 1);
		System.out.println(u.getGroup().getName());
		session.getTransaction().commit();
	}
	
	/**
	 * CascadeType.ALL������ͬʱɾ�� Group
	 * ��Ϊ��ʱ�� u ��Ȼ�����ݿ����й����� Group�����ڴ��в����й��� Group
	 * �����˵�����ԣ���������Ϊ�ڴ��� u û�й���Group��������Ϊ  u.setGroup(null)���� commit() ʱ��
	 *   ���������ݿ⣬�������ݿ��� u �� gid ��Ϊ�� null
	 *   ������ɾ��ʱ���ݿ���û�й����� Group���Ͳ���ɾ�� Group
	 */
	@Test
	public void testDelete1() {
		User u = new User();
		u.setId(2);
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.delete(u);
		session.getTransaction().commit();
	}
	
	@Test
	public void testTreeSave1() {
		Tree t0 = new Tree();
//		t0.setId(0);
		t0.setName("��");
		
		Tree t1 = new Tree();
//		t1.setId(1);
		t1.setName("t1");
		t1.setTree(t0);
		Tree t2 = new Tree();
//		t2.setId(2);
		t2.setName("t2");
		t2.setTree(t0);
		
		Tree t1_1 = new Tree();
//		t1_1.setId(3);
		t1_1.setName("t1_1");
		t1_1.setTree(t1);
		Tree t1_2 = new Tree();
//		t1_2.setId(4);
		t1_2.setName("t1_2");
		t1_2.setTree(t1);
		
		Set<Tree> set0 = new HashSet<Tree>();
		set0.add(t1);
		set0.add(t2);
		t0.setTrees(set0);
		
		Set<Tree> set1 = new HashSet<Tree>();
		set1.add(t1_1);
		set1.add(t1_2);
		t1.setTrees(set1);
		
		Tree t2_1 = new Tree();
//		t2_1.setId(5);
		t2_1.setName("t2_1");
		t2_1.setTree(t2);
		Tree t2_2 = new Tree();
//		t2_2.setId(6);
		t2_2.setName("t2_2");
		t2_2.setTree(t2);
		
		Set<Tree> set2 = new HashSet<Tree>();
		set2.add(t2_1);
		set2.add(t2_2);
		t2.setTrees(set2);
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
//		session.save(t1);
//		session.save(t2);
		session.save(t0);
		session.getTransaction().commit();
		
	}
	
	@Test
	public void testTreeGet1() {
		testTreeSave1();
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Tree root = (Tree)session.get(Tree.class, 1);
		RecursionUtil.showTree(root, 0);
		session.getTransaction().commit();
	}
	
	/**
	 * �� User ����Ϊ CascadeType.PERSIST ʱ��ֻ��ʹ�� persist(o) ��������Ч��ʹ�� save(o) ��Ч
	 */
	@Test
	public void testPersist1() {
		Group g = new Group();
		g.setName("g1");
		
		User u = new User();
		u.setName("u1");
		u.setGroup(g);
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.persist(u);
		
		/*
		 * û�����ü���ʱ�����쳣�����ᱣ��
		 * org.hibernate.TransientObjectException: 
		 * object references an unsaved transient instance - 
		 * save the transient instance before flushing: com.land.model.many2onebi.Group
		 * ���ǣ������� u ���� Group ʱ���������쳣���ᱣ�� u
		 */
//		session.save(u);
		session.getTransaction().commit();
		
	}
	
}



















