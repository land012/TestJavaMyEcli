package com.umbrella.designpattern.observer.p1;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Observable osa1 = new ConcreteObservable();
		Observer os1 = new ConcreteObserverA();
		Observer os2 = new ConcreteObserverB();
		osa1.addObserver(os1);
		osa1.addObserver(os2);
		osa1.notifyAllObservers();
		System.out.println();
		osa1.removeObserver(os1);
		osa1.notifyAllObservers();
	}

}
