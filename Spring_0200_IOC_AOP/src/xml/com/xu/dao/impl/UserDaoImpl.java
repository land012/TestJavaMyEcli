package xml.com.xu.dao.impl;

import org.springframework.stereotype.Component;

import xml.com.xu.dao.UserDao;
import xml.com.xu.model.User;

@Component("userDao")
public class UserDaoImpl implements UserDao {

	@Override
	public void save(User user) {
		System.out.println("save user " + user.getName() + " !");
	}

}
