package com.umbrella.thread;

import org.apache.log4j.Logger;

public class WaitDemo {
	
	private static Logger log = Logger.getLogger(WaitDemo.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * �߳�ͬ��
		 */
		new Thread(new ThreadDemo("tom", 1)).start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Exception in thread "main" java.lang.IllegalMonitorStateException
		try {
//			new WaitDemo().notifyAll();
		} catch(Exception e) {
			log.info("", e);
		}
		
		
//		new Thread(new ThreadDemo("jim", 2)).start();
		
		log.info("main finished!");
	}
	
	static class ThreadDemo implements Runnable {
		
		private static Integer mutex = new Integer(1);
		private String name;
		private int i;

		public ThreadDemo(String name, int i) {
			this.name = name;
			this.i = i;
		}

		@Override
		public void run() {
			log.info(name + "-" + i + " start!");
			if(i==1) {
//				log.info(name + "-" + i + " wait Lock...");
				synchronized(mutex) {
//					log.info(name + "-" + i + " get Lock!");
					try {
						/**
						 * ����ĳ������� wait()��������ζ��ʲô��
						 * ��ǰ�߳��ͷŵ� mutex ����
						 */
						mutex.wait();
//						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(mutex) {
					mutex.notify();
				}
			}
			log.info(name + "-" + i + " end!");
		}
	}

}
