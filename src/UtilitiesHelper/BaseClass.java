package UtilitiesHelper;

import org.testng.annotations.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import UtilitiesHelper.ReadConfigProperties;

public class BaseClass {
  
 // WebDriver driver = new FirefoxDriver();
  WebDriver driver;
  @BeforeClass
  public void SetBrowser()
  {
     // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
   //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     // Launch website
    // driver.navigate().to("http://www.calculator.net");
    // driver.manage().window().maximize(); 
    // public static void setWebDriver()
     //{
     	//if(browserName.equals("chrome"))
	//  Properties prop=new Properties();
	  //String BrowserName = prop.getProperty("AUT_Base_URL");
	  
     	//String browserName=Constants.Browser; //this should be in config file prop
     		//if(browserName.equals("chrome"))
     	//{
     	//read it from config prop
     	
     		//System.setProperty("webdriver.chrome.driver","C:/Users/anujksharma/Downloads/chromedriver.exe");
     		//driver= new ChromeDriver();
     		
     		//String BrowserURL=Constants.
     		//driver.get(Constants.URLHome);
     		//driver.get("https://google.com");
     //	}
     		 //public static final WebDriver getWebdriver(){ 
	 // String browser=ReadConfigProperties.ReadConfigMethod("Browser_For_AUT");
	  
     			  		 
     			  		  Properties prop=new Properties();
     			  		  //String browser1= prop.getProperty("Browser_For_AUT");
     			  		  String browser1=ReadConfigProperties.ReadConfigMethod("Browser");
     			  		  
     			  		//browser= System.getProperties("user.dir","Browser_For_AUT");
     			  		  // If the browser is Firefox, then do this 
     			if(browser1.equalsIgnoreCase("firefox")) { 
     			  			  System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe"); 
     			  			  driver = new FirefoxDriver(); 
     			  		  } else if (browser1.equalsIgnoreCase("chrome")){ 
     			  			  System.setProperty("webdriver.chrome.driver", "C:/Users/anujksharma/Downloads/chromedriver.exe"); 
     			  			  driver = new ChromeDriver(); 
     			  		  } else if (browser1.equalsIgnoreCase("ie")) {  
     			  		 	  System.setProperty("webdriver.ie.driver", "drivers\\IEDriverServer.exe"); 
     			  		 	  DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();     
     			  		 	  capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true); 
     			  		 	  driver = new InternetExplorerDriver(capabilities); 
     			  		  } 
     			  		 //return driver; 
     			  	 } 
	@BeforeClass	
  public void launchApplication()
		{
			
			String URL=ReadConfigProperties.ReadConfigMethod("AppURL");
			driver.get(URL);
			driver.manage().window().maximize();
		}
     		
  
  
  @AfterClass
  public void terminatetest()
  {
     driver.quit();
     //driver.close();
  }
}
