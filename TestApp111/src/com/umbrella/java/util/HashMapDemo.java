package com.umbrella.java.util;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
	
	static {
		System.out.println("���Ǿ�̬����飡");
	}
	
	{
		System.out.println("ʵ����ʼ����");
	}

	public static void main(String[] args) {
		Map<String, String> map1 = new HashMap<String, String>(){
				{
					put("k1", "v1");
					put("k2", "v2");
				}
			};
		System.out.println(map1.get("k1"));
		
		String[] str1 = new String[]{"s1", "s2"};
		System.out.println(str1[0]);
	}

}
