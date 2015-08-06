package com.my.thread;

import com.umbrella.vo.CommonVo;

public class SynThread2 implements Runnable {

	@Override
	public void run() {
		
		for(int i=0; i<10000000; i++) {
//			System.out.print("2");
//			System.out.println("2");
			CommonVo.increI();
//			CommonVo.setI(CommonVo.getI()+1);
		}
		System.out.println("t2:" + CommonVo.getI());
	}

}
