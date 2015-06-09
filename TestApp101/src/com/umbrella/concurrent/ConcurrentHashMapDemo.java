package com.umbrella.concurrent;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		 * putIfAbsent(key, value_new)
		 * ���������ָ�� key,����� value_new������ null
		 * ������ڣ��򲻷����� value_new�������Ѿ����ڵ� value
		 */
		Long l1 = System.currentTimeMillis();
		System.out.println("l1=" + l1);
		ConcurrentHashMap<String, Long> cmap1 = new ConcurrentHashMap<String, Long>();
		Long l2 = cmap1.putIfAbsent("k1", l1);
		if(null == l2) {
			System.out.println("l2 is null");
		} else {
			System.out.println("l2=" + l2);
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Long l3 = System.currentTimeMillis();
		Long l4 = cmap1.putIfAbsent("k1", l3);
		System.out.println("l3=" + l3);
		if(null == l4) {
			System.out.println("l4 is null");
		} else {
			System.out.println("l4=" + l4);
		}
	}

}
