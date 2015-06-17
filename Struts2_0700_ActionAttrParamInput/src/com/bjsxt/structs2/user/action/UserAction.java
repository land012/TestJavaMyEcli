package com.bjsxt.structs2.user.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	private String name;
	private int age;
	
	public String add() {
		System.out.println(name + ":" + age);
		return SUCCESS;
	}
	
	public String delete() {
		// TODO Auto-generated method stub
		return "myr_delete";
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}












