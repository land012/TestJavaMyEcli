package com.land.scheduler;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import com.land.job.HelloJob;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.CronScheduleBuilder.*;

public class HelloScheduler {
	public void run() {
		try {
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
			
			JobDetail job = newJob(HelloJob.class).withIdentity("j1", "g1").build();
			
			Trigger trigger = newTrigger().withIdentity("t1", "g1").
				withSchedule(cronSchedule("0/3 * * * * ?")).build();
			
			scheduler.scheduleJob(job, trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
