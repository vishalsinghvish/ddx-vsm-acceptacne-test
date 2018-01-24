package org.vsm.stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class PropertyReader {
	
	HashMap<String,Object> propertyMap = new HashMap<String,Object>();
	
	public HashMap<String,Object>  ReadPropertyFile(String FileName) {
		
		try {
		File file = new File(FileName);
		FileInputStream fis = new FileInputStream(file);    // FileNotFoundxception
		Properties properties = new Properties();
		properties.load(fis);                              // IOException
		fis.close();
		
		Enumeration<Object> enumKeys = properties.keys();
		while(enumKeys.hasMoreElements()) {
			String key = (String) enumKeys.nextElement();
			propertyMap.put(key, properties.getProperty(key));
		}
		}
		catch(FileNotFoundException  e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
			}
		return propertyMap;
		}

	public static void main(String[] args) {

		PropertyReader pr = new PropertyReader();
		pr.ReadPropertyFile("environment.properties");
	}

}
