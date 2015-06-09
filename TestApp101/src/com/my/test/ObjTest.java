package com.my.test;

import com.my.base.BaseTest;


public class ObjTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dog1 d = (Dog1)null;
		if(d == null) { // true
			info.info("d 是 Null");
		}
		Dog1 d1 = new Dog1();
		if(d1.getName() == null) { // true
			info.info("d1.name 是 null");
		}
		
		/**
		 * 对象比较
		 */
		Object o1 = new Object();
		Object o2 = o1;
		Object o3 = new Object();
		System.out.println("=== Start ===");
		System.out.println("o1=" + o1);
		System.out.println("o2=" + o2);
		System.out.println("o3=" + o3);
		System.out.println(o1==o2);        // true
		System.out.println(o1.equals(o2)); //true
		System.out.println(o1==o3);        // false
		System.out.println("=== End ===");
	}

}

class Dog1 {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}