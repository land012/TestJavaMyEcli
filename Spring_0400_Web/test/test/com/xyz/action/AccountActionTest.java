package test.com.xyz.action;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.xyz.action.AccountAction;
import com.xyz.model.User;
import com.xyz.util.ContextUtil;

public class AccountActionTest {
	
	private ApplicationContext ctx;
	
	@Before
	public void before() {
		ctx = ContextUtil.getApplicationContext();
	}
	
	@Test
	public void testUserlist() {
		AccountAction aa = (AccountAction)ctx.getBean("accountAction");
		aa.userlist();
		List<User> users = aa.getUserlist();
		Assert.assertTrue(users.size()>0);
	}
}
