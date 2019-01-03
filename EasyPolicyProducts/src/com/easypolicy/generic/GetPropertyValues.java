package com.easypolicy.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author Gaurav
 *
 */

public class GetPropertyValues {
	/**
	 * @description This method is used to read the value fromconfig.properties file based on key.
	 * @param key
	 * @return
	 */
	public static String getPropertyValue(String key) {
		String value="";
		try{
		Properties prop=new Properties();
		prop.load(new FileInputStream(new File("D:\\surya\\EasyPolicyProducts\\URL.properties")));//this line is used to get the property value 
		value=prop.getProperty(key);                                                               //from config.properties file by using key 
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		return value;
	}

}
