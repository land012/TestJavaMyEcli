package com.xu.test.impl;

import java.util.List;

import com.xu.test.TestBean;

public class TestBeanImpl implements TestBean {
	private List<String> lists;

	public List<String> getLists() {
		return lists;
	}

	public void setLists(List<String> lists) {
		this.lists = lists;
	}

	@Override
	public void printList() {
		for(String s : this.lists) {
			System.out.println(s);
		}
	}
	
}
