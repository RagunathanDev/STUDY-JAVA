package com.study;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootApacheCamelApplication extends RouteBuilder {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApacheCamelApplication.class, args);
	}

	@Override
	public void configure() throws Exception {
		System.out.println("Started ......");
		// transferFile();
		transferSpecificFile("data");
		transferSpecificFileWithContent("Hello");
		System.out.println("End.....");
	}

	public void transferFile() {
		from("file:C:\\Users\\training5\\Desktop\\a?noop=true").to("file:C:\\Users\\training5\\Desktop\\b");
	}

	// header
	// body -> we also specify the inside file content based transfer
	public void transferSpecificFile(String fileName) {
		from("file:C:\\Users\\training5\\Desktop\\a?noop=true").filter(header(Exchange.FILE_NAME).startsWith(fileName))
				.to("file:C:\\Users\\training5\\Desktop\\b");
	}

	public void transferSpecificFileWithContent(String content) {
		from("file:C:\\Users\\training5\\Desktop\\a?noop=true").filter(body().startsWith(content))
				.to("file:C:\\Users\\training5\\Desktop\\b");
	}
}
