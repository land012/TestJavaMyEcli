package test.com.xu.aop;

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
		/*
		 * ���������Ĳ���
		 * ������Ҫ����������ʵ����
		 * ʹ�÷���ķ�ʽ���� ����ʵ����ķ���
		 */
		LogHandler handler = new LogHandler(userDao);
		
		// ���ɴ�����
		UserDao proxy = (UserDao)Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
				new Class[]{UserDao.class},
				handler);
		
		System.out.println("================================================");
		System.out.println("proxy=" + proxy);
		System.out.println("================================================");
		
		User u = new User();
		u.setName("tom");
		proxy.save(u);
		
	}
}