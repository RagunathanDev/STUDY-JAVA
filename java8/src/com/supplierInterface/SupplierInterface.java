package com.supplierInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

public class SupplierInterface {
	public static void main(String[] args) {
		Supplier<String> supplier = () -> "No Args";

		// If list does not contain any value then return the orElseGet -> call supplier
		List<String> list = Arrays.asList();

		System.out.println(list.stream().findAny().orElseGet(supplier));
		System.out.println("ragu".charAt(3));
		int[] a = { 1, 2, 3, 4 };
		System.out.println(a[2]);

		String[] array = new String[] { "A", "B", "C" };
		List<String> list1 = Arrays.asList(array);
		List<String> list2 = new ArrayList<>(Arrays.asList(array));
		List<String> list3 = new ArrayList<>(Arrays.asList("A", new String("B"), "C"));
		System.out.print(list1.equals(list2));
		System.out.print(list1.equals(list3));

		HashMap<String, Integer> pantry = new HashMap<>();

		pantry.put("Apples", 3);
		pantry.put("Oranges", 2);

		int currentApples = pantry.get("Apples");
		pantry.put("Apples", currentApples + 4);

		pantry.entrySet().stream().forEach(t -> System.out.println(t));

		System.out.println(pantry.get("Apples"));

	}

}
