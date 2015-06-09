package com.umbrella.generictype;

import org.apache.log4j.Logger;
/**
 * 泛型测试
 * @author asdf
 *
 */
public class GenericsTest1 {
	
	private static final Logger log = Logger.getLogger(GenericsTest1.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Point<String> p = new Point<String>();
//		p.setT("p1");
//		log.info(p.getT());
//		fn1(p);
//		
//		fn2(new Point<Integer>(new Integer(1)));
//		fn3(new Point<Number>(new Double(1)));
		
		Demo1 d1 = new Demo1();
		d1.fn1("aa");
	}
	
	/**
	 * 通配符
	 * @param p
	 */
	public static void fn1(Point<?> p) {
		log.info(p.getT());
	}
	/**
	 * 受限泛型
	 * Number 及其子类
	 * @param p
	 */
	public static void fn2(Point<? extends Number> p) {
		log.info(p.getT());
	}
	/**
	 * 受限泛型
	 * Double及其父类
	 * @param p
	 */
	public static void fn3(Point<? super Double> p) {
		log.info(p.getT());
	}

}

class Point<T> {
	private T t;
	
	public Point() {
		
	}
	
	public Point(T t) {
		this.t = t;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
}

class Demo1 {
	private static final Logger log = Logger.getLogger(Demo1.class);
	/**
	 * 泛型方法
	 * @param <T>
	 * @param t
	 */
	public <T> void fn1(T t) {
		log.info(t);
	}
}
