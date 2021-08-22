package com.FilterAndForeach;

import java.util.List;

public class FilterAndforEach {

	public static void main(String[] args) {
		DatabaseService databaseService = new DatabaseService();
		List<Employee> list = databaseService.getEmployees();

		// Traditional approach for iteration
		System.out.println("Traditional For loop over list ");

		for (Employee E : list) {
			System.out.println(E);
		}
		System.out.println();

		System.out.println("Using stream to iterate list ");
		// JAVA - 8 forEach
		list.stream().forEach(t -> System.out.println(t));
		System.out.println();

		System.out.println("Using filter to achive the specific value iteration filter & forEach : ");
		// Using filter to achieve the specify condition
		list.stream().filter(t -> t.getSalary() > 500000).forEach(t -> System.out.println(t));

	}
}
