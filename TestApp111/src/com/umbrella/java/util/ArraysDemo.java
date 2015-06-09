package com.umbrella.java.util;

import java.util.Arrays;

public class ArraysDemo {

	public static void main(String[] args) {
		int[] arr1 = new int[10];
		for(int i : arr1) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
		Arrays.fill(arr1, 0, arr1.length-1, 2);
		for(int i : arr1) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}

}
