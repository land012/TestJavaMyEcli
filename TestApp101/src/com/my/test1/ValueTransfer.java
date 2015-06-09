package com.my.test1;

/**
 * ��ֵ�������á�
 * hashCode()
 * @author xudz
 *
 */
public class ValueTransfer {
	
	private static int count = 0;

	public static void main(String[] args) {
		// �������������Ĳ���
		/*A[] a = new A[4];
		for(int i=0; i<a.length; i++) {
			a[i] = new A(i);
		}
		
		if(a instanceof A[]) {
			System.out.println("Yes");
		}
		// ����ʹ�� ��ǿforѭ��
		for(A temp : a) {
			System.out.println(temp.num);
		}*/
		
		// jar����Ӷϵ㣬��������jar���ϵ㴦
		/*String str = "abc";
		System.out.println(str.length());*/
		
		// ��ֵ ������
		/*String str = "abc";
		str = add(str); // ���÷����������÷��ؽ��
		System.out.println(str); // abcabc
		add(str); // ֵ����
		System.out.println(str); // abcabc
		int i = 1;
		add(i); // ֵ����
		// �����1
		System.out.println(i);*/
		
		/*
		 * ���� ��ֵ  ������
		 * hashCode
		 */
//		A a = new A(1);
//		modifyA(a);
//		//System.out.println(a);                   // ���� toString()��toString() ���� toHexString(hashCode())
//		//System.out.println(Integer.toHexString(a.hashCode()));
//		//System.out.println(a.hashCode());
//		System.out.println(a.num); // 1 ���������
//		modifyA2(a);
//		//System.out.println(a); // a �� hashCode ��û�иı䣬a ���� a
//		//System.out.println(a.hashCode());
//		System.out.println(a.num); // 22, �������
		
		System.out.println("--------------");
		
		A a = new A();
		A a2 = new A();
		A a3 = null;
		try {
			a3 = (A)a.clone(); // a �ĸ���
			//System.out.println("try ��������ݣ�");
		} catch (CloneNotSupportedException e) {
			System.out.println("��¡��������ˣ�-_-");
		}
		System.out.println(a.hashCode());  // 33263331
		System.out.println(a2.hashCode()); // 6413875
		System.out.println(a3.hashCode()); // 21174459
		
		// ֵ����
//		int a = 2;
//		int b = 3;
//		exechange(a,b);
//		System.out.println("a=" + a + "," + "b=" + b); // a=2,b=3
		
//		// ֵ����
//		String str1 = "ab";
//		String str2 = "bc";
//		exechange(str1, str2);
//		System.out.println("str1=" + str1 + ", str2=" + str2); // str1=ab, str2=bc
		
//		System.out.println(count); // 0
		add2(count); // count����ı�
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
	
	// ֵ����
	public static void exechange(int a,int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	// ֵ����
	public static void exechange(String a, String b) {
		String temp = a;
		a = b;
		b = temp;
		System.out.println("exechange�У�a=" + a + ", b=" + b);
	}
	
	//ֵ����
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
		return new A(this.num); // ��ϣ�� ���ܲ�ͬ
		//return this; // ��ϣ����ͬ
		//return super.clone();
	}

//	@Override
//	public String toString() {
//		return "num=" + num;
//	}
	
}