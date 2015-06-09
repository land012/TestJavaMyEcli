package com.umbrella.designpattern.observer.p1;

public class ConcreteObserverA implements Observer {

	@Override
	public void update(Object obj) {
		System.out.println("观察者 ConcreteObserverA 被通知了！" + obj.toString());
	}

}
