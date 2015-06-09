package com.umbrella.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
/**
 * 
 * @author asdf
 * ������ CyclicBarrier �� await() �̴߳ﵽָ����Ŀʱ���Ͳ�����await()��
 *
 */
public class CyclicBarrierDemo {
	
	private static Logger log = Logger.getLogger(CyclicBarrierDemo.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3);
		ExecutorService exec = Executors.newFixedThreadPool(6);
		exec.submit(new Racer(barrier, "tom"));
		exec.submit(new Racer(barrier, "jim"));
		exec.submit(new Racer(barrier, "jack"));
		
		exec.submit(new Racer(barrier, "lucy"));
		exec.submit(new Racer(barrier, "lily"));
//		exec.submit(new Racer(barrier, "edward"));
		exec.shutdown();
		
//		log.info("Race finish!"); // ���̲߳��� �ȴ����߳̽�����ִ��
	}
	
	static class Racer implements Runnable {
		CyclicBarrier barrier;
		String name;
		
		public Racer(CyclicBarrier barrier, String name) {
			this.barrier = barrier;
			this.name = name;
		}
		
		@Override
		public void run() {
			log.info(this.name + " is Ready...");
			try {
				barrier.await(); // �չ�����������
				log.info(this.name + " Run!");
				Thread.sleep((long)(Math.random() * 1000));
				log.info(this.name + " Arrived!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
		
	}

}
