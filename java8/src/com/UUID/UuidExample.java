package com.UUID;

import java.util.UUID;

public class UuidExample {

	public static void main(String[] args) {
		UUID uuid = new UUID(0, 1000);
		System.out.println(uuid);

		UUID randomUUID = UUID.randomUUID();
		System.out.println(randomUUID);
		System.out.println("Varient :" + randomUUID.variant());
		System.out.println("Varient :" + randomUUID.version());

	}
}
