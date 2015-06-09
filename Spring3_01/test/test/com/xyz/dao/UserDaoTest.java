package test.com.xyz.dao;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.xyz.dao.UserDao;
import com.xyz.model.User;

/**
 * SpringContextTests
 * @author asdf
 *
 */
@ContextConfiguration("classpath:applicationContext.xml")
public class UserDaoTest extends AbstractJUnit4SpringContextTests {
	@Resource
	private UserDao userDao;
	
	@Test
	public void test1() {
		User u = new User();
		u.setUsername("tom");
		Assert.assertTrue(userDao.save(u));
	}
}
