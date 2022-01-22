package com.ford;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BusBookingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusBookingSystemApplication.class, args);
	}

}
