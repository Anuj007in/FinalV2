package ReusableLibraryActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

import Helper.GetElement;
import UtilitiesHelper.ExcelUtility;

public class Verify_BackgroundColorClass {
//use xpath for this method
	public static void Verify_BackgroundColor (String FieldName,int a,int b, String ObjIdentifier,String ExpectedBGColor) throws Exception
	{
		WebDriver driver=ExcelUtility.getWebDriverfor();
		//WebElement webElement= GetElement.getWebElement(FieldName, a, b, ObjIdentifier);
		ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
		try {
	if(ObjIdentifier=="Xpath")
	{
		//boolean s;

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String color = driver.findElement(By.xpath(FieldName)).getCssValue("color");
		System.out.println("color is:"+color);
		String hex = Color.fromString(color).asHex();
		System.out.println("Hex color:"+hex);
		//Assert.assertEquals(hex, ExpectedBGColor);
		//if(hex.equalsIgnoreCase(ExpectedBGColor))
			if(ExpectedBGColor.equalsIgnoreCase(hex))	
		{
			//Thread.sleep(1000);
		//	Assert.assertEquals(hex, ExpectedBGColor);
			ExcelUtility.setCellData("Passed", a, b,"Pass");
			System.out.println("Actual and expected color passed in test method is same!");
		}
		else {
			  System.out.println("Actual and expected color passed in test method is NOT same!");	
			  Thread.sleep(1000);
			  ExcelUtility.setCellData("Failed", a, b,"Fail");
		}
	}
		//assert(s);
		//System.out.println("Actual and expected color passed in test method is same!");
		
		/*catch(Exception ex)
		{
			  System.out.println("Actual and expected color passed in test method is NOT same!");	
			  Thread.sleep(1000);
			  ExcelUtility.setCellData("Failed", a, b,"Fail");
		}*/
		  /*if(hex.equalsIgnoreCase(ExpectedBGColor))
		  {
			  System.out.println("Actual and expected color passed in test method is same!");	
			  Thread.sleep(1000);
			  ExcelUtility.setCellData("Passed", a, b,"Pass");
		  }
		  else
		  {
			  System.out.println("Actual and expected color passed in test method is NOT same!");	
			  Thread.sleep(1000);
			  ExcelUtility.setCellData("Failed", a, b,"Fail");
		  } */
		 
	
		else if(ObjIdentifier=="CSS")
	{
		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String color = driver.findElement(By.xpath(FieldName)).getCssValue("color");
			System.out.println("color is:"+color);
			String hex = Color.fromString(color).asHex();
			System.out.println("Hex color:"+hex);
			//Assert.assertEquals(hex, ExpectedBGColor);
			if(hex.equalsIgnoreCase(ExpectedBGColor))
			{
				//Thread.sleep(1000);
				//Assert.assertEquals(hex, ExpectedBGColor);
				ExcelUtility.setCellData("Passed", a, b,"Pass");
				System.out.println("Actual and expected color passed in test method is same!");
			}
			else {
				  System.out.println("Actual and expected color passed in test method is NOT same!");	
				  Thread.sleep(1000);
				  ExcelUtility.setCellData("Failed", a, b,"Fail");
			}
	}}
			/*try {
			String color = driver.findElement(By.cssSelector(FieldName)).getCssValue("color");
			System.out.println("color is:"+color);
			String hex = Color.fromString(color).asHex();
			System.out.println("Hex color:"+hex);
			Assert.assertEquals(hex, ExpectedBGColor);
			System.out.println("Actual and expected color passed in test method is same!");
			}
			catch(Exception ex)
			{
				  System.out.println("Actual and expected color passed in test method is NOT same!");	
				  Thread.sleep(1000);
				  ExcelUtility.setCellData("Failed", a, b,"Fail");
			}
/*	String color = driver.findElement(By.cssSelector(FieldName)).getCssValue("color");
	System.out.println("color is:"+color);
	String hex = Color.fromString(color).asHex();
	System.out.println(hex);
	//Assert.assertEquals(hex, ExpectedBGColor);
	 if(hex.equalsIgnoreCase(ExpectedBGColor))
	  {
		  System.out.println("Actual and expected color passed in test method is same!");	
		  Thread.sleep(1000);
		  ExcelUtility.setCellData("Passed", a, b,"Pass");
	  }
	  else
	  {
		  System.out.println("Actual and expected color passed in test method is NOT same!");	
		  Thread.sleep(1000);
		  ExcelUtility.setCellData("Failed", a, b,"Fail");
	  }*/
		
	catch(Exception ex)
	{
		  System.out.println("Actual and expected color passed in test method is NOT same!");	
		  Thread.sleep(1000);
		  ExcelUtility.setCellData("Failed", a, b,"Fail");
		 
	}
	}}

