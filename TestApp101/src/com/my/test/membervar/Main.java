package com.my.test.membervar;

public class Main {
	public static void main(String[] args) {
		/*
		 * Exception in thread "main" java.lang.StackOverflowError
		 * 	at com.my.membervar.B.<init>(B.java:4)
		 * 	at com.my.membervar.A.<init>(A.java:4)
		 */
//		A a = new A();
		
		/*
		 * 不会抛异常
		 */
//		C c = new C();
		
		/*
		 * 不会抛异常
		 */
		F f = new F();
		f.fn1();
	}
}
