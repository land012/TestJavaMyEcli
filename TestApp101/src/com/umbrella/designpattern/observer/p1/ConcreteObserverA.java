package com.umbrella.designpattern.observer.p1;

public class ConcreteObserverA implements Observer {

	@Override
	public void update(Object obj) {
		System.out.println("�۲��� ConcreteObserverA ��֪ͨ�ˣ�" + obj.toString());
	}

}
