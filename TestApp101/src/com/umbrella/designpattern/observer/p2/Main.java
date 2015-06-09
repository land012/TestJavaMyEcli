package com.umbrella.designpattern.observer.p2;

import java.util.Observer;

public class Main {
	public static void main(String[] args) {
		MyObservable osa1 = new MyObservable();
		Observer os1 = new MyObserver();
		osa1.addObserver(os1);
		osa1.setChanged();
		System.out.println(osa1.hasChanged());
		osa1.notifyObservers("通知所有观察者");
		System.out.println(osa1.hasChanged());
	}
}
