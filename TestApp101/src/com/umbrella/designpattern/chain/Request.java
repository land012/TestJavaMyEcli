package com.umbrella.designpattern.chain;
/**
 * ������ģʽ
 * @author asdf
 *
 */
public interface Request {
	void setQuestion(Object question);
	Object getQuestion();
	void setResponse(Object response);
	Object getResponse();
}
