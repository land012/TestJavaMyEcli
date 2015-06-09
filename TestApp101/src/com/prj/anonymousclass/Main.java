package com.prj.anonymousclass;
/**
 * 匿名内部类
 * @author asdf
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyService service = new MyService();
		service.fn1("Hello Tom");
		service.fn2("Hello Jim");
	}

}
