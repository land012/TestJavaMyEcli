package com.umbrella.designpattern.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.log4j.Logger;



/**
 * Éî¿½±´
 * @author asdf
 *
 */
public class TeacherD implements Cloneable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3976455733198319762L;

	private static Logger log = Logger.getLogger(TeacherD.class);
	
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
		Object o = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(this);
			oos.flush();
			
			log.info(baos.toString("gbk"));
			
			ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
			o = ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos!=null) oos.close();
				if(ois!=null) ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return o;
	}
	@Override
	public String toString() {
		return super.toString();
	}
}
