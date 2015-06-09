package com.my.test1;

import java.text.DecimalFormat;

import com.my.util.crypto.CipherUtil;

/**
 * catch(Exception)
 * @author xudz
 *
 */
public class T7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//MyUtils.print(Integer.parseInt("")); //java.lang.NumberFormatException: For input string: ""
		//MyUtils.print(Integer.parseInt(null)); // java.lang.NumberFormatException: null\
		//MyUtils.print("here!"); // 前面抛异常时，会影响后面(此处)的执行
		
//		try{
//			MyUtils.print(Integer.parseInt(null));
//		} catch(NumberFormatException e){ // 当捕捉异常时，不会影响到后面的执行
//			MyUtils.print("解析出错！");
//		}
//		MyUtils.print("here!");
		
//		Properties p = new Properties();
//		String str = "abcd";
//		p.put("k1", "abc".equals(str)?str:"def");
//		MyUtils.print((String)p.get("k1"));
		
		//MyUtils.print("abc".equals(null));
		
//		String str = "'1','2','3'";
//		MyUtils.print(str);
//		str = "'" + "abc" + "'";
//		MyUtils.print(str);
		
//		String str1 = "1,,3,4";
//		String[] strarr = str1.split("[,]");
//		for(String s : strarr) {
//			System.out.println(s.trim());
//		}
		
//		String abc;
//		if("".equals(abc) || abc==null) { // 未初始化时，不能使用，报错
//			abc = "";
//			
//		}
//		MyUtils.print(abc+"a");
		//MyUtils.print(null.equals("xx")); // cannot invoke equals()
		
		//String str;
		//MyUtils.print(str);// 报错：The local variable str may not have been initialized
		//MyUtils.print(str==null); // 报错：The local variable str may not have been initialized
		//MyUtils.print(str=="");// 报错：The local variable str may not have been initialized
		
//		int i;
//		MyUtils.print(i);// 报错：The local variable str may not have been initialized
		
//		for(int i=1; i<10; i++) {
//			if(i%3==0) {
//				System.out.println("跳过！");
//				continue;
//			} else if(i%7==0) {
//				System.out.println("终止！");
//				break;
//			}
//			System.out.println(i);
//		}
		
//		int i=0;
//		while(i<10) {
//			i++;
//			if(i%3==0) {
//				System.out.println("跳过！");
//				continue;
//			} else if(i%7==0) {
//				System.out.println("终止！");
//				break;
//			}
//			System.out.println(i);
//		}
		
		
//		DecimalFormat df = new DecimalFormat("000");
//		for(int i=16; i<=322; i++) {
//			System.out.println("<img src=\"正文部分/" + df.format(i) + ".jpg\" />");
//		}
//		
		System.out.println(CipherUtil.encryptData("yc4500000654385", "838d9ac8"));
		System.out.println("c16d8af2915ca1653963bc155c9abe4e");
		try {
			System.out.println(CipherUtil.decryptData("c16d8af2915ca1653963bc155c9abe4e", "838d9ac8"));
			System.out.println("yc4500000654385");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
