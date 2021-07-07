package com.indigo.fashion;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;



//@Configuration
//@ComponentScan(basePackages = {"com.indigo.fashion.*"})
//@EnableAutoConfiguration
//@SpringBootApplication(scanBasePackages = {"com.indigo.fashion.*"},exclude = 
//{ SecurityAutoConfiguration.class })
//@SpringBootApplication(scanBasePackages = {"com.indigo.fashion.*"})
//package com.indigo.fashion;



@SpringBootApplication
public class DesignApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(DesignApplication.class);

	
	public static void main(String[] args) throws InterruptedException {

		ApplicationContext ctx = SpringApplication.run(DesignApplication.class, args);

		StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
//		Receiver receiverR = ctx.getBean(Receiver.class);
//
//		while (receiverR.getCount() == 0) {
//
//			LOGGER.info("Sending message...");
//			template.convertAndSend("chat", "Hello from Redis!");
//			Thread.sleep(500L);
//		}
//
//		System.exit(0);
	}
}