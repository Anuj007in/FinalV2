package Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory; 
import PageObjectModal.ORHomePage_Login;
import ReusableLibraryActions.Click_Action;

import org.openqa.selenium.WebElement;

import UtilitiesHelper.ExcelUtility;
import UtilitiesHelper.Log;
//Author: Anuj Sharma
public class GetElement {
	
	//add below declarftion at all class wherever calling this log
	//private static Logger log = LoggerFactory.getLogger(GetElement.class); 
	public static WebElement getWebElement(String elementName,Integer a,Integer b,String Objidentifier) throws Exception{
		
		WebElement webElement = null;
		//WebDriver driver= ExcelUtility.getWebDriverfor("chrome");
		WebDriver driver= ExcelUtility.getWebDriverfor();
		try{
			if(Objidentifier=="Xpath")
			{
		       webElement=driver.findElement(By.xpath(elementName));
			}
			else if(Objidentifier=="ID")
			{
				webElement=driver.findElement(By.id(elementName));
			}
			else if(Objidentifier=="CSS")
			{
				webElement=driver.findElement(By.cssSelector(elementName));
			}
			else if(Objidentifier=="Class")
			{
				webElement=driver.findElement(By.className(elementName));
			}
		//return webElement;
		//Log.info("test log");
		
         // log.info("aasdasdDS");
		}
		catch(Exception ex)
		{
			ex.getMessage();
			Integer rowSum=a+b;
			if(rowSum > 0)
			{
			ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
			ExcelUtility.setCellData("Fail-GetWebElement-Object is not Found",a,b, "Fail");
			System.out.println("Object/Element is not recognized/found- Check the POM-OR value i.e Xpath");
			}
		}
		return webElement;
	}

}
