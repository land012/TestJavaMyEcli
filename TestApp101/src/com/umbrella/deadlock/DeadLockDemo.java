package com.umbrella.deadlock;

import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;
/**
 * �򵥵���������
 * @author asdf
 * �����̷߳���ͬһ������Ĳ�ͬ synchronized����
 *
 */
public class DeadLockDemo {
	
	private static Logger log = Logger.getLogger(DeadLockDemo.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final CountDownLatch mutex = new CountDownLatch(2);
		
		final Counter counter = new Counter();
		
		/**
		 * �����̻߳ụ����� inc() ��  inc2()
		 * ��Ϊ�߳�A ���� inc()ʱ����ȡ�˶���counter���ڲ���
		 * ��ʱ���߳�B �ò���counter���ڲ������޷����� inc2()�������ȴ�A�ͷ���
		 * mutex �޷�countDown()�����߳��޷�����ִ��
		 */
		new Thread(new Runnable() {
			@Override
			public void run() {
				counter.inc(Thread.currentThread().getName());
				mutex.countDown();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				counter.inc2(Thread.currentThread().getName());
				mutex.countDown();
			}
		}).start();
		
		log.info(counter.getCount()); // 0
		
		try {
			mutex.await(); // �ȴ����������߳�ִ����
			log.info(counter.getCount()); // 2
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	static class Counter {
		private int count = 0;
		
		public synchronized void inc(String threadName) {
			log.info("i am " + threadName);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.count++;
		}
		
		public synchronized void inc2(String threadName) {
			log.info("i am " + threadName);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.count++;
		}
		
		public int getCount() {
			return this.count;
		}
	}
}
