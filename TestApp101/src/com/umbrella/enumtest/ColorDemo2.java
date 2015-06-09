package com.umbrella.enumtest;

public enum ColorDemo2 {
	
	RED("red"),
	GREEN("green"),
	BLUE("blue");
	
	
	private String value;
	
	private ColorDemo2(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
}
