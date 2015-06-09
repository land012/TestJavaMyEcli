package com.umbrella.produconsu;

import org.apache.log4j.Logger;

public class Consumer implements Runnable {
	
	private static Logger log = Logger.getLogger(Consumer.class);
	
	private Box box;
	
	public Consumer(Box box) {
		this.box = box;
	}

	@Override
	public void run() {
		String msg = box.take();
		while(!"DONE".equals(msg)) {
			log.info("consume : " + msg);
			try {
				Thread.sleep((long)(Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			msg = box.take();
		}
	}
	
}
