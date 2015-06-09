package com.umbrella.designpattern.observer.p1;

import java.util.Iterator;

public class ConcreteObservable extends Observable {

	@Override
	public void notifyAllObservers() {
		for(Iterator<Observer> it = this.observers.iterator(); it.hasNext(); ) {
			it.next().update("通知观察者了!");
		}
	}

}
