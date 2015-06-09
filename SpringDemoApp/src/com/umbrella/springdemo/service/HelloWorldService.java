package com.umbrella.springdemo.service;

public class HelloWorldService {
	private String name;
	private int age;
	
	public HelloWorldService() {
		System.out.println("this is HelloWorldService()");
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
