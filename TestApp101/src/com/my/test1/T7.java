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
		//MyUtils.print("here!"); // ǰ�����쳣ʱ����Ӱ�����(�˴�)��ִ��
		
//		try{
//			MyUtils.print(Integer.parseInt(null));
//		} catch(NumberFormatException e){ // ����׽�쳣ʱ������Ӱ�쵽�����ִ��
//			MyUtils.print("��������");
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
//		if("".equals(abc) || abc==null) { // δ��ʼ��ʱ������ʹ�ã�����
//			abc = "";
//			
//		}
//		MyUtils.print(abc+"a");
		//MyUtils.print(null.equals("xx")); // cannot invoke equals()
		
		//String str;
		//MyUtils.print(str);// ����The local variable str may not have been initialized
		//MyUtils.print(str==null); // ����The local variable str may not have been initialized
		//MyUtils.print(str=="");// ����The local variable str may not have been initialized
		
//		int i;
//		MyUtils.print(i);// ����The local variable str may not have been initialized
		
//		for(int i=1; i<10; i++) {
//			if(i%3==0) {
//				System.out.println("������");
//				continue;
//			} else if(i%7==0) {
//				System.out.println("��ֹ��");
//				break;
//			}
//			System.out.println(i);
//		}
		
//		int i=0;
//		while(i<10) {
//			i++;
//			if(i%3==0) {
//				System.out.println("������");
//				continue;
//			} else if(i%7==0) {
//				System.out.println("��ֹ��");
//				break;
//			}
//			System.out.println(i);
//		}
		
		
//		DecimalFormat df = new DecimalFormat("000");
//		for(int i=16; i<=322; i++) {
//			System.out.println("<img src=\"���Ĳ���/" + df.format(i) + ".jpg\" />");
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
