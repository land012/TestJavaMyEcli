package com.umbrella.designpattern.flyweight;

public class ConcreteFlyweight extends Flyweight {

	public ConcreteFlyweight(String intrinsic) {
		super(intrinsic);
	}

	@Override
	public void operate(String extrinsic) {
		System.out.println(intrinsic + ":" + extrinsic);
	}

}
