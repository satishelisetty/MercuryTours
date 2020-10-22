package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	
	public ConfigDataProvider(){
		
		File src=new File("./Config/Config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			
			pro=new Properties();
			
			pro.load(fis);
		} 
		catch (Exception e) {
			
			System.out.println("Unable to load properties" +e.getMessage());
		} 
	}
	
	public String getDataFromConfig(String keyToSearch){
		return pro.getProperty(keyToSearch);
		
	}
	
	public String getBrowser(){
		return pro.getProperty("browser");
		
	}
	public String getURL(){
		return pro.getProperty("qaUrl");
	}

	public String getChromePath(){
		return pro.getProperty("chromepath");
	}
	
	public String getFirefoxPath(){
		return pro.getProperty("firefoxPath");
	}
	public String getIEPath(){
		return pro.getProperty("iePath");
	}

}
