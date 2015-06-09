package com.my.test;

public class CharacterDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Unicode �հ��ַ� ���� true
//		info.info(Character.isSpaceChar(' ')); // ��ǿո� true
//		info.info(Character.isSpaceChar('��')); // ȫ�ǿո� true
//		info.info(Character.isSpaceChar('\r')); // false
//		info.info(Character.isSpaceChar('\n')); // false
//		info.info(Character.isSpaceChar('\t')); // false
//		info.info(Character.isSpaceChar('\f')); // false
//		info.info(Character.isSpaceChar('\b')); // false
		/*
		 * ��Ϊ Character.SPACE_SEPARATOR ��һ������ x���������������� x ��Ϊ char �����ж�
		 * ���� �����������ж���û�������
		 */
		// 12 ��Ӧ���ַ���ҳ�� ��FormFeed/NewPage��
//		info.info(Character.isSpaceChar(Character.SPACE_SEPARATOR)); // false
		// 13 �ǻ��з�
//		info.info(Character.isSpaceChar(Character.LINE_SEPARATOR)); // false 
		// 14 ��Ӧ���ַ� shift out
//		info.info(Character.isSpaceChar(Character.PARAGRAPH_SEPARATOR)); // false
		
		// ��Ӧ ASCII ?
//		char c1 = 12; // ��ҳ����FormFeed/NewPage��
//		char c2 = 13; // �س�
//		char c3 = 14; // shift out
//		info.info("\t" + c1 + "," + c2 + "," + c3);
		
		// ISO-LATIN-1 �հ� ���� true
//		info.info(Character.isSpace(' ')); // deprecated���� isWhitespace() ȡ��
		// Java �հ��ַ�
//		info.info(Character.isWhitespace(' ')); // true
//		info.info(Character.isWhitespace('��')); // true ȫ�ǿո�
//		info.info(Character.isWhitespace('\r')); // true
//		info.info(Character.isWhitespace('\n')); // true
//		info.info(Character.isWhitespace('\t')); // true
//		info.info(Character.isWhitespace('\f')); // true ��ҳ��
//		info.info(Character.isWhitespace('\b')); // ���ʱ߽� false
		
		/*
		 * ������ isSpaceChar() ��ͬ�������������ж�Ҳ��û�������
		 */
//		info.info(Character.isWhitespace(Character.SPACE_SEPARATOR)); // true��12
//		info.info(Character.isWhitespace(Character.LINE_SEPARATOR)); // true��13
//		info.info(Character.isWhitespace(Character.PARAGRAPH_SEPARATOR)); // false��14
		//������� Invalid escape sequence(valid ones are \b \t \n \f \r \" \' \\ )
		//info.info(Character.isWhitespace('\s'));
		
		// ----- ����ĸ��д�ַ� Start -----
//		info.info(Character.TITLECASE_LETTER); // 3
//		info.info(Character.isTitleCase('A')); // false���� getType() Ϊ3ʱ������true
//		info.info(Character.isTitleCase('a')); // false
//		info.info(Character.isTitleCase('B')); // false
//		info.info(Character.isTitleCase('D')); // false
//		info.info(Character.isTitleCase('L')); // false
		
//		info.info(Character.toTitleCase('a')); // A
//		info.info(Character.isTitleCase(Character.toTitleCase('a'))); // false
		
		// ��д��ĸ
//		info.info('\u0041'); // A
//		info.info('\u00C0'); // ??
//		info.info('\u00DE'); // ??
//		info.info(Character.getType('\u00C0')); // 1
//		info.info(Character.UPPERCASE_LETTER); // 1
//		info.info(Character.LOWERCASE_LETTER); // 2
//		info.info(Character.getType('A')); // 1
//		info.info(Character.getType('a')); // 2
		// ----- ����ĸ��д�ַ� End -----

// -----------------------------------------------------------------------
		
		// ------- Unicode �������� Start -------
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
//		info.info(Character.getType('��')); // ȫ�ǿո� 12
		// ------- Unicode �������� End -------
		
// -----------------------------------------------------------------------
		
		// ------- ָ�������£��ַ���ʾ��ʽ �� �ض����� �Ķ�Ӧ Start -------
//		info.info(Character.MAX_RADIX); // 36�����������ַ����໥ת������������
//		info.info(Character.digit('9', 10)); // ��˼�ǣ��� 10 �����'9' ���� 9
//		info.info(Character.digit('0', 2)); // 
//		info.info(Character.digit('a', 16)); // 10 ��˼�ǣ��� 16 �����'a' ���� 10
//		info.info(Character.digit('A', 16)); // 10 ��˼�ǣ��� 16 �����'A' ���� 10
//		info.info(Character.digit('G', 17)); // 16 ��˼�ǣ��� 17 �����'G' ���� 16
//		info.info(Character.forDigit(34, 35)); // y �� 35 �����35 �� 'y' ��ʾ
//		info.info(Character.forDigit(35, 36)); // z �� 36 �����35 �� 'z' ��ʾ
//		info.info(Character.forDigit(36, 37)); // �����������
		
		// ����ָ���ַ�(Ӣ����ĸ)��ĳ�ֽ����£��������ֵ��ʮ������ֵ��
//		info.info(Character.getNumericValue(' '));  // -1 �������κ���ֵ
//		info.info(Character.getNumericValue('\r')); // -1
//		info.info(Character.getNumericValue('\n')); // -1
//		info.info(Character.getNumericValue('\\')); // -1
//		info.info(Character.getNumericValue('$'));  // -1
//		info.info(Character.getNumericValue('a'));  // 10 ������ֵ 10
//		info.info(Character.getNumericValue('b'));  // 11
//		info.info(Character.getNumericValue('A'));  // 10
//		info.info(Character.getNumericValue('Z'));  // 35
		
		// ------- ָ�������£��ַ���ʾ��ʽ �� �ض����� �Ķ�Ӧ End -------
		
// -----------------------------------------------------------------------
		// unicode
//		info.info(Character.toLowerCase('\u005a'));
//		char c1 = '\u0042';
		//char c2 = '\x42'; // �������
		//info.info(c2);
	}

}
