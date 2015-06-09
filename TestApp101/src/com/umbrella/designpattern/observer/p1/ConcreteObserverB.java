package com.umbrella.designpattern.observer.p1;

public class ConcreteObserverB implements Observer {

	@Override
	public void update(Object obj) {
		System.out.println("观察者 ConcreteObserverB 被通知了！" + obj.toString());
	}

}
