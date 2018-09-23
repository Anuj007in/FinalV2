package UtilitiesHelper;

import java.util.Properties;
import java.io.*;
import java.net.URL;
import java.util.Objects;

public class ReadConfigProperties
{
	//call this method by passing the Kayname in the place
	public static String  ReadConfigMethod(String KeyName){
	try {
		Properties prop= new Properties();
        // the configuration file name
		File F=new File(System.getProperty("user.dir")+"\\Configs\\configuration.properties");
        //String fileName = System.getProperty("user.dir")+ "\\Configs\\configuration.properties";
        
		FileReader FR=new FileReader(F);
		prop.load(FR);
		
        String KeyValue= prop.getProperty(KeyName);
        // get the value for app.name key
        System.out.println(prop.getProperty("Browser"));
        // get the value for app.version key
        System.out.println(prop.getProperty("This is the selected URL:"+"AppURL"));

        // get the value for app.vendor key and if the
        // key is not available return No COnfig file found
        System.out.println(prop.getProperty("app.vendor","No COnfig file value is found"));
        return KeyValue;
    } 
	
	catch (IOException e) 
	{
        e.printStackTrace();
    }
	//return KeyName;
	return KeyName;
}
}



