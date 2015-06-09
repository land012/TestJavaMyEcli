package com.umbrella.designpattern.composite;

public class Banana extends Fruit {

	@Override
	public double getTotalPrice() {
		return this.getPrice() * this.getCount() * 0.8;
	}

}
