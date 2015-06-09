package com.umbrella.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		
		ScheduledExecutorService exec = Executors.newScheduledThreadPool(2);
		exec.scheduleAtFixedRate(new Task(), 0, 5000, TimeUnit.MILLISECONDS);
	}

}
