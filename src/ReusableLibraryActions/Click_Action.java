package ReusableLibraryActions;
import PageObjectModal.ORHomePage_Login;
import UtilitiesHelper.Log;
import PageObjectModal.SearchTextPage;
import java.lang.Object;
import org.openqa.selenium.support.ui.Select;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import Helper.GetElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import com.sun.org.apache.bcel.internal.generic.Select;
import com.thoughtworks.selenium.Wait;

import UtilitiesHelper.Constants;
import UtilitiesHelper.ExcelUtility;
public class Click_Action {
	
public static WebElement element= null;

public static void Btn_Click(String buttonName,int a,int b, String ObjIdentifier) throws Exception
{
	
	try {
	ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement webElement = GetElement.getWebElement(buttonName,a,b,ObjIdentifier); 
	if(webElement.isDisplayed()) {
		ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webElement.click();
		 System.out.println("Button"+webElement+"is found and clicked!");
		 ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
		 ExcelUtility.setCellData("Passed", a, b,"Pass");
		// Assert.assertTrue(webElement.isDisplayed(), "Element not found to click");
	}
	else {
		 System.out.println("Button"+webElement+"is NOT found on the page to be clicked!");
		 ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
		 ExcelUtility.setCellData("Failed", a, b,"Fail");
		 //Assert.assertTrue(webElement.isDisplayed(), "Element not found to click");
	}
	ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	catch(Exception ex) {
		System.out.println("From catch:Button is NOT found on the page to be clicked!");
		ex.printStackTrace();
		 ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
		 ExcelUtility.setCellData("Failed", a, b,"Fail");
	}
	
}


public static void Enter_Text(String FieldName,int a,int b,int readFromRow,int ReadFromColumn,String ObjIdentifier) throws Exception
{
   //ObjIdentifier= Xpath,CSS or ID
	WebElement webElement= GetElement.getWebElement(FieldName, a, b, ObjIdentifier);
   ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
	String TextToEnter= ExcelUtility.getCellData(readFromRow,ReadFromColumn);
	webElement.clear();
	webElement.sendKeys(TextToEnter);
   
  //System.out.println("EnterText Method is called");
   //ExcelUtility.getWebDriverfor();
   //WebDriver driver=null;
   //driver=  ExcelUtility.getWebDriverfor();
  // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

public static void NextBtnClick(WebDriver driver)
{
  ORHomePage_Login.NextBtnLogin(driver).click();	
}

public static void PassCCredential(WebDriver driver) throws Exception
{
	ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
	String PWD = ExcelUtility.getCellData(1, 2);
	ORHomePage_Login.PasswordBox(driver).sendKeys(PWD);
	Log.info("Text is typed and passed as Input");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
   
}
//click search button - search text scenario
public static void SearchText(WebDriver driver)
{
	SearchTextPage.ORSearchBox(driver).sendKeys("HI This is HP PPS Automation");

}
public static void clickSearchBtn(WebDriver driver) throws Exception
{
	try{
	SearchTextPage.ORSearchBtn(driver).click();
    ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
	ExcelUtility.setCellData("Search Pass", 2, 6,"Pass");
	}
	catch(Exception ex)
	{
		//throw exception
		ExcelUtility.setCellData("Search Fail", 2, 6,"Fail");
		
	}
}
public static void SelectionBox_passSelection(String FieldName, int a,int b,String ObjIdentifier,String PassSelection) throws Exception
{
	  try {
		  
		   ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
		   WebElement webElement= GetElement.getWebElement(FieldName, a, b, ObjIdentifier);
		  
		 //  ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   //ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
		  // String TextToEnter= ExcelUtility.getCellData(readFromRow,ReadFromColumn);
	      
			//WebDriverWait wait = new WebDriverWait(WebDriver.driver, /*seconds=*/10);

	    // webElement = Wait.until(presenceOfElementLocated(By.id("countVal")));
////*[@id="wiseExperience_dd_list"]/li[1]/a
		   
	     /* Select select = new Select(webElement);
	      select.deselectAll();
	      select.selectByVisibleText(PassSelection);*/
	      if (webElement.isDisplayed()) {
	    	  
	    	  webElement.click();
			  Thread.sleep(1000);
	    	  Select select = new Select(webElement);
		      //select.deselectAll();
		      select.selectByVisibleText(PassSelection);
		      System.out.println("Selection is made");
		      
		   
		     // ExcelUtility.setCellData("Passed", a, b, "Pass");
	      }
	      else
	      {
	    	  System.out.println("Selection box is not displayed");
	    	  assert(false);
	      }
	  } catch (NoSuchElementException ex) {
	      System.out.println("no Selection box object is found or clickable-Selection Span or timed out!!");
	      ex.printStackTrace();
	  }

	}
}
