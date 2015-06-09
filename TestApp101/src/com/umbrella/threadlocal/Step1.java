package com.umbrella.threadlocal;

public class Step1 {
	
	private Step2 step2 = new Step2();
	
	private User user;
	
	public Step1(User user) {
		this.user = user;
	}
	
	public void exe() {
		// 将 user 放到 ThreadLocalMap 中
		if("1".equals(user.getName())) UserUtil.setUser(user);
		step2.exe();
	}
}
