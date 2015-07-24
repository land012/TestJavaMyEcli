package com.my.test;

import java.util.Random;

import com.my.base.BaseTest;

public class RandomTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random rn = new Random();
		rn.setSeed(2);
		info.info(rn.nextInt()); // -1154715079
		info.info(rn.nextInt()); // 1260042744
		info.info(rn.nextInt()); // -423279216
		info.info(rn.nextInt(10)); // 7
		info.info(rn.nextInt(5)); // 4
		
		// 指定同一 seed 时，具有相同的随机数序列
		Random rn2 = new Random(2);
		info.info(rn2.nextInt());
		info.info(rn2.nextInt());
		info.info(rn2.nextInt());
		info.info(rn.nextInt(5)); // 0
		info.info(rn2.nextInt(10)); // 7(返回 0-9之间的整数)
		
		info.info("=====================================");
		
		Random rn3 = new Random();
		info.info(rn3.nextInt(10));
		info.info(rn3.nextInt(9));
		Random rn4 = new Random();
		info.info(rn4.nextInt(9));
		
//		// 异常 ava.lang.IllegalArgumentException: n must be positive
//		info.info(rn2.nextInt(0));
	}

}
