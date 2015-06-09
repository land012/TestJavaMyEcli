package com.umbrella.thread;

import org.apache.log4j.Logger;

/**
 * 死锁
 * @author asdf
 * 所谓同步，是在不同线程访问对一个对象发生的情况
 * 所谓锁，是指具体某一个对象的锁，这个锁同一时刻只能被一个线程拿到
 *
 */
public class DeadLockDemo3 {
	
	private static Logger log = Logger.getLogger(DeadLockDemo3.class);

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		final Friend alphonse = new Friend("Alphonse");
		final Friend edward = new Friend("Edward");
		
		/**
		 * 所谓 同步，是对不同线程中的同一个对象而言的
		 * 不同对象，不存在互斥访问方法的问题
		 * 所以，下面两个线程都会进入 bow()方法
		 * 
		 * 这样，线程A 拿到了 alphonse的内部锁，线程B拿到了 edward 的内部锁
		 * 当线程A 的 bow() 中执行 edward.bowBack() 方法时，需要获取edward的内部锁，
		 * 这时线程A当然拿不到edward的锁
		 */
		new Thread(new Runnable() {
			@Override
			public void run() {
				alphonse.bow(edward);
			}
		}).start();
		
		Thread.sleep(500);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				edward.bow(alphonse);
			}
		}).start();
	}
	
	static class Friend {
		private String name;
		
		public Friend(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
		
		/**
		 * 向 bower鞠躬
		 * @param bower
		 * 
		 */
		public synchronized void bow(Friend bower) {
//			System.out.format("%s:%s has bowed to me%n", this.name, bower.getName());
			log.info(this.name + " : I has bowed to " + bower.getName());
			
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			
			bower.bowBack(this);
		}
		
		/**
		 * 向 bower鞠回去
		 * @param bower
		 */
		private synchronized void bowBack(Friend bower) {
//			System.out.format("%s:%s has bowed back to me%n", this.name, bower.getName());
			log.info(this.name + " : I has bowed back to " + bower.getName());
		}
	}

}
