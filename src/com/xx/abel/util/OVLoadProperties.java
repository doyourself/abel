package com.xx.abel.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class OVLoadProperties {

	private static OVLoadProperties instance = new OVLoadProperties();
	final static String fileName = "/config.properties";

	public static synchronized OVLoadProperties getInstance() {
		return instance;
	}
	public String getProperties(String key) {
		Properties p = new Properties();
		InputStream is = null;
		try {
		
			is = OVLoadProperties.class.getResourceAsStream(fileName);
			if (is == null)
				is = new FileInputStream(fileName);
			p.load(is);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
		}
		return p.getProperty(key);
	}
}