package com.FilterAndForeach;

import java.time.LocalDate;

public class Employee {

	private Long Id;
	private String name;
	private Long salary;
	private String position;
	private LocalDate dateOfJoining;

	public Employee(Long id, String name, Long salary, String position, LocalDate dateOfJoining) {
		super();
		Id = id;
		this.name = name;
		this.salary = salary;
		this.position = position;
		this.dateOfJoining = dateOfJoining;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", name=" + name + ", salary=" + salary + ", position=" + position
				+ ", dateOfJoining=" + dateOfJoining + "]";
	}

}
