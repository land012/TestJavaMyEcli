package com.umbrella.designpattern.observer.p2;

import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("���ǹ۲��� MyObserver�����۲��߷����ı��ˣ�arg=" + arg.toString());
	}

}
