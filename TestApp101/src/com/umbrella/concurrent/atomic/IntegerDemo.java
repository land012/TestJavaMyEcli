package com.umbrella.concurrent.atomic;

import java.util.concurrent.CountDownLatch;

//import org.apache.log4j.Logger;
/**
 * 线程干扰
 * @author asdf
 * 线程1加100000次，线程2减100000次，希望得到的结果是0，但结果并不一定是0
 *
 */
public class IntegerDemo {
	
//	private static Logger log = Logger.getLogger(IntegerDemo.class);
	
	private int c = 0;

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		final IntegerDemo id = new IntegerDemo();
		final CountDownLatch latch = new CountDownLatch(2);
		
		/*
		 * 线程1
		 */
		new Thread(new Runnable() {
			@Override
			public void run() {
//				log.info("线程1 start");
				for(int i=0; i<100000; i++) {
					id.incr();
				}
//				log.info("线程1 end");
				latch.countDown();
			}
		}).start();
		
		/*
		 * 线程2
		 */
		new Thread(new Runnable() {
			@Override
			public void run() {
//				log.info("线程2 start");
				for(int i=0; i<100000; i++) {
					id.decr();
				}
//				log.info("线程2 end");
				latch.countDown();
			}
		}).start();
		
		latch.await();
		
		System.out.println(id.value());
	}
	
	public void incr() {
		c++;
	}
	
	public void decr() {
		c--;
	}
	
	public int value() {
		return c;
	}

}
