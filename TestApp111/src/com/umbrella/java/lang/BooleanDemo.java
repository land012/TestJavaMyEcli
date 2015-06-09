package com.umbrella.java.lang;

public class BooleanDemo {

	public static void main(String[] args) {
		Boolean b1 = new Boolean(true);
		Boolean b2 = new Boolean(true);
		System.out.println(b1==true); // true
		System.out.println(b2==true); // true
		System.out.println(b1==b2);   // false
	}

}
