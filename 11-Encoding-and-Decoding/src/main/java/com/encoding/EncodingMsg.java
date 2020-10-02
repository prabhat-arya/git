package com.encoding;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class EncodingMsg {
	
	public static void main(String[] args) {
		String encodeMsg = encodeMsg("Prahat Kumar");
		System.out.println(encodeMsg);
		System.out.println("\nAfter Decoding this encoded message\n");
		String decodeMsg = decodeMsg(encodeMsg);
		System.out.println(decodeMsg);
	}
	
	
	public static String encodeMsg(String msg) {
		
		Encoder encoder = Base64.getEncoder();
		String encodeMsg = encoder.encodeToString(msg.getBytes());
		return encodeMsg;
		
	}
	
	public static String decodeMsg(String encodeMsg) {
		Decoder decoder = Base64.getDecoder();
		byte[] decodeMsg = decoder.decode(encodeMsg);
		String decodeStringMsg= new String(decodeMsg);
		return decodeStringMsg;
	}

}
