package com.umbrella.designpattern.chain;

public class HandlerA extends Handler {

	@Override
	void handle(Request request) {
		String question = (String)request.getQuestion();
		if(question == null) return;
		if("A".equals(question)) {
			System.out.println("HandlerA ���Դ����������");
			request.setResponse("HandlerA �������������");
		} else {
			System.out.println("HandlerA ���ܴ���������󣬽�����һ��Handler");
			this.getNextHandler().handle(request);
		}
	}

}
