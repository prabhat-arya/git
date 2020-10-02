package com.arya;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionDecryptionUsingAES {
	private static final String SECRETE_KEY = "amdjyhfrnchtwiut";
	private static final String INIT_VECTOR = "akjdfjghrytecmnf";

	public static String encrytPwd(String pwd) throws Exception {
		IvParameterSpec ivParameterSpec = new IvParameterSpec(INIT_VECTOR.getBytes());
		SecretKeySpec secretKeySpec = new SecretKeySpec(SECRETE_KEY.getBytes("UTF-8"), "AES");
		
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		cipher.init(cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
		byte[] encryptedPwd = cipher.doFinal(pwd.getBytes());
		System.out.println("Original password :: "+pwd);
		System.out.println("Encrypted passwor :: " + new String(encryptedPwd));
		String encodeEncryptedPwd = Base64.getEncoder().encodeToString(encryptedPwd);
		System.out.println("Encode and Encrypted password :: " + encodeEncryptedPwd);
		return encodeEncryptedPwd;
	}
	public static void deCryptePwd(String encodeEncryptedPwd) throws Exception  {
		IvParameterSpec ivParameterSpec = new IvParameterSpec(INIT_VECTOR.getBytes());
		SecretKeySpec secretKeySpec = new SecretKeySpec(SECRETE_KEY.getBytes("UTF-8"), "AES");
		
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		cipher.init(cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
		
		byte[] decodePwd= Base64.getDecoder().decode(encodeEncryptedPwd);
		System.out.println("Decode and Encrypted Password :: "+decodePwd);
		
		byte[] decryptedPwd = cipher.doFinal(decodePwd);
		
		System.out.println("De-crypted Password :: "+new String(decryptedPwd));
		
	}
	public static void main(String[] args) throws Exception {
		String encrytPwd = encrytPwd("prabhat");
		deCryptePwd(encrytPwd);
	}

}
