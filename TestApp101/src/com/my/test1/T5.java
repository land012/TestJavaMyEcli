package com.my.test1;

import org.apache.commons.lang3.StringUtils;

import com.my.util.MyPrintUtils;
/**
 * Math
 * 截断浮点数小数位
 * Character Unicode
 * StringUtils
 * @author xudz
 *
 */
public class T5 {

	public static void main(String[] args) {
		//System.out.println(Runtime.getRuntime());

//		print(Math.log10(100)); // 2.0
//		print(Math.log(Math.E)); // 1.0
//		print(Math.PI);
//		print(Math.E);
//		print(5+3);
//		print(Math.pow(2, 3));
//		print(Math.rint(3.453)); // 四舍五入为浮点型整数
//		print(2^3);
//		print(2^2);
//		print(2^4);

		/*
		 * 对整数进行截断
		 * 12345 -- 12300
		 */
//		int i1 = 12345;
//		print(i1/100*100);

		/*
		 * 浮点数截断
		 * 截断后两位，最后两位 置为 0
		 * 12345.0 -- 12300
		 * 12395.0 -- 12300
		 */
		/*double d1 = 12375.0;
		print(Double.valueOf(Math.floor(d1/100)*100).intValue());
		print(Double.valueOf(d1/100).intValue()*100);
		
		double d2 = 123.7;
		print(Double.valueOf(d2).intValue());
		int i2 = (int)d2;
		print(i2);
		//print(Integer.valueOf("123.7")); //NumberFormatException
		long l1 = 123L;
		print(l1);*/

//		print("str".equals(null));
//		print("".equals(null));
		//print(null.equals("")); // 编译错误 Cannot invoke equals(String) on the primitive type null
		//print(StringUtils.equals("", null));

		// Unicode 空白字符 返回 true
//		print(Character.isSpaceChar(' ')); // 半角空格 true
//		print(Character.isSpaceChar('　')); // 全角空格 true
//		print(Character.isSpaceChar('\r')); // false
//		print(Character.isSpaceChar('\n')); // false
//		print(Character.isSpaceChar('\t')); // false
//		print(Character.isSpaceChar('\f')); // false
//		print(Character.isSpaceChar('\b')); // false
		/*
		 * 因为 Character.SPACE_SEPARATOR 是一个整数 x，在这里，把这个整数 x 做为 char 进行判断
		 * 所以 下面这三个判断是没有意义的
		 */
		// 12 对应的字符换页符 （FormFeed/NewPage）
//		print(Character.isSpaceChar(Character.SPACE_SEPARATOR)); // false
		// 13 是换行符
//		print(Character.isSpaceChar(Character.LINE_SEPARATOR)); // false 
		// 14 对应的字符 shift out
//		print(Character.isSpaceChar(Character.PARAGRAPH_SEPARATOR)); // false
		
		// 对应 ASCII ?
//		char c1 = 12; // 换页符（FormFeed/NewPage）
//		char c2 = 13; // 回车
//		char c3 = 14; // shift out
//		MyUtils.print("\t" + c1 + "," + c2 + "," + c3);
		
		// ISO-LATIN-1 空白 返回 true
//		print(Character.isSpace(' ')); // deprecated，被 isWhitespace() 取代
		// Java 空白字符
//		print(Character.isWhitespace(' ')); // true
//		print(Character.isWhitespace('　')); // true 全角空格
//		print(Character.isWhitespace('\r')); // true
//		print(Character.isWhitespace('\n')); // true
//		print(Character.isWhitespace('\t')); // true
//		print(Character.isWhitespace('\f')); // true 换页符
//		print(Character.isWhitespace('\b')); // 单词边界 false
		
		/*
		 * 与上面 isSpaceChar() 相同，下面这三个判断也是没有意义的
		 */
//		print(Character.isWhitespace(Character.SPACE_SEPARATOR)); // true，12
//		print(Character.isWhitespace(Character.LINE_SEPARATOR)); // true，13
//		print(Character.isWhitespace(Character.PARAGRAPH_SEPARATOR)); // false，14
		//编译错误 Invalid escape sequence(valid ones are \b \t \n \f \r \" \' \\ )
		//print(Character.isWhitespace('\s'));
		
		// ----- 首字母大写字符 Start -----
		MyPrintUtils.print(Character.TITLECASE_LETTER); // 3
//		MyUtils.print(Character.isTitleCase('A')); // false，当 getType() 为3时，返回true
//		MyUtils.print(Character.isTitleCase('a')); // false
//		MyUtils.print(Character.isTitleCase('B')); // false
//		MyUtils.print(Character.isTitleCase('D')); // false
//		MyUtils.print(Character.isTitleCase('L')); // false
		
		MyPrintUtils.print(Character.toTitleCase('a')); // A
		MyPrintUtils.print(Character.isTitleCase(Character.toTitleCase('a'))); // false
		
		// 大写字母
//		MyUtils.print('\u0041'); // A
//		MyUtils.print('\u00C0'); // ��
//		MyUtils.print('\u00DE'); // ��
//		MyUtils.print(Character.getType('\u00C0')); // 1
//		MyUtils.print(Character.UPPERCASE_LETTER); // 1
//		MyUtils.print(Character.LOWERCASE_LETTER); // 2
//		MyUtils.print(Character.getType('A')); // 1
//		MyUtils.print(Character.getType('a')); // 2
		// ----- 首字母大写字符 End -----

// -----------------------------------------------------------------------
		
		// ------- Unicode 常规类型 Start -------
//		print(Character.COMBINING_SPACING_MARK); // 8
//		print(Character.DIRECTIONALITY_LEFT_TO_RIGHT); // 0
//		print(Character.DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING); // 14
		
//		print(Character.CONTROL); // 15
//		print(Character.DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE); // 15
//		print(Character.getType('\r')); // 15
//		print(Character.getType('\n')); // 15
//		print(Character.getType('\b')); // 15
//		print(Character.getType('\t')); // 15
//		print(Character.getType('\f')); // 15

//		print(Character.LINE_SEPARATOR); // 13
//		print(Character.PARAGRAPH_SEPARATOR); // 14

//		print(Character.SPACE_SEPARATOR); // 12
//		print(Character.getType(' ')); // 12
//		print(Character.getType('　')); // 全角空格 12
		// ------- Unicode 常规类型 End -------
		
// -----------------------------------------------------------------------
		
		// ------- 指定进制下，字符表示形式 与 特定数字 的对应 Start -------
//		MyUtils.print(Character.MAX_RADIX); // 36，可用于与字符串相互转换的最大基数。
//		print(Character.digit('9', 10)); // 意思是：在 10 进制里，'9' 代表 9
//		print(Character.digit('0', 2)); // 
//		print(Character.digit('a', 16)); // 10 意思是：在 16 进制里，'a' 代表 10
//		print(Character.digit('A', 16)); // 10 意思是：在 16 进制里，'A' 代表 10
//		print(Character.digit('G', 17)); // 16 意思是：在 17 进制里，'G' 代表 16
//		print(Character.forDigit(34, 35)); // y 在 35 进制里，35 用 'y' 表示
//		print(Character.forDigit(35, 36)); // z 在 36 进制里，35 用 'z' 表示
//		print(Character.forDigit(36, 37)); // 解析不到结果
		
		// 返回指定字符(英文字母)在某种进制下，代表的数值（十进制数值）
//		print(Character.getNumericValue(' '));  // -1 不代表任何数值
//		print(Character.getNumericValue('\r')); // -1
//		print(Character.getNumericValue('\n')); // -1
//		print(Character.getNumericValue('\\')); // -1
//		print(Character.getNumericValue('$'));  // -1
//		print(Character.getNumericValue('a'));  // 10 代表数值 10
//		print(Character.getNumericValue('b'));  // 11
//		print(Character.getNumericValue('A'));  // 10
//		print(Character.getNumericValue('Z'));  // 35
		
		// ------- 指定进制下，字符表示形式 与 特定数字 的对应 End -------
		
// -----------------------------------------------------------------------
		// unicode
//		print(Character.toLowerCase('\u005a'));
//		char c1 = '\u0042';
		//char c2 = '\x42'; // 编译错误
		//print(c2);
		
		// int(八进制与十六进制) 与 char 类型的转换
		/*char c3 = 0x41; // 十六进制数
		print(c3);
		char c4 = 65; // 十进制数
		print(c4);
		int i1 = 0x41; // 十六进制数 65
		print(i1);
		print(Integer.toOctalString(65)); // 101，65 的 八进制数
		char c5 = 0101; // 以 0 开头表示八进制
		print(c5);
		int i2 = 0101; // 八进制数
		print(i2); // 65
		int i3 = 'A';
		print(i3);
		int i4 = '\u0041';
		print(i4);*/

//		print(Integer.MAX_VALUE); // 32位，其中 1 位符号位
//		print(Byte.MAX_VALUE);
//		print(Short.MAX_VALUE); // 16位，其中 1 位符号位
//		print(new Double(Math.pow(2, 31)).intValue());

		// 将指定的字符（Unicode 代码点）转换成其存储在 char 数组中的 UTF-16 表示形式
		/*char[] carr1 = Character.toChars(0x91);
		//char[] carr2 = Character.toChars(\u0000); // u cannot be resolved
		for(char c : carr1) {
			print("---- 输出 Start ----");
			print(c);
			print("---- 输出 End ----");
		}*/

		// StringUtils
//		String str1 = "abcefg";
//		String str2 = "abdefg";
//		String strdif = StringUtils.difference(str1, str2);
//		print(str2.indexOf(strdif));
//		print(str2.substring(str2.indexOf(strdif)));
//		print(StringUtils.equals("", null));

		//Runtime.getRuntime().exit(0);
		//System.exit(0);
	}
	
	public static void print() {
		System.out.println();
	}
	public static void print(String param) {
		System.out.println(param);
	}
	public static void print(int param) {
		System.out.println(param);
	}
	public static void print(long param) {
		System.out.println(param);
	}
	public static void print(float param) {
		System.out.println(param);
	}
	public static void print(double param) {
		System.out.println(param);
	}
	public static void print(boolean param) {
		System.out.println(param);
	}
	public static void print(char param) {
		System.out.println(param);
	}
	
}
