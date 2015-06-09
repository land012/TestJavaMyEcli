package com.umbrella.test;

import org.apache.log4j.Logger;

public class BinaryTest {
	
	private static final Logger log = Logger.getLogger(BinaryTest.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 异或
		 */
//		log.info(2^2); // 0
//		log.info(0^0); // 0
//		log.info(0^1); // 1
//		log.info(1^0); // 1
//		log.info(1^1); // 0
		
		/**
		 * >> 右移两位，高位补符号位
		 * << 左移两位
		 */
//		log.info(1>>2); // 0
//		log.info(1<<2); // 4
//		log.info(2>>2); // 0
		/*
		 * -1
		 * 原码           1000 0001
		 * 按位取反 1111 1110
		 * +1      1111 1111
		 * 右移2   1111 1111
		 * -1      1111 1110
		 * 按位取反 1000 0001
		 */
//		log.info(-1>>2); // -1
		
//		/**
//		 * 无符号右移
//		 */
//		log.info(1>>>2); // 0
//		/**
//		 * 1000 - 8
//		 * 0010 - 2
//		 */
//		log.info(8>>>2); // 2
		
		// 补码表示
		log.info(Integer.toBinaryString(-1)); // 1111 1111 1111 1111 1111 1111 1111 1111 （32位）
		
		/*
		 * 5    - 00000101
		 * 0x11 - 00010001
		 */
//		info.info(5 & 0x11);  // 1   按位相与
//		info.info(21 & 0x11); // 17 按位相与
//		info.info(Integer.toString(17, 16)); // 11，17 的16进制表示法
//		info.info(Integer.toHexString(17));
	}

}
