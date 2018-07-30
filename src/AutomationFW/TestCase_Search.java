package AutomationFW;
import org.testng.annotations.Test;
import PageObjectModal.SearchTextPage;
import UtilitiesHelper.Log;
import ReusableLibraryActions.Click_Action;
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
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
//import org.bouncycastle.eac.EACIOException;
import org.openqa.selenium.By;

@Listeners(UtilitiesHelper.IListner.class)
@Test
//@BeforeMethod
public class TestCase_Search {
	WebDriver driver = null;
	public TestCase_Search()
	{
		
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

	@Test(priority = 0)
	//@BeforeMethod
	public void Home_PoductSearch() throws Exception
	{
		Log.startTestCase("Home_ProductSearch");
		this.driver.get(Constants.URLHome);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		Thread.sleep(2000);
        Click_Action.Btn_Click(ORHomePage_Login.HomePageSEarchTextBox, 2, 5,"Xpath");
        ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Thread.sleep(5000);
		ClearObject.ClearTextField(ORHomePage_Login.HomePageSEarchTextBox, 2, 6,"Xpath");
		Click_Action.Enter_Text(ORHomePage_Login.HomePageSEarchTextBox, 2, 6, 2,4,"Xpath");
		Click_Action.Btn_Click(ORHomePage_Login.HomePageSearchBtn, 2, 6,"Xpath");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Thread.sleep(4000);
		AssertCls.AssertText(ORHomePage_Login.SeriesTextLabel,2,6,2,5,"Xpath");
		driver.close();
		//driver.quit();
		//AssertCls.AssertText(ORHomePage_Login.SeriesTextLabel,null,null,2,5);
				
	}
@Test(priority = 1)
	public void Home_ModalSearch() throws Exception
	{
        this.driver.get(Constants.URLHome);
		
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
        Click_Action.Btn_Click(ORHomePage_Login.HomePageSEarchTextBox, 3, 6,"Xpath");
        ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ClearObject.ClearTextField(ORHomePage_Login.HomePageSEarchTextBox, 3, 6,"Xpath");
		Click_Action.Enter_Text(ORHomePage_Login.HomePageSEarchTextBox, 3, 6, 3,4,"Xpath");
		Click_Action.Btn_Click(ORHomePage_Login.HomePageSearchBtn, 3, 6,"Xpath");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		AssertCls.AssertText(ORHomePage_Login.SeriesTextLabel,3,6,3,5,"Xpath");
		//driver.close();
		
	}
	
}
