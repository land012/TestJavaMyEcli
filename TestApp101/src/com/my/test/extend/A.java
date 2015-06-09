package com.my.test.extend;

public class A {
	
	public A() {
		System.out.println("construct A");
	}
	
	public void fn1() {
		System.out.println("this is A!");
	}
	
	public void finalize() {
		System.out.println("finalize A!");
	}
}
