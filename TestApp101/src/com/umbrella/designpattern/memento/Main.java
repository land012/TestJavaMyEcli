package com.umbrella.designpattern.memento;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConcreteOriginator co1 = new ConcreteOriginator();
		co1.setState("ԭ״̬");
		Memento m1 = co1.save();
		System.out.println(co1);
		co1.setState("��״̬");
		System.out.println(co1);
		co1.recover(m1);
		System.out.println(co1);
		
	}

}
