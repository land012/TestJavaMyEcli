package com.my.thread;

import com.umbrella.vo.CommonVo;

public class SynThread1 implements Runnable {

	@Override
	public void run() {
		
		for(int i=0; i<10000000; i++) {
			// ��̬����ͬ��
//			System.out.print("1"); // ʹ�ò����д�ӡʱ����Ϊ������ݹ��࣬Console�Ͳ���ʾ��
//			System.out.println("1");
			CommonVo.increI();
//			CommonVo.setI(CommonVo.getI()+1);
		}
		System.out.println("t1:" + CommonVo.getI());
	}

}
