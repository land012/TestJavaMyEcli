package com.umbrella.main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.Test;

import com.umbrella.rmi.IHello;
/**
 * RMI 客户端
 * @author asdf
 * 客户端只有接口
 *
 */
public class HelloClient {
	@Test
	public void testRmi() {
		try {
			IHello rhello = (IHello)Naming.lookup("rmi://localhost:8888/RHello");
			System.out.println(rhello.helloworld());
			System.out.println(rhello.sayToSomebody("Li"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
