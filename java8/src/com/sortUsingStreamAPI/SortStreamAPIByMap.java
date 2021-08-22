package com.sortUsingStreamAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.FilterAndForeach.DatabaseService;
import com.FilterAndForeach.Employee;

public class SortStreamAPIByMap {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("five", 5);
		map.put("one", 1);
		map.put("nine", 9);
		map.put("Ten", 10);

		List<Entry<String, Integer>> entries = new ArrayList<Entry<String, Integer>>(map.entrySet());
		Collections.sort(entries, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {

				return o2.getKey().compareTo(o1.getKey());
			}
		});

		for (Entry<String, Integer> entrie : entries) {
			System.out.println(entrie);
		}

		System.out.println("Using StreamAPI to sort the map : \n");

		List<Entry<String, Integer>> out = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toList());
		System.out.println(out);

		System.out.println("If Map conatin Object as a key then how will itreate :");

		DatabaseService databseservice = new DatabaseService();
		Map<Employee, Integer> employeemap = databseservice.getEmployeesByMap();

		employeemap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName)))
				.forEach(System.out::println);
		;

	}

}
