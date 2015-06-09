package com.umbrella.designpattern.composite;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Apple a1 = new Apple();
		a1.setPrice(4);
		a1.setCount(1);
		Banana b1 = new Banana();
		b1.setPrice(2);
		b1.setCount(3);
		CompositeFruit cf1 = new CompositeFruit();
		cf1.add(a1);
		cf1.add(b1);
		System.out.println(a1.getTotalPrice());
		System.out.println(b1.getTotalPrice());
		System.out.println(cf1.getTotalPrice());
		
		CompositeFruit cf2 = new CompositeFruit();
		cf2.add(a1);
		cf2.add(b1);
		cf2.add(cf1);
		System.out.println(cf2.getTotalPrice());
	}

}
