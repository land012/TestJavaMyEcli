package com.umbrella.concurrent.atomic;

import java.util.concurrent.CountDownLatch;

//import org.apache.log4j.Logger;
/**
 * �̸߳���
 * @author asdf
 * �߳�1��100000�Σ��߳�2��100000�Σ�ϣ���õ��Ľ����0�����������һ����0
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
		 * �߳�1
		 */
		new Thread(new Runnable() {
			@Override
			public void run() {
//				log.info("�߳�1 start");
				for(int i=0; i<100000; i++) {
					id.incr();
				}
//				log.info("�߳�1 end");
				latch.countDown();
			}
		}).start();
		
		/*
		 * �߳�2
		 */
		new Thread(new Runnable() {
			@Override
			public void run() {
//				log.info("�߳�2 start");
				for(int i=0; i<100000; i++) {
					id.decr();
				}
//				log.info("�߳�2 end");
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
