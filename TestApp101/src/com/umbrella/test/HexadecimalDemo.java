package com.umbrella.test;

import org.apache.log4j.Logger;

public class HexadecimalDemo {
	private static final Logger log = Logger.getLogger(HexadecimalDemo.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int i1 = 012; // 八进制表示法
//		int i2 = 0xf; // 十六进制表示法
//		log.info(i1); // 10
//		log.info(i2); // 15
		
		int i3 = 0x61c88647;
		log.info(i3);
	}

}
