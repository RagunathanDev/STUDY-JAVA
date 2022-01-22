package com.sortUsingStreamAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.FilterAndForeach.DatabaseService;
import com.FilterAndForeach.Employee;

public class SortSreamAPIByList {
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(100);
		list.add(5);
		list.add(89);
		list.add(50);

		System.out.println("List value : " + list);

		Collections.sort(list);
		System.out.println("After collections.sort() : " + list);

		Collections.reverse(list);
		System.out.println("After collections.reverse() : " + list);

		// Collections.reverseOrder();
		// System.out.println("After collections.reverseOrder() : " + list);

		System.out.println();
		System.out.println("********** Using Streams ******************\n");

		list = list.stream().sorted().collect(Collectors.toList());
		System.out.println("After stream().sorted().collect(Collectors.toList()) : " + list);

		list = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("After stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()) : " + list);

		DatabaseService database = new DatabaseService();

		List<Employee> employee = database.getEmployees();
		// Sort perform against some employee obj

		System.out.println("Before perform sort in Employee obj" + employee);

		Collections.sort(employee, new SortComprator());
		System.out.println("After perform sort in Employee obj" + employee);

		Collections.sort(employee, new ReverseSort());
		System.out.println("After perform sort in Employee obj" + employee);

		System.out.println();
		System.out.println("************ Using Streams and lambda functionInter **************\n");

		Collections.sort(employee, (item1, item2) -> (int) (item1.getSalary() - item2.getSalary()));
		System.out.println("After perform sort in Employee obj using Lambda : " + employee + "\n");

		employee = employee.stream().sorted((t1, t2) -> (int) (t1.getSalary() - t2.getSalary()))
				.collect(Collectors.toList());

		System.out.println("After perform sort in Employee obj using Lambda & StreamAPI : " + employee + "\n");

		employee = employee.stream().sorted(Comparator.comparing(emp -> emp.getSalary())).collect(Collectors.toList());
		System.out.println(
				"After perform sort in Employee obj using Lambda & StreamAPI & Comparing : " + employee + "\n");

		employee = employee.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
		System.out.println(
				"After perform sort in Employee obj using Lambda & StreamAPI & Comparing using Method Reference : "
						+ employee);

		System.out.println();
		employee.stream().filter(emp -> emp.getName().equals("ragu") || emp.getName().equals("manu")).forEach(emp -> {

			System.out.println(emp);

			emp.setSalary(emp.getSalary() + 400000L);

			System.out.println(emp);
		});

	}

}

//class

final class SortComprator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return (int) (o1.getSalary() - o2.getSalary());
	}

}

final class ReverseSort implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return (int) (o2.getSalary() - o1.getSalary());
	}
}
