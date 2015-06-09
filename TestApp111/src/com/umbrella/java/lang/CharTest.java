package com.umbrella.java.lang;

public class CharTest {

	public static void main(String[] args) {
		char[] arr1 = new char[]{'a', 'b', 'c'};
		for(char c : arr1) {
			System.out.print(c);
			System.out.print(" ");
		}
		System.out.println();
		
		char[] arr2 = "¹þ¹þ".toCharArray();
		for(char c : arr2) {
			System.out.print(c);
			System.out.print(" - ");
		}
		System.out.println();
	}

}
