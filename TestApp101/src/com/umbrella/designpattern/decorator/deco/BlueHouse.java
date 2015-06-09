package com.umbrella.designpattern.decorator.deco;

import com.umbrella.designpattern.decorator.base.House;

public class BlueHouse extends DecoratorHouse {
	
	private String name;

	public BlueHouse(House house, String name) {
		super(house);
		this.name = name;
	}

	@Override
	protected void Before() {
		System.out.println("想把房子染成蓝色" + name);
	}

	@Override
	protected void After() {
		System.out.println("把房子染成蓝色" + name);
	}

}
