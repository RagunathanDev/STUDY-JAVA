package com.FilterAndForeach;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DatabaseService {

	// static List<Employee> list = new ArrayList<Employee>();

	public List<Employee> getEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(16533L, "ragu", 200000L, "Software Engineer", LocalDate.of(1997, 07, 11)));
		list.add(new Employee(16532L, "manu", 800000L, "Testing Engineer", LocalDate.of(1965, 07, 11)));
		list.add(new Employee(16537L, "janu", 300000L, "Marketing Engineer", LocalDate.of(1943, 07, 11)));
		list.add(new Employee(16535L, "cano", 900000L, "Support Engineer", LocalDate.of(1954, 07, 11)));
		list.add(new Employee(16538L, "vilo", 1200000L, "Databse Engineer", LocalDate.of(1964, 07, 11)));
		return list;
	}

	public Map<Employee, Integer> getEmployeesByMap() {
		Map<Employee, Integer> map = new TreeMap<>();
		map.put(new Employee(16533L, "ragu", 200000L, "Software Engineer", LocalDate.of(1997, 07, 11)), 10);
		map.put(new Employee(16532L, "manu", 800000L, "Testing Engineer", LocalDate.of(1965, 07, 11)), 40);
		map.put(new Employee(16537L, "janu", 300000L, "Marketing Engineer", LocalDate.of(1943, 07, 11)), 90);
		map.put(new Employee(16535L, "cano", 900000L, "Support Engineer", LocalDate.of(1954, 07, 11)), 53);
		map.put(new Employee(16538L, "vilo", 1200000L, "Databse Engineer", LocalDate.of(1964, 07, 11)), 87);
		return map;
	}
}
