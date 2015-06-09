package com.umbrella.produconsu2;

import org.apache.log4j.Logger;

public class MyConsumer extends Consumer<String> {
	
	private static Logger log = Logger.getLogger(MyConsumer.class);

	@Override
	public void consume(String t) {
		log.info(Thread.currentThread().getName() + " ฯ๛ทัมหฃบ" + t);
	}

}
