package com.utils;

import java.util.ArrayList;
import java.util.List;

public class SteamsEx {

	public static void main(String[] args) {
		List<LocalObject> list = new ArrayList<>();
		list.stream().forEach(System.out::println);
	}

}
