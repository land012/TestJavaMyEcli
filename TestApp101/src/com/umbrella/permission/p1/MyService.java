package com.umbrella.permission.p1;


public class MyService extends MyServiceIf {
	
	// 只有同一个包里的类或子类才能调用
	protected void fn1() {
		System.out.println("this is fn1");
	}

	@Override
	protected void fn2() {
		System.out.println("this is fn2");
	}
}
