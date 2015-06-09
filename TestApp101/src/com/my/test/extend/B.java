package com.my.test.extend;

public class B extends A {
	
	public B() {
		System.out.println("construct B");
	}
	
	@Override
	public void fn1() {
		System.out.println("this is B!");
	}
	
	public void finalize() {
		System.out.println("finalize B!");
	}
}
