package com.MapandFlatMap;

import java.util.List;
import java.util.stream.Collectors;

public class MapAndFlatMapEx {
	public static void main(String[] args) {

		// Map Vs FlatMap

		List<Customer> customers = CustomerDatabase.getCustomer();

		// Map has been one-to-one relationship
		// Accept Stream of value and (Data transformed) return another stream of value.
		// List<Customer> converted into List<String>
		List<String> email = customers.stream().map(customer -> customer.getEmail()).collect(Collectors.toList());
		System.out.println(email);

		// List<Customer -> customer.getPhoneNumber -> one-to-many mapping
		// Return List<List<String>> so we get non-faltered structured data
		List<List<String>> phone = customers.stream().map(customer -> customer.getPhoneNumber())
				.collect(Collectors.toList());
		System.out.println(phone);

		// We can use faltered structured data to one data as input but inside many
		// value we can perform with flatMap
		// flatMap accept data as Stream<Stream<T>> and return as Stream<R>
		// Accept Stream of stream data and return the stream of data.
		List<String> phoneFlutredStructure = customers.stream().flatMap(customer -> customer.getPhoneNumber().stream())
				.collect(Collectors.toList());
		System.out.println(phoneFlutredStructure);

		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				continue;
			}
			System.out.println(i);
		}

	}
}
