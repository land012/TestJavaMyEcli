package com.umbrella.designpattern.observer.p2;

import java.util.Observable;
/**
 * jdk�Դ����۲���
 * @author asdf
 *
 */
public class MyObservable extends Observable {

	@Override
	public synchronized void setChanged() {
		super.setChanged();
	}

}
