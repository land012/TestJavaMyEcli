package com.my.test;

import java.text.CollationKey;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringEscapeUtils;

import com.my.util.ChineseComparator;

public class CollatorTest {
	public static void main(String[] args) {
		
		// Unicode����
//		System.out.println("a" + ":" + StringEscapeUtils.escapeJava("a")); // a
		
		String str1 = "��";
		String str2 = "��";
		System.out.println(str1 + ":" + StringEscapeUtils.escapeJava(str1)); // Unicode���� \u6211
		System.out.println(str2 + ":" + StringEscapeUtils.escapeJava(str2)); // Unicode���� \u628A
		System.out.println(str1.compareTo(str2)); // -121
		
		Collator collator = Collator.getInstance(Locale.CHINA);
		CollationKey k1 = collator.getCollationKey(str1);
		CollationKey k2 = collator.getCollationKey(str2);
		System.out.println(k1.compareTo(k2)); // 1
		
		// �Ժ��ְ�ƴ������
		List<String> list = new ArrayList<String>();
		list.add("��");
		list.add("��");
		list.add("��");
		list.add("��");
		list.add("��");
		Collections.sort(list);
		System.out.println(list);
		Collections.sort(list, new ChineseComparator<String>());
		System.out.println(list);
	}
}
