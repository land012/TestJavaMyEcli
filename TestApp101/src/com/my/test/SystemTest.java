package com.my.test;

import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import com.my.service.CommonService;
import com.my.util.MyComparator;
import com.umbrella.vo.User;

public class SystemTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		/**
//		 * 数组拷贝
//		 */
//		String[] arr1 = { "a", "b", "c" };
//		
//		String[] arr2 = new String[4];
//		System.arraycopy(arr1, 0, arr2, 0, 3);
//		System.out.println("arr2.length:" + arr2.length);
//		System.out.println("arr2:" + Arrays.toString(arr2));
//		if("null".equals(arr2[3])) {
//			System.out.println("arr2[3] is 'null':" + arr2[3]);
//		} else if(null == arr2[3]) {
//			System.out.println("arr2[3] is null:" + arr2[3]);
//		} else {
//			System.out.println("arr2[3] is else:" + arr2[3]);
//		}
//		
//		
//		String[] arr3 = new String[2];
//		System.arraycopy(arr1, 0, arr3, 0, 2);
//		System.out.println("arr3:" + Arrays.toString(arr3));
//		
//		String[] arr4 = new String[2];
//		System.arraycopy(arr1, 1, arr4, 0, 2);
//		System.out.println("arr4:" + Arrays.toString(arr4));
//		
//		String[] arr5 = new String[2];
//		System.arraycopy(arr1, 0, arr5, 1, 1);
//		System.out.println("arr5:" + Arrays.toString(arr5));
		
		/**
		 * 排序
		 */
//		// 一维数组排序
//		String[] arr1 = { "b", "a", "c" };
//		Arrays.sort(arr1, new MyComparator<String>());
//		System.out.println(Arrays.toString(arr1));
		
//		// 二维数组排序
//		String[][] arr2 = {
//				{ "b", "1"},
//				{ "a", "2"},
//				{ "c", "3"}
//		};
//		Arrays.sort(arr2, new MyComparator<String[]>());
//		for(String[] ar : arr2) {
//			System.out.println(Arrays.toString(ar));
//		}
		
//		/**
//		 * 毫秒
//		 */
//		System.out.println(new Date().getTime());       // 1404024445904
//		System.out.println(System.currentTimeMillis()); // 1404024445904
//		System.out.println(System.nanoTime());          // 9071127851683 从JVM启动到当前的时长
		
//		/**
//		 * %s 占位符
//		 * %n 换行符
//		 */
//		System.out.format("name:%s,age:%s", "name", 19);
//		System.out.format("name:%s,age:%s%n", "name", 19);
//		System.out.format("name:%s,age:%s%n", "name", 19);
		
		/**
		 * 环境属性
		 */
//		Map<String, String> map1 = System.getenv();
//		Set<String> set1 = map1.keySet();
//		for(String key : set1) {
//			System.out.format("%s 是 %s%n", key, map1.get(key));
//		}
		
		/**
		 * 系统属性
		 */
		Properties prop1 = System.getProperties();
		Set<Object> set2 = prop1.keySet();
		for(Object key : set2) {
			System.out.format("%s 是 %s%n", key, prop1.get(key));
		}
	}
	
	

}
