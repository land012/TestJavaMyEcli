package com.umbrella.test.objref;

import java.util.Arrays;

/**
 * ��������
 * @author asdf
 *
 */
public class Demo {

	public static void main(String[] args) {
//		// ָ��ͬһ������
//		User user1 = new User();
//		user1.setId(1);
//		User user2 = user1;
//		System.out.println(user2 == user1); // true
//		user1.setId(2);
//		System.out.println(user2.getId()); // 2
//		
//		// ָ�����µĶ���
//		String str1 = "abc"; // String Constant Pool
//		String str2 = str1;
//		System.out.println(str2 == str1); // true
//		str1 = "def";
//		System.out.println(str2); // abc
		
		int[] arr = {1, 2};
		System.out.println(Arrays.toString(arr));
		swap(arr[0], arr[1]);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void swap(int i, int j) {
		int temp = i;
		i = j;
		j = temp;
	}

}
