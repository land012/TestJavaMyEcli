package com.umbrella.designpattern.composite;
/**
 * ���ģʽ
 * @author asdf
 *
 */
public abstract class Fruit {
	private int count;
	private double price;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void add(Fruit fruit) {
		
	}
	
	public boolean remove(Fruit furit) {
		return false;
	}
	
	public abstract double getTotalPrice();
}
