package com.main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {

	@RequestMapping("/")
	public String addController() {
		return "index.jsp";
	}

	@RequestMapping("/index.htm")
	public int addControllerHello() {
		return 45;
	}

}
