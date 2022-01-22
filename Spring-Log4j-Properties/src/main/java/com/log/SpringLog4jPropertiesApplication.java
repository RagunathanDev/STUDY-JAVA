package com.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLog4jPropertiesApplication {

	final static private Logger log = LoggerFactory.getLogger(SpringLog4jPropertiesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLog4jPropertiesApplication.class, args);
		for (int i = 0; i < 200; i++) {
			log.debug("App debug");

			log.info("App info");

			log.trace("App Trace");
			log.trace(
					"With this we have successfully setup File Appender and Rolling File Appender using Log4J2. This makes our logging setup even more robust and makes it easy to manage the logs our application will generate.");
		}
		try {
			int a = 1 / 0;
		} catch (Exception e) {
			log.error("Exception", e);
		}
	}

}
