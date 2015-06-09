package com.my.test3;

import com.my.service.CommonService;

public class T11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(11);
		
		/**
		 * 静态变量的方法里，有一个没有引入的类
		 */
		CommonService commonService = new CommonService();
		commonService.fn1();
	}

}
