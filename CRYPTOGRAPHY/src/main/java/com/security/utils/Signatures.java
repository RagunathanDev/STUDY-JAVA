package com.security.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;

public class Signatures {
	public static void main(String[] args) {

		try {
			Signature signature = Signature.getInstance("SHA256WithDSA");
			SecureRandom secureRandom = new SecureRandom();

			KeyPairGenerator keyPairgen = KeyPairGenerator.getInstance("DSA");
			KeyPair keyPair = keyPairgen.genKeyPair();

			signature.initSign(keyPair.getPrivate(), secureRandom);

			byte[] data = "ragunathan".getBytes("UTF-8");

			signature.update(data);

			byte[] resultData = signature.sign();

			Signature signature2 = Signature.getInstance("SHA256WithDSA");

			signature2.initVerify(keyPair.getPublic());

			signature2.update(data);

			boolean verify = signature2.verify(resultData);

			System.out.println(verify);

		} catch (NoSuchAlgorithmException | InvalidKeyException | UnsupportedEncodingException | SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
