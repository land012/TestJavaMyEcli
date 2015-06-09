package com.umbrella.designpattern.iterator;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Collection<Integer> collection = new Collection<Integer>();
		for(int i=0; i<10; i++) {
			collection.add(i);
		}
		System.out.println("第一次遍历：");
		for(Iterator<Integer> it = collection.iterator(); it.hasNext(); ) {
			int temp = it.next();
			System.out.println(temp);
			if(temp%2==0) it.remove();
		}
		System.out.println("第二次遍历：");
		for(Iterator<Integer> it = collection.iterator(); it.hasNext(); ) {
			int temp = it.next();
			System.out.println(temp);
		}
	}

}
