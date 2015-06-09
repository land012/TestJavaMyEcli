package com.umbrella.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//import org.apache.log4j.Logger;

/**
 * 使用 可重入锁 ReentrantLock 解析死锁问题
 * @author asdf
 *
 */
public class DeadLockDemo4 {
	
//	private static Logger log = Logger.getLogger(DeadLockDemo4.class);

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		final Friend alphonse = new Friend("Alphonse");
		final Friend edward = new Friend("Edward");

		new Thread(new BowLoop(alphonse, edward)).start();
		new Thread(new BowLoop(edward, alphonse)).start();
	}
	
	static class Friend {
		private final String name;
		private final Lock lock = new ReentrantLock();
		
		public Friend(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
		
		/**
		 * 即将鞠躬
		 * @param bower
		 * @return
		 */
		private boolean impendingBow(Friend bower) {
			boolean myLock = false;
			boolean yourLock = false;
			try {
				myLock = this.lock.tryLock();    // 尝试获取当前对象的锁
				yourLock = bower.lock.tryLock(); // 尝试获取bower的锁
			} finally {
				if(!(myLock && yourLock)) {
					if(myLock) this.lock.unlock();     // 释放锁
					if(yourLock) bower.lock.unlock();
				}
			}
			
			return myLock && yourLock;
		}
		
		/**
		 * bower鞠躬
		 * @param bower
		 * 
		 */
		public synchronized void bow(Friend bower) {
			if(impendingBow(bower)) {
				try {
					System.out.format("%s : %s has bowed to me.%n", this.name, bower.getName());
//					log.info(this.name + " : " + bower.getName() + " has bowed to me");
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// 向 bower 鞠回去
					bower.bowBack(this);
				} finally {
					this.lock.unlock();
					bower.lock.unlock();
				}
			} else {
				System.out.format("%s : %s started to bow to me, but saw that I was already bowing to him.%n", this.name, bower.getName());
			}
		}
		
		/**
		 * bower鞠回来
		 * @param bower
		 */
		private synchronized void bowBack(Friend bower) {
			System.out.format("%s : %s has bowed back to me%n", this.name, bower.getName());
//			log.info(this.name + " : " + bower.getName() + " has bowed back to me");
		}
	}
	
	static class BowLoop implements Runnable {
		private Friend bower;
		private Friend bowee;
		
		public BowLoop(Friend bower, Friend bowee) {
			this.bower = bower;
			this.bowee = bowee;
		}
		
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep((long)(Math.random()*1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				bowee.bow(bower);
			}
		}
	}

}
