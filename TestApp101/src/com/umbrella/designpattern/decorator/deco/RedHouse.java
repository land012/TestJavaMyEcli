package com.umbrella.designpattern.decorator.deco;

import com.umbrella.designpattern.decorator.base.House;

public class RedHouse extends DecoratorHouse {

	public RedHouse(House house) {
		super(house);
	}

	@Override
	protected void Before() {
		System.out.println("��ѷ���Ⱦ�ɺ�ɫ");
	}

	@Override
	protected void After() {
		
	}

}
