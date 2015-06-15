package com.xu.action;

import com.opensymphony.xwork2.ActionSupport;

public class ResultParamsAction extends ActionSupport {
	private String type;
	private String type2;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(this.type);
		this.type2 = this.type;
		return SUCCESS;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}
	
}
