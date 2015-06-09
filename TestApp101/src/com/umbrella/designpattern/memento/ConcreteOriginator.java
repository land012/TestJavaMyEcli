package com.umbrella.designpattern.memento;

public class ConcreteOriginator extends Originator {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5678463083550141805L;
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public void recover(Memento memento) {
		ConcreteOriginator co = (ConcreteOriginator)memento.getOriginator();
		System.out.println(co.getState());
		this.state = co.getState();
	}

	@Override
	public String toString() {
		return "µ±Ç°×´Ì¬£º" + this.state;
	}

}
