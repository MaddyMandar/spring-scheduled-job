package com.darkseid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
public class ScheduledJobApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger( ScheduledJobApplication.class );

	public static void main(String[] args) {
		SpringApplication.run(ScheduledJobApplication.class, args);
	}


//	@Scheduled(fixedRate = 2000L )
//	void someJob(){
//		System.out.println("Now is " + new Date());
//	}

//	@Scheduled(initialDelay = 1000L,fixedDelay = 6000L)
//	void someJob(){
//		System.out.println("Now is " + new Date());
//
//	}

//	@Scheduled(initialDelay = 1000L,fixedDelayString = "${someJob.delay}" ) //start with 1 sec delay
//	void someJob(){
//		System.out.println("Now is " + new Date());
//
//	}

//	@Scheduled(cron = "*/5 */3 * * * *" ) // Job to run every 5 sec after every 2 min
//	void someJob(){
//		System.out.println("Now is " + new Date());
//
//	}

	@Scheduled(fixedRate = 1000L )
	void someJob() throws InterruptedException {
		LOGGER.info("Job 1: Now is " + new Date());
		Thread.sleep(1000L);
	}

	@Scheduled(fixedRate = 1000L )
	void someJob2(){
		LOGGER.info("Job 2: Now is " + new Date());
	}

}

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
class SchedulingConfiguration{


}