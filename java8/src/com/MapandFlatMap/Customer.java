package com.MapandFlatMap;

import java.util.List;

public class Customer {

	private String name;
	private String email;
	private List<String> phoneNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(List<String> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Customer(String name, String email, List<String> list) {
		super();
		this.name = name;
		this.email = email;
		this.setPhoneNumber(list);
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}

}
