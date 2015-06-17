package com.bjsxt.structs2.user.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.bjsxt.structs2.user.model.User;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	
	private User user = new User();
	
	public String add() {
		System.out.println(user.getName() + ":" + user.getPassword());
		return SUCCESS;
	}
	
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}












