package com.umbrella.designpattern.iterator;
/**
 * Iterator模式
 * @author asdf
 *
 */
public interface Iterator<E> {
	boolean hasNext();
	E next();
	/**
	 * 删除刚遍历过的元素
	 */
	void remove();
}
