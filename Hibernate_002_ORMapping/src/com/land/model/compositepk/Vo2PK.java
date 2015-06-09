package com.land.model.compositepk;

import java.io.Serializable;

public class Vo2PK implements Serializable {
	private int id1;
	private int id2;
	public int getId1() {
		return id1;
	}
	public void setId1(int id1) {
		this.id1 = id1;
	}
	public int getId2() {
		return id2;
	}
	public void setId2(int id2) {
		this.id2 = id2;
	}
	@Override
	public int hashCode() {
		return String.valueOf(this.id1).hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null) {
			Vo2PK pk = (Vo2PK)obj;
			if(this.id1 == pk.id1 && this.id2 == pk.id2) {
				return true;
			}
		}
		return false;
	}
	
}
