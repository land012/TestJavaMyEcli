package com.my.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.my.base.BaseTest;
/**
 * 
 * @author asdf
 *
 */
public class StringUtilsTest extends BaseTest {

	/**
	 * @param args
	 */
	@Test
	public void test1() {
		//System.out.info.infoln(Runtime.getRuntime());

//		info.info(Math.log10(100)); // 2.0
//		info.info(Math.log(Math.E)); // 1.0
//		info.info(Math.PI);
//		info.info(Math.E);
//		info.info(5+3);
//		info.info(Math.pow(2, 3));
//		info.info(Math.rint(3.453)); // 四舍五入为浮点型整数
//		info.info(2^3);
//		info.info(2^2);
//		info.info(2^4);

		/*
		 * 对整数进行截断
		 * 12345 -- 12300
		 */
//		int i1 = 12345;
//		info.info(i1/100*100);

		/*
		 * 浮点数截断
		 * 截断后两位，最后两位 置为 0
		 * 12345.0 -- 12300
		 * 12395.0 -- 12300
		 */
		/*double d1 = 12375.0;
		info.info(Double.valueOf(Math.floor(d1/100)*100).intValue());
		info.info(Double.valueOf(d1/100).intValue()*100);
		
		double d2 = 123.7;
		info.info(Double.valueOf(d2).intValue());
		int i2 = (int)d2;
		info.info(i2);
		//info.info(Integer.valueOf("123.7")); //NumberFormatException
		long l1 = 123L;
		info.info(l1);*/

//		info.info("str".equals(null));
//		info.info("".equals(null));
		//info.info(null.equals("")); // 编译错误 Cannot invoke equals(String) on the primitive type null
		//info.info(StringUtils.equals("", null));

		
		
		// int(八进制与十六进制) 与 char 类型的转换
		/*char c3 = 0x41; // 十六进制数
		info.info(c3);
		char c4 = 65; // 十进制数
		info.info(c4);
		int i1 = 0x41; // 十六进制数 65
		info.info(i1);
		info.info(Integer.toOctalString(65)); // 101，65 的 八进制数
		char c5 = 0101; // 以 0 开头表示八进制
		info.info(c5);
		int i2 = 0101; // 八进制数
		info.info(i2); // 65
		int i3 = 'A';
		info.info(i3);
		int i4 = '\u0041';
		info.info(i4);*/

//		info.info(Integer.MAX_VALUE); // 32位，其中 1 位符号位
//		info.info(Byte.MAX_VALUE);
//		info.info(Short.MAX_VALUE); // 16位，其中 1 位符号位
//		info.info(new Double(Math.pow(2, 31)).intValue());

		// 将指定的字符（Unicode 代码点）转换成其存储在 char 数组中的 UTF-16 表示形式
		/*char[] carr1 = Character.toChars(0x91);
		//char[] carr2 = Character.toChars(\u0000); // u cannot be resolved
		for(char c : carr1) {
			info.info("---- 输出 Start ----");
			info.info(c);
			info.info("---- 输出 End ----");
		}*/

		// StringUtils
//		String str1 = "abcefg";
//		String str2 = "abdefg";
//		String strdif = StringUtils.difference(str1, str2);
//		info.info(str2.indexOf(strdif));
//		info.info(str2.substring(str2.indexOf(strdif)));
//		info.info(StringUtils.equals("", null));
		
//		info.info(StringUtils.isEmpty(StringUtils.trim("  ")));
//
//		//Runtime.getRuntime().exit(0);
//		//System.exit(0);
//		
//		
//		String str1 = StringUtils.trimToNull("");
//		info.info(StringUtils.isEmpty(str1)); // true
//		
//		info.info("================= str2 ================");
//		String str2 = null;
//		info.info(str2);          // 空
//		System.out.println(str2); // null
//		info.info("" + str2);     // null
//		
//		info.info("================= str3 ================");
//		String str3 = "" + str2;
//		if(null == str3) {
//			info.info("str3 是  null");
//		} else if("".equals(str3)) {
//			info.info("str3 是 ''");
//		} else if("null".equals(str3)) {
//			info.info("str3 是 'null'");
//		} else {
//			info.info("str3 是 ：" + str3);
//		}
//		
//		info.info("================= str4 ================");
//		String str4 = "abcdef";
//		info.info("下标：" + StringUtils.lastIndexOf(str4, "."));
//		info.info("子串：" + StringUtils.substring(str4, -1)); // 从右边往右数
//		info.info("子串：" + StringUtils.substring(str4, 6));
//		info.info("子串：" + StringUtils.substring(str4, 7));
//		info.info(str4.substring(1));
		
		
		
//		/// 分割函数
//		String str1 = "abc";
//		String str2 = "a,b,c";
//		String[] arr1 = StringUtils.split(str2, ",");
//		for(String s : arr1) {
//			info.info(s);
//		}
		
//		// 不会抛异常
//		String[] arr2 = StringUtils.split(null, ",");
//		// 异常 java.lang.NullPointerException
////		info.info(arr2.length);
		
//		info.info(StringUtils.capitalize("abCDefg"));
//		String str1 = "abcdef";
//		int i = StringUtils.indexOf(str1, "-");
//		info.info(i);
//		info.info(StringUtils.substring(str1, 0, -1));
		
//		info.info(StringUtils.isEmpty(null)); // true
//		info.info(StringUtils.isEmpty("")); // true
		
		// 中文替换
//		info.info(StringUtils.replace("你好，小王", "小王", "小李"));
		
		/**
		 * 取子串
		 */
		// 最后3位
//		info.info(StringUtils.substring("abcdef", -3));
		// 倒数第三位
//		info.info(StringUtils.substring("abcdef", -3, -2));
		info.info(StringUtils.substring("abcd", 0, -3)); // a
		
		// 异常 java.lang.StringIndexOutOfBoundsException: String index out of range: -2
//		info.info("abcdef".substring(-2));
		
		// 删除最后一位
//		String str1 = "abcdef";
//		info.info(str1.substring(0, str1.length()-1));
		
	}
	
