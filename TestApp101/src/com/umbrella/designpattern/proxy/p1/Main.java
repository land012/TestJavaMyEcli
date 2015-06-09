package com.umbrella.designpattern.proxy.p1;

import java.lang.reflect.Proxy;

import com.umbrella.designpattern.proxy.p2.RailWayStation;
import com.umbrella.designpattern.proxy.p2.SellTicket;
import com.umbrella.designpattern.proxy.p2.SellTicketHandler;
/**
 * 
 * @author asdf
 * JDK 自带代理
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
