package com.umbrella.java.lang;

public class StaticClassDemo {
	
	public static void main(String[] args) {
		/**
		 * ��̬�����ʵ���������������Ǿ�̬�ķ���
		 */
//		InnerClass ic1 = new InnerClass();
//		ic1.fn2();
//		InnerClass.fn1();
	}
	
	/**
	 * ����һ����Ϊ StaticClassDemo$InnerClass.class ���ļ�
	 * @author ����
	 *
	 */
	static class InnerClass {
		static {
			System.out.println("this is InnerClass static{}");
		}
		
		public static void fn1() {
			
		}
		
		public void fn2() {
			
		}
	}
}
