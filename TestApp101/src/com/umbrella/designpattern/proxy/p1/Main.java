package com.umbrella.designpattern.proxy.p1;

import java.lang.reflect.Proxy;

import com.umbrella.designpattern.proxy.p2.RailWayStation;
import com.umbrella.designpattern.proxy.p2.SellTicket;
import com.umbrella.designpattern.proxy.p2.SellTicketHandler;
/**
 * 
 * @author asdf
 * JDK �Դ�����
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SellTicketHandler stHandler = new SellTicketHandler(new RailWayStation());
		SellTicket st = (SellTicket)Proxy.newProxyInstance(SellTicket.class.getClassLoader(),
				RailWayStation.class.getInterfaces(),
				stHandler);
		st.sellTicket(100);
	}

}
