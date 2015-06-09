package com.umbrella.designpattern.observer.p1;

import java.util.ArrayList;
import java.util.List;

/**
 * ±ªπ€≤Ï’ﬂ
 * @author asdf
 *
 */
public abstract class Observable {
	protected List<Observer> observers = new ArrayList<Observer>();
	
	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}
	
	public void removeObserver(Observer observer) {
		this.observers.remove(observer);
	}
	
	public void removeAll() {
		this.observers.clear();
	}
	
	public abstract void notifyAllObservers();
}
