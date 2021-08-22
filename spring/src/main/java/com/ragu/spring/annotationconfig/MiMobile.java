package com.ragu.spring.annotationconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MiMobile {

	@Autowired
	@Qualifier("snapdragon")
	private MobileProcessor cpu;

	public void Phone() {
		cpu.process();
	}
}
