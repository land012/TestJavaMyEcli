package com.xyz.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.xyz.model.User;
import com.xyz.service.UserManager;
import com.xyz.util.ContextUtil;

@Component("accountAction")
@Scope("prototype")
public class AccountAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3813211859489407720L;
	
	private static Logger log = Logger.getLogger("logs");
	
//	private UserManager userManager = (UserManager)SystemInit.getApplicationContext().getBean("userManager");
	
	private UserManager userManager;
	
	private List<User> userlist;
	
	public AccountAction() {
		log.info("AccountAction construction!");
	}
	
	public String register() {
//		UserManager um = (UserManager)ContextUtil.getBean(request, "userManager");
//		if(null != um) um.fn1();
		
		String username = StringUtils.trimToEmpty(request.getParameter("username"));
		String password = StringUtils.trimToEmpty(request.getParameter("password"));
		String password2 = StringUtils.trimToEmpty(request.getParameter("password2"));
		
		if(StringUtils.isNotEmpty(username)) {
			log.info("用户名：" + username);
//			try {
//				log.info("用户名：" + URLDecoder.decode(username, "utf-8"));
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
			log.info("密码：" + password);
			log.info("确认密码：" + password2);
			if(StringUtils.isEmpty(password)
					|| StringUtils.isEmpty(password2)) {
				return "registerFail";
			}
			if(!StringUtils.equals(password, password2)) {
				return "registerFail";
			}
			
			User u = new User();
			u.setUsername(username);
			u.setPassword(password);
			
//			if(null != username) return null;
			
			if(userManager.exsits(u)) {
				return "registerFail";
			}
			
			userManager.add(u);
			return "registerSuccess";
		}
		return "register";
	}
	
	public String userlist() {
		List<User> userlist = userManager.getUserList();
		if(null != userlist) {
			log.info("用户数为：" + userlist.size());
		} else {
			log.info("找不到用户");
		}
//		request.setAttribute("userlist", userlist);
		this.userlist = userlist;
		return "userlist";
	}
	
	public String userinfo() {
		String id = request.getParameter("id");
		User u = userManager.getUser(Integer.parseInt(id));
		log.info("username=" + u.getUsername());
		request.setAttribute("user", u);
		return "userinfo";
	}
	
	// ----------------------- Getters and Setters --------------------------
	
	public UserManager getUserManager() {
		return userManager;
	}
//	@Resource
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<User> getUserlist() {
		return userlist;
	}
	
	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
}
