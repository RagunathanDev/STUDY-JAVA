package com.security.utils;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class KeyPairGenerate {

	public static void main(String[] args) {

		KeyPairGenerator keyPair;
		try {
			keyPair = KeyPairGenerator.getInstance("DSA");
			System.out.println(keyPair.generateKeyPair());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
