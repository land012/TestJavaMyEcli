package com.land.bbs.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Msg {
	private int id;
	private String cont;
	private Topic topic;
	
	public Msg() {}
	
	public Msg(int id, String cont, Topic topic) {
		this.id = id;
		this.cont = cont;
		this.topic = topic;
	}
	
	@Id
	@GeneratedValue
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
	
	@ManyToOne
	@JoinColumn(name="tid")
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}
