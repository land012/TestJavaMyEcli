package com.my.test;

import java.util.HashMap;
import java.util.Map;

public class StaticTest {
	private static Map<String, String> map = new HashMap<String, String>();
	
	static {
		map.put("k1", "v1");
		map.put("k1", "v2");
	}
	
	private StaticTest() {
		
	}
	
	public static String getV(String key) {
		return map.get(key);
	}
	
	public static void main(String[] args) {
		System.out.println(StaticTest.getV("k1"));
	}
	
}
