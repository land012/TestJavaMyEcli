package com.umbrella.timer;

import java.util.Timer;

public class TimerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Timer t = new Timer();
		/**
		 * MyTask 中的成员变量，如果在声明是被赋值
		 * 那么，即使被Timer重复执行，变量也不会变，是在声明时的值
		 * 也就是说，Timer只重复执行MyTask的run方法，不会重复创建对象
		 */
		t.scheduleAtFixedRate(new MyTask(), 0, 3000);
	}

}
