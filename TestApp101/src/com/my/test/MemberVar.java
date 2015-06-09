package com.my.test;

public class MemberVar {
	private A a;
	
	public static void main(String[] args) {
		MemberVar t2 = new MemberVar();
		t2.printIt(); // a is null!!
		
	}
	
	public void printIt(){
		if(a != null) {
			System.out.println("a is not null!!" + a.num);
		} else {
			System.out.println("a is null!!");
		}
	}

}

class A {
	public int num = 2;
}