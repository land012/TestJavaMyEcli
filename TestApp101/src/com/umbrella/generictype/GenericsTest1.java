package com.umbrella.generictype;

import org.apache.log4j.Logger;
/**
 * ���Ͳ���
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
	 * ͨ���
	 * @param p
	 */
	public static void fn1(Point<?> p) {
		log.info(p.getT());
	}
	/**
	 * ���޷���
	 * Number ��������
	 * @param p
	 */
	public static void fn2(Point<? extends Number> p) {
		log.info(p.getT());
	}
	/**
	 * ���޷���
	 * Double���丸��
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
	 * ���ͷ���
	 * @param <T>
	 * @param t
	 */
	public <T> void fn1(T t) {
		log.info(t);
	}
}
