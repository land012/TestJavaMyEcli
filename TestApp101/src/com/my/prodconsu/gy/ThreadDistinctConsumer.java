package com.my.prodconsu.gy;

import org.apache.log4j.Logger;

import com.hispeed.producerConsumer.distinct.DistinctConsumer;

public class ThreadDistinctConsumer extends DistinctConsumer<String> {
	
	private Logger log = Logger.getLogger("logs");
	
	private static int count = 0;
	
	@Override
	public boolean consume(String arg0) {
		
		int lcount = inc();
		
		log.info("count=" + count);
		
		log.info("lcount=" + lcount + "," + lcount + "%3=" + lcount%3);
		if(lcount%3 == 0) {
			log.info(arg0 + "消费成功");
			return true;
		} else {
			log.info(arg0 + "消费失败");
			return false;
		}
		
	}

	@Override
	public String getObjectKeyId(String arg0) {
		return arg0;
	}
	
	private synchronized int inc() {
		return ++count;
	}

}