	/**
	 * 会保留前后空格
	 */
	@Test
	public void test2() {
		String str1 = " aasd, 3sdf, df, 23423";
		String[] str1Arr = StringUtils.split(str1, ",");
		for(int i=0; i<str1Arr.length; i++) {
			System.out.println("-" + str1Arr[i] + "-");
		}
	}
	
	/**
	 * 长度为1的数组
	 * 会保留前后空格
	 */
	@Test
	public void test3() {
		String str1 = " aasd";
		String[] str1Arr = StringUtils.split(str1, ",");
		for(int i=0; i<str1Arr.length; i++) {
			System.out.println("-" + str1Arr[i] + "-");
		}
	}
	
	/**
	 * 长度为1的数组
	 * 会保留前后空格
	 */
	@Test
	public void test4() {
		String str1 = "aasd,";
		String[] str1Arr = StringUtils.split(str1, ",");
		for(int i=0; i<str1Arr.length; i++) {
			System.out.println("-" + str1Arr[i] + "-");
		}
	}
	
	/**
	 * 长度为2的数组
	 * 会保留前后空格
	 */
	@Test
	public void test5() {
		String str1 = "aasd,,bb,";
		String[] str1Arr = StringUtils.split(str1, ",");
		for(int i=0; i<str1Arr.length; i++) {
			System.out.println("-" + str1Arr[i] + "-");
		}
	}
	
	/**
	 * 长度为0的数组
	 * 会保留前后空格
	 */
	@Test
	public void test6() {
		String str1 = ",";
		String[] str1Arr = StringUtils.split(str1, ",");
		for(int i=0; i<str1Arr.length; i++) {
			System.out.println("-" + str1Arr[i] + "-");
		}
	}

}
