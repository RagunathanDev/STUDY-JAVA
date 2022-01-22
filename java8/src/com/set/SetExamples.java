package com.set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExamples extends HashSet<String> {

	static HashMap<String, Object> map = new HashMap<>();

	public static void main(String[] args) {

		SetExamples set = new SetExamples();

		boolean a1 = set.add("ragu");
		boolean a2 = set.add("sangili");

		boolean a3 = set.add("ragu");
		set.add(null);

		set.add(null);
		set.add(null);
		boolean a4 = set.add(null);
		System.out.println(a1 + " " + a2 + " " + a3 + " " + a4);

		System.out.println(map.entrySet());
		Set<String> linkedSet = new LinkedHashSet<>();

		Set<String> treeSet = new TreeSet<>();

		Hashtable<String, String> table = new Hashtable<>();
		table.put("ragu", "ragu");
		table.put("sanglili", "ragu");

		table.put("ragu3", "ragu");
		table.put("ragu4", "ragu");
		table.put("ragu5", "ragu");
		System.out.println(table);

		System.out.println(Math.min(0.75, 2147483639));

	}

	@Override
	public boolean add(String e) {
		System.out.println("Calling :: " + e);
		// System.out.println(map.put(e, "ragu"));
		return map.put(e, "ragu") == null;
	}

}
