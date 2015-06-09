package com.umbrella.volatilet;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.umbrella.volatilet.thread.R1;
import com.umbrella.volatilet.thread.R2;
import com.umbrella.volatilet.thread.R3;
/**
 * 
 * @author asdf
 * 仍然没有写出来测试 volatile 的Demo
 *
 */
public class Main {
	
	private static Logger log = Logger.getLogger(Main.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test3();
	}
	
	public static void test1() {
		final Counter c1 = new Counter();
		final CountDownLatch cdl = new CountDownLatch(1);
		final CountDownLatch cdl2 = new CountDownLatch(2);
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		for(int i=0; i<2; i++) {
			exec.execute(new Runnable() {
				@Override
				public void run() {
					try {
						cdl.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					c1.add();
					cdl2.countDown();
				}
			});
		}
		
		cdl.countDown();
		exec.execute(new Runnable() {
			@Override
			public void run() {
				try {
					cdl2.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				log.info(c1.get());
			}
		});
		exec.shutdown();
	}
	
	public static void test2() {
		Counter c1 = new Counter();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new R1(c1));
		try {
			Thread.sleep(1 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		exec.execute(new R2(c1));
		exec.shutdown();
	}
	
	public static void test3() {
		Counter c1 = new Counter();
		CountDownLatch cdl1 = new CountDownLatch(2);
		
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new R3(c1, cdl1));
		exec.execute(new R3(c1, cdl1));
		exec.shutdown();
		
		try {
			cdl1.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(c1.get());
		
	}

}
