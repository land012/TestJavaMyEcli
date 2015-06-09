package com.umbrella.designpattern.chain;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Request req = new MyRequest();
		req.setQuestion("B");
		Handler handlerA1 = new HandlerA();
		Handler handlerA2 = new HandlerA();
		Handler handlerB = new HandlerB();
		handlerA1.setNextHandler(handlerA2);
		handlerA2.setNextHandler(handlerB);
		handlerA1.handle(req);
		System.out.println("ÏìÓ¦£º" + req.getResponse());
	}

}
