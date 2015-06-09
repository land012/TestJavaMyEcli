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
	 * Transient ���� Persistent
	 * ���������ֶΣ���������ֶζ���Ϊ��
	 */
	@Test
	public void testUpdate1() {
		Teacher t = new Teacher();
		t.setId(1);
		t.setTitle("����");
		Session sion = sf.getCurrentSession();
		sion.beginTransaction();
		sion.update(t);
		sion.getTransaction().commit();
	}
	
	/**
	 * ���������ֶΣ��Ի�������ֶζ���Ϊ��
	 * ԭ��merge()ʱ�������ݿ��в鵽���ֶ������� t�Ĳ�һ�������Ը���Ϊt������
	 */
	@Test
	public void testUpdate2() {
		Teacher t = new Teacher();
		t.setId(2);
		t.setTitle("����");
		Session sion = sf.getCurrentSession();
		sion.beginTransaction();
		sion.merge(t);
		sion.getTransaction().commit();
	}
	
	/**
	 * Persistent����Persistent
	 * ���������ֶΣ�����δ�޸ĵ��ֶ�
	 * ԭ����Ϊ�����ݿ���ȡ��һ�Σ����������ֶ��Ѿ���Ϊ���ݿ��е�ֵ
	 */
	@Test
	public void testUpdate3() {
		Session sion = sf.getCurrentSession();
		sion.beginTransaction();
		Teacher t = (Teacher)sion.get(Teacher.class, 3);
		t.setTitle("ש��");
		sion.getTransaction().commit();
	}
	
	/**
	 * Persistent ���� Detached ���� Persistent
	 * ���������ֶΣ����Ǹı������ֶε�ֵ����Ϊ��һ��get()ʱ���Ѿ������� t �������ֶ�
	 * �ڶ��θ��²���ʹ�� merge()������ʦ���Ĳ�һ������ʦ���ڶ���Ӧ��ʹ�� merge��
	 */
	@Test
	public void testUpdate4() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Teacher t = (Teacher)session.get(Teacher.class, 4);
		t.setTitle("����1");
		session.getTransaction().commit();
		
		t.setTitle("����2"); // ��ʱ��t �������ֶ������������ݿ�������
		
		Session session2 = sf.getCurrentSession();
		session2.beginTransaction();
		session2.update(t);
		session2.getTransaction().commit();
	}
	
	/**
	 * ��ִ��һ�� update ���
	 */
	@Test
	public void testUpdate44() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Teacher t = (Teacher)session.get(Teacher.class, 1);
		t.setName("Jim1");
		session.update(t); // �൱���ֶ� commit
		session.getTransaction().commit();
	}
	
	/**
	 * ������ֵ���ĵ��ֶ�
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
	 * ��ִ�� insert ��ִ�� update
	 */
	@Test
	public void testSaveOrUpdate1() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Teacher t = new Teacher();
		t.setName("Jack1");
		t.setAge(25);
		t.setTitle("������0");
		session.saveOrUpdate(t);
		session.getTransaction().commit();
		
		t.setName("Jack11");
		Session session2 = sf.getCurrentSession();
		session2.beginTransaction();
		session2.saveOrUpdate(t);
		session2.getTransaction().commit();
	}
	
	/**
	 * ��ѯһ�Σ���Ϊ  session�����д��ڸö���
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
	 * ��ѯ ���Σ�������һ�� session ʱ����ִ�и��ԵĲ�ѯ��
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
	 * ��ѯ���Σ����˻��棬��Ҫ�ٴ�ִ�в�ѯ��
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
	 * ִ��һ�� update
	 */
	@Test
	public void testFlush1() {
//		Teacher t = new Teacher();
//		t.setName("Lucy1");
//		t.setAge(19);
//		t.setGender(Gender.FEMALE);
//		t.setTitle("����5");
		
		Session sn1 = sf.getCurrentSession();
		sn1.beginTransaction();
		Teacher t1 = (Teacher)sn1.get(Teacher.class, 2);
		t1.setName("Lily1");
		t1.setName("Lily2");
		sn1.getTransaction().commit();
		
	}
	
	/**
	 * ִ���� �� update
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
		// �������ڵĻ�������ɾ�� 
		new SchemaExport(new Configuration().configure()).create(true, true);
	}
}
















