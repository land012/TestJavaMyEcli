package com.umbrella.thread;

import org.apache.log4j.Logger;

public class InterruptDemo {
	
	private static Logger log = Logger.getLogger(InterruptDemo.class);
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		log.info("main begin!");
		long startTime = System.currentTimeMillis();
		Thread t1 = new Thread(new Task());
		t1.start();
		while(t1.isAlive()) {
			/**
			 * 将子线程和主线程合并
			 * 此时，子线程的内容相当于主线程的代码片段，子线程不会和主线程并发执行
			 * 主线程会阻塞，等待子线程 1秒钟
			 */
			t1.join(1000);
			
			/*
			 * 为什么会打印3次？
			 * 因为主线程循环一次，执行1秒
			 */
			long temp = System.currentTimeMillis();
			long interval = temp - startTime;
			log.info("here1! interval=" + interval);
			if((interval)>3000 && t1.isAlive()) {
				t1.interrupt();
				t1.join(); // 为什么在这里执行 join
				log.info("线程 t1 结束了! 耗时 " + (System.currentTimeMillis()-startTime) + "ms");
			}
		}
		log.info("main end!");
	}
	
	private static class Task implements Runnable {
		@Override
		public void run() {
			try {
				for(int i=1; i<6; i++) {
					log.info(i + " begin!");
					Thread.sleep(2000);
					log.info(i + " end!");
				}
			} catch (InterruptedException e) {
				log.info("Thread1 抛 InterruptedException 异常了！");
			}
		}
	}

}
