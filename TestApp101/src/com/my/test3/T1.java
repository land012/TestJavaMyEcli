package com.my.test3;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;


public class T1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Calendar cal = Calendar.getInstance(Locale.CHINA);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(sdf.format(cal.getTime()));
//		System.out.println("年：" + cal.get(Calendar.YEAR));
//		System.out.println("Calendar.MONTH:" + cal.get(Calendar.MONTH)); // 一月为 0
//		System.out.println("日：" + cal.get(Calendar.DAY_OF_MONTH));
//		System.out.println("Calendar.DATE：" + cal.get(Calendar.DATE));
//		System.out.println("Calendar.DAY_OF_WEEK:" + cal.get(Calendar.DAY_OF_WEEK)); // 周天为第一天，所以周一为第二天
//		System.out.println(cal.get(Calendar.SUNDAY)); // ???????????
//		System.out.println("---------------------");
//		System.out.println(cal.getLeastMaximum(Calendar.DAY_OF_MONTH)); // 28
//		System.out.println(cal.getMaximum(Calendar.DAY_OF_MONTH)); // 31
//		System.out.println(cal.getMinimum(Calendar.MONTH)); // 0
//		System.out.println(cal.getMinimum(Calendar.DAY_OF_MONTH)); // 1
//		System.out.println("---------------------");
//		System.out.println(2>1?"a":"b");
		
		/*int i = 5;
		String str = i>10 ? String.valueOf(i) : ("0" + i);
		System.out.println(str);*/
		
//		Calendar cal = Calendar.getInstance(Locale.CHINA);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		sdf.setCalendar(cal);
		
		/*String str1 = "abc?efg?h";
		String str2 = str1.substring(0, str1.indexOf("?")) + "Z" + str1.substring(str1.indexOf("?")+1, str1.length());
		System.out.println(str2);*/
		
		/*String[] strs1 = new String[] {}; //声明一个空字符串数组
		System.out.println(strs1.length);
		//strs1[0] = "a"; // ArrayIndexOutOfBoundsException:
		String[] strs = new String[]{"a", "b"};
		System.out.println(strs.length);*/
		
		/*int i = 5;
		System.out.println((i-1) + "a");*/
		
		try {
			System.out.println(InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	

}
