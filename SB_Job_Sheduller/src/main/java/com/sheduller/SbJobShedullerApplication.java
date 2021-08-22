package com.sheduller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SbJobShedullerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbJobShedullerApplication.class, args);
	}

}
