package test.com.umbrella.threadpool2;

import org.apache.log4j.Logger;

import com.umbrella.threadpool2.Task;

public class MyTask extends Task {
	
	private static final Logger log = Logger.getLogger(MyTask.class);

	@Override
	public boolean isExecuteImmediate() {
		return false;
	}

	@Override
	public String info() {
		return null;
	}

	@Override
	public boolean exec() {
		log.info("MyTask");
		return false;
	}

}
