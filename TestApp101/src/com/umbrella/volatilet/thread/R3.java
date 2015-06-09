package com.umbrella.volatilet.thread;

import java.util.concurrent.CountDownLatch;

import com.umbrella.volatilet.Counter;

public class R3 implements Runnable {
	
	private Counter c;
	private CountDownLatch cdl;
	
	public R3(Counter c, CountDownLatch cdl) {
		this.c = c;
		this.cdl = cdl;
	}

	@Override
	public void run() {
		c.fn3();
		cdl.countDown();
	}

}
