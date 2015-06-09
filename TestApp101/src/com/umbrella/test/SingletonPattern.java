package com.umbrella.test;

import org.apache.log4j.Logger;
/**
 * ����
 * ��̬�ڲ���
 * ��ֹ����
 * @author asdf
 *
 */
public class SingletonPattern {
	private static final Logger log = Logger.getLogger(SingletonPattern.class);
	/**
	 * ʹ�ø�����ķ���ʱ���ͻᱻִ�е�
	 */
//	private static SingletonPattern instance = new SingletonPattern();
	private static SingletonPattern instance;
	
	/**
	 * ʹ�ø�����ķ���ʱ���ͻᱻִ�е�
	 */
	static {
		log.info("i am static");
	}
	
	private SingletonPattern () {
		log.info("i am SingletonPattern!");
	}
	
	public static SingletonPattern getIntance() {
		return SingletonPatternHolder.singletonPattern;
	}
	
	/**
	 * ��ֹ����
	 * @return
	 */
	public static SingletonPattern getIntance2() {
		if(instance != null) return instance;
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		log.info("== ��ʼ�� SingletonPattern.clas  ==" + Thread.currentThread().getName());
		// �������ܷ�ֹ����
		synchronized(SingletonPattern.class) {
			// �������ܷ�ֹ����
//			instance = new SingletonPattern();
			
			// �������ܷ�ֹ����
			if(instance == null) instance = new SingletonPattern();
		}
		log.info("== ������ SingletonPattern.clas  ==" + Thread.currentThread().getName());
		
		return instance;
	}
	
	/**
	 * ʹ�ø���ʱ���Żᱻִ�е�
	 * ������� getIntance()
	 * @author asdf
	 *
	 */
	static class SingletonPatternHolder {
		private static SingletonPattern singletonPattern = new SingletonPattern();
	}
	
	class A {
		public A() {
			log.info("this is A");
		}
	}
	
	public static void fn1() {
		log.info("i am fn1!");
	}
	
	public void fn2() {
		log.info("i am fn2!");
	}
	
}
