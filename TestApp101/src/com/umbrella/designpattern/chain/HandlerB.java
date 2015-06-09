package com.umbrella.designpattern.chain;

public class HandlerB extends Handler {

	@Override
	void handle(Request request) {
		String question = (String)request.getQuestion();
		if(question == null) return;
		if("B".equals(question)) {
			System.out.println("HandlerB ���Դ����������");
			request.setResponse("HandlerB �������������");
		} else {
			this.getNextHandler().handle(request);
		}
	}

}
