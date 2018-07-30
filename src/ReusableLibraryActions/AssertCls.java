package ReusableLibraryActions;

import java.sql.Time;
import UtilitiesHelper.Log;
import java.util.concurrent.TimeUnit;
import javax.rmi.CORBA.Util;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

//import com.gargoylesoftware.htmlunit.javascript.host.Popup; commented 12/12/16 recheck

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import PageObjectModal.ORHomePage_Login;
import ReusableLibraryActions.Click_Action;
import UtilitiesHelper.ExcelUtility;
import mx4j.util.Utils;
import Helper.GetElement;

//Author: Anuj Sharma
public class AssertCls {
  
	public static WebElement element= null;
		@SuppressWarnings("deprecation")
		//@Test 
	public static void AssertText(String TextFieldObjectID,int a,int b,int ExptdRow,int ExptColumn,String ObjIdentifier) throws Exception {
			 JFrame parent = new JFrame();
			 WebDriver driver=ExcelUtility.getWebDriverfor();
			
		  try{
	
		  WebElement webElement = GetElement.getWebElement(TextFieldObjectID,a,b,ObjIdentifier);
		 //String[] splittedstring= webElement.toString().split(" ");
		  boolean asrt;
		  if (webElement.isDisplayed()){
			  
			  asrt= true;
			  JavascriptExecutor js = (JavascriptExecutor) driver;
		        //use executeScript() method and pass the arguments 
		        //Here i pass values based on css style. Yellow background color with solid red color border. 
		  js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", webElement);
		 	
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);		  
		  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		  String ActualText =webElement.getText();
		 // String ActualText1 = ": Commercial";
		//  ActualText = ActualText.replaceAll(". ", "");
		  ActualText = ActualText.replaceAll(": ", "");
		
		  ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
		  String ExpectedText=ExcelUtility.getCellData(ExptdRow,ExptColumn);
		  System.out.println("Actual Text="+ActualText.toString());
		  System.out.println("Expected Text="+ExpectedText.toString());
		  if (ExpectedText.equalsIgnoreCase(ActualText))
				//	  if (ExpectedText==ActualText)
				  {
					 System.out.println("Actual and expected string is same!!!!");	
					 // Assert.assertTrue("Text Not matched in the result-Assert Failed",ExpectedText );
					 Thread.sleep(2000);
					 //ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
					 ExcelUtility.setCellData("Passed", a, b,"Pass");
					 //Assert.assertEquals(ExpectedText,ActualText,"Assert Failed");
				  }
				  else{
					  //Assert.assertTrue("Text Not matched in the result-Assert Failed",asrt );
					  Thread.sleep(3000);
					  //ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
					  ExcelUtility.setCellData("Failed", a, b,"Fail");
					  		  
					  Assert.assertEquals(ExpectedText,ActualText,"Assert Failed");
					  //Assert.assertNotSame(ActualText, ExpectedText, "Assert Failed");
					  
				  }
		  }
		  else
		  { 
			  asrt= false;
			  ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
			  ExcelUtility.setCellData("Fail", a, b,"Fail");
			  Assert.assertTrue(asrt, "Assert WebElement object is not found-check Xpath!");
			  Log.info("WebElement is not found");
			 
		  }}
		
		 /* driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);		  
		  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		  String ActualText =webElement.getText();
		  ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
		  String ExpectedText=ExcelUtility.getCellData(ExptdRow,ExptColumn);
		  System.out.println("Actual Text="+ActualText.toString());
		  System.out.println("Expected Text="+ExpectedText.toString());*/
		//  JOptionPane.showMessageDialog(parent,ActualText.toString());
		/* if (ExpectedText.equalsIgnoreCase(ActualText))
		//	  if (ExpectedText==ActualText)
		  {
			 System.out.println("Actual and expected string matched!!!!");	
			 // Assert.assertTrue("Text Not matched in the result-Assert Failed",ExpectedText );
			 Thread.sleep(2000);
			 //ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
			 ExcelUtility.setCellData("Pass", a, b);
			 //Assert.assertEquals(ExpectedText,ActualText,"Assert Failed");
		  }
		  else{
			  //Assert.assertTrue("Text Not matched in the result-Assert Failed",asrt );
			  Thread.sleep(3000);
			  //ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
			  ExcelUtility.setCellData("Fail", a, b);
			  		  
			  Assert.assertEquals(ExpectedText,ActualText,"Assert Failed");
			  //Assert.assertNotSame(ActualText, ExpectedText, "Assert Failed");
			  
		  }
		  //Assert.assertEquals(ExpectedText,ActualText);
		  
		  }*/
		  catch(Exception ex)
		  {
			  System.out.println("Assert Text element Not found");
			  ex.printStackTrace();
			  ExcelUtility.setCellData("Fail", a, b,"Fail");
		  }
	  }
	  
  }

