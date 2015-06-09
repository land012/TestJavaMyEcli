package com.my.test3;
import java.util.Calendar;


public class T5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		// 值 传递 日期会被改变
//		Calendar cal = Calendar.getInstance();
//		//System.out.println(cal.DAY_OF_MONTH); // 5 该常量代表的数值
//		//System.out.println(Calendar.DAY_OF_MONTH); // 5
//		addCal(cal);
//		System.out.println(cal.getTime().toString()); // 值被改变了
//		
//		String str1 = new String("abc");
//		modifyStr(str1);
//		System.out.println(str1); //值没有变
//		
//		Dog d = new Dog("dog1");
//		modifyDog(d);
//		System.out.println(d.name);
		
		System.out.println(System.currentTimeMillis()%10);
	}
	
	/**
	 * 值 传递问题
	 * @param cal
	 */
	public static void addCal(Calendar cal) {
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)+1);
		
		System.out.println(cal.getTime().toString());
	}
	private static void modifyStr(String str) {
		System.out.println("传进来的是：" + str);
		str = new String("def");
		System.out.println(str);
	}
	private static void modifyDog(Dog d) {
		System.out.println("传进来的是：" + d.name);
		// d.name = "dog3"; //这样就会改变传进来的 Dog
		d = new Dog("dog2");
		System.out.println(d.name);
	}
}

class Dog{
	public String name;
	public Dog(String name) {
		this.name = name;
	}
	public Dog(Dog d) {
		this.name = d.name;
	}
}













