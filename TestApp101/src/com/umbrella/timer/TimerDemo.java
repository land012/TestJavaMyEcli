package com.umbrella.timer;

import java.util.Timer;

public class TimerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Timer t = new Timer();
		/**
		 * MyTask �еĳ�Ա����������������Ǳ���ֵ
		 * ��ô����ʹ��Timer�ظ�ִ�У�����Ҳ����䣬��������ʱ��ֵ
		 * Ҳ����˵��Timerֻ�ظ�ִ��MyTask��run�����������ظ���������
		 */
		t.scheduleAtFixedRate(new MyTask(), 0, 3000);
	}

}
