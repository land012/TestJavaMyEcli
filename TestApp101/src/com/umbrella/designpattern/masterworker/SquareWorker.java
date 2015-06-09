package com.umbrella.designpattern.masterworker;

public class SquareWorker extends Worker {

	@Override
	protected Object handle(Object task) {
		Integer obj = (Integer)task;
		try {
			Thread.sleep((long)(Math.random()*10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return obj * obj;
	}

}
