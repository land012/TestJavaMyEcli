package test.com.my.prodconsu.gy;

import org.junit.Test;

import com.hispeed.producerConsumer.distinct.DistinctProducerAndConsumer;
import com.hispeed.producerConsumer.nodistinct.NoDistinctProducerAndConsumer;
import com.my.prodconsu.gy.ThreadDistinctConsumer;
import com.my.prodconsu.gy.ThreadDistinctProducer;
import com.my.prodconsu.gy.ThreadNoDistinctConsumer;
import com.my.prodconsu.gy.ThreadNoDistinctProducer;

public class ProducerConsumerTest {
	
	public static void main(String[] args) {
		DistinctProducerAndConsumer<String> d = new DistinctProducerAndConsumer<String>();
		d.createDistinct(new String[]{ ThreadDistinctProducer.class.getName() },
				ThreadDistinctConsumer.class.getName(),
				10,
				50,
				false,
				10000,
				10000);
	}
	
	@Test
	public void testPC(){
		DistinctProducerAndConsumer<String> d = new DistinctProducerAndConsumer<String>();
		d.createDistinct(new String[]{ ThreadDistinctProducer.class.getName() },
				ThreadDistinctConsumer.class.getName(),
				10,
				50,
				false,
				1000,
				1000);
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testNoPC(){
		NoDistinctProducerAndConsumer<String> d = new NoDistinctProducerAndConsumer<String>();
		d.createNoDistinct(new String[]{ ThreadNoDistinctProducer.class.getName() },
				ThreadNoDistinctConsumer.class.getName(),
				1,
				1,
				false,
				1000,
				1000);
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
