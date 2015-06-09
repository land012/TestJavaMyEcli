package com.my.test;

/**
 * ��ӡ��ǰ������
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
	 * ��ӡ��ǰ������
	 */
	public static void fn1() {
		StackTraceElement ste0 = Thread.currentThread().getStackTrace()[0];
		StackTraceElement ste1 = Thread.currentThread().getStackTrace()[1];
		
		Thread t = Thread.currentThread();
		
		System.out.println("��ǰ�߳�ID=" + t.getId());
		
		System.out.println("���������" + ste0.getClassName()); // java.lang.Thread
		System.out.println("��㷽������" + ste0.getMethodName()); // getStackTrace
		
		System.out.println("��ǰ������" + ste1.getClassName()); // com.my.test.MethodTest
		System.out.println("��ǰ��������" + ste1.getMethodName()); // fn1
		
		
		
		StackTraceElement[] steArr = t.getStackTrace();
		for(int i=0; i<steArr.length; i++) {
			System.out.println(steArr[i].getFileName() + "-" + steArr[i].getClassName() + "-" + steArr[i].getMethodName());
		}
	}
	
	/**
	 * ��ӡ��ǰ����
	 */
	public static void fn2() {
		
		System.out.println("��ǰ�߳�ID=" + Thread.currentThread().getId());
		
		Throwable t = new Throwable();
		StackTraceElement[] steArr = t.getStackTrace();
		for(int i=0; i<steArr.length; i++) {
			System.out.println(steArr[i].getFileName() + "-" + steArr[i].getClassName() + "-" + steArr[i].getMethodName());
		}
	}

}
