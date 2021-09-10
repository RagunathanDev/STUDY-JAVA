package com.jenkin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJenkinsApplication {

	public static final Logger log = LoggerFactory.getLogger(SpringJenkinsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringJenkinsApplication.class, args);
		log.info("Application Started....");
	}

}
