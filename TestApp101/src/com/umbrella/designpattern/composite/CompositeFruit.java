package com.umbrella.designpattern.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositeFruit extends Fruit {
	
	private List<Fruit> fruits = new ArrayList<Fruit>();

	@Override
	public void add(Fruit fruit) {
		fruits.add(fruit);
	}

	@Override
	public boolean remove(Fruit furit) {
		return fruits.remove(furit);
	}

	@Override
	public double getTotalPrice() {
		double res = 0.0;
		Iterator<Fruit> iterator = fruits.iterator();
		for(; iterator.hasNext(); ) {
			Fruit f = iterator.next();
			res += f.getTotalPrice();
		}
		return res;
	}

}
