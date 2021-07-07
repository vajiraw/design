package com.indigo.fashion.config;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


public class Receiver implements iReceiver {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
	private AtomicInteger counter = new AtomicInteger();
	
	public void receiveMessage(String message) {
        LOGGER.info("Received <" + message + ">");
        counter.incrementAndGet();
    }

    public int getCount() {    	
//    	LOGGER.debug(msg);
//    	//Consumer<String> c = System.out::println;
//    	Runnable r = () -> System.out.println();
        return counter.get();
    }

}
