package com.umbrella.java.lang;

public class StaticClassDemo {
	
	public static void main(String[] args) {
		/**
		 * 静态类可以实例化，可以声明非静态的方法
		 */
//		InnerClass ic1 = new InnerClass();
//		ic1.fn2();
//		InnerClass.fn1();
	}
	
	/**
	 * 生成一个名为 StaticClassDemo$InnerClass.class 的文件
	 * @author 大洲
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
