package com.springMVC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan({ "com.springMVC" })
@EnableWebMvc
public class Config {

	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver ir = new InternalResourceViewResolver();
		ir.setPrefix("/WEB-INF/jsp/");
		ir.setSuffix(".jsp");

		return ir;

	}

}
