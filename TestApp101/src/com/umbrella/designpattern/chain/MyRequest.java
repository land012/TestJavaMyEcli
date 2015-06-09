package com.umbrella.designpattern.chain;

public class MyRequest implements Request {
	
	private Object question;
	private Object response;

	@Override
	public void setQuestion(Object question) {
		this.question = question;
	}

	@Override
	public Object getQuestion() {
		return this.question;
	}

	@Override
	public void setResponse(Object response) {
		this.response = response;
	}

	@Override
	public Object getResponse() {
		return this.response;
	}

}
