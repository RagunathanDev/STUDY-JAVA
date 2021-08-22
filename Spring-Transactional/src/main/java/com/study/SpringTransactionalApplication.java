package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringTransactionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTransactionalApplication.class, args);
	}

}
