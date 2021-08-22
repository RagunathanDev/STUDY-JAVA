package com.study;

import org.springframework.stereotype.Component;

@Component(value = "lap1")
public class Laptop {
	private String brandname;
	private String price;

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void laptopIn() {
		System.out.println("Laptop initiated...");
	}

}
