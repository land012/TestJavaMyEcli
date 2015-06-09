package com.my.test;

import java.util.StringTokenizer;

import org.apache.log4j.Logger;

public class StringTokenizerTest {
	
	private static Logger log = Logger.getLogger(StringTokenizerTest.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "a?b?c";
		StringTokenizer st1 = new StringTokenizer(str1, "?"); // 3
		log.info(st1.countTokens());
		while(st1.hasMoreTokens()) {
			System.out.print(st1.nextToken() + ",");
		}
		System.out.println();
		
		String str2 = "a?b?";
		StringTokenizer st2 = new StringTokenizer(str2, "?"); // 2
		log.info(st2.countTokens());
		
		String str3 = "a?b? ";
		StringTokenizer st3 = new StringTokenizer(str3, "?"); // 3
		log.info(st3.countTokens());
		
		String str4 = "a?b? ? ";
		StringTokenizer st4 = new StringTokenizer(str4, "?"); // 4
		log.info(st4.countTokens());
		
		String str5 = "a?b?? ";
		StringTokenizer st5 = new StringTokenizer(str5, "?"); // 3
		log.info(st5.countTokens());
		
	}

}
