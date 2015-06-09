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
			 * �����̺߳����̺߳ϲ�
			 * ��ʱ�����̵߳������൱�����̵߳Ĵ���Ƭ�Σ����̲߳�������̲߳���ִ��
			 * ���̻߳��������ȴ����߳� 1����
			 */
			t1.join(1000);
			
			/*
			 * Ϊʲô���ӡ3�Σ�
			 * ��Ϊ���߳�ѭ��һ�Σ�ִ��1��
			 */
			long temp = System.currentTimeMillis();
			long interval = temp - startTime;
			log.info("here1! interval=" + interval);
			if((interval)>3000 && t1.isAlive()) {
				t1.interrupt();
				t1.join(); // Ϊʲô������ִ�� join
				log.info("�߳� t1 ������! ��ʱ " + (System.currentTimeMillis()-startTime) + "ms");
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
				log.info("Thread1 �� InterruptedException �쳣�ˣ�");
			}
		}
	}

}
