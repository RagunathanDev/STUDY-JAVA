package com.concurrent;

import java.util.concurrent.ConcurrentHashMap;

import com.set.HashSetEx;

public class ConcurrentHashMapEX {
	public static void main(String[] args) {

		HashSetEx sample = new HashSetEx();
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
		map.put("name", "ragu");
		map.put("name1", "kannan");
		map.put("name2", "Sangili");
		map.put("name", "ragu");
		map.put("name", "ragu");

	}

}
