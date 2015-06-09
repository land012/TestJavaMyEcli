package com.my;

import org.apache.log4j.Logger;

public class Test<T> {
	
	private static final Logger log = Logger.getLogger(Test.class);
	
	public static void main(String[] args) {
//		for(int i=0; i<1000; i++) {
//			System.out.println("¹þ¹þ list.add(\"" + i + "\");");
//		}
		
//		fn1();
		
		
	}
	
	public void fn1() {
		T t = (T)new Object();
		fn2(t);
	}
	
	public void fn2(T t) {
		
	}
}
