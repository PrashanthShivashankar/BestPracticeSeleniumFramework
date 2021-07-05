package com.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider 
{
	Properties prop;
	public ConfigDataProvider()
	{
		
		File src=new File("./Config/config.properties");
		try 
		{
			FileInputStream fs=new FileInputStream(src);
			prop=new Properties();
			prop.load(fs);
			
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Not able to load config file " + e);
		
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	public String getDataFromConfig(String key)
	{
		return prop.getProperty(key);
	}
}
