package com.my.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExprTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Pattern pattern = Pattern.compile("1|(0(\\.\\d{1,5})?)");
//		System.out.println(pattern.matcher("0.87").matches());
		
		/*
		 * matches() 和  find()
		 * ab 和 a,b
		 */
		String regexp1 = "[a,b]";
		String str1 = "plain";
		
		System.out.println(Pattern.matches(regexp1, str1)); // false
		
		Pattern pattern1 = Pattern.compile(regexp1);
		Matcher matcher1 = pattern1.matcher(str1);
		
		// false 验证整个串是否符合 正则规则
		System.out.println(matcher1.matches());
		matcher1.reset();
		
		// true 验证串中是否有符合正则规则的子串
		System.out.println(matcher1.find());
		
		// matches() 和  find()
		// ab 和 a,b
		String regexp2 = "[ab]";
		String str2 = "plain";
		
		System.out.println(Pattern.matches(regexp2, str2)); // false
		
		Pattern pattern2 = Pattern.compile(regexp2);
		Matcher matcher2 = pattern2.matcher(str2);
		// false 验证整个串是否符合 正则规则
		System.out.println(matcher2.matches());
		matcher2.reset();
		// true 验证串中是否有符合正则规则的子串
		System.out.println(matcher2.find());
		
//		String regexp = "(.*)[a](.*)";
//		String str = "plain";
//		Pattern pattern = Pattern.compile(regexp);
//		Matcher matcher = pattern.matcher(str);
//		// true
//		// 验证整个串是否符合 正则规则
//		System.out.println(matcher.matches());
//		matcher.reset(); // 如果不加这句，find()会从上次 matches的位置开始查找
//		// true
//		System.out.println(matcher.find());


//		// 非贪婪 find()-false
//		String regexp = "(?:.*)[a](?:.*)";
//		String str = "plain";
//		Pattern pattern = Pattern.compile(regexp);
//		Matcher matcher = pattern.matcher(str);
//		// true
//		// 验证整个串是否符合 正则规则
//		System.out.println(matcher.matches());
//		// false ????????????
//		System.out.println(matcher.find());
		
//		/*
//		 * 非贪婪 find()-true
//		 */
//		String regexp = "(?:.*)[a]?(?:.*)";
//		String str = "plain";
//		Pattern pattern = Pattern.compile(regexp);
//		Matcher matcher = pattern.matcher(str);
//		// true
//		// 验证整个串是否符合 正则规则
//		System.out.println(matcher.matches());
//		// true ????????????
//		System.out.println(matcher.find());
		
		// [a]? find()-true
//		String regexp = "(.*)([a]?)(.*)";
//		String str = "plain";
//		Pattern pattern = Pattern.compile(regexp);
//		Matcher matcher = pattern.matcher(str);
//		// true
//		// 验证整个串是否符合 正则规则
//		System.out.println(matcher.matches());
//		// true ????????????
//		// 此处的 true 或 false 与是否贪婪无关
//		System.out.println(matcher.find());
		
		// [a]* find()-true
//		String regexp = "(.*)([a]*)(.*)";
//		String str = "plain";
//		Pattern pattern = Pattern.compile(regexp);
//		Matcher matcher = pattern.matcher(str);
//		// true
//		// 验证整个串是否符合 正则规则
//		System.out.println(matcher.matches());
//		// true ????????????
//		// 此处的 true 或 false 与是否贪婪无关
//		System.out.println(matcher.find());
		
		// [a]+ find()-false
//		String regexp = "(.*)([a]+)(.*)";
//		String str = "plain";
//		Pattern pattern = Pattern.compile(regexp);
//		Matcher matcher = pattern.matcher(str);
//		// true
//		// 验证整个串是否符合 正则规则
//		System.out.println(matcher.matches());
//		// false ????????????
//		System.out.println(matcher.find());
		
//		String regexp = ".+";
//		String str = "plain";
//		Pattern pattern = Pattern.compile(regexp);
//		Matcher matcher = pattern.matcher(str);
//		// plain,
//		while(matcher.find()) {
//			System.out.print(matcher.group() + ",");
//		}
		
//		String regexp = ".*?";
//		String str = "plain";
//		Pattern pattern = Pattern.compile(regexp);
//		Matcher matcher = pattern.matcher(str);
//		// ,,,,,,
//		while(matcher.find()) {
//			System.out.print(matcher.group() + ",");
//		}
		
//		String regexp = ".+?";
//		String str = "plain";
//		Pattern pattern = Pattern.compile(regexp);
//		Matcher matcher = pattern.matcher(str);
//		// p,l,a,i,n,
//		while(matcher.find()) {
//			System.out.print(matcher.group() + ",");
//		}
		
//		String regexp = ".++";
//		String str = "plain";
//		Pattern pattern = Pattern.compile(regexp);
//		Matcher matcher = pattern.matcher(str);
//		// plain,
//		while(matcher.find()) {
//			System.out.print(matcher.group() + ",");
//		}
		
//		String regexp = "(.*)[a](.*)";
//		String str = "plain";
//		Pattern pattern = Pattern.compile(regexp);
//		Matcher matcher = pattern.matcher(str);
//		// plain,
//		while(matcher.find()) {
//			System.out.print(matcher.group() + ",");
//		}
		
	}

}
