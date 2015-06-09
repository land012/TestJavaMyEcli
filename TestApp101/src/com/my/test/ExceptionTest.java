package com.my.test;

import com.my.base.BaseTest;

public class ExceptionTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "abc";
		try {
			Integer.parseInt(str1);
		} catch(NumberFormatException e) {
			e.printStackTrace();
			System.out.println("============================================");
			info.info(e.getMessage());
			System.out.println("============================================");
			info.info(e);
			System.out.println("============================================");
			info.info(e.getMessage(), e);
		}
		
		try {
			System.out.println("this is try!");
//			return;         // ���� return ʱ��finally �е����ᱻִ��
			
//			throw new RuntimeException("���쳣��"); // ���� throw ʱ��finally �е�����Իᱻִ��
			
//			System.exit(0); // ���� exit ʱ��finally �е���� ���ᱻִ��
		} finally {
			System.out.println("this is finally!");
		}
		
	}

}
