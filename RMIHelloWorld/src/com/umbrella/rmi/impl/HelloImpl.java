package com.umbrella.rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.umbrella.rmi.IHello;

public class HelloImpl extends UnicastRemoteObject implements IHello {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HelloImpl() throws RemoteException {
		super();
	}

	public String helloworld() throws RemoteException {
		return "Hellow World!";
	}

	public String sayToSomebody(String name) throws RemoteException {
		return "Hello " + name + "!";
	}

}
