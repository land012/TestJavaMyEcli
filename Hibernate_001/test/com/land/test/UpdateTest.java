package com.land.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Before;
import org.junit.Test;

import com.land.model.Gender;
import com.land.model.Student;
import com.land.model.Teacher;
import com.land.util.HibernateUtil;

public class UpdateTest {
	private static SessionFactory sf;
	
	@Before
	public void before() {
		sf = HibernateUtil.getSessionFactory();
	}
	
	/**
	 * Transient —— Persistent
	 * 更新所有字段，会把其他字段都置为空
	 */
	@Test
	public void testUpdate1() {
		Teacher t = new Teacher();
		t.setId(1);
		t.setTitle("教授");
		Session sion = sf.getCurrentSession();
		sion.beginTransaction();
		sion.update(t);
		sion.getTransaction().commit();
	}
	
	/**
	 * 更新所有字段，仍会把其他字段都置为空
	 * 原因：merge()时，在数据库中查到的字段内容与 t的不一样，所以更新为t的内容
	 */
	@Test
	public void testUpdate2() {
		Teacher t = new Teacher();
		t.setId(2);
		t.setTitle("教授");
		Session sion = sf.getCurrentSession();
		sion.beginTransaction();
		sion.merge(t);
		sion.getTransaction().commit();
	}
	
	/**
	 * Persistent——Persistent
	 * 更新所有字段，保留未修改的字段
	 * 原因：因为从数据库中取了一次，所以其它字段已经置为数据库中的值
	 */
	@Test
	public void testUpdate3() {
		Session sion = sf.getCurrentSession();
		sion.beginTransaction();
		Teacher t = (Teacher)sion.get(Teacher.class, 3);
		t.setTitle("砖家");
		sion.getTransaction().commit();
	}
	
	/**
	 * Persistent —— Detached —— Persistent
	 * 更新所有字段，不是改变其它字段的值，因为第一次get()时，已经设置了 t 的其它字段
	 * 第二次更新不必使用 merge()（跟老师讲的不一样，老师讲第二处应该使用 merge）
	 */
	@Test
	public void testUpdate4() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Teacher t = (Teacher)session.get(Teacher.class, 4);
		t.setTitle("叫兽1");
		session.getTransaction().commit();
		
		t.setTitle("叫兽2"); // 这时候，t 的其它字段内容仍是数据库中内容
		
		Session session2 = sf.getCurrentSession();
		session2.beginTransaction();
		session2.update(t);
		session2.getTransaction().commit();
	}
	
	/**
	 * 仅执行一次 update 语句
	 */
	@Test
	public void testUpdate44() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Teacher t = (Teacher)session.get(Teacher.class, 1);
		t.setName("Jim1");
		session.update(t); // 相当于手动 commit
		session.getTransaction().commit();
	}
	
	/**
	 * 仅更新值更改的字段
	 */
	@Test
	public void testUpdate5() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Student s = (Student)session.get(Student.class, 1);
		s.setName("Tom1");
		session.getTransaction().commit();
	}
	
	/**
	 * HQL
	 */
	@Test
	public void testUpdate6() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		String sql = "update Student s set s.name='Tom2' where s.id=2";
		Query q = session.createQuery(sql);
		q.executeUpdate();
		session.getTransaction().commit();
	}
	
	/**
	 * 先执行 insert 再执行 update
	 */
	@Test
	public void testSaveOrUpdate1() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Teacher t = new Teacher();
		t.setName("Jack1");
		t.setAge(25);
		t.setTitle("副叫兽0");
		session.saveOrUpdate(t);
		session.getTransaction().commit();
		
		t.setName("Jack11");
		Session session2 = sf.getCurrentSession();
		session2.beginTransaction();
		session2.saveOrUpdate(t);
		session2.getTransaction().commit();
	}
	
	/**
	 * 查询一次，因为  session缓存中存在该对象
	 */
	@Test
	public void testClear1() {
		Session sn1 = sf.getCurrentSession();
		sn1.beginTransaction();
		Teacher t1 = (Teacher)sn1.get(Teacher.class, 1);
		System.out.println(t1.getName());
		
		Teacher t2 = (Teacher)sn1.get(Teacher.class, 1);
		System.out.println(t2.getName());
		
		sn1.getTransaction().commit();
	}
	
	/**
	 * 查询 两次（当不是一个 session 时，会执行各自的查询）
	 */
	@Test
	public void testClear2() {
		Session sn1 = sf.getCurrentSession();
		sn1.beginTransaction();
		Teacher t1 = (Teacher)sn1.get(Teacher.class, 1);
		System.out.println(t1.getName());
		sn1.getTransaction().commit();
		
		Session sn2 = sf.getCurrentSession();
		sn2.beginTransaction();
		Teacher t2 = (Teacher)sn2.get(Teacher.class, 1);
		System.out.println(t2.getName());
		sn2.getTransaction().commit();
	}
	
	/**
	 * 查询两次（清了缓存，需要再次执行查询）
	 */
	@Test
	public void testClear3() {
		Session sn1 = sf.getCurrentSession();
		sn1.beginTransaction();
		Teacher t1 = (Teacher)sn1.get(Teacher.class, 1);
		System.out.println(t1.getName());
		
		sn1.clear();
		
		Teacher t2 = (Teacher)sn1.get(Teacher.class, 1);
		System.out.println(t2.getName());
		
		sn1.getTransaction().commit();
	}
	
	/**
	 * 执行一次 update
	 */
	@Test
	public void testFlush1() {
//		Teacher t = new Teacher();
//		t.setName("Lucy1");
//		t.setAge(19);
//		t.setGender(Gender.FEMALE);
//		t.setTitle("叫兽5");
		
		Session sn1 = sf.getCurrentSession();
		sn1.beginTransaction();
		Teacher t1 = (Teacher)sn1.get(Teacher.class, 2);
		t1.setName("Lily1");
		t1.setName("Lily2");
		sn1.getTransaction().commit();
		
	}
	
	/**
	 * 执行两 次 update
	 */
	@Test
	public void testFlush2() {
		Session sn1 = sf.getCurrentSession();
		sn1.beginTransaction();
		Teacher t1 = (Teacher)sn1.get(Teacher.class, 2);
		t1.setName("Lily1");
		sn1.flush();
		t1.setName("Lily2");
		sn1.getTransaction().commit();
	}
	
	
	@Test
	public void testSchemaExport() {
		// 如果表存在的话，会先删除 
		new SchemaExport(new Configuration().configure()).create(true, true);
	}
}
















