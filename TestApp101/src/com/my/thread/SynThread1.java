package com.my.thread;

import com.umbrella.vo.CommonVo;

public class SynThread1 implements Runnable {

	@Override
	public void run() {
		
		for(int i=0; i<10000000; i++) {
			// 静态变量同步
//			System.out.print("1"); // 使用不换行打印时，因为输出内容过多，Console就不显示了
//			System.out.println("1");
			CommonVo.increI();
//			CommonVo.setI(CommonVo.getI()+1);
		}
		System.out.println("t1:" + CommonVo.getI());
	}

}
