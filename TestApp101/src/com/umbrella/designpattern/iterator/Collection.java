package com.umbrella.designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class Collection<E> {
	
	private List<E> lists = new ArrayList<E>();
	
	public Iterator<E> iterator() {
		return new ConcreteIterator<E>();
	}
	
	public void add(E e) {
		lists.add(e);
	}
	
	private class ConcreteIterator<T> implements Iterator<E> {
		int cursor; // 下一个元素的索引
		
		@Override
		public boolean hasNext() {
			return cursor < lists.size();
		}

		@Override
		public E next() {
			return lists.get(cursor++);
		}

		@Override
		public void remove() {
			lists.remove(--cursor);
		}
		
	}
}
