package com.authentication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetPropertyValues {
	public static String getPropertyValue(String key) {
		String value="";
		try{
		Properties prop=new Properties();
		prop.load(new FileInputStream(new File("D:\\surya\\EncryptDecrypt\\dbCredential.properties")));
		//the above line is used to get the property value from config.properties file by using key
		value=prop.getProperty(key);                                                                
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		return value;
	}
}
