package xml.com.xu.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import xml.com.xu.base.BaseDao;
import xml.com.xu.dao.UserDao;
import xml.com.xu.model.Student;
import xml.com.xu.model.User;

@Component("userDao")
public class UserDaoImpl extends BaseDao implements UserDao {
	
//	private SessionFactory sessionFactory;
//
//	public SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//	@Resource
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
//	
//	
//	@Override
//	public void save(User user) {
//		Session session = sessionFactory.getCurrentSession();
//		session.save(user);
//	}
//
//	@Override
//	public void save(Student s) {
//		Session session = sessionFactory.getCurrentSession();
//		session.save(s);
//	}
	
//	private HibernateTemplate hibernateTemplate;
//	
//	public HibernateTemplate getHibernateTemplate() {
//		return hibernateTemplate;
//	}
//	@Resource
//	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
//		this.hibernateTemplate = hibernateTemplate;
//	}
//	
//	@Override
//	public void save(User user) {
//		hibernateTemplate.save(user);
//	}
//
//	@Override
//	public void save(Student s) {
//		
//	}
	
	@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}
	
	@Override
	public void save(Student s) {
		
	}

}
