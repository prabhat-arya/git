package com.arya;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;

public class EncryptionPwdUsingSHA256 {
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.reset();
		String pwd="prabhat";
		System.out.println("Original Pwd :: "+pwd);
		byte[] bPwd=pwd.getBytes();
		md.update(bPwd);
		byte[] digestPwd = md.digest();
		System.out.println("encrypted Pwd :: "+digestPwd);
		//But in the real time project dataBase is there in Remote location
		//so we have to sends the data through network
		//But all the characters of encrypted data may not compatable for network
		//for this we have to convert this encrypted data in to encoded data
		Encoder encoder = Base64.getEncoder();
		byte[] encodData = encoder.encode(digestPwd);
		String encryptedEncodeData=new String(encodData);
		System.out.println("Encrypted and Encoded Data ::"+encryptedEncodeData);
		
		//now we can store this encryptedEncodeData in database
		//this data is 
		  // non-readable 
		  // transferable 
		
		
	}

}
