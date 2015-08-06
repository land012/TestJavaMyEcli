package com.umbrella.vo;

public class User extends Human {
	private String age;
	private String gender;
	public String address;
	
	private static final String s1 = "s1";
	private static int s2;
	public static final String s3 = "s3";
	public final String s4 = "s4";
	
	String s5;
	protected String s6;
	
	public User() {
		StackTraceElement ste = new Throwable().getStackTrace()[0];
		System.out.format("%s.%s(%s)%n", ste.getClassName(), ste.getMethodName(), ste.getLineNumber());
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	private void fn1() {
//		User2 u = new User2();
	}
	
	public void fn2() {
		fn1();
	}
}
