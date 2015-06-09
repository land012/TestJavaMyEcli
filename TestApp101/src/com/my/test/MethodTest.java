package com.my.test;

/**
 * 打印当前方法名
 * @author asdf
 *
 */
public class MethodTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		fn1();
		System.out.println("==========================================");
		fn2();
	}
	
	/**
	 * 打印当前方法名
	 */
	public static void fn1() {
		StackTraceElement ste0 = Thread.currentThread().getStackTrace()[0];
		StackTraceElement ste1 = Thread.currentThread().getStackTrace()[1];
		
		Thread t = Thread.currentThread();
		
		System.out.println("当前线程ID=" + t.getId());
		
		System.out.println("最顶层类名：" + ste0.getClassName()); // java.lang.Thread
		System.out.println("最顶层方法名：" + ste0.getMethodName()); // getStackTrace
		
		System.out.println("当前类名：" + ste1.getClassName()); // com.my.test.MethodTest
		System.out.println("当前方法名：" + ste1.getMethodName()); // fn1
		
		
		
		StackTraceElement[] steArr = t.getStackTrace();
		for(int i=0; i<steArr.length; i++) {
			System.out.println(steArr[i].getFileName() + "-" + steArr[i].getClassName() + "-" + steArr[i].getMethodName());
		}
	}
	
	/**
	 * 打印当前方法
	 */
	public static void fn2() {
		
		System.out.println("当前线程ID=" + Thread.currentThread().getId());
		
		Throwable t = new Throwable();
		StackTraceElement[] steArr = t.getStackTrace();
		for(int i=0; i<steArr.length; i++) {
			System.out.println(steArr[i].getFileName() + "-" + steArr[i].getClassName() + "-" + steArr[i].getMethodName());
		}
	}

}
