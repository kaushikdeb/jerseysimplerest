package org.secureworks.pe.jerseysimplerest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class TextToHash {
	
	public static String getMd5forText(String text) {
    	return getHashforText(text, "MD5");
    }
	
	public static String getShaforText(String text) {
    	return getHashforText(text, "SHA");
    }
	
	private static String getHashforText(String text, String hashingAlgorithm) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(hashingAlgorithm);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        md.update(text.getBytes());
        byte[] digest = md.digest();
		String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		return myHash;
	}
}
