package com.umbrella.designpattern.mediatar;
/**
 * 调停者模式
 * @author asdf
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Manager manager = new Manager();
		Designer d1 = new Designer(manager);
		Programmer p1 = new Programmer(manager);
		Tester t1 = new Tester(manager);
		manager.setProgrammer(p1);
		manager.setTester(t1);
		d1.process();
	}

}
