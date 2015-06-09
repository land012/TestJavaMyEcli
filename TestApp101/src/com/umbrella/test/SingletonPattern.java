package com.umbrella.test;

import org.apache.log4j.Logger;
/**
 * 单例
 * 静态内部类
 * 防止并发
 * @author asdf
 *
 */
public class SingletonPattern {
	private static final Logger log = Logger.getLogger(SingletonPattern.class);
	/**
	 * 使用该类里的方法时，就会被执行到
	 */
//	private static SingletonPattern instance = new SingletonPattern();
	private static SingletonPattern instance;
	
	/**
	 * 使用该类里的方法时，就会被执行到
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
	 * 防止并发
	 * @return
	 */
	public static SingletonPattern getIntance2() {
		if(instance != null) return instance;
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		log.info("== 开始锁 SingletonPattern.clas  ==" + Thread.currentThread().getName());
		// 这样不能防止并发
		synchronized(SingletonPattern.class) {
			// 这样不能防止并发
//			instance = new SingletonPattern();
			
			// 这样才能防止并发
			if(instance == null) instance = new SingletonPattern();
		}
		log.info("== 结束锁 SingletonPattern.clas  ==" + Thread.currentThread().getName());
		
		return instance;
	}
	
	/**
	 * 使用该类时，才会被执行到
	 * 比如调用 getIntance()
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
