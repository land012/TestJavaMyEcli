package com.umbrella.designpattern.chain;
/**
 * 责任链模式
 * @author asdf
 *
 */
public interface Request {
	void setQuestion(Object question);
	Object getQuestion();
	void setResponse(Object response);
	Object getResponse();
}
