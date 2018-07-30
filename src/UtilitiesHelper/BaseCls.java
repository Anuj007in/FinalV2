package UtilitiesHelper;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseCls {
  
  WebDriver driver = new FirefoxDriver();
  
  @BeforeTest
  public void launchapp()
  {
     // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     // Launch website
     driver.navigate().to("http://www.calculator.net");
     driver.manage().window().maximize(); 
  
  }
  @AfterTest
  public void terminatetest()
  {
     driver.close();
  }
}
