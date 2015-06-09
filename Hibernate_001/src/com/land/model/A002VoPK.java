package com.land.model;

import java.io.Serializable;

public class A002VoPK implements Serializable {
	private String f1;
	private String f2;
	
	public String getF1() {
		return f1;
	}
	public void setF1(String f1) {
		this.f1 = f1;
	}
	public String getF2() {
		return f2;
	}
	public void setF2(String f2) {
		this.f2 = f2;
	}
	@Override
	public int hashCode() {
		return this.f1.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof A002VoPK) {
			A002VoPK pk = (A002VoPK)obj;
			if(this.f1.equals(pk.f1) && this.f2.equals(pk.f2)) {
				return true;
			}
		}
		return false;
	}
	
}
