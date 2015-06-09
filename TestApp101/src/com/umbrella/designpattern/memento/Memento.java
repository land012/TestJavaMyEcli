package com.umbrella.designpattern.memento;

public class Memento {

	private Originator originator;
	
	public Memento(Originator originator) {
		this.originator = originator;
	}

	public Originator getOriginator() {
		return originator;
	}
}
