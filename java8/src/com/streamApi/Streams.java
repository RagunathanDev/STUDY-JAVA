package com.streamApi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Streams {

	static List<Integer> list = new ArrayList<Integer>();
	{
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(6);
	}

	public static void main(String[] args) {

		/*
		 * private static int sumStream(List<Integer> list) { return
		 * list.stream().filter(i -> i > 10).mapToInt(i -> i).sum(); }
		 */
		Streams stre = new Streams();
		List<LocalObject> ogj = new ArrayList<LocalObject>();
		ogj.add(stre.new LocalObject());
		ogj.stream().forEach(System.out::println);

	}

	class LocalObject implements Serializable {
		Map<Object, Object> map = new LinkedHashMap<Object, Object>();
	}
}
