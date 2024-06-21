package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * This class consists of generic methods related to property file 
 * @author Nithish
 *
 */
public class FileUtility {
	/**
	 * This method reads Data from property file based on given key
	 * @param key
	 * @return data
	 * @throws Throwable
	 */
	public String getDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\configAppData\\commondata.properties.txt");
		Properties p=new Properties();
		p.load(fis);
		String data=p.getProperty(key);
	
		return data;
}
}