package com.umbrella.deadlock;

import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;
/**
 * 简单的死锁测试
 * @author asdf
 * 两个线程访问同一个对象的不同 synchronized方法
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
		 * 两个线程会互斥进入 inc() 和  inc2()
		 * 因为线程A 进入 inc()时，获取了对象counter的内部锁
		 * 这时，线程B 拿不到counter的内部锁，无法进入 inc2()方法，等待A释放锁
		 * mutex 无法countDown()，主线程无法继续执行
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
			mutex.await(); // 等待上面两个线程执行完
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
