package com.umbrella.main;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import com.umbrella.rmi.IHello;
import com.umbrella.rmi.impl.HelloImpl;
/**
 * RMI Remote Method Invocation 服务端
 * @author asdf
 * 服务端才有具体的实现
 *
 */
public class HelloServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			IHello rhello = new HelloImpl();
			LocateRegistry.createRegistry(8888);
			Naming.bind("rmi://localhost:8888/RHello", rhello);
			System.out.println(">>>>> 远程 IHello 对象绑定成功！");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}

}
