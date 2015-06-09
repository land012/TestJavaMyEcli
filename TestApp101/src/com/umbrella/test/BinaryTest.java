package com.umbrella.test;

import org.apache.log4j.Logger;

public class BinaryTest {
	
	private static final Logger log = Logger.getLogger(BinaryTest.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * ���
		 */
//		log.info(2^2); // 0
//		log.info(0^0); // 0
//		log.info(0^1); // 1
//		log.info(1^0); // 1
//		log.info(1^1); // 0
		
		/**
		 * >> ������λ����λ������λ
		 * << ������λ
		 */
//		log.info(1>>2); // 0
//		log.info(1<<2); // 4
//		log.info(2>>2); // 0
		/*
		 * -1
		 * ԭ��           1000 0001
		 * ��λȡ�� 1111 1110
		 * +1      1111 1111
		 * ����2   1111 1111
		 * -1      1111 1110
		 * ��λȡ�� 1000 0001
		 */
//		log.info(-1>>2); // -1
		
//		/**
//		 * �޷�������
//		 */
//		log.info(1>>>2); // 0
//		/**
//		 * 1000 - 8
//		 * 0010 - 2
//		 */
//		log.info(8>>>2); // 2
		
		// �����ʾ
		log.info(Integer.toBinaryString(-1)); // 1111 1111 1111 1111 1111 1111 1111 1111 ��32λ��
		
		/*
		 * 5    - 00000101
		 * 0x11 - 00010001
		 */
//		info.info(5 & 0x11);  // 1   ��λ����
//		info.info(21 & 0x11); // 17 ��λ����
//		info.info(Integer.toString(17, 16)); // 11��17 ��16���Ʊ�ʾ��
//		info.info(Integer.toHexString(17));
	}

}
