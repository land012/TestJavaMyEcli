package com.bjsxt.structs2.user.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction2 extends ActionSupport implements RequestAware, SessionAware, ApplicationAware {
	
	private Map<String, Object> request;
	private Map<String, Object> session;
	private Map<String, Object> application;
	
	private String username;
	private String password;
	
	
	@Override
	public String execute() {
		request.put("r1_name", "r2_value");
		request.put("username", username);
		request.put("password", password);
		session.put("s1_name", "s2_value");
		application.put("a1_name", "a2_value");
		return SUCCESS;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}
}












