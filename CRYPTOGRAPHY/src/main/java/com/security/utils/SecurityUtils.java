package com.security.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class SecurityUtils {

	public static void main(String[] args) {
		// Security.addProvider(new )

		try {

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			byte[] data = new byte[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
			SecretKeySpec key = new SecretKeySpec(data, "RawBytes");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] plainText = "ragunathan".getBytes();
			byte[] cypherText = cipher.doFinal(plainText);
			System.out.println(cypherText);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
