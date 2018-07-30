package ReusableLibraryActions;
import PageObjectModal.ORHomePage_Login;
import UtilitiesHelper.Log;
import PageObjectModal.SearchTextPage;
import java.util.concurrent.TimeUnit;
import Helper.GetElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import UtilitiesHelper.Constants;
import UtilitiesHelper.ExcelUtility;
public class Click_Action {
	
public static WebElement element= null;

public static void Btn_Click(String buttonName,int a,int b, String ObjIdentifier) throws Exception
{
	
	WebElement webElement = GetElement.getWebElement(buttonName,a,b,ObjIdentifier); 
	webElement.click();
	ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
}


public static void Enter_Text(String FieldName,int a,int b,int readFromRow,int ReadFromColumn,String ObjIdentifier) throws Exception
{
   //ObjIdentifier= Xpath,CSS or ID
	WebElement webElement= GetElement.getWebElement(FieldName, a, b, ObjIdentifier);
   ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
	String TextToEnter= ExcelUtility.getCellData(readFromRow,ReadFromColumn);
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

}
