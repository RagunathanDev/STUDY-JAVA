package com.ragu.spring.annotationconfig;

import org.springframework.stereotype.Component;

@Component
class Snapdragon implements MobileProcessor {

	public void process() {
		System.out.println("Snapdragon Processor");
	}

}
