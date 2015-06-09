package com.my.test1;

import org.apache.commons.lang3.StringUtils;

import com.my.util.MyPrintUtils;
/**
 * org.apache.commons.lang3.StringUtils
 * @author xudz
 *
 */
public class T6 {

	public static void main(String[] args) {
		String str1 = "Hello I am StringUtils!";
//		MyUtils.print(StringUtils.abbreviate(str1, 15));
//		MyUtils.print(StringUtils.abbreviate(null, 4));
		//MyUtils.print(StringUtils.abbreviate(str1, 4, 5));
		
		String str2 = "hello world!";
//		MyUtils.print(StringUtils.capitalize(str2)); // Hello world!
//		MyUtils.print(StringUtils.chop(str2)); // hello world
//		MyUtils.print(StringUtils.contains(str2, "hello")); // true
//		MyUtils.print(StringUtils.contains(str2, "Hello")); // false
//		MyUtils.print(StringUtils.contains(null, "Hello")); // false
//		MyUtils.print(StringUtils.contains(null, null)); // false
//		MyUtils.print(str2.contains("hello")); // true
		//MyUtils.print(str2.contains(null)); // java.lang.NullPointerException
		
		String c1 = " "; // whitespace
		String c2 = "　"; // whitespace
		String c3 = "\r"; // whitespace
		String c4 = "\n"; // whitespace
		String c5 = "\t"; // whitespace
		String c6 = "\f"; // whitespace
		String c7 = "";
		String c8 = null;
		/*MyUtils.print(StringUtils.isBlank(c1) + "," + // true
				StringUtils.isBlank(c2) + "," + // true
				StringUtils.isBlank(c3) + "," + // true
				StringUtils.isBlank(c4) + "," + // true
				StringUtils.isBlank(c5) + "," + // true
				StringUtils.isBlank(c6) + "," + // true
				StringUtils.isBlank(c7) + "," + // true
				StringUtils.isBlank(c8) // true
			);
		MyUtils.print(StringUtils.isEmpty(c1) + "," + // false
				StringUtils.isEmpty(c2) + "," + // false
				StringUtils.isEmpty(c3) + "," + // false
				StringUtils.isEmpty(c4) + "," + // false
				StringUtils.isEmpty(c5) + "," + // false
				StringUtils.isEmpty(c6) + "," + // false
				StringUtils.isBlank(c7) + "," + // true
				StringUtils.isBlank(c8) // true
			);*/
		
//		String str3 = "\\";
//		str3.concat("n");
//		String str4 = "n";
//		MyUtils.print(str3);
//		MyUtils.print(str3.concat("n"));
		
//		String str3 = "abczdefzghi";
		String str3 = "abc" + "\n" + "def" + "\n" + "ghi";
		
//		String[] strArr = str3.split("z");
//		String[] strArr = str3.split("\n");
//		MyUtils.print("---- 主函数参数 Start ----");
//		for(String s : args) {
//			MyUtils.print(s);
//		}
//		MyUtils.print("---- 主函数参数 End ----");
		
//		String[] strArr = args[0].split("\n");
//		for(String s : strArr) {
//			MyUtils.print(s);
//		}
		
		MyPrintUtils.print("abc".equals(null));
		String str4 = null;
		MyPrintUtils.print(null == str4);
	}

}
