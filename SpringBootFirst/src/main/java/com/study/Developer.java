package com.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Developer {
	private String name;
	private String dest;
	@Autowired
	private Laptop laptop;

	public Developer() {
		System.out.println("Object created....");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public void display() {
		System.out.println("Display the role");
		laptop.laptopIn();
	}
}
