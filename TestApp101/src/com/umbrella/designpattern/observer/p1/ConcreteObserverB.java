package com.umbrella.designpattern.observer.p1;

public class ConcreteObserverB implements Observer {

	@Override
	public void update(Object obj) {
		System.out.println("�۲��� ConcreteObserverB ��֪ͨ�ˣ�" + obj.toString());
	}

}
