package com.my.test;

import org.apache.commons.lang3.StringEscapeUtils;

public class StringEscapeUtilsTest {
	public static void main(String[] args) {
		// Unicode编码
//		System.out.println(StringEscapeUtils.escapeJava("你好"));           // \u4F60\u597D
//		System.out.println(StringEscapeUtils.escapeEcmaScript("你好"));     // \u4F60\u597D
//		System.out.println(StringEscapeUtils.unescapeJava("\u4F60\u597D")); // 你好
//		
//		System.out.println(StringEscapeUtils.ESCAPE_XML.translate("你好&")); // 你好&amp;
//		System.out.println(StringEscapeUtils.escapeXml("你好&"));            // 你好&amp;
//		System.out.println(StringEscapeUtils.escapeHtml3("你好&"));          // 你好&amp;
//		System.out.println(StringEscapeUtils.escapeHtml4("你好&"));          // 你好&amp;
//		
//		System.out.println(org.apache.commons.lang.StringEscapeUtils.escapeHtml("你好")); // &#20320;&#22909;
		
		System.out.println(StringEscapeUtils.escapeJava("射雕ZERO"));
	}
}
