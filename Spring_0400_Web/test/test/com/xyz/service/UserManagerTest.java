package test.com.xyz.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.xyz.model.User;
import com.xyz.service.UserManager;
import com.xyz.util.StringUtil;
import com.xyz.util.ContextUtil;
/**
 * Hibernate≤‚ ‘
 * @author asdf
 *
 */
public class UserManagerTest {
	
//	@Test
//	public void testExists() {
//		UserManager um = new UserManager();
//		User u = new User();
//		u.setUsername("tom1");
//		boolean exists = um.exists(u);
//		Assert.assertTrue(exists);
//	}
//	
//	@Test
//	public void testAdd() {
//		UserManager um = new UserManager();
//		User u = new User();
//		u.setUsername("tom2");
//		u.setPassword("tom2");
//		boolean res = um.add(u);
//		Assert.assertTrue(res);
//	}
	
	@Test
	public void testExists() {
		ApplicationContext applicationContext = ContextUtil.getApplicationContext();
		UserManager um = (UserManager)applicationContext.getBean("userManager");
		User u = new User();
		u.setUsername("tom");
		Assert.assertTrue(um.exsits(u));
	}
	
	@Test
	public void testAdd() {
		ApplicationContext applicationContext = ContextUtil.getApplicationContext();
		UserManager um = (UserManager)applicationContext.getBean("userManager");
		User u = new User();
		u.setUsername("tom" + StringUtil.getRandomNum(3));
		u.setPassword(StringUtil.getRandomNum(6));
		um.add(u);
	}
}



















