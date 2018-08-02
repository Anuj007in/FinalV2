package ReusableLibraryActions;

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
	if(ObjIdentifier=="Xpath")
	{
		try {
		String color = driver.findElement(By.xpath(FieldName)).getCssValue("color");
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
		 
	}
	if(ObjIdentifier=="CSS")
	{
		try {
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
	 
	}
}}
