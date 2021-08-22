package com.ragu.spring.annotationconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);

		MiMobile obj = (MiMobile) factory.getBean(MiMobile.class);
		obj.Phone();
	}

}
