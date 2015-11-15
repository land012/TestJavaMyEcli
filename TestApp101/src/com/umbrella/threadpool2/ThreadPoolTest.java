package com.umbrella.threadpool2;

import org.junit.Test;

import com.umbrella.threadpool2.ThreadPool;

public class ThreadPoolTest {
	
	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool(3);
		for(int i=0; i<5; i++) {
			MyTask t = new MyTask();
			pool.addTask(t);
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		pool.waitFinish();
//		pool.destory();
	}
	
	@Test
	public void test1() {
		ThreadPool pool = new ThreadPool(3);
		for(int i=0; i<5; i++) {
			pool.addTask(new MyTask());
		}
		
		pool.destory();
	}
}
