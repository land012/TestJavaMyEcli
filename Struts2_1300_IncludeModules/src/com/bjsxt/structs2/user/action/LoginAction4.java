package com.bjsxt.structs2.user.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction4 extends ActionSupport implements ServletRequestAware {
	
	private HttpServletRequest request;
	private HttpSession session;
	private ServletContext application;
	
	private String username;
	private String password;
	
	@Override
	public String execute() {
		request.setAttribute("r1_name", "r4_value");
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		session.setAttribute("s1_name", "s4_value");
		application.setAttribute("a1_name", "a4_value");
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

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
		this.application = session.getServletContext();
	}
}












