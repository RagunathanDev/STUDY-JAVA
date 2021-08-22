package com.ragu.spring.annotationconfig;

import org.springframework.stereotype.Component;

@Component

public class Mediatech implements MobileProcessor {

	public void process() {
		System.out.println("Media tech");
	}

}
