package AutomationFW;
import org.testng.annotations.Test;
//package UtilitiesHelper;
import PageObjectModal.ORHomePage_Login;
import UtilitiesHelper.Constants;
import UtilitiesHelper.ExcelUtility;
import UtilitiesHelper.Constants;
import ReusableLibraryActions.Click_Action;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
//import org.bouncycastle.eac.EACIOException;
import org.openqa.selenium.By;

@Listeners(UtilitiesHelper.IListner.class)
public class TestCase_Login {
	
	WebDriver driver = null;
	public TestCase_Login()
	{
		System.out.println("Hithis is constructor");
		try {
			//driver = ExcelUtility.getWebDriverfor("chrome");
			driver = ExcelUtility.getWebDriverfor();
			ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
			
		}	
	}
		
//private static WebDriver driver= null;
@Test

public void LoginTest01() throws Exception
{
	
	this.driver.get(Constants.URLHome);
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	Click_Action.Btn_Click(PageObjectModal.ORHomePage_Login.WebSignInBtn,1,6,"Xpath");
	Click_Action.Enter_Text(ORHomePage_Login.UserNameBox,1,6,1,1,"Xpath");
	Click_Action.Btn_Click(ORHomePage_Login.NextButton,1,1,"Xpath");
	Click_Action.Enter_Text(ORHomePage_Login.PasswordBox, 1, 1, 1,2,"Xpath");
    Click_Action.Btn_Click(PageObjectModal.ORHomePage_Login.SignINButton,1,6,"Xpath");
	System.out.println("this is after loginn");
	
try{
	if (ORHomePage_Login.VerifyloggedIn(driver).isDisplayed())
	{
		System.out.print("Login is successful!!");
		//ExcelUtils.setCellData("Pass-Login is successful", 1, 3);
		ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
		ExcelUtility.setCellData("Pass-Login is successful",1,6,"Pass");
	}
	else
	{
		System.out.print("Unable to login");
	}
}
catch(Exception ex)
{
	System.out.print("Exception occured:"+ex.getMessage());
	ExcelUtility.setCellData("Login Failed",1,6,"Fail");
}
SearchText();
}

//@Test
public void SearchText() throws Exception 
{
	try{
	Click_Action.SearchText(driver);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Click_Action.clickSearchBtn(driver);
	//Thread.sleep(50);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//driver.close();
	System.out.println("Search is successful");
	ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
	ExcelUtility.setCellData("Pass-Search case",2,6,"Pass");
	}
	catch(Exception ex)
	{
		ExcelUtility.setCellData("Fail",2,6,"Fail");
	}
	}
	
	
}
