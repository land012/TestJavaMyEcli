package com.umbrella.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;
/**
 * ��������
 * @author asdf
 *
 */
public class ReentrantLockDemo {
	
	private static Logger log = Logger.getLogger(ReentrantLockDemo.class);
	
	private static int resources = 5;
	private static Lock lock = new ReentrantLock();
	private static Condition pullCnd = lock.newCondition();
	private static Condition pushCnd = lock.newCondition();
	
	/**
	 * ����
	 * @return
	 */
	public int pull() {
		lock.lock();
		int index = 0;
		try {
			while(resources <= 0) {
				log.info(Thread.currentThread().getName() + " û����Դ�ˣ�֪ͨ����");
				pushCnd.signal();
				pullCnd.await();
				log.info(Thread.currentThread().getName() + " �Ѿ�������Դ�ˣ���������");
			}
			index = resources;
			resources--;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return index;
	}
	
	/**
	 * ����
	 */
	public void push() {
		lock.lock();
		log.info(Thread.currentThread().getName() + " ������");
		try {
			while(resources>0) {
				log.info(Thread.currentThread().getName() + " ��������Դ������Ҫ����");
				pushCnd.await();
			}
			resources += 3;
			pullCnd.signalAll();
			log.info(Thread.currentThread().getName() + " ������Դ��");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScheduledExecutorService exec = Executors.newScheduledThreadPool(3);
		
		/*
		 * ������
		 */
		for(int i=0; i<2; i++) {
			exec.scheduleAtFixedRate(new Runnable() {
				@Override
				public void run() {
					int idx = new ReentrantLockDemo().pull();
					log.info(Thread.currentThread().getName() + " ������ " + idx);
				}
			}, 0, 3000, TimeUnit.MILLISECONDS);
		}
		
		exec.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				new ReentrantLockDemo().push();
			}
		}, 0, 3000, TimeUnit.MILLISECONDS);
	}

}
