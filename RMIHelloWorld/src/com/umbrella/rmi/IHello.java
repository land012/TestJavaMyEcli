package com.umbrella.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * RMI Զ�̷�������
 * @author asdf
 *
 */
public interface IHello extends Remote {
	public String helloworld() throws RemoteException;
	
	public String sayToSomebody(String name) throws RemoteException;
}
