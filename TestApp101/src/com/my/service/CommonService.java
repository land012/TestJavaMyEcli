package com.my.service;

public class CommonService {
	private static UserService userService = new UserService();
	
	public void fn1() {
		userService.fn1();
	}
}
