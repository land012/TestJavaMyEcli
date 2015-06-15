package com.xu.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xu.vo.User;

public class UserAction extends ActionSupport implements ServletRequestAware {
	private User user;
	private HttpServletRequest request;
	
	public String login() {
		return SUCCESS;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;		
	}
	
}
