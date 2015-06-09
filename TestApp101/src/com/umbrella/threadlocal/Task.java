package com.umbrella.threadlocal;

public class Task implements Runnable {
	
	private String name;
	
	public Task(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		User u = new User(name);
		Step1 step1 = new Step1(u);
		step1.exe();
	}

}
