package com.umbrella.designpattern.prototype;

import java.io.Serializable;
/**
 * Ç³¿½±´
 * @author asdf
 *
 */
public class TeacherL implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5185119980353287482L;
	private String name;
	private Student student;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	@Override
	public String toString() {
		return super.toString();
	}
}
