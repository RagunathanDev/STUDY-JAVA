package com.home.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.core.annotation.Order;

@Entity
@Order
public class User {

	@Id
	private int Id;

	private String name;
	private String email;
	private String password;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
