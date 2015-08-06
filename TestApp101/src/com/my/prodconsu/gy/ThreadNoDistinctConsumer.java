package com.my.prodconsu.gy;

import org.apache.log4j.Logger;

import com.hispeed.producerConsumer.nodistinct.NoDistinctConsumer;
import com.umbrella.vo.Human;

public class ThreadNoDistinctConsumer extends NoDistinctConsumer<Human> {
	
	private Logger log = Logger.getLogger("logs");
	
	private static int count = 0;

	@Override
	public boolean consume(Human human) {
		
		int lcount = inc();
		
		if(lcount%3==0) {
			log.info(human.getId() + "消费成功");
			return true;
		} else {
			log.info(human.getId() + "消费失败");
			return false;
		}
	}

	@Override
	public String getObjectKeyId(Human human) {
		return human.getId();
	}
	
	private synchronized int inc() {
		return ++count;
	}
	
}
