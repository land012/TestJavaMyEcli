package com.umbrella.concurrent.countdownLatch;

import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;
/**
 * CountDownLatch
 * @author asdf
 * ʵ����ʱָ����ʼ��ֵ
 * countDown() ���м�1
 * await() �ȴ���Ϊ0
 *
 */
public class CountDownLatchDemo {
	
	private static Logger log = Logger.getLogger(CountDownLatchDemo.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountDownLatch signal = new CountDownLatch(3);
		new Thread(new Worker(signal)).start();
		try {
//			log.info(signal.getCount());
			signal.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("ʱ�䵽��");
	}
	
	static class Worker implements Runnable {
		
		CountDownLatch signal;

		public Worker(CountDownLatch signal) {
			this.signal = signal;
		}

		@Override
		public void run() {
			
			for(int i=0; i<3; i++) {
				log.info("countdown=" + signal.getCount());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				signal.countDown();
			}
		}
	}

}
