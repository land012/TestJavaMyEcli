package com.umbrella.calculate;
/**
 * FizzBuzz
 * �ݹ�
 * 
 * �� 1 �� 100������
 * ����ܱ�3��������� Fizz��
 * ����ܱ�5���������Buzz��
 * ����ܱ�3��5���������FizzBuzz
 * @author ����
 *
 */
public class FizzBuzzDemo {

	public static void main(String[] args) {
		fn1(1);
	}
	
	public static void fn1(int i) {
		if(i>100) {
			return;
		} else if(i%3==0 && i%5==0) {
			System.out.println(i + " - FizzBuzz");
		} else if(i%3==0) {
			System.out.println(i + " - Fizz");
		} else if(i%5==0) {
			System.out.println(i + " - Buzz");
		}
		fn1(i+1);
	}

}
