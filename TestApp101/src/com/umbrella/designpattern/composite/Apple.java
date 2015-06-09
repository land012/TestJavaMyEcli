package com.umbrella.designpattern.composite;

public class Apple extends Fruit {

	@Override
	public double getTotalPrice() {
		return this.getPrice() * this.getCount();
	}

}
