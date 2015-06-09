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
//			return;         // 当有 return 时，finally 中的语句会被执行
			
//			throw new RuntimeException("抛异常了"); // 当有 throw 时，finally 中的语句仍会被执行
			
//			System.exit(0); // 当有 exit 时，finally 中的语句 不会被执行
		} finally {
			System.out.println("this is finally!");
		}
		
	}

}
