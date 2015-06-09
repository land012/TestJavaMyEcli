package com.my.test;

import com.my.base.BaseTest;

public class MathTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		info.info(Math.random());
//		info.info(Math.rint(1.5)); // 四舍五入为 double
//		info.info(Math.rint(1.4));
//		info.info(Math.rint(1.6));
//		info.info(Math.round(1.4)); // 四舍五入为 int
//		info.info(Math.round(1.5));
//		info.info(Math.round(1.6));
		
//		info.info((double)13103/1505);                // 8.706312292358804
//		info.info(Math.round(13103/1505));            // 8
//		info.info(Math.round((double)13103/1505));    // 9
//		info.info(Math.round(Integer.valueOf(13103).doubleValue()/1505));    // 9
//		info.info(Math.floor(8.7+0.5));               // 9.0
		
		System.out.println(Math.ceil(12.3));  // 13.0
		System.out.println(Math.floor(12.3)); // 12.0
		System.out.println(1%2);
	}

}
