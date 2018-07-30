package AutomationFW;
import org.testng.annotations.Test;
import PageObjectModal.SearchTextPage;
import UtilitiesHelper.Log;
import ReusableLibraryActions.Click_Action;
import ReusableLibraryActions.ObjectFound;

import org.testng.annotations.Test;
//import org.tetng.annotations.BeforeMethod;
//package UtilitiesHelper;
import PageObjectModal.ORHomePage_Login;
import UtilitiesHelper.Constants;
import UtilitiesHelper.ExcelUtility;
import UtilitiesHelper.Constants;
import ReusableLibraryActions.Click_Action;
import ReusableLibraryActions.AssertCls;
import ReusableLibraryActions.ClearObject;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
//import org.bouncycastle.eac.EACIOException;
import org.openqa.selenium.By;
//import javax.swing.JOptionPane;a
@Listeners(UtilitiesHelper.IListner.class)

@Test
public class TestCase_WISELogin {
	
	WebDriver driver = null;
	public TestCase_WISELogin()
	{
		
		try {
			//driver = ExcelUtility.getWebDriverfor("chrome");
			driver = ExcelUtility.getWebDriverfor();
			ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
			driver.quit();
			driver.close();
			
		}	
	} 
	@AfterClass
    public void tearDown() {
        driver.close();
    }
	@Test(priority = 1)
	//@BeforeMethod
	public void LoginToWise() throws Exception
	{
		Log.startTestCase("WISE_LoginTest");
		this.driver.get(Constants.URLHome);
		// this.driver.navigate().to(Constants.URLHome);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		Thread.sleep(1000);
     
       ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       Click_Action.Btn_Click(PageObjectModal.WISE_Login_Page.Email_CompLink_Xpath, 4, 6,"Xpath");
       Thread.sleep(1000);
        
       Click_Action.Enter_Text(PageObjectModal.WISE_Login_Page.WISE_USN_Xpath, 4, 6, 4, 1,"Xpath");
       Click_Action.Enter_Text(PageObjectModal.WISE_Login_Page.WISE_PWD_Xpath, 4, 6, 4, 2,"Xpath");
       
		
        Click_Action.Btn_Click(PageObjectModal.WISE_Login_Page.WISE_SignOn_Xpath, 4, 6,"Xpath");
        ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        driver.navigate().refresh();
        ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.HomePageTitle_Xpath, 4, 6, 4, 5,"Xpath");
        AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.HomePageTitle_UIExp_Xpath, 4, 6, 4, 5,"Xpath");
		
				
	}
	
	
	@Test(priority = 2)
	//@BeforeMethod
	public void SearchSKU() throws Exception
	{
		Log.startTestCase("WISE_SKU Search");
		this.driver.get(Constants.URLHome);
		// this.driver.navigate().to(Constants.URLHome);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		Thread.sleep(1000);
     
       ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
              
       Click_Action.Enter_Text(PageObjectModal.WISE_HomePage_Page.WISE_SearchBox, 5, 6, 5, 4,"Xpath");
       Click_Action.Btn_Click(PageObjectModal.WISE_HomePage_Page.WISE_SearchMagnifier, 5, 6,"Xpath");   
       AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_SearchPDPLink, 5, 6, 5, 5,"Xpath");
       Thread.sleep(1000);
       /* Click_Action.Btn_Click(PageObjectModal.WISE_Login_Page.WISE_SignOn_Xpath, 2, 6);
        Thread.sleep(1000);
        AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.HomePageTitle_Xpath, 1, 2, 4, 5);*/
		
				
	}
	@Test(priority = 3)
	//@BeforeMethod
	public void NavigateToPDPPage() throws Exception
	{
	/*	Log.startTestCase("WISE_PDP Page");
		this.driver.get(Constants.URLHome);
		// this.driver.navigate().to(Constants.URLHome);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		Thread.sleep(1000);
     
       ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
              
       Click_Action.Enter_Text(PageObjectModal.WISE_HomePage_Page.WISE_SearchBox, 6, 6, 5, 4);
       Click_Action.Btn_Click(PageObjectModal.WISE_HomePage_Page.WISE_SearchMagnifier, 6, 6);   
       ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); */
		this.driver=driver;
       Click_Action.Btn_Click(PageObjectModal.WISE_HomePage_Page.WISE_SearchPDPLink, 6, 6,"Xpath");
       Thread.sleep(1000);
       
       //**
       Set<String> AllWindowHandles = driver.getWindowHandles();
       String window1 = (String) AllWindowHandles.toArray()[0];
       System.out.print("window1 handle code = "+AllWindowHandles.toArray()[0]);
       String window2 = (String) AllWindowHandles.toArray()[1];
       System.out.print("\nwindow2 handle code = "+AllWindowHandles.toArray()[1]);
       driver.switchTo().window(window2);
       
       //**
       AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_PDPProdName, 6, 6, 6, 5,"Xpath");
       //AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_SearchPDPLink, 1, 2, 5, 5);
       //driver.close();
       //driver.switchTo().window(window1);
       driver.switchTo().window(window1).close();
       driver.switchTo().window(window2);
       //driver.close();
		
				
	}
	@Test(priority = 4)
	public void PDPPage_TabsDIsplay() throws Exception
	{
	/*	Log.startTestCase("WISE_PDP Page");
		this.driver.get(Constants.URLHome);
		// this.driver.navigate().to(Constants.URLHome);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		Thread.sleep(1000);
     
       ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
              
       Click_Action.Enter_Text(PageObjectModal.WISE_HomePage_Page.WISE_SearchBox, 6, 6, 5, 4);
       Click_Action.Btn_Click(PageObjectModal.WISE_HomePage_Page.WISE_SearchMagnifier, 6, 6);   
       ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); */
		this.driver=driver;
       Click_Action.Btn_Click(PageObjectModal.WISE_PDPPage_Page.PDP_TroubleShoot_CSS, 7, 6,"CSS");
       
       //Thread.sleep(1000);
       AssertCls.AssertText(PageObjectModal.WISE_PDPPage_Page.PDP_TroubleShootTitle_CSS, 7, 6, 7, 5,"CSS");

       Click_Action.Btn_Click(PageObjectModal.WISE_PDPPage_Page.PDP_HowTo_CSS, 8, 6,"CSS");
       
       Thread.sleep(1000);
       AssertCls.AssertText(PageObjectModal.WISE_PDPPage_Page.PDP_HowToTitle_CSS, 8, 6, 8, 5,"CSS");
Click_Action.Btn_Click(PageObjectModal.WISE_PDPPage_Page.PDP_ProdInfo_CSS, 9, 6,"CSS");
       
       Thread.sleep(1000);
       AssertCls.AssertText(PageObjectModal.WISE_PDPPage_Page.PDP_ProdInfoTitle_CSS, 9, 6, 9, 5,"CSS");
       /*
       //**
       Set<String> AllWindowHandles = driver.getWindowHandles();
       String window1 = (String) AllWindowHandles.toArray()[0];
       System.out.print("window1 handle code = "+AllWindowHandles.toArray()[0]);
       String window2 = (String) AllWindowHandles.toArray()[1];
       System.out.print("\nwindow2 handle code = "+AllWindowHandles.toArray()[1]);
       driver.switchTo().window(window2);
       
       //**
        */
       
      // driver.close();
       //driver.switchTo().window(window1);
       //driver.close();
		
				
	}
	@Test(priority = 5)
	public void NavigateToHomePage() throws Exception
	{
	//AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_HomePageLogo_CSS, 10, 6, 10, 5, "CSS");
	boolean status=ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_HomePage_Page.WISE_HomePageLogo_CSS,10,6,"CSS");
	if (status==true)
	{
		System.out.println("Log Is found on the screen and ready to click");
		//AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_HomePageLogo_CSS, 10, 6, 10, 5, "CSS");
		Click_Action.Btn_Click(PageObjectModal.WISE_HomePage_Page.WISE_HomePageLogo_CSS, 10, 6, "CSS");
		Thread.sleep(1000);
		AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_WelcomeToWise_CSS, 11, 6, 11, 5, "CSS");
		driver.close();
		driver.quit();
	}
	else
	{
		System.out.println("Log Is NOT found on the screen and NOT ready to click");
		driver.close();
		driver.quit();
		
	}
	}
	
}
