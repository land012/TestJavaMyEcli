package com.umbrella.java.lang;

import java.util.Map.Entry;
import java.util.Properties;

public class SystemDemo {

	public static void main(String[] args) {
		
		/*
		 * ��ӡ����ϵͳ����
		 */
		Properties p1 = System.getProperties();
		for(Entry<Object, Object> e : p1.entrySet()) {
			System.out.println(e.getKey() + "=" + e.getValue());
		}
	}

}
