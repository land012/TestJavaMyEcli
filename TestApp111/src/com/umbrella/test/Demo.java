package com.umbrella.test;

import java.util.ArrayList;
import java.util.List;

public class Demo {
	
	// 如果权限是默认的话，什么都不能写，不能用 default，否则语法错误
//	default String s1;
	
	private String s2;
	
	public final static native int fn1();

	public static void main(String[] args) {
//		List<Integer> l1 = new ArrayList<Integer>();
//		List<Number> l2 = l1;
		
		Number[] arr1 = new Integer[10];
		arr1[0] = 0.1;
	}

}

// 语法错误 不能写 default
//default class C1 {
//	
//}