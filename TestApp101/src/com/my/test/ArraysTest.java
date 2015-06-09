package com.my.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.my.base.BaseTest;

public class ArraysTest extends BaseTest {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String[] Arr1 = {"aa", "bb", "cc"};
//		String[] Arr2 = new String[]{"aaa", "bbb", "ccc"};
//		info.info(Arrays.toString(Arr1)); // [aa, bb, cc]
//		List<String> list1 = Arrays.asList(Arr1);
//		info.info(list1); // [aa, bb, cc]
		
		/*
		 * 打印空数组
		 */
//		String[] arr1 = null;
//		System.out.println(Arrays.toString(arr1)); // null
//		String[] arr2 = {};
//		System.out.println(Arrays.toString(arr2)); // []
//		if(null == arr2) {
//			System.out.println("arr2 is null");
//		} else {
//			System.out.println("arr2 is not null");
//			System.out.println("arr2.length=" + arr2.length);
////			// 异常 java.lang.ArrayIndexOutOfBoundsException: 0
////			System.out.println(arr2[0]);
//		}
		
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		String[] arr1 = new String[2];
		String[] arr2 = new String[2];
		arr2 = list.toArray(arr1);
		Object[] arr3 = list.toArray();
		info.info("arr1 =" + Arrays.toString(arr1));
		info.info("arr2 =" + Arrays.toString(arr2));
		info.info("arr3 =" + Arrays.toString(arr3));
	}

}
