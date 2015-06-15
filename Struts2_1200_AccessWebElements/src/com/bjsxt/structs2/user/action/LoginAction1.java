package com.bjsxt.structs2.user.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction1 extends ActionSupport {
	
	private Map request;
	private Map session;
	private Map application;
	//private Map myRequest;
	
	private String username;
	private String password;
	
	public LoginAction1() {
		request = (Map)ActionContext.getContext().get("request");
		session = ActionContext.getContext().getSession();
		application = ActionContext.getContext().getApplication();
		//myRequest = (Map)ActionContext.getContext().get("myRequest");
	}
	
	@Override
	public String execute() {
		request.put("r1_name", "r1_value");
		request.put("username", username);
		request.put("password", password);
		session.put("s1_name", "s1_value");
		application.put("a1_name", "a1_value");
		//myRequest.put("mr_name1", "mr_value1"); //±¨´í
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
}












