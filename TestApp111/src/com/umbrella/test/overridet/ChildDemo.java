package com.umbrella.test.overridet;


public class ChildDemo<K, V> extends FatherDemo<K, V> {
	/**
	 * 编译版本为 jdk7时，会报错，如果为 jdk6及以下，不会报错
	 * @param key
	 */
//	public void remove(K key) {
//		
//	}

}
