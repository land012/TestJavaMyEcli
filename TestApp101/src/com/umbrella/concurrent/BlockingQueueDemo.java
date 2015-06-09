package com.umbrella.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
		
		try {
			queue.put("a");
			queue.put("a");
			queue.put("b");
//			queue.put("c"); // 执行到这一步是会阻塞，因为队列满了
			System.out.println(queue.take());
			System.out.println(queue.take());
			System.out.println(queue.take());
			System.out.println(queue.take()); // 执行到这一步时也会阻塞，因为队列空了
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
