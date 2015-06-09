package test.com.umbrella.produconsu;

import com.umbrella.produconsu.Box;
import com.umbrella.produconsu.Consumer;
import com.umbrella.produconsu.Producer;

public class ProducerConsumerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Box box = new Box();
		new Thread(new Producer(box)).start();
		new Thread(new Consumer(box)).start();
	}

}
