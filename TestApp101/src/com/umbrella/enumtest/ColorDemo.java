package com.umbrella.enumtest;

public enum ColorDemo {
	RED, GREEN, BLUE;
	
	public static void main(String[] args) {
		ColorDemo cd = null;
		int i = 1;
		if(0==i) {
			cd = ColorDemo.RED;
		} else if(1==i) {
			cd = ColorDemo.GREEN;
		} else {
			cd = ColorDemo.BLUE;
		}
		if(cd == ColorDemo.GREEN) {
			System.out.println(cd);
			System.out.println(cd.toString());
			System.out.println(cd.name());
			System.out.println(cd.ordinal());
		}
		
		Object a = new Object();
		Object b = a;
		System.out.println(a);
		System.out.println(b);
		System.out.println(a==b); // true
		
	}
}
