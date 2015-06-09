package com.umbrella.produconsu;

import org.apache.log4j.Logger;

/**
 * 
 * @author asdf
 *
 */
public class Producer implements Runnable {
	
	private static Logger log = Logger.getLogger(Producer.class);
	
	private Box box;
	
	public Producer(Box box) {
		this.box = box;
	}

	@Override
	public void run() {
		String[] arr = { "a", "b", "c", "d" };
		for(int i=0; i<arr.length; i++) {
			log.info("produce : " + arr[i]);
			box.put(arr[i]);
			try {
				Thread.sleep((long)(Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		box.put("DONE");
	}
}
