package com.umbrella.calculate;
/**
 * FizzBuzz
 * 递归
 * 
 * 从 1 到 100的数，
 * 如果能被3整除，输出 Fizz；
 * 如果能被5整除，输出Buzz；
 * 如果能被3和5整除，输出FizzBuzz
 * @author 大洲
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
