package com.umbrella.designpattern.decorator.deco;

import com.umbrella.designpattern.decorator.base.House;

public abstract class DecoratorHouse implements House {
	
	private House house;
	
	public DecoratorHouse(House house) {
		this.house = house;
	}

	@Override
	public void info() {
		this.Before();
		this.house.info();
		this.After();
	}
	
	protected abstract void Before();
	
	protected abstract void After();
	
}
