package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class ConfigReader {
	Properties prop = new Properties();
	private FileInputStream ip;
	
	public Properties Init_prop(){
		
		try {
			ip = new FileInputStream(ResourceHelper.GetResourcePath("\\src\\test\\resources\\config\\config.properties"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return prop;



		
	}	
	 }

