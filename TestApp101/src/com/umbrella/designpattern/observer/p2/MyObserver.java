package com.umbrella.designpattern.observer.p2;

import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("我是观察者 MyObserver，被观察者发生改变了！arg=" + arg.toString());
	}

}
