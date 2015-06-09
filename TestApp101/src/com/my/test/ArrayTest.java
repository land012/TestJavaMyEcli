package com.my.test;

import java.util.Arrays;

import com.my.base.BaseTest;

public class ArrayTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String[] strArr = new String[]{}; // 空数组，没有长度
//		strArr[0] = "0"; // 异常：java.lang.ArrayIndexOutOfBoundsException
//		info.info("数组第一个元素是：" + strArr[0]);
		
//		String[] strArr1 = {"v1", "v2", "v3"};
//		info.info(strArr1[0]); // v1
//		//String[] strArr2 = {"k1":"v1", "k2":"v2"}; // Syntax error
		
//		// 空数组做参数
//		ArrayTest.fn1(new String[]{});
//		
//		String[][] strArr3 = {
//				{"v11", "v12"},
//				{"v21", "v22"}
//		};
//		info.info(strArr3[0][0]); // v11
		
		// 动态声明二维数组
//		int[] i11 = new int[1];
//		int[] i12 = new int[3];
//		int[] i13 = new int[3];
//		i11[0] = 110;
//		int[][] i1 = {
//				i11,
//				i12,
//				i13
//		};
//		info.info("i1[0][0]:" + i1[0][0]);
		
//		int[][] i1 = new int[2][6];
//		i1[0] = new int[7];
//		i1[0][0] = 0;
//		i1[0][6] = 6;
//		info.info("i1[0][0]:" + i1[0][0]);
//		info.info("i1[0][6]:" + i1[0][6]);
		
//		double[][] i1 = new double[2][2];
//		i1[0][0] = 1;
//		i1[1][1] = 1;
//		i1[1] = new double[3];
//		for(int i=0; i<i1.length; i++) {
//			for(int j=0; j<i1[i].length; j++) {
//				info.info(i1[i][j]);
//			}
//		}
		
//		String[] arr1 = { "a", "b" };
//		System.out.println(arr1); // [Ljava.lang.String;@12d7d02
//		System.out.println(Arrays.toString(arr1)); // [a, b]
		
//		int[] arr1 = { 1, 2, 3 };
//		System.out.println(arr1[+1]);
	}
	
	public static void fn1(String[] str) {
		info.info("This is fn1!");
	}

}