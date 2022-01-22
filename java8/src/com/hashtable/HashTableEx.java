package com.hashtable;

import java.util.Hashtable;

public class HashTableEx {
	public static void main(String[] args) {

		Hashtable<String, Integer> table = new Hashtable<>();
		table.put("ragu", 1);
		table.put("ragu", 1);

		table.put("ugar", 2);

		System.out.println(table);

	}

}
