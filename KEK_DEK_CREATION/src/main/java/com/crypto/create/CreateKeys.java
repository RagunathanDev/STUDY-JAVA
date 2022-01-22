package com.crypto.create;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;

public class CreateKeys {

	private KeyStore keyStore;

	// Alaise name
	final private String AliaseName = "Key_123";

	public static void main(String[] args) {

		String kek_file_path = null;
		String dek_file_path = null;
		KeyStore keyStore = null;

		try {

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void createKeyStore(String keyStoreType, String keyStoreFilePath, String password) {
		File file = null;
		char[] pass = null;
		try {

			keyStore = KeyStore.getInstance(keyStoreType);
			file = new File(keyStoreFilePath);
			pass = password.toCharArray();

			if (!file.exists()) {
				file.createNewFile();
				keyStore.load(null, pass);
			} else {
				InputStream in = new FileInputStream(file);
				keyStore.load(in, pass);
			}

		} catch (Exception e) {
			System.out.printf("Exception occured createKeyStore ::", e);
		} finally {
			file = null;
			pass = null;
		}

	}

}
