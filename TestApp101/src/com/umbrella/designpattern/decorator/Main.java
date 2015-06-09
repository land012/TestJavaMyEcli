package com.umbrella.designpattern.decorator;

import com.umbrella.designpattern.decorator.base.BaseHouse;
import com.umbrella.designpattern.decorator.base.House;
import com.umbrella.designpattern.decorator.deco.BlueHouse;
import com.umbrella.designpattern.decorator.deco.RedHouse;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		House h1 = new BaseHouse();
//		House h2 = new RedHouse(h1);
//		h2.info();
		
		House h3 = new BlueHouse(h1, "h3");
		House h4 = new RedHouse(h3);
		House h5 = new BlueHouse(h4, "h5");
		h5.info();
	}

}
