package com.umbrella.designpattern.iterator;
/**
 * Iteratorģʽ
 * @author asdf
 *
 */
public interface Iterator<E> {
	boolean hasNext();
	E next();
	/**
	 * ɾ���ձ�������Ԫ��
	 */
	void remove();
}
