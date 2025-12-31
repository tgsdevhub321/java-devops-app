package com.travel.utility;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class CCEncryptDecrypt
{	
	public String getEncryotedCC(String plainText) throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException 
	{	
		DESKeySpec keySpec = new DESKeySpec("Your secret Key phrase".getBytes("UTF8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(keySpec);
		byte[] cleartext = plainText.getBytes("UTF8");      
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		String encrypedString = java.util.Base64.getMimeEncoder().encodeToString(cipher.doFinal(cleartext));
		System.out.println(" Encryped Values is :: " + encrypedString);
		String urlEncodeddata=URLEncoder.encode(encrypedString,"UTF-8");
		System.out.println(" URLEncodeddata Encryot :: " + urlEncodeddata);
        return urlEncodeddata;
	}
	
	public String getDecryptedCC(String encrypedString) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException 
	{	
		DESKeySpec keySpec = new DESKeySpec("Your secret Key phrase".getBytes("UTF8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(keySpec);
		
		//String urlDecodedData = URLDecoder.decode(encrypedString, "UTF-8");
		//byte[] encrypedStringBytes = java.util.Base64.getMimeDecoder().decode(urlDecodedData);
		
		byte[] encrypedStringBytes = java.util.Base64.getMimeDecoder().decode(encrypedString);
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] plainTextBytes = (cipher.doFinal(encrypedStringBytes));
		String value = new String(plainTextBytes);
        System.out.println("Decripted value : " + value);	
        String urlEncodeddata=URLEncoder.encode(value,"UTF-8");
		System.out.println(" URLEncodeddata Decrypted :: " + urlEncodeddata);
		return value;
	}
	
	/*public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException 
	{	
		CCEncryptDecrypt encrypter = new CCEncryptDecrypt();
    	String encrypted = encrypter.getEncryotedCC("67193");
    	System.out.println(" Encryped Values is :: "+encrypted);
		
		String decripted = encrypter.getDecryptedCC("Dgpi%2BTUijvc%3D");
    	System.out.println(" Decripted Values is :: "+decripted);
    	
    	 //sandy pwd is [ekYTCGoxcdQ=] 
	}*/
}
