package com.umbrella.designpattern.chain;

public abstract class Handler {
	private Handler nextHandler;
	
	public void setNextHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	public Handler getNextHandler() {
		return this.nextHandler;
	}
	
	abstract void handle(Request request);
}
