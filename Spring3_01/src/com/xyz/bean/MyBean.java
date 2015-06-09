package com.xyz.bean;

import org.springframework.beans.factory.annotation.Value;

public class MyBean {
	@Value("#{T(java.lang.Math).random() * 100}")
	private double randomNumber;
	
	@Value("#{systemProperties['user.country']}")
	private String uesrRegion;
	
	public double getRandomNumber() {
		return randomNumber;
	}
	public void setRandomNumber(double randomNumber) {
		this.randomNumber = randomNumber;
	}
	public String getUesrRegion() {
		return uesrRegion;
	}
	public void setUesrRegion(String uesrRegion) {
		this.uesrRegion = uesrRegion;
	}
}
