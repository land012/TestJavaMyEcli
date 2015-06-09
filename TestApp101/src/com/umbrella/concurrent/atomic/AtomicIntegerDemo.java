package com.umbrella.concurrent.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * ԭ����
 * @author asdf
 * ��ֹ�̸߳���
 *
 */
public class AtomicIntegerDemo {
	private AtomicInteger c = new AtomicInteger(0);
	
	public void incr() {
		c.incrementAndGet();
	}
	
	public void decr() {
		c.decrementAndGet();
	}
	
	public int value() {
		return c.get();
	}
	
	public static void main(String[] args) {
		final AtomicIntegerDemo aid = new AtomicIntegerDemo();
		final int count = 100000; // 10���
		
		final CountDownLatch latch = new CountDownLatch(2);
		
		/*
		 * �߳�1
		 */
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<count; i++) {
					aid.incr();
				}
				latch.countDown();
			}
		}).start();
		
		/*
		 * �߳�2
		 */
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<count; i++) {
					aid.decr();
				}
				latch.countDown();
			}
		}).start();
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(aid.value()); // 0
	}
}
