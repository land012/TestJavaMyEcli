package com.umbrella.designpattern.proxy.p2;


public class RailWayStation implements SellTicket {

	@Override
	public void sellTicket(double money) {
		System.out.println("��վ�ۼۣ�" + money);
	}

}
