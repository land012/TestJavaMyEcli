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
import com.land.bbs.vo.MsgInfo;
import com.land.bbs.vo.Topic;
import com.land.util.HibernateUtil;
import com.land.util.RecursionUtil;


public class BBSTest {
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
	 * 给 sql 传参数
	 */
	@Test
	public void testGet1() {
		testSave1();
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Category c where c.id > :param1 order by c.id desc")
			.setParameter("param1", 5);
		List<Category> list = query.list();
		for(Category c : list) {
			System.out.println(c.getName());
		}
		
		session.getTransaction().commit();
	}
	
	/**
	 * 分页
	 */
	@Test
	public void testGet2() {
		testSave1();
		
		int pagesize = 3;
		int page = 1;
		int startrecord = (page-1) * pagesize;
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("select c.id, c.name from Category c order by c.id")
			.setMaxResults(pagesize)
			.setFirstResult(startrecord);
		List<Object[]> list = query.list();
		for(Object[] o : list) {
			System.out.println(o[0]);
		}
		
//		// 异常 java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
//		List<String[]> list = query.list();
//		for(String[] s : list) {
//			System.out.println(s[0]);
//		}
		
		session.getTransaction().commit();
	}
	
	/**
	 * 关联
	 */
	@Test
	public void testGet3() {
		testSave1();
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Msg t where t.topic.category.id=1 order by t.id");
		List<Msg> list = query.list();
		for(Msg m : list) {
			System.out.println(m.getCont() + "-" + m.getTopic().getName() + "-" + m.getTopic().getCategory().getName());
		}
		
		session.getTransaction().commit();
	}
	
	/**
	 * 传值对象
	 */
	@Test
	public void testGet4() {
		testSave1();
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("select new com.land.bbs.vo.MsgInfo(t.id, t.cont, t.topic.name, t.topic.category.name) from Msg t where t.id=1");
		List<MsgInfo> list = query.list();
		for(MsgInfo m : list) {
			System.out.println(m.getCont() + "-" + m.getTopicName() + "-" + m.getCategoryName());
		}
		
		session.getTransaction().commit();
	}
	
	/**
	 * 传值对象2
	 */
	@Test
	public void testGet4_2() {
		testSave1();
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("select new Msg(t.id, t.cont, t.topic) from Msg t where t.id=1");
		Msg m = (Msg)query.uniqueResult();
		System.out.println(m.getCont() + "-" + m.getTopic().getName());
		
		session.getTransaction().commit();
	}
	
	/**
	 * join —— inner join
	 * left join —— left outer join
	 * uniqueResult
	 */
	@Test
	public void testGet5() {
		testSave1();
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("select t1.cont, t2.name from Msg t1 left join t1.topic t2 where t1.id=1");
		Object[] o = (Object[])query.uniqueResult();
		System.out.println(o[0] + "-" + o[1]);
		
		session.getTransaction().commit();
	}
	
	@Test
	public void testGet5_1() {
		testSave1();
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("select count(*) from Msg");
		long count = (Long)query.uniqueResult();
		System.out.println("记录条数：" + count);
		
		session.getTransaction().commit();
	}
	
	/**
	 * is empty
	 */
	@Test
	public void testGet6() {
		testSave1();
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		String sql = "from Topic t where t.msgs is empty";
		Query q = session.createQuery(sql);
		
		List<Topic> list = q.list();
		for(Topic t : list) {
			System.out.println(t.getName());
		}
		
		session.getTransaction().commit();
	}
	
	@Test
	public void testUpdate1() {
		testSave1();
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		String sql = "update Topic t set t.name='t001' where t.id = 1";
		Query q = session.createQuery(sql);
		System.out.println(q.executeUpdate());
		session.getTransaction().commit();
	}
	
	/**
	 * Criteria
	 */
	@Test
	public void testCriteria1() {
		testSave1();
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Criteria c = session.createCriteria(Topic.class).add(Restrictions.or(Restrictions.lt("id", 3),
				Restrictions.gt("id", 8)));
		List<Topic> list = c.list();
		for(Topic t : list) {
			System.out.println(t.getName());
		}
		session.getTransaction().commit();
	}
	
	/**
	 * QBE
	 */
	@Test
	public void testQBE1() {
		testSave1();
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		
		Topic tEx = new Topic();
		tEx.setName("%1%");
		
		Example ex = Example.create(tEx).ignoreCase().enableLike();
		
		Criteria c = session.createCriteria(Topic.class).add(ex);
		List<Topic> list = c.list();
		for(Topic t : list) {
			System.out.println(t.getName());
		}
		session.getTransaction().commit();
	}
	
	@Test
	public void testSave2() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		
		for(int i=1; i<4; i++) {
			Category c = new Category();
			c.setName("c" + i);
			Topic t = new Topic();
			t.setName("t" + i);
			t.setCategory(c);
			session.save(c);
			session.save(t);
		}
		
		session.getTransaction().commit();
	}
	
	/**
	 * 1+N
	 */
	@Test
	public void testGet2_1() {
		testSave2();
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		List<Topic> list = session.createQuery("from Topic t").list();
		for(Topic t : list) {
			System.out.println(t.getName());
		}
		session.getTransaction().commit();
	}
	
	@Test
	public void testGet2_2() {
		testSave2();
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		List<Topic> list = session.createQuery("from Topic t left join fetch t.category").list();
		for(Topic t : list) {
			System.out.println(t.getName());
		}
		session.getTransaction().commit();
	}
	
	/**
	 * 根上面的比较，这句  sql 取出了两个对象
	 */
	@Test
	public void testGet2_3() {
		testSave2();
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		List<Object[]> list = session.createQuery("from Topic t left join t.category").list();
		for(Object[] o : list) {
			Topic t = (Topic)o[0];
			Category c = (Category)o[1];
			System.out.println(t.getName() + " - " + c.getName());
		}
		session.getTransaction().commit();
	}
	
	@Test
	public void testIterator() {
		testSave2();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		List<Category> list = session.createQuery("from Category").list(); // 发一次sql
		Iterator<Category> it = session.createQuery("from Category").iterate(); // 发一次sql
		
		for(; it.hasNext();) {
			Category c = it.next();
			// 不会再去库取，因为 list() 已经将 Category 放到了 session缓存
			System.out.println(c.getName());
		}
	}
}



















