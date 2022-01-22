package com.technical;

public class ArmStrongNUmber {

	public static void main(String[] args) {
		String a = "153";

		a.chars().mapToObj(x -> Integer.toString(x)).forEach(System.out::println);

	}
}
