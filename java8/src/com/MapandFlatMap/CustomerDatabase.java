package com.MapandFlatMap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerDatabase {

	public static List<Customer> getCustomer() {
		return Stream
				.of(new Customer("Ragu", "ragu@gmail.com", Arrays.asList("2342432543254", "234234324")),
						new Customer("mass", "mass@gmail.com", Arrays.asList("546546435654", "435434354353")),
						new Customer("veru", "veru@gmail.com", Arrays.asList("43643565436", "4365464356546")),
						new Customer("manjh", "manjh@gmail.com", Arrays.asList("546546546754", "324234234234")),
						new Customer("eryter", "eryter@gmail.com", Arrays.asList("57654754435324", "2342432546546")))
				.collect(Collectors.toList());
	}
}
