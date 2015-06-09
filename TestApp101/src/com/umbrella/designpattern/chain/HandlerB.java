package com.umbrella.designpattern.chain;

public class HandlerB extends Handler {

	@Override
	void handle(Request request) {
		String question = (String)request.getQuestion();
		if(question == null) return;
		if("B".equals(question)) {
			System.out.println("HandlerB 可以处理这个请求");
			request.setResponse("HandlerB 处理了这个请求");
		} else {
			this.getNextHandler().handle(request);
		}
	}

}
