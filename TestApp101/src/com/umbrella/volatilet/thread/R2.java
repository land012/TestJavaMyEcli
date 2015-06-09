package com.umbrella.volatilet.thread;

import com.umbrella.volatilet.Counter;

public class R2 implements Runnable {

	private Counter c;
	
	public R2(Counter c) {
		this.c = c;
	}
	
	@Override
	public void run() {
		c.fn2();
	}

}
