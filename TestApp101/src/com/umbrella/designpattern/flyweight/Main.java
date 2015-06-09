package com.umbrella.designpattern.flyweight;
/**
 * 享元模式
 * @author 大洲
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FlyweightFactory factory = FlyweightFactory.getInstance();
		Flyweight f1 = factory.getFlyweight("f1");
		f1.operate("1");
		Flyweight f2 = factory.getFlyweight("f1");
		f2.operate("2");
		Flyweight f3 = factory.getFlyweight("f3");
		f3.operate("3");
		System.out.println(f1 == f2);
		System.out.println(f1 == f3);
	}

}
