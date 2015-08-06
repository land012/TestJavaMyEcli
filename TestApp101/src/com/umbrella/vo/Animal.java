package com.umbrella.vo;

public enum Animal {
	TIGER("I'm tiger!"),
	LION("I'm lion!"),
	WOLF("I'm wolf!");
	
	private String name;
	
	private Animal(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
