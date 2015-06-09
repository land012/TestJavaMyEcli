package com.umbrella.designpattern.memento;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class Originator implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6629279446999211803L;
	
	public Memento save() {
		Memento memento = null;
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;
		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;
		
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(this);
			
			bais = new ByteArrayInputStream(baos.toByteArray());
			ois = new ObjectInputStream(bais);
			Originator temp = (Originator)ois.readObject();
			memento = new Memento(temp);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(baos!=null) baos.close();
				if(bais!=null) bais.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return memento;
	}
	abstract void recover(Memento memento);
	
}
