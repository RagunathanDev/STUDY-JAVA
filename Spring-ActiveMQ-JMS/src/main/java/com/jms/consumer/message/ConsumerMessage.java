package com.jms.consumer.message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerMessage {

	@JmsListener(destination = "standalone.queue")
	public void consumer(String message) {
		System.out.println("Consumer 1 :: " + message);
	}

}
