package com.predicateinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateEx implements Predicate<Object> {

	public static void main(String[] args) {

		Predicate<Integer> predicate = (t) -> t % 2 == 0;

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// Print the Even numbers using predicate , stream,filter
		list.stream().filter(predicate).forEach(t -> System.out.println("Mod of 2:" + t));

		list.stream().filter(t -> t % 3 == 0).forEach(t -> System.out.println("Mod of 3 :" + t));
	}

	@Override
	public boolean test(Object t) {
		// TODO Auto-generated method stub
		return false;
	}
}
