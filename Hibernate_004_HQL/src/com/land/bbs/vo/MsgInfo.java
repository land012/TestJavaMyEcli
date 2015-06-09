package com.land.bbs.vo;

public class MsgInfo {
	private int id;
	private String cont;
	private String topicName;
	private String categoryName;
	
	public MsgInfo(int id, String cont, String topicName, String categoryName) {
		this.id = id;
		this.cont = cont;
		this.topicName = topicName;
		this.categoryName = categoryName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
