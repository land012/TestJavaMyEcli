package com.my.test;

import org.apache.commons.lang3.StringEscapeUtils;

public class StringEscapeUtilsTest {
	public static void main(String[] args) {
		// Unicode����
//		System.out.println(StringEscapeUtils.escapeJava("���"));           // \u4F60\u597D
//		System.out.println(StringEscapeUtils.escapeEcmaScript("���"));     // \u4F60\u597D
//		System.out.println(StringEscapeUtils.unescapeJava("\u4F60\u597D")); // ���
//		
//		System.out.println(StringEscapeUtils.ESCAPE_XML.translate("���&")); // ���&amp;
//		System.out.println(StringEscapeUtils.escapeXml("���&"));            // ���&amp;
//		System.out.println(StringEscapeUtils.escapeHtml3("���&"));          // ���&amp;
//		System.out.println(StringEscapeUtils.escapeHtml4("���&"));          // ���&amp;
//		
//		System.out.println(org.apache.commons.lang.StringEscapeUtils.escapeHtml("���")); // &#20320;&#22909;
		
		System.out.println(StringEscapeUtils.escapeJava("���ZERO"));
	}
}
