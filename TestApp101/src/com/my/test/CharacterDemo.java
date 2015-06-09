package com.my.test;

public class CharacterDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Unicode 空白字符 返回 true
//		info.info(Character.isSpaceChar(' ')); // 半角空格 true
//		info.info(Character.isSpaceChar('　')); // 全角空格 true
//		info.info(Character.isSpaceChar('\r')); // false
//		info.info(Character.isSpaceChar('\n')); // false
//		info.info(Character.isSpaceChar('\t')); // false
//		info.info(Character.isSpaceChar('\f')); // false
//		info.info(Character.isSpaceChar('\b')); // false
		/*
		 * 因为 Character.SPACE_SEPARATOR 是一个整数 x，在这里，把这个整数 x 做为 char 进行判断
		 * 所以 下面这三个判断是没有意义的
		 */
		// 12 对应的字符换页符 （FormFeed/NewPage）
//		info.info(Character.isSpaceChar(Character.SPACE_SEPARATOR)); // false
		// 13 是换行符
//		info.info(Character.isSpaceChar(Character.LINE_SEPARATOR)); // false 
		// 14 对应的字符 shift out
//		info.info(Character.isSpaceChar(Character.PARAGRAPH_SEPARATOR)); // false
		
		// 对应 ASCII ?
//		char c1 = 12; // 换页符（FormFeed/NewPage）
//		char c2 = 13; // 回车
//		char c3 = 14; // shift out
//		info.info("\t" + c1 + "," + c2 + "," + c3);
		
		// ISO-LATIN-1 空白 返回 true
//		info.info(Character.isSpace(' ')); // deprecated，被 isWhitespace() 取代
		// Java 空白字符
//		info.info(Character.isWhitespace(' ')); // true
//		info.info(Character.isWhitespace('　')); // true 全角空格
//		info.info(Character.isWhitespace('\r')); // true
//		info.info(Character.isWhitespace('\n')); // true
//		info.info(Character.isWhitespace('\t')); // true
//		info.info(Character.isWhitespace('\f')); // true 换页符
//		info.info(Character.isWhitespace('\b')); // 单词边界 false
		
		/*
		 * 与上面 isSpaceChar() 相同，下面这三个判断也是没有意义的
		 */
//		info.info(Character.isWhitespace(Character.SPACE_SEPARATOR)); // true，12
//		info.info(Character.isWhitespace(Character.LINE_SEPARATOR)); // true，13
//		info.info(Character.isWhitespace(Character.PARAGRAPH_SEPARATOR)); // false，14
		//编译错误 Invalid escape sequence(valid ones are \b \t \n \f \r \" \' \\ )
		//info.info(Character.isWhitespace('\s'));
		
		// ----- 首字母大写字符 Start -----
//		info.info(Character.TITLECASE_LETTER); // 3
//		info.info(Character.isTitleCase('A')); // false，当 getType() 为3时，返回true
//		info.info(Character.isTitleCase('a')); // false
//		info.info(Character.isTitleCase('B')); // false
//		info.info(Character.isTitleCase('D')); // false
//		info.info(Character.isTitleCase('L')); // false
		
//		info.info(Character.toTitleCase('a')); // A
//		info.info(Character.isTitleCase(Character.toTitleCase('a'))); // false
		
		// 大写字母
//		info.info('\u0041'); // A
//		info.info('\u00C0'); // ??
//		info.info('\u00DE'); // ??
//		info.info(Character.getType('\u00C0')); // 1
//		info.info(Character.UPPERCASE_LETTER); // 1
//		info.info(Character.LOWERCASE_LETTER); // 2
//		info.info(Character.getType('A')); // 1
//		info.info(Character.getType('a')); // 2
		// ----- 首字母大写字符 End -----

// -----------------------------------------------------------------------
		
		// ------- Unicode 常规类型 Start -------
//		info.info(Character.COMBINING_SPACING_MARK); // 8
//		info.info(Character.DIRECTIONALITY_LEFT_TO_RIGHT); // 0
//		info.info(Character.DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING); // 14
		
//		info.info(Character.CONTROL); // 15
//		info.info(Character.DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE); // 15
//		info.info(Character.getType('\r')); // 15
//		info.info(Character.getType('\n')); // 15
//		info.info(Character.getType('\b')); // 15
//		info.info(Character.getType('\t')); // 15
//		info.info(Character.getType('\f')); // 15

//		info.info(Character.LINE_SEPARATOR); // 13
//		info.info(Character.PARAGRAPH_SEPARATOR); // 14

//		info.info(Character.SPACE_SEPARATOR); // 12
//		info.info(Character.getType(' ')); // 12
//		info.info(Character.getType('　')); // 全角空格 12
		// ------- Unicode 常规类型 End -------
		
// -----------------------------------------------------------------------
		
		// ------- 指定进制下，字符表示形式 与 特定数字 的对应 Start -------
//		info.info(Character.MAX_RADIX); // 36，可用于与字符串相互转换的最大基数。
//		info.info(Character.digit('9', 10)); // 意思是：在 10 进制里，'9' 代表 9
//		info.info(Character.digit('0', 2)); // 
//		info.info(Character.digit('a', 16)); // 10 意思是：在 16 进制里，'a' 代表 10
//		info.info(Character.digit('A', 16)); // 10 意思是：在 16 进制里，'A' 代表 10
//		info.info(Character.digit('G', 17)); // 16 意思是：在 17 进制里，'G' 代表 16
//		info.info(Character.forDigit(34, 35)); // y 在 35 进制里，35 用 'y' 表示
//		info.info(Character.forDigit(35, 36)); // z 在 36 进制里，35 用 'z' 表示
//		info.info(Character.forDigit(36, 37)); // 解析不到结果
		
		// 返回指定字符(英文字母)在某种进制下，代表的数值（十进制数值）
//		info.info(Character.getNumericValue(' '));  // -1 不代表任何数值
//		info.info(Character.getNumericValue('\r')); // -1
//		info.info(Character.getNumericValue('\n')); // -1
//		info.info(Character.getNumericValue('\\')); // -1
//		info.info(Character.getNumericValue('$'));  // -1
//		info.info(Character.getNumericValue('a'));  // 10 代表数值 10
//		info.info(Character.getNumericValue('b'));  // 11
//		info.info(Character.getNumericValue('A'));  // 10
//		info.info(Character.getNumericValue('Z'));  // 35
		
		// ------- 指定进制下，字符表示形式 与 特定数字 的对应 End -------
		
// -----------------------------------------------------------------------
		// unicode
//		info.info(Character.toLowerCase('\u005a'));
//		char c1 = '\u0042';
		//char c2 = '\x42'; // 编译错误
		//info.info(c2);
	}

}
