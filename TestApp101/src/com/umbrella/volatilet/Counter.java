package com.umbrella.volatilet;

import org.apache.log4j.Logger;


public class Counter {
	
	private static Logger log = Logger.getLogger(Counter.class);
	
	private int i = 0;
	
	private static int k = 0;
	
	public void add() {
//		log.info("add begin");
		for(int j=0; j<100000; j++) {
			i++;
		}
		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		log.info("add end");
	}
	
	public int get() {
		log.info("get begin");
		return i;
	}
	
	public void fn1() {
		while(i!=9999) {
			log.info("i am fn1, i=" + i);
		}
		log.info("fn1 end");
	}
	
	public void fn2() {
		log.info("i am fn2");
		for(int j=0; j<20000; j++) {
			i++;
		}
		log.info("fn2 end");
	}
	
	public void fn3() {
		for(int j=1; j<=10000; j++) {
			k++;
			i = k;
		}
	}
}
