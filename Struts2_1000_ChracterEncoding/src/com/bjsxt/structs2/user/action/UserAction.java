package com.bjsxt.structs2.user.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	private String name;
	
	public String add() {
		System.out.println(name);
		return SUCCESS;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}












