package com.umbrella.volatilet.thread;

import com.umbrella.volatilet.Counter;

public class R1 implements Runnable {

	private Counter c;
	
	public R1(Counter c) {
		this.c = c;
	}
	
	@Override
	public void run() {
		c.fn1();
	}

}
