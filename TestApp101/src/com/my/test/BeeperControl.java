package com.my.test;
import static java.util.concurrent.TimeUnit.*;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import org.junit.Test;

public class BeeperControl {
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	public void beepForAnHour() {
		/*
		 * �����ڲ���
		 * ������Բ�ʹ�� final
		 */
		final Runnable beeper = new Runnable() {
			public void run() {
				System.out.println("beep");
			}
		};
		/*
		 * �������ʹ�� final
		 */
		final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 0, 2, SECONDS);
		// ȡ����ʱ����
		scheduler.schedule(new Runnable() {
			public void run() {
				beeperHandle.cancel(true);
				System.out.println("End It!");
			}
		}, 10, SECONDS);
	}
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BeeperControl bc = new BeeperControl();
		bc.beepForAnHour();
	}

}
