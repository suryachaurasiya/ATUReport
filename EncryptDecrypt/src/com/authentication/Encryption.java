package com.authentication;

import java.security.AlgorithmParameters;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
public class Encryption {
public String encrypt(String word) throws Exception {
    byte[] ivBytes;
    String password="!@#$%^&***&^%$%^&^^^RrtfdfgEDFGFDFF"; 
/*you can give whatever you want for password. This is for testing purpose*/
    SecureRandom random = new SecureRandom();
    byte bytes[] = new byte[20];
    random.nextBytes(bytes);
    byte[] saltBytes = bytes;
    // Derive the key
   SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    PBEKeySpec spec = new PBEKeySpec(password.toCharArray(),saltBytes,65556,256);
     SecretKey secretKey = factory.generateSecret(spec);
    SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), "AES");
     //encrypting the word
     Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
     cipher.init(Cipher.ENCRYPT_MODE, secret);
     AlgorithmParameters params = cipher.getParameters();
     ivBytes =   params.getParameterSpec(IvParameterSpec.class).getIV();
     byte[] encryptedTextBytes = cipher.doFinal(word.getBytes("UTF-8"));
     //prepend salt and vi
      byte[] buffer = new byte[saltBytes.length + ivBytes.length + encryptedTextBytes.length];
      System.arraycopy(saltBytes, 0, buffer, 0, saltBytes.length);
      System.arraycopy(ivBytes, 0, buffer, saltBytes.length, ivBytes.length);
       System.arraycopy(encryptedTextBytes, 0, buffer, saltBytes.length + ivBytes.length, encryptedTextBytes.length);
       return new Base64().encode(buffer);
    }
  public static void main(String[] args) throws Exception {
//    Encryption en=new Encryption();
//    String encryptedWord=en.encrypt("08 (Aug)"); 
//    System.out.println("Encrypted word is : " + encryptedWord);
    Unfold de =new Unfold();
    System.out.println("Decrypted word is : " + de.unravel("0zna+tGHulxjmGBnOKpckJixUBV6kpxmN8dVZzSKHhjElXfFXZhHS5x57X6oUOD+pllvTA=="));
}
}