package com.bjsxt.structs2.user.action;

import com.opensymphony.xwork2.ActionSupport;
import com.bjsxt.structs2.user.model.User;

public class UserAction extends ActionSupport {
	
	private User user;
	
	public String add() {
		System.out.println(user.getName() + ":" + user.getPassword());
		return SUCCESS;
	}
	
	public String delete() {
		// TODO Auto-generated method stub
		return "myr_delete";
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}












