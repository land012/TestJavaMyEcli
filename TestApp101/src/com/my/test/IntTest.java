package com.my.test;

public class IntTest {
	public static void main(String[] args) {
		short s1 = 1;
		s1 += 1;
		// �����쳣 Type mismatch:cannot convert from int to short
//		s1 = s1 + 1;
		s1 = (short)(s1 + 1);
		
		int i1 = 2;
		// �����쳣 Type mismatch:cannot convert from int to short
//		s1 = i1;
		
	}
}
