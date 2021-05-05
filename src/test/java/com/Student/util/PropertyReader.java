package com.Student.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

	private static volatile PropertyReader propinstance;
	private PropertyReader() {
		
	}
	public static synchronized PropertyReader getInstance() {
		
			if(propinstance==null) {
				propinstance =new PropertyReader();
			}
			return propinstance;
	}
	public String getProperty(String property) throws IOException {
		Properties prop=new Properties();
		InputStream input=getClass().getClassLoader().getResourceAsStream("application.properties");
		prop.load(input);
		if(prop.getProperty(property)!=null) {
			return prop.getProperty(property);
		}
		return null;
	}
}
