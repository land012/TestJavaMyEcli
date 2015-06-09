package com.my.thread;

import java.util.ArrayList;
import java.util.List;

import com.hispeed.producerConsumer.nodistinct.NoDistinctProducer;
import com.my.vo.Human;

public class ThreadNoDistinctProducer extends NoDistinctProducer<Human> {
	
	private static int count = 0;

	@Override
	public String getObjectKeyId(Human human) {
		return human.getId();
	}

	@Override
	public List<Human> getProducts() {
		count++;
		
		List<Human> list = new ArrayList<Human>();
//		for(int i=0; i<10; i++) {
//			list.add(String.valueOf(i));
//		}
		
//		if(count == 1) {
//			Human h1 = new Human();
//			h1.setId("r1-" + count);
//			list.add(h1);
//			
//			Human h2 = new Human();
//			h2.setId("r2-" + count);
//			list.add(h2);
//		}
		
		Human h1 = new Human();
		h1.setId("r1");
		list.add(h1);
		
		Human h2 = new Human();
		h2.setId("r2");
		list.add(h2);
		
		return list;
	}

}
