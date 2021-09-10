
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

import javax.crypto.Cipher;

//import org.bouncycastle.jce.provider.BouncyCastleProvider;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class KVBBANKSUN {

	private static final String RSA_PADDING_STANDARD = "RSA/ECB/OAEPWithSHA1AndMGF1Padding";
	private static String RSA_KEY_FACTORY_INSTANCE = "RSA";

	// private static String PRIVATE_KEY_HEADER = "-----BEGIN PUBLIC KEY-----\r\n" ;
	// private static String PRIVATE_KEY_FOOTER = "-----END PUBLIC KEY-----" ;

	// FSS Team Suggested changes starts
	private static String PRIVATE_KEY_HEADER = "-----BEGIN PUBLIC KEY-----";
	private static String PRIVATE_KEY_FOOTER = "-----END PUBLIC KEY-----";
	// FSS Team Suggested changes Ends

	public static String encrypt(String plainData, String filename) {

		try {
			byte[] cipherData = blockDeCipher(plainData.getBytes(), filename);
			// byte[] encodedBytes = Base64.encodeBase64(cipherData);
			BASE64Encoder l_base64encoder = new sun.misc.BASE64Encoder();
			byte[] encodedBytes = l_base64encoder.encode(cipherData).getBytes();
			return new String(encodedBytes, "UTF-8");

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static String decrypt(String encryptedData, String keyFilePath) {

		try {
			BASE64Decoder l_base64decoder = new sun.misc.BASE64Decoder();
			byte[] decodedBytes = l_base64decoder.decodeBuffer(encryptedData);
			byte[] plainData = blockDeCipherDeCrypt(decodedBytes, keyFilePath);
			return new String(plainData, "UTF-8");

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	private static byte[] blockDeCipherDeCrypt(byte[] bytes, String pemFileName) {

		try {
			Cipher decipher = Cipher.getInstance(RSA_PADDING_STANDARD);
			decipher.init(Cipher.DECRYPT_MODE, getPemPrivateKey(pemFileName));
			byte[] scrambled = new byte[0];
			byte[] toReturn = new byte[0];
			int length = 256;
			byte[] buffer = new byte[length];
			for (int counter = 0; counter < bytes.length; counter++) {

				if ((counter > 0) && (counter % length == 0)) {

					scrambled = decipher.doFinal(buffer);
					toReturn = append(toReturn, scrambled);
					int newlength = length;
					if (counter + length > bytes.length) {
						newlength = bytes.length - counter;
					}
					buffer = new byte[newlength];
				}
				buffer[counter % length] = bytes[counter];
			}
			scrambled = decipher.doFinal(buffer);
			toReturn = append(toReturn, scrambled);
			return trim(toReturn);
		} catch (Exception e) {

			return null;
		}

	}

	/*
	 * public static PrivateKey get() { KeyStoreManager dek_ksm =
	 * KeyStoreManager.getInstance("","",""); Key sc = dek_ksm.getKey("" ,"");
	 * PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec (sc.getEncoded());
	 * KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_FACTORY_INSTANCE);
	 * PrivateKey key = keyFactory.generatePrivate(spec); return key;
	 * 
	 * }
	 */
	private static byte[] blockDeCipher(byte[] bytes, String pemFileName) {

		try {
			// Security.addProvider(new BouncyCastleProvider());
			Cipher decipher = Cipher.getInstance(RSA_PADDING_STANDARD);
			decipher.init(Cipher.ENCRYPT_MODE, getPemPrivateKey(pemFileName));
			byte[] scrambled = new byte[0];
			byte[] toReturn = new byte[0];
			int length = 128;
			byte[] buffer = new byte[length];
			for (int counter = 0; counter < bytes.length; counter++) {

				if ((counter > 0) && (counter % length == 0)) {

					scrambled = decipher.doFinal(buffer);
					toReturn = append(toReturn, scrambled);
					int newlength = length;
					if (counter + length > bytes.length) {
						newlength = bytes.length - counter;
					}
					buffer = new byte[newlength];
				}
				buffer[counter % length] = bytes[counter];
			}
			scrambled = decipher.doFinal(buffer);
			toReturn = append(toReturn, scrambled);
			return trim(toReturn);
		} catch (Exception e) {

			return null;
		}

	}

	private static PublicKey getPemPrivateKey(String filename) throws IOException {

		FileInputStream fileInputStream = null;
		DataInputStream dataInputStream = null;
		try {

			File file = new File(filename);
			fileInputStream = new FileInputStream(file);
			dataInputStream = new DataInputStream(fileInputStream);

			byte[] keyBytes = new byte[(int) file.length()];
			dataInputStream.readFully(keyBytes);
			String privateKeyPEM = new String(keyBytes);
			// FSS Team Suggested changes starts
			// privateKeyPEM = privateKeyPEM.replace(PRIVATE_KEY_HEADER, "");
			// privateKeyPEM = privateKeyPEM.replace(PRIVATE_KEY_FOOTER, "");
			privateKeyPEM = privateKeyPEM.replace(PRIVATE_KEY_HEADER, "").replaceFirst(System.lineSeparator(), "")
					.replace(PRIVATE_KEY_FOOTER, "");
			// FSS Team Suggested changes ends

			System.out.println("KEY :" + privateKeyPEM);
			// byte[] decoded = Base64.decodeBase64(privateKeyPEM);
			BASE64Decoder l_base64decoder = new sun.misc.BASE64Decoder();
			byte[] decoded = l_base64decoder.decodeBuffer(privateKeyPEM);

			X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);
			KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_FACTORY_INSTANCE);
			return keyFactory.generatePublic(spec);

		} catch (Exception e) {
			return null;
		} finally {
			dataInputStream.close();
		}

	}

	private static byte[] append(byte[] prefix, byte[] suffix) {

		byte[] toReturn = new byte[prefix.length + suffix.length];

		for (int counter = 0; counter < prefix.length; counter++) {

			toReturn[counter] = prefix[counter];
		}
		for (int counter = 0; counter < suffix.length; counter++) {

			toReturn[counter + prefix.length] = suffix[counter];
		}

		return toReturn;
	}

	private static byte[] trim(byte[] original) {

		int length = original.length - 1;
		while (length >= 0 && original[length] == 0) {
			length--;
		}
		return Arrays.copyOf(original, length + 1);
	}

	public static void main(String[] args) {
		String encryptedData = "GHxm6WsrWlbqB43qa3tE2sIixdx6s+0qfpOKAph/sUI9ZCp7gNNVmt4xmVj69lhkuyurTvK4hjQUSuZWBVV2phcS9HMHmP3rgqJBeih6OdscUIeRLFdsQUPPW9UW6kTFj98Q26c2JHDOMbBl296CZziJW06Ss22gOK6Nt0xwYHncbdlVfrUDhO/7UG5IBVLaWyOkntadtdYnPd0lchPEhvTP4ciIrLnhoqmQa25UZfeB34qFgA663Zt8G6Rj81kkCm0L/E3fUC/Ju7XLXUXBCVgILYFd8OoNzw5bPABXY/GWDX+etkdGcwbmXtLvVAlXd5KoORWgltZftf7YPZpw3w==";
		String result = decrypt(encryptedData, "E://53_publicKey.pem");
		System.out.println("Decrpt Token :: " + result);
	}

}
