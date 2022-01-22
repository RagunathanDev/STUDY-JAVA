package com.set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

public class HashSetEx {

	public HashSetEx() {

	}

	public static void main(String[] args) {

		HashSet<String> hashSet = new HashSet<>();

		hashSet.add("ragu");
		hashSet.add("kannan");
		hashSet.add("sangili");
		hashSet.add("aaaa");
		System.out.println(hashSet);

		ArrayList<Integer> numberList = new ArrayList<>();

		numberList.add(11);
		numberList.add(30);
		numberList.add(35);
		numberList.add(40);
		numberList.add(34);

		HashSet<Integer> hashSet1 = new HashSet<>(numberList);

		System.out.println(hashSet1);

		TreeSet<Integer> treeSet = new TreeSet<>(numberList);

		System.out.println(treeSet);

		ArrayList<Integer> al = new ArrayList<>();
		int a[] = { 1, 2, 7, 4, 44, 55, 89, 5, 6, 5, 4, 3, 2, 1, 3 };
		for (int i = 0; i < a.length; i++) {
			al.add(a[i]);
		}
		System.out.println(al);

		HashSet<Integer> hs = new HashSet<>(al);
		HashSet<Integer> hs1 = new HashSet<>();
		hs1.add(45);
		System.out.println(hs);

		TreeMap<Integer, String> treeMap = new TreeMap<>();
		treeMap.put(45, "zragu");
		treeMap.put(12, "ragu");
		treeMap.put(1, "bragu");
		treeMap.put(67, "aragu");
		treeMap.put(67, "aragu");
		treeMap.put(67, null);
		treeMap.put(5, "ragu");
		System.out.println(treeMap);

		HashMap<Integer, String> hashMap = new HashMap<>();
		hashMap.put(45, "zragu");
		hashMap.put(12, "ragu");
		hashMap.put(1, "bragu");
		hashMap.put(67, "aragu");

		System.out.println(hashMap);
		System.out.println();

		for (Entry<Integer, String> s : hashMap.entrySet()) {

			if (s.getKey().equals(45))
				s.setValue(null);

		}

		System.out.println(hashMap);

		for (Entry<Integer, String> s : treeMap.entrySet()) {
			if (s.getKey().equals(45))
				s.setValue("ragu");
		}

		System.out.println("------------------");
		System.out.println(treeMap);
	}
}
