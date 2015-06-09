package com.xyz.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.xyz.dao.UserDao;
import com.xyz.model.User;
@Component("userDao")
public class UserDaoImpl extends BaseDao implements UserDao {
	
	private static Logger log = Logger.getLogger("logs");

	@Override
	public User get(User u) {
		return null;
	}

	@Override
	public boolean exsits(User u) {
		String sql = "select count(*) from User t where t.username=?";
		List<Long> list = this.getHibernateTemplate().find(sql, new String[]{ u.getUsername() });
		if(null == list || list.size() == 0) {
			return false;
		}
		long count = list.get(0);
		log.info("ÓÃ»§Êý£º" + count);
		if(count==0) return false;
		return true;
	}

	@Override
	public boolean add(User u) {
		Integer i = (Integer)this.getHibernateTemplate().save(u);
		if(null == i) return false;
		return true;
	}

	@Override
	public List<User> getUserList() {
		return this.getHibernateTemplate().find("from User");
	}

	@Override
	public User getUser(int id) {
		User u = (User)this.getHibernateTemplate().load(User.class, id);
//		System.out.println(u.getUsername());
		return u;
	}

}
