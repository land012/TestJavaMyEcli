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
//			queue.put("c"); // ִ�е���һ���ǻ���������Ϊ��������
			System.out.println(queue.take());
			System.out.println(queue.take());
			System.out.println(queue.take());
			System.out.println(queue.take()); // ִ�е���һ��ʱҲ����������Ϊ���п���
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
