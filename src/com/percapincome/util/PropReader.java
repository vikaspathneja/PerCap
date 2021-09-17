package com.percapincome.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropReader {
	   static Properties p=new Properties();
	   InputStream inputStream=null;
		private final String propFileName = "CurrencyConversion.properties";

		
		public PropReader() {
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		}
	   
	public String readValue(String value) throws FileNotFoundException{
		if (inputStream != null) {
			try {
				p.load(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		return p.getProperty(value);
	}
}
