package com.umbrella.threadpool3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.umbrella.threadpool3.Task;

public class FixedThreadPoolTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		for(int i=0; i<5; i++) {
			pool.execute(new Task());
		}
		pool.shutdown();
	}

}
