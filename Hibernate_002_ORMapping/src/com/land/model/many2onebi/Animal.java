package com.land.model.many2onebi;

import java.util.Set;


public class Animal {
	private int id;
	private String name;
	private Set<Tiger> tigers;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Tiger> getTigers() {
		return tigers;
	}
	public void setTigers(Set<Tiger> tigers) {
		this.tigers = tigers;
	}
	
}
