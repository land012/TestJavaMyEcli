package com.xu.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xu.vo.User;

public class TestAction extends ActionSupport {
	private String username;
	private String password;
	
	private String admin;
	
	private User u;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String fn1() {
		this.username = "aaa<br/>bbb";
		this.password = "123456";
		this.admin = "adminname";
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

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}
	
}
