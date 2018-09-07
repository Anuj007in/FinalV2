package ReusableLibraryActions;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import UtilitiesHelper.Log;
import UtilitiesHelper.ExcelUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Helper.GetElement;
import UtilitiesHelper.ExcelUtility;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import Helper.GetElement;
import UtilitiesHelper.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import PageObjectModal.ORHomePage_Login;
import ReusableLibraryActions.Click_Action;
import mx4j.util.Utils;

public class Actions_PageFactory {

	public static WebElement element= null;
	public static void buttonClick_PageFactory(WebElement webelementName,int a, int b) throws Exception
	{
		 JFrame parent = new JFrame();
		// WebDriver driver=ExcelUtility.getWebDriverfor();
		 @SuppressWarnings("unused")
		WebDriver driver= ExcelUtility.getWebDriverfor();
	try {
		
		ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(webelementName));
		  if(webelementName.isDisplayed()==true) {
			ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//
			
			
			//
			webelementName.click();
			Thread.sleep(4000);
			 System.out.println("Button"+webelementName+"is found and clicked!");
			// ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
			 Integer rowSum=a+b;
				if(rowSum > 0)
		    ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
			ExcelUtility.setCellData("Passed", a, b,"Pass");
			Log.error("Excel connection is not established!");
			// Assert.assertTrue(webElement.isDisplayed(), "Element not found to click");
		    }
		  /* else {
			 System.out.println("Button"+webelementName+"is NOT found on the page to be clicked!");
			 ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
			 ExcelUtility.setCellData("Failed", a, b,"Fail");
			 //Assert.assertTrue(webElement.isDisplayed(), "Element not found to click");
		       }*/
	//	ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		catch(Exception ex) {
			System.out.println("From Factory catch:Button is NOT found Or Issue withUtil excel");
			ex.printStackTrace();
			// ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
			// ExcelUtility.setCellData("Failed", a, b,"Fail");
		}
	}
	
	public static void Click_SelectionList_PageFactory(WebElement webelementName,int a, int b,int index) throws Exception
	{
		 JFrame parent = new JFrame();
		
		 @SuppressWarnings("unused")
		WebDriver driver= ExcelUtility.getWebDriverfor();
	try {
			
		
		ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Thread.sleep(1000);
		  if(webelementName.isDisplayed()==true) {
			ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//or call Waitexplicit helper method instead of full defination below
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(webelementName));
			Select listbox=new Select(webelementName);
			listbox.selectByIndex(index);
			//
			//webelementName.click();
			Thread.sleep(1000);
			 System.out.println("Button"+webelementName+"is found and clicked!");
			// ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
			 Integer rowSum=a+b;
				if(rowSum > 0)
		    ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
			ExcelUtility.setCellData("Passed", a, b,"Pass");
			// Assert.assertTrue(webElement.isDisplayed(), "Element not found to click");
		    }
		  /* else {
			 System.out.println("Button"+webelementName+"is NOT found on the page to be clicked!");
			 ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
			 ExcelUtility.setCellData("Failed", a, b,"Fail");
			 //Assert.assertTrue(webElement.isDisplayed(), "Element not found to click");
		       }*/
	//	ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		catch(Exception ex) {
			System.out.println("From Factory catch:Button is NOT found Or Issue withUtil excel");
			ex.printStackTrace();
			// ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
			// ExcelUtility.setCellData("Failed", a, b,"Fail");
		}
	}
    public static void Assert_PageFactory(WebElement webelementName, int a,int b,int ExptdRow,int ExptColumn) throws Exception
    {
    	@SuppressWarnings("deprecation")
		//@Test 
	//public static void AssertText(String TextFieldObjectID,int a,int b,int ExptdRow,int ExptColumn,String ObjIdentifier) throws Exception {
			 JFrame parent = new JFrame();
			 WebDriver driver=ExcelUtility.getWebDriverfor();
			
		  try{
	
		  boolean asrt;
		  if (webelementName.isDisplayed()){
			  
			//  asrt= true;
			  
			  JavascriptExecutor js = (JavascriptExecutor) driver;
		        //use executeScript() method and pass the arguments 
		        //Here i pass values based on css style. Yellow background color with solid red color border. 
		  js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", webelementName);
		 	
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);		  
		  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		  String ActualText =webelementName.getText();
		  ActualText = ActualText.replaceAll(": ", "");
		
		  ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
		  String ExpectedText=ExcelUtility.getCellData(ExptdRow,ExptColumn);
		  System.out.println("Actual Text="+ActualText.toString());
		  System.out.println("Expected Text="+ExpectedText.toString());
		  if (ExpectedText.equalsIgnoreCase(ActualText))
				//	  if (ExpectedText==ActualText)
				  {
					 System.out.println("Actual and expected string is same!!!!");	
					 Thread.sleep(2000);
					 ExcelUtility.setCellData("Passed", a, b,"Pass");
					 					
				  }
				  else{
					  Thread.sleep(2000);
					  ExcelUtility.setCellData("Failed", a, b,"Fail");
					  Assert.assertEquals(ExpectedText,ActualText,"Assert Failed");
					  
					  
				  }
		  }
		  else
		  { 
			  //asrt= false;
			 boolean objfound=webelementName.isDisplayed();
			  ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
			  ExcelUtility.setCellData("Failed-To locate object on the page", a, b,"Fail");
			  Log.info("WebElement is not found");
			  Assert.assertTrue(objfound, "Assert WebElement object is not found-check Xpath or Object is not displayed on the Page!");
			  
		  }}
		
		
		  catch(Exception ex)
		  {
			  boolean objfound2=false;
			  System.out.println("Assert Text element Not found");
			  ex.printStackTrace();
			  ExcelUtility.setCellData("Failed", a, b,"Fail");
			  Assert.fail();
			//  Assert.assertTrue(objfound2, "Assert WebElement object is not found-check Xpath or Object is not displayed on the Page!");
				 
		  }
	  }
    }

