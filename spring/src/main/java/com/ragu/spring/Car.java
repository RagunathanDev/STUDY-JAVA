package com.ragu.spring;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vechile {

	public void drive() {
		System.out.println("I will drive the car");
	}
}
