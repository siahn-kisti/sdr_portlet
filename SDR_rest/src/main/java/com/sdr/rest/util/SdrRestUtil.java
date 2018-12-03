package com.sdr.rest.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Random;

public class SdrRestUtil {

	private final static String key = "sdr_rest_apikey";

	public static String getApiKey(String userId) {
		Random random = new Random();
		int r = random.nextInt();
		String text = userId+r;
		String result = null;

		try {
			result = SdrRestUtil.encryptAES(text, key);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public static String getSHA256(String text) throws Exception {
		StringBuffer result = new StringBuffer();

		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] bytes = digest.digest(text.getBytes(StandardCharsets.UTF_8));

		for (byte b : bytes)
			result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));

		return result.toString();
	}

	public static String decryptAES(String text, String key) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] keyBytes = new byte[16];
		byte[] b = key.getBytes("UTF-8");
		int len = b.length;
		if (len > keyBytes.length) len = keyBytes.length;
		System.arraycopy(b, 0, keyBytes, 0, len);
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
		cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

		BASE64Decoder decoder = new BASE64Decoder();
		byte[] results = cipher.doFinal(decoder.decodeBuffer(text));
		return new String(results, "UTF-8");
	}

	public static String encryptAES(String text, String key) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] keyBytes = new byte[16];
		byte[] b = key.getBytes("UTF-8");
		int len = b.length;
		if (len > keyBytes.length) len = keyBytes.length;
		System.arraycopy(b, 0, keyBytes, 0, len);
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

		byte[] results = cipher.doFinal(text.getBytes("UTF-8"));
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(results);
	}


	public static void main(String[] args) {

		try {

			System.out.println("getApiKey >> " + SdrRestUtil.getApiKey("test11"));

			//System.out.println("SHA-256 >> " + SdrRestUtil.getSHA256(text));
			//System.out.println("encryptAES >> " + SdrRestUtil.encryptAES(text, key));
			//System.out.println("decryptAES >> " + SdrRestUtil.decryptAES("70rUe4nayJ0AVErfWvjnJg==", "sdr_rest_apikey"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
