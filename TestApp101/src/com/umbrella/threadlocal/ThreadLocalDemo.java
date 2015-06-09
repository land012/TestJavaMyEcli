package com.umbrella.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		ExecutorService exec = Executors.newCachedThreadPool();
		ExecutorService exec = Executors.newFixedThreadPool(2);
		
		for(int i=1; i<=4; i++) {
			exec.execute(new Task(String.valueOf(i)));
		}
		exec.shutdown();
	}

}
