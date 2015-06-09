package com.umbrella.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//import org.apache.log4j.Logger;

/**
 * ʹ�� �������� ReentrantLock ������������
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
		 * �����Ϲ�
		 * @param bower
		 * @return
		 */
		private boolean impendingBow(Friend bower) {
			boolean myLock = false;
			boolean yourLock = false;
			try {
				myLock = this.lock.tryLock();    // ���Ի�ȡ��ǰ�������
				yourLock = bower.lock.tryLock(); // ���Ի�ȡbower����
			} finally {
				if(!(myLock && yourLock)) {
					if(myLock) this.lock.unlock();     // �ͷ���
					if(yourLock) bower.lock.unlock();
				}
			}
			
			return myLock && yourLock;
		}
		
		/**
		 * bower�Ϲ�
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
					// �� bower �ϻ�ȥ
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
		 * bower�ϻ���
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
