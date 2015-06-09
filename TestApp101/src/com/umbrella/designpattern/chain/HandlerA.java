package com.umbrella.designpattern.chain;

public class HandlerA extends Handler {

	@Override
	void handle(Request request) {
		String question = (String)request.getQuestion();
		if(question == null) return;
		if("A".equals(question)) {
			System.out.println("HandlerA 可以处理这个请求");
			request.setResponse("HandlerA 处理了这个请求");
		} else {
			System.out.println("HandlerA 不能处理这个请求，交给下一个Handler");
			this.getNextHandler().handle(request);
		}
	}

}
