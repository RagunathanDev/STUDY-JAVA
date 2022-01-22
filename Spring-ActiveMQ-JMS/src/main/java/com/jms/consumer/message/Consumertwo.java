package com.jms.consumer.message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumertwo {

	@JmsListener(destination = "standalone.queue")
	public void consumer(String message) {
		System.out.println("Second Consumer 2 : " + message);
	}
}
