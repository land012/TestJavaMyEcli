package com.bjsxt.structs2.user.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction3 extends ActionSupport {
	
	private HttpServletRequest request;
	private HttpSession session;
	private ServletContext application;
	
	private String username;
	private String password;
	
	public LoginAction3() {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		application = session.getServletContext();
	}
	
	@Override
	public String execute() {
		request.setAttribute("r1_name", "r3_value");
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		session.setAttribute("s1_name", "s3_value");
		application.setAttribute("a1_name", "a3_value");
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












