package com.umbrella.threadpool;

import java.util.LinkedList;

import org.apache.log4j.Logger;

/**
 * �̳߳�
 * @author asdf
 * �̳� ThreadGroup �ķ�ʽ�����̳߳�
 *
 */
public class ThreadPool extends ThreadGroup {
	
	private static final Logger log = Logger.getLogger(ThreadPool.class);
	
	private boolean isClose = false;
	private LinkedList<Runnable> workQueue;
	private static String threadPoolID = "1";
	
	/**
	 * �����̳߳أ������������߳�
	 * @param threadID
	 * @return
	 * @throws InterruptedException
	 */
	public ThreadPool(int poolSize) {
		super(threadPoolID);
		this.setDaemon(true);
		this.workQueue = new LinkedList<Runnable>(); // �������
		for(int i=0; i<poolSize; i++) {
			new WorkThread(String.valueOf(i)).start();
		}
	}
	
	/**
	 * �����̻߳�ȡ�����е�����
	 * @param threadID
	 * @return
	 * @throws InterruptedException
	 */
	public synchronized Runnable getTask(String threadID) throws InterruptedException {
		while(this.workQueue.size() == 0) {
			if(this.isClose) {
				log.info("�����߳� " + threadID + ", ThreadPool �Ѿ� close");
				return null;
			}
			log.info("�����߳� " + threadID + " �ȴ�����...");
			this.wait(); // ���ø÷������߳̽��� wait ״̬
		}
		log.info("�����߳� " + threadID + " ��ʼִ������...");
		return this.workQueue.removeFirst();
	}
	
	/**
	 * ִ��������
	 * @param task
	 */
	public synchronized void execute(Runnable task) {
		if(isClose) {
			throw new IllegalStateException("�̳߳��ѹرգ�");
		}
		if(task != null) {
			this.workQueue.add(task);
			this.notify(); // �����̳߳��д��� wait ״̬���߳�
		}
	}
	
	public synchronized void closePool() {
		log.info("closePool - step-1");
		
		if(!this.isClose) {
			log.info("closePool - step-2"); // ���ﲻ�ᱻִ�е�,waitFinish() ���Ѿ� isClose=true ��
			this.waitFinish();
			this.isClose = true;
			this.workQueue.clear();
			this.interrupt();
		}
	}
	
	public void waitFinish() {
		log.info("waitFinish");
		
		synchronized(this) {
			this.isClose = true;
			/*
			 * ���������һ��
			 * ��ĳЩ�����߳̽��� wait״̬���޷������ѣ����³����޷�����
			 */
			this.notifyAll();
		}
		
//		Thread[] threads = new Thread[this.activeCount()];
//		int count = this.enumerate(threads);
//		
//		log.info("��ǰ���ڻ״̬�Ĺ����߳���=" + count);
//		
//		for(int i=0; i<count; i++) {
//			try {
//				threads[i].join();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}
	
	/**
	 * �����߳�
	 * @author asdf
	 *
	 */
	private class WorkThread extends Thread {
		private String threadID; // ��ǰ�����߳� name
		
		public WorkThread(String threadID) {
			super(ThreadPool.this, threadID);
			this.threadID = threadID;
		}

		@Override
		public void run() {
			while(!this.isInterrupted()) {
				Runnable task = null;
				try {
					task = getTask(this.threadID);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(task == null) return;
				task.run(); // �ڵ�ǰ�����߳�����������
			}
		}
	}
}
