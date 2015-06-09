package test.com.xyz.dao;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xyz.dao.UserDao;
import com.xyz.model.User;

public class UserDaoTest3 {
	
	private static ApplicationContext ctx;
	private static UserDao userDao;
	
	@Before
	public void before() {
		ctx = new ClassPathXmlApplicationContext(new String[]{ "classpath:applicationContext2.xml" });
		/*
		 * ·ºÐÍ
		 */
		userDao = ctx.getBean("userDao", UserDao.class);
	}
	
	@Test
	public void test1() {
		User u = new User();
		u.setUsername("tom");
		Assert.assertTrue(userDao.save(u));
	}
}
