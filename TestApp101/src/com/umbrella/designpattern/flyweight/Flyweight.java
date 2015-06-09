package com.umbrella.designpattern.flyweight;

public abstract class Flyweight {
	protected String intrinsic;
	public Flyweight(String intrinsic) {
		this.intrinsic = intrinsic;
	}
	public abstract void operate(String extrinsic);
}
