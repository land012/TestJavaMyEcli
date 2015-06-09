package com.my.test1;

/**
 * 传值，传引用、
 * hashCode()
 * @author xudz
 *
 */
public class ValueTransfer {
	
	private static int count = 0;

	public static void main(String[] args) {
		// 将对象存入数组的测试
		/*A[] a = new A[4];
		for(int i=0; i<a.length; i++) {
			a[i] = new A(i);
		}
		
		if(a instanceof A[]) {
			System.out.println("Yes");
		}
		// 可以使用 增强for循环
		for(A temp : a) {
			System.out.println(temp.num);
		}*/
		
		// jar包里加断点，可以跳到jar包断点处
		/*String str = "abc";
		System.out.println(str.length());*/
		
		// 传值 传引用
		/*String str = "abc";
		str = add(str); // 调用方法，并引用返回结果
		System.out.println(str); // abcabc
		add(str); // 值传递
		System.out.println(str); // abcabc
		int i = 1;
		add(i); // 值传递
		// 输出：1
		System.out.println(i);*/
		
		/*
		 * 对象 传值  传引用
		 * hashCode
		 */
//		A a = new A(1);
//		modifyA(a);
//		//System.out.println(a);                   // 调用 toString()，toString() 调用 toHexString(hashCode())
//		//System.out.println(Integer.toHexString(a.hashCode()));
//		//System.out.println(a.hashCode());
//		System.out.println(a.num); // 1 ，结果不变
//		modifyA2(a);
//		//System.out.println(a); // a 的 hashCode 并没有改变，a 还是 a
//		//System.out.println(a.hashCode());
//		System.out.println(a.num); // 22, 结果变了
		
		System.out.println("--------------");
		
		A a = new A();
		A a2 = new A();
		A a3 = null;
		try {
			a3 = (A)a.clone(); // a 的副本
			//System.out.println("try 下面的内容！");
		} catch (CloneNotSupportedException e) {
			System.out.println("克隆对象出错了！-_-");
		}
		System.out.println(a.hashCode());  // 33263331
		System.out.println(a2.hashCode()); // 6413875
		System.out.println(a3.hashCode()); // 21174459
		
		// 值传递
//		int a = 2;
//		int b = 3;
//		exechange(a,b);
//		System.out.println("a=" + a + "," + "b=" + b); // a=2,b=3
		
//		// 值传递
//		String str1 = "ab";
//		String str2 = "bc";
//		exechange(str1, str2);
//		System.out.println("str1=" + str1 + ", str2=" + str2); // str1=ab, str2=bc
		
//		System.out.println(count); // 0
		add2(count); // count不会改变
//		System.out.println(count); // 0
//		count++;
//		System.out.println(count); // 1
		
	}
	
	public static String add(String str) {
		str += "abc";
		return str;
	}
	
	public static void add(int i) {
		i += 1;
		//return i;
	}
	
	public static void modifyA(A a) {
		a = new A(21);
	}
	
	public static void modifyA2(A a) {
		a.num = 22;
	}
	
	static void m1() { }
	
	protected void  m2() { }
	
	public void m3() { }
	
	// 值传递
	public static void exechange(int a,int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	// 值传递
	public static void exechange(String a, String b) {
		String temp = a;
		a = b;
		b = temp;
		System.out.println("exechange中：a=" + a + ", b=" + b);
	}
	
	//值传递
	public static void add2(int i) {
		i++;
	}

}

class A {
	public int num;
	
	public A() {}
	
	public A(int num) {
		this.num = num;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new A(this.num); // 哈希码 可能不同
		//return this; // 哈希码相同
		//return super.clone();
	}

//	@Override
//	public String toString() {
//		return "num=" + num;
//	}
	
}