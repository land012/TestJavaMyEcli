package test.xu.test;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.xu.aop.LogHandler;
import com.xu.dao.UserDao;
import com.xu.dao.impl.UserDaoImpl;
import com.xu.model.User;

public class ProxyTest {
	
	@Test
	public void testProxy1() {
		UserDao userDao = new UserDaoImpl();
		LogHandler handler = new LogHandler(userDao);
		UserDao proxy = (UserDao)Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
				new Class[]{UserDao.class},
				handler);
		User u = new User();
		u.setName("tom");
		proxy.save(u);
	}
}
