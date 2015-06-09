package xml.com.xu.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import xml.com.xu.dao.OpetLogDao;
import xml.com.xu.model.OpetLog;

@Component("opetLogDao")
public class OpetLogDaoImpl implements OpetLogDao {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(OpetLog l) {
		Session session = sessionFactory.getCurrentSession();
		session.save(l);
//		throw new NullPointerException();
	}

}
