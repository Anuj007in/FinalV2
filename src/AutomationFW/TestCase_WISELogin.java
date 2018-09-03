package AutomationFW;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.bouncycastle.eac.EACIOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ReusableLibraryActions.Actions_PageFactory;
import ReusableLibraryActions.AssertCls;
import ReusableLibraryActions.Click_Action;
import ReusableLibraryActions.ObjectFound;
import ReusableLibraryActions.Verify_BackgroundColorClass;
import ReusableLibraryActions.Wait_ElementToBeClickable;
import UtilitiesHelper.Constants;
import UtilitiesHelper.ExcelUtility;
import UtilitiesHelper.Log;
import mx4j.util.Utils;
import Helper.GetElement;
import java.io.FileInputStream;
import UtilitiesHelper.Constants;

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
        ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(1000);
        Boolean AnoFound=ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_Login_Page.WISE_Anonymous_PopUp_CSS, 12, 6, "CSS");
        try {
        if (AnoFound==true)
        {
        	AssertCls.AssertText(PageObjectModal.WISE_Login_Page.WISE_Anonymous_PopUp_CSS, 12, 6, 12, 5, "CSS");
            Click_Action.Btn_Click(PageObjectModal.WISE_Login_Page.WISE_Anonymous_PopUp_Selection_Xpath, 4, 6,"Xpath");
            Click_Action.Btn_Click(PageObjectModal.WISE_Login_Page.WISE_Anonymous_PopUp_Commercialoption_Xpath, 4, 6, "Xpath");
           // AssertCls.AssertText(PageObjectModal.WISE_Login_Page.WISE_Anonymous_PopUp_Selection_Xpath, 12, 6, 12, 5, "CSS");
         //   Click_Action.SelectionBox_passSelection(PageObjectModal.WISE_Login_Page.WISE_Anonymous_PopUp_Selection_Xpath, 4, 6, "Xpath");
            System.out.println("Anonymous POP UI is displayed and user selected the selection!");
            ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.HomePageTitle_UIExp_Xpath, 4, 6, 4, 5,"Xpath");
        }
        
        else {
        	Thread.sleep(1000);
            driver.navigate().refresh();
            ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           // AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.HomePageTitle_Xpath, 4, 6, 4, 5,"Xpath");
            System.out.println("NO Anonymous POP UI is displayed flow will take CRM user login route to login!");
            AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.HomePageTitle_UIExp_Xpath, 4, 6, 4, 5,"Xpath");
        }
        	
        }
        catch(Exception ex) {
       	 System.out.println("Anonymous POP UI is NOT displayed and user will proceed with CRM login experiance");
        }
	}
       /*
        try {
        AssertCls.AssertText(PageObjectModal.WISE_Login_Page.WISE_Anonymous_PopUp_CSS, 12, 6, 12, 5, "CSS");
        Click_Action.Btn_Click(PageObjectModal.WISE_Login_Page.WISE_Anonymous_PopUp_Selection_Xpath, 4, 6,"Xpath");
        Click_Action.Btn_Click(PageObjectModal.WISE_Login_Page.WISE_Anonymous_PopUp_Commercialoption_Xpath, 4, 6, "Xpath");
       // AssertCls.AssertText(PageObjectModal.WISE_Login_Page.WISE_Anonymous_PopUp_Selection_Xpath, 12, 6, 12, 5, "CSS");
     //   Click_Action.SelectionBox_passSelection(PageObjectModal.WISE_Login_Page.WISE_Anonymous_PopUp_Selection_Xpath, 4, 6, "Xpath");
        System.out.println("Anonymous POP UI is displayed and user selected the selection!");
        ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.HomePageTitle_UIExp_Xpath, 4, 6, 4, 5,"Xpath");
        }
         catch(Exception ex) {
        	 System.out.println("Anonymous POP UI is NOT displayed and user will proceed with CRM login experiance");
         }
        
        finally {
        Thread.sleep(1000);
        driver.navigate().refresh();
        ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.HomePageTitle_Xpath, 4, 6, 4, 5,"Xpath");
        System.out.println("NO Anonymous POP UI is displayed flow will take CRM user login route to login!");
        AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.HomePageTitle_UIExp_Xpath, 4, 6, 4, 5,"Xpath");
        }
				
	}
	*/
	
	@Test(priority = 2)
	//@BeforeMethod
	public void SearchSKU() throws Exception
	{
		Log.startTestCase("WISE_SKU Search");
		this.driver.get(Constants.URLHome);
		// this.driver.navigate().to(Constants.URLHome);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
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
	boolean status=ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_HomePage_Page.WISE_HomePageLogo_CSS,10,6,"CSS");
	if (status==true)
	{
		System.out.println("Logo Is found on the screen and ready to click");
		Click_Action.Btn_Click(PageObjectModal.WISE_HomePage_Page.WISE_HomePageLogo_CSS, 11, 6, "CSS");
		Thread.sleep(1000);
		AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_WelcomeToWise_CSS, 11, 6, 11, 5, "CSS");
		
	}
	else
	{
		System.out.println("Logo Is NOT found on the screen and NOT ready to click");
		
	}
		
	}
	
	@Test(priority = 6)
	public void DocICSearch_ProductDocument() throws Exception
	{
		Log.startTestCase("DocICSearch_ProductDocument");
		//this.driver=driver;
		//this.driver.get(Constants.URLHome);
		// this.driver.navigate().to(Constants.URLHome);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_HomePageLogo_CSS, 10, 6, 10, 5, "CSS");
	boolean status=ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_DocDetailPage.WISE_SearchBox_Xpath,13,6,"Xpath");
	if (status==true)
	{
		System.out.println("Search box Is found on the screen and ready to enter text");
		//AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_HomePageLogo_CSS, 10, 6, 10, 5, "CSS");
		//Click_Action.Btn_Click(PageObjectModal.WISE_HomePage_Page.WISE_HomePageLogo_CSS, 10, 6, "CSS");
		Click_Action.Enter_Text(PageObjectModal.WISE_DocDetailPage.WISE_SearchBox_Xpath, 13, 6, 13, 5,"Xpath");
		Click_Action.Btn_Click(PageObjectModal.WISE_DocDetailPage.WISE_SearchMagnifier_Xpath_Generic, 13, 6,"Xpath"); 
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AssertCls.AssertText(PageObjectModal.WISE_DocDetailPage.WISE_SearchResult_ProdDoc_Xpath, 14, 6, 14, 5, "Xpath");
		//driver.close();
		//driver.quit();
	}
	else
	{
		System.out.println("Search box is not located on the screen/page");
	//	driver.close();
		//driver.quit();
		
	}
	
	}
	
	@Test(priority = 7)
	public void DocumentRendering_ProductDocument() throws Exception
	{
		Log.startTestCase("DocumentRendering_ProductDocument");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	boolean status=ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_DocDetailPage.WISE_SearchResult_ProdDoc_Xpath,13,6,"Xpath");
	if (status==true)
	{
		System.out.println("Document ID is found in the search result page and its Title to be clicked");
		Click_Action.Btn_Click(PageObjectModal.WISE_SearchResultPage.WISE_SearchResultDocTitle1_CSS, 13, 6,"CSS"); 
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  //**
	       Set<String> AllWindowHandles = driver.getWindowHandles();
	       String window1 = (String) AllWindowHandles.toArray()[0];
	       System.out.print("window1 handle code = "+AllWindowHandles.toArray()[0]);
	       String window2 = (String) AllWindowHandles.toArray()[1];
	       System.out.print("\nwindow2 handle code = "+AllWindowHandles.toArray()[1]);
	       driver.switchTo().window(window2);
	       
	       //**
		AssertCls.AssertText(PageObjectModal.WISE_DocDetailPage.WISE_DocumentTitleonDetailPage_Xpath, 15, 6, 15, 5, "Xpath");
		//boolean RatingExist=ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_DocDetailPage.WISE_ThumpsUP_CSS, 15, 6, "CSS");
		   driver.switchTo().window(window1).close();
	       driver.switchTo().window(window2);
		//driver.close();
		//driver.quit();
	}
	else
	{
		System.out.println("No document link to click has found in search result page");
		//driver.close();
	//	driver.quit();
		
	}
	}
	@Test(priority = 8)
	public void Rating_ProductDocument() throws Exception
	{
		Log.startTestCase("Rating_Product Document");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	boolean RatingExist=ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_DocDetailPage.WISE_ThumpsUP_CSS, 16, 6, "CSS");
	if (RatingExist==true)
	{
		System.out.println("Rating Icon is found on the doc detail page_product document");
		Click_Action.Btn_Click(PageObjectModal.WISE_DocDetailPage.WISE_ThumpsUP_CSS, 16, 6,"CSS"); 
		System.out.println("User has clicked on Rating -Thumbs UP Icon");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Verify_BackgroundColorClass.Verify_BackgroundColor(PageObjectModal.WISE_DocDetailPage.WISE_ThumpsUP2_Xpath, 16, 6, "Xpath", "#6BC039");
		//driver.close();
		//driver.quit();
	}
		else 
		{  
			
			System.out.println("Rating Icon is not displayed");
			assert(RatingExist);
			//driver.close();
			//driver.quit();
			
		}
		
	}
		
	@Test(priority = 9)
	public void Feedback_ProductDocument() throws Exception
	{
		Log.startTestCase("Feedback without attachment_Product Document");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Click_Action.Btn_Click(PageObjectModal.WISE_DocDetailPage.WISE_FeedbackBtn_CSS, 17, 6, "CSS");
		//driver.switchTo().activeElement();
		//driver.switchTo().
	boolean FeedbackPopUPExist=ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_DocDetailPage.WISE_FeedbackPopUP_PD_Xpath, 17, 6, "Xpath");
	if (FeedbackPopUPExist==true)
	{
		System.out.println("Feedback Pop up is displayed");
		System.out.println("Feedback has document title displayed");
		Thread.sleep(1000);
		Click_Action.Btn_Click(PageObjectModal.WISE_DocDetailPage.WISE_FeedbackPopUP_Reason_CSS, 17, 6, "CSS");
		Click_Action.Btn_Click(PageObjectModal.WISE_DocDetailPage.WISE_FeedbackPopUP_Reason_Input_Xpath, 17, 6, "Xpath");
		Click_Action.Enter_Text(PageObjectModal.WISE_DocDetailPage.WISE_FeedbackPopUP_Title_CSS, 17, 6, 17, 5, "CSS");
		Click_Action.Enter_Text(PageObjectModal.WISE_DocDetailPage.WISE_FeedbackPopUP_Detail_CSS, 17, 6, 17, 5, "CSS");
		Click_Action.Btn_Click(PageObjectModal.WISE_DocDetailPage.WISE_FeedbackPopUP_Submit_CSS, 17, 6, "CSS");
		Thread.sleep(3000);
		ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_DocDetailPage.WISE_Feedback_Success_Xpath, 17, 6, "Xpath");
	
		//can use both Assert reusable method or Page Object found- Anuj 8/6/18
		//AssertCls.AssertText(PageObjectModal.WISE_DocDetailPage.WISE_Feedback_Success_Xpath, 17, 6, 17, 5, "Xpath");
		//Click_Action.Btn_Click(PageObjectModal.WISE_DocDetailPage.WISE_FeedbackSuccessBox_X_Xpath, 17, 6, "Xpath");
		Click_Action.Btn_Click(PageObjectModal.WISE_DocDetailPage.WISE_FeedbackSuccessBox_X_CSS, 17, 6, "CSS");
		//driver.close();
		
	}
		else 
		{  
			
			System.out.println("Feedback pop up is not displayed");
			//driver.close();
			assert(FeedbackPopUPExist);
			//driver.quit();
			
		}
		
	}
	
	@Test(priority = 10)
	public void DocIDSearch_ProcessDocument() throws Exception
	{
		Log.startTestCase("DocIDSearch_ProcessDocument");
		//driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_HomePageLogo_CSS, 10, 6, 10, 5, "CSS");
	boolean status=ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_DocDetailPage.WISE_SearchBox_Xpath,18,6,"Xpath");
	if (status==true)
	{
		System.out.println("Search box Is found on the screen and ready to enter text");
		//AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_HomePageLogo_CSS, 10, 6, 10, 5, "CSS");
		//Click_Action.Btn_Click(PageObjectModal.WISE_HomePage_Page.WISE_HomePageLogo_CSS, 10, 6, "CSS");
		//utilizing the 
		Click_Action.Enter_Text(PageObjectModal.WISE_DocDetailPage.WISE_SearchBox_Xpath, 18, 6, 18, 5,"Xpath");
		Click_Action.Btn_Click(PageObjectModal.WISE_DocDetailPage.WISE_SearchMagnifier_Xpath_Generic, 18, 6,"Xpath"); 
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//using existing Xpath to Assert for process doc- WISE_SearchResult_ProdDoc_Xpath'
		AssertCls.AssertText(PageObjectModal.WISE_DocDetailPage.WISE_SearchResult_ProdDoc_Xpath, 19, 6, 19, 5, "Xpath");
		//driver.close();
		//driver.quit();
	}
	else
	{
		System.out.println("Search box is not located on the screen/page");
	//	driver.close();
		//driver.quit();
		
	}
	
	}
	
	
	
	@Test(priority = 11)
public void DocumentRendering_ProcessDocument() throws Exception
	{
		Log.startTestCase("DocumentRendering_ProcessDocument");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//Below boolean :using prod doc div place for process and manual so Xpath is same-FYI
	Thread.sleep(1000);
		boolean status=ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_DocDetailPage.WISE_SearchResult_ProdDoc_Xpath,22,6,"Xpath");
	if (status==true)
	{
		System.out.println("Document ID is found in the search result page and its Title to be clicked");
		//using same as for prod document doc title- same CSS/Xpath below line
		Click_Action.Btn_Click(PageObjectModal.WISE_SearchResultPage.WISE_SearchResultDocTitle1_CSS, 22, 6,"CSS"); 
	  
		Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  //**
	       Set<String> AllWindowHandles = driver.getWindowHandles();
	       String window1 = (String) AllWindowHandles.toArray()[0];
	       System.out.print("window1 handle code = "+AllWindowHandles.toArray()[0]);
	       String window2 = (String) AllWindowHandles.toArray()[1];
	       System.out.print("\nwindow2 handle code = "+AllWindowHandles.toArray()[1]);
	       //String window3=(String) AllWindowHandles.toArray()[2];
	      // System.out.print("\nwindow2 handle code = "+AllWindowHandles.toArray()[2]);
	       driver.switchTo().window(window2); 
	      // cd v
	       //**
	       //Using same Xpath for document detail page title- generic below line-FYI
		AssertCls.AssertText(PageObjectModal.WISE_DocDetailPage.WISE_DocumentTitleonDetailPage_Xpath, 22, 6, 22, 5, "Xpath");
		//boolean RatingExist=ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_DocDetailPage.WISE_ThumpsUP_CSS, 15, 6, "CSS");
		   driver.switchTo().window(window1).close();
		   //driver.switchTo().window(window1).close();
	       driver.switchTo().window(window2);
		//driver.close();
		//driver.quit();
	}
	else
	{
		System.out.println("No document link to click has found in search result page");
		//driver.close();
	//	driver.quit();
		
	}
	
	}	
	@Test(priority = 12)
	public void DocIDSearch_ManualDocument() throws Exception
	{
		Log.startTestCase("DocIDSearch_ManualDocument");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	//AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_HomePageLogo_CSS, 10, 6, 10, 5, "CSS");
	boolean status=ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_DocDetailPage.WISE_SearchBox_Xpath, 20, 6,"Xpath");
	if (status==true)
	{
		System.out.println("Search box Is found on the screen and ready to enter text");
		//AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_HomePageLogo_CSS, 10, 6, 10, 5, "CSS");
		//Click_Action.Btn_Click(PageObjectModal.WISE_HomePage_Page.WISE_HomePageLogo_CSS, 10, 6, "CSS");
		//utilizing the 
		Click_Action.Enter_Text(PageObjectModal.WISE_DocDetailPage.WISE_SearchBox_Xpath, 20, 6, 20, 5,"Xpath");
		Click_Action.Btn_Click(PageObjectModal.WISE_DocDetailPage.WISE_SearchMagnifier_Xpath_Generic, 20, 6,"Xpath"); 
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//using existing Xpath to Assert for process doc- WISE_SearchResult_ProdDoc_Xpath'
		AssertCls.AssertText(PageObjectModal.WISE_DocDetailPage.WISE_SearchResult_ProdDoc_Xpath, 21, 6, 21, 5, "Xpath");
		//driver.close();
		//driver.quit();
	}
	else
	{
		System.out.println("Search box is not located on the screen/page");
	   //  driver.close();
		 //driver.quit();
		
	}
	
	}
	
	@Test(priority = 13)
    public void DocumentRendering_ManualDocument() throws Exception
	{
		Log.startTestCase("DocumentRendering_ProcessDocument");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.switchTo().defaultContent();
	//Below boolean :using prod doc div place for process and manual so Xpath is same-FYI
	boolean status=ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_DocDetailPage.WISE_SearchResult_ProdDoc_Xpath,23,6,"Xpath");
	if (status==true)
	{
		System.out.println("Document ID is found in the search result page and its Title to be clicked");
		//using same as for prod document doc title- same CSS/Xpath below line
		Click_Action.Btn_Click(PageObjectModal.WISE_SearchResultPage.WISE_SearchResultDocTitle1_CSS, 23, 6,"CSS"); 
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//**
		   Set<String> AllWindowHandles = driver.getWindowHandles();
	       String window1 = (String) AllWindowHandles.toArray()[0];
	       System.out.print("window1 handle code = "+AllWindowHandles.toArray()[0]);
	       String window2 = (String) AllWindowHandles.toArray()[1];
	       System.out.print("\nwindow2 handle code = "+AllWindowHandles.toArray()[1]);
	     //String window3 = (String) AllWindowHandles.toArray()[2];
	       //System.out.print("\nwindow2 handle code = "+AllWindowHandles.toArray()[2]);
	   	driver.switchTo().window(window2);
	    //driver.switchTo().window(window2).close();
	      // driver.switchTo().window(window3);
	       
	       //**
	       //For manual Xpath/CSS for manual doc which is PDP will change -FYI
	       AssertCls.Compare_BrowserURL(23, 6, 23, 5);
		//AssertCls.AssertText(PageObjectModal.WISE_DocDetailPage.WISE_DocumentTitleonDetailPage_Xpath, 22, 6, 22, 5, "Xpath");
		//boolean RatingExist=ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_DocDetailPage.WISE_ThumpsUP_CSS, 15, 6, "CSS");
	
	    //driver.switchTo().window(window3).close();
	   // driver.switchTo().window(window3);
	    driver.switchTo().window(window2).close();
	    driver.switchTo().window(window1);
	    
		//driver.switchTo().defaultContent();
		//driver.quit();
	}
	else
	{
		System.out.println("No Manual document link to click has found in search result page");
		//driver.close();
	//	driver.quit();
		
	}
	
	}	
    
	@Test(priority = 14)
	public void Rating_ProcessDocument() throws Exception
	{
		Log.startTestCase("Rating_Process Document");
		//driver.close();
		driver.navigate().to(UtilitiesHelper.Constants.URL_FeedbackRating_ProcessURL);
		//driver.navigate().to("https://uat.support.hp.com/wise/DocumentDetail/ams-en?docId=c04110219&contentType=Process%20Document");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	boolean RatingExist=ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_DocDetailPage.WISE_ThumpsUP_CSS, 24, 6, "CSS");
	if (RatingExist==true)
	{
		System.out.println("Rating Icon is found on the doc detail page_product document");
		Click_Action.Btn_Click(PageObjectModal.WISE_DocDetailPage.WISE_ThumpsUP_CSS, 24, 6,"CSS"); 
		System.out.println("User has clicked on Rating -Thumbs UP Icon");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Verify_BackgroundColorClass.Verify_BackgroundColor(PageObjectModal.WISE_DocDetailPage.WISE_ThumpsUP2_Xpath, 24, 6, "Xpath", "#6BC039");
		//driver.close();
		//driver.quit();
		
	}
		else 
		{  
			
			System.out.println("Rating Icon is not displayed");
			assert(RatingExist);
			//driver.close();
			//driver.quit();
			
		}
		
	}
	@Test(priority = 15)
	public void Feedback_ProcessDocument() throws Exception
	{
		Log.startTestCase("Feedback without attachment_Product Document");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Click_Action.Btn_Click(PageObjectModal.WISE_DocDetailPage.WISE_FeedbackBtn_CSS, 25, 6, "CSS");
		//driver.switchTo().activeElement();
		//driver.switchTo().
	boolean FeedbackPopUPExist=ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_DocDetailPage.WISE_FeedbackPopUP_PD_Xpath, 17, 6, "Xpath");
	if (FeedbackPopUPExist==true)
	{
		System.out.println("Feedback Pop up is displayed");
		System.out.println("Feedback has document title displayed");
		Thread.sleep(1000);
		Click_Action.Btn_Click(PageObjectModal.WISE_DocDetailPage.WISE_FeedbackPopUP_Reason_CSS, 25, 6, "CSS");
		Click_Action.Btn_Click(PageObjectModal.WISE_DocDetailPage.WISE_FeedbackPopUP_Reason_Input_Xpath, 25, 6, "Xpath");
		Click_Action.Enter_Text(PageObjectModal.WISE_DocDetailPage.WISE_FeedbackPopUP_Title_CSS, 25, 6, 17, 5, "CSS");
		Click_Action.Enter_Text(PageObjectModal.WISE_DocDetailPage.WISE_FeedbackPopUP_Detail_CSS, 25, 6, 17, 5, "CSS");
		Click_Action.Btn_Click(PageObjectModal.WISE_DocDetailPage.WISE_FeedbackPopUP_Submit_CSS, 25, 6, "CSS");
		Thread.sleep(3000);
		ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_DocDetailPage.WISE_Feedback_Success_Xpath, 25, 6, "Xpath");
	
		//can use both Assert reusable method or Page Object found- Anuj 8/6/18
		//AssertCls.AssertText(PageObjectModal.WISE_DocDetailPage.WISE_Feedback_Success_Xpath, 17, 6, 17, 5, "Xpath");
		//Click_Action.Btn_Click(PageObjectModal.WISE_DocDetailPage.WISE_FeedbackSuccessBox_X_Xpath, 17, 6, "Xpath");
		Click_Action.Btn_Click(PageObjectModal.WISE_DocDetailPage.WISE_FeedbackSuccessBox_X_CSS, 17, 6, "CSS");
		//driver.close();	
	}
		else 
		{  
			
			System.out.println("Feedback pop up is not displayed");
			assert(FeedbackPopUPExist);
			//driver.close();
			
		}
	
	}
	@Test(priority = 16)
	public void Search_ByProductTerm_ProdContext() throws Exception
	{
		Log.startTestCase("Search_ByProductTerm_ProdContext");
		this.driver.get(Constants.URLHome);
		// this.driver.navigate().to(Constants.URLHome);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		Thread.sleep(1000);
     //utilizing the existing X path as used in above scripts for SKU search/PDP
       ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
              
       Click_Action.Enter_Text(PageObjectModal.WISE_HomePage_Page.WISE_SearchBox, 26, 6, 26, 5,"Xpath");
       Click_Action.Btn_Click(PageObjectModal.WISE_HomePage_Page.WISE_SearchMagnifier, 26, 6,"Xpath");   
       AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_SearchPDPLink, 27, 6, 27, 5,"Xpath");
       Thread.sleep(1000);
       //driver.navigate().forward();
				
	}	
	
	@Test(priority = 17)
	public void Verify_PDPImage() throws Exception
	{
	
	   Log.startTestCase("Verify_PDPImage started");
       Click_Action.Btn_Click(PageObjectModal.WISE_HomePage_Page.WISE_SearchPDPLink, 28, 6,"Xpath");
       Thread.sleep(1000);
       ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_PDPPage_Page.PDP_Image_Xpath, 28, 6, "Xpath");
       
       //**
       Set<String> AllWindowHandles = driver.getWindowHandles();
       String window1 = (String) AllWindowHandles.toArray()[0];
       System.out.print("window1 handle code = "+AllWindowHandles.toArray()[0]);
       String window2 = (String) AllWindowHandles.toArray()[1];
       System.out.print("\nwindow2 handle code = "+AllWindowHandles.toArray()[1]);
       driver.switchTo().window(window2);
         
     //  AssertCls.AssertText(PageObjectModal.WISE_PDPPage_Page.PDP_Image_Xpath, 28, 6, 28, 5,"Xpath");
       ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_PDPPage_Page.PDP_Image_Xpath, 28, 6, "Xpath");
       driver.switchTo().window(window1).close();
       driver.switchTo().window(window2);
       
       Log.endTestCase("Verify_PDPImage ends");
		
				
	}
	@Test(priority = 18)
	public void Verify_Tool_Display() throws Exception
	{
	
	   Log.startTestCase("Verify_ToolDisplay started");
	  // driver.switchTo().defaultContent();
	   Thread.sleep(1000);
       
	   //Click_Action.Btn_Click(PageObjectModal.WISE_HomePage_Page.WISE_SearchPDPLink, 28, 6,"Xpath");
	  ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_Tool_CSS, 29, 6, 29, 5,"CSS");
    //  ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_PDPPage_Page.PDP_Image_Xpath, 28, 6, "Xpath");
       Log.endTestCase("Verify_ToolDisplay ends");
					
	}	
	@Test(priority = 19)
	public void Verify_Link_Display() throws Exception
	{
	
	   Log.startTestCase("Verify_Link_Display started");
	   Thread.sleep(1000);
	    ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   //Click_Action.Btn_Click(PageObjectModal.WISE_HomePage_Page.WISE_SearchPDPLink, 28, 6,"Xpath");
               
      AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_Link_CSS, 30, 6, 30, 5,"CSS");
    //  ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_PDPPage_Page.PDP_Image_Xpath, 28, 6, "Xpath");
       Log.endTestCase("Verify_Link_Display ends");
      					
	}	
	@Test(priority = 20)
	//@BeforeMethod
	public void UIExperiance_Toogle() throws Exception
	{
		Log.startTestCase("UIExperiance_Toogle starts");
		this.driver.get(Constants.URLHome);
		// this.driver.navigate().to(Constants.URLHome);
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
     
      ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_HomePage_Page.HomePageTitle_UIExp_Xpath, 31, 6, "Xpath");
     // AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.HomePageTitle_UIExp_Xpath, 31, 6, 31, 5,"Xpath");
      //Below immediate next line use for object identifcation untill its present -expicit wait condition
    // WebElement emp=(new WebDriverWait(driver,20)).until(ExpectedCOnditions.presenceOfElementLocated(By.xpath);
      Click_Action.Btn_Click(PageObjectModal.WISE_HomePage_Page.HomePageTitle_UIExp_Xpath, 31, 6, "Xpath");
      ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.HomePageTitle_UIExp_Consumer_Drop_Xpath, 32, 6, 32, 5, "Xpath");
      Click_Action.Btn_Click(PageObjectModal.WISE_HomePage_Page.HomePageTitle_UIExp_Consumer_Drop_Xpath, 32, 6, "Xpath");
      //ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      Thread.sleep(1000);
      AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.HomePageTitle_UIExp_Xpath, 33, 6, 33, 5, "Xpath");
      Thread.sleep(1000);
      //toggle back to commercial
      Click_Action.Btn_Click(PageObjectModal.WISE_HomePage_Page.HomePageTitle_UIExp_Xpath, 34, 6, "Xpath");
      ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.HomePageTitle_UIExp_Commercial_Drop_Xpath, 34, 6, 34, 5, "Xpath");
      Click_Action.Btn_Click(PageObjectModal.WISE_HomePage_Page.HomePageTitle_UIExp_Commercial_Drop_Xpath, 34, 6, "Xpath");
      ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      Thread.sleep(1000);
      AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.HomePageTitle_UIExp_Xpath, 34, 6, 34, 5, "Xpath");
      Log.endTestCase("UIExperiance_Toogle ends");
      		
	}
	
	@Test(priority = 21)
	public void Verify_ProcessTab_Display() throws Exception
	{
	
	   Log.startTestCase("Verify_ProcessTab_Display started");
	   Thread.sleep(1000);
	    ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   //Click_Action.Btn_Click(PageObjectModal.WISE_HomePage_Page.WISE_SearchPDPLink, 28, 6,"Xpath");
               
      AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_ProcessTab_Xpath, 35, 6, 35, 5,"Xpath");
    //  ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_PDPPage_Page.PDP_Image_Xpath, 28, 6, "Xpath");
       Log.endTestCase("Verify_ProcessTab_Display ends");
}
	@Test(priority = 22)
	public void Verify_ProductTab_Display() throws Exception
	{
	
	   Log.startTestCase("Verify_ProductTab_Display started");
	   Thread.sleep(1000);
	    ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   //Click_Action.Btn_Click(PageObjectModal.WISE_HomePage_Page.WISE_SearchPDPLink, 28, 6,"Xpath");
               
      AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_ProductTab_Xpath, 36, 6, 36, 5,"Xpath");
    //  ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_PDPPage_Page.PDP_Image_Xpath, 28, 6, "Xpath");
       Log.endTestCase("Verify_ProductTab_Display ends");
}
	@Test(priority = 23)
	public void Verify_HPLogo_Display() throws Exception
	{
	
	   Log.startTestCase("Verify_HPLogo_Display started");
	   Thread.sleep(1000);
	    ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	                
     // AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_HPLogo_Xpath, 36, 6, 36, 5,"Xpath");
      ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_HomePage_Page.WISE_HPLogo_Xpath, 37, 6, "Xpath");
      Log.endTestCase("Verify_HPLogo_Display ends");
}
	
	@Test(priority = 24)
	public void Verify_FooterSection_Displayed() throws Exception
	{
	
	   Log.startTestCase("Verify_FooterSection_Displayed started");
	   Thread.sleep(1000);
	    ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	                 
      //AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_Footer_Xpath, 38, 6, 38, 5,"Xpath");
      ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_HomePage_Page.WISE_HPLogo_Xpath, 38, 6, "Xpath");
        Log.endTestCase("Verify_FooterSection_Displayed ends");
}
	@Test(priority = 25)
	public void Verify_SitMap_Displayed() throws Exception
	{
	
	   Log.startTestCase("Verify_SitMap_Displayed started");
	   Thread.sleep(1000);
	    ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   //Click_Action.Btn_Click(PageObjectModal.WISE_HomePage_Page.WISE_SearchPDPLink, 28, 6,"Xpath");
               
      AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_Footer_SiteMap_Xpath, 39, 6, 39, 5,"Xpath");
     // ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_HomePage_Page.WISE_HPLogo_Xpath, 39, 6, "Xpath");
    
       Log.endTestCase("Verify_SitMap_Displayed ends");
}
	@Test(priority = 26)
	public void Verify_TermOfUse_Displayed() throws Exception
	{
	
	   Log.startTestCase("Verify_TermOfUse_Displayed started");
	   Thread.sleep(1000);
	    ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   //Click_Action.Btn_Click(PageObjectModal.WISE_HomePage_Page.WISE_SearchPDPLink, 28, 6,"Xpath");
               
      AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_Footer_TermOfUse_Xpath, 40, 6, 40, 5,"Xpath");
    //  ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_HomePage_Page.WISE_HPLogo_Xpath, 40, 6, "Xpath");
   
       Log.endTestCase("Verify_TermOfUse_Displayed ends");
}
	@Test(priority = 27)
	public void Verify_PrivacyLink_Displayed() throws Exception
	{
	
	   Log.startTestCase("Verify_PrivacyLink_Displayed started");
	   Thread.sleep(1000);
	    ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   //Click_Action.Btn_Click(PageObjectModal.WISE_HomePage_Page.WISE_SearchPDPLink, 28, 6,"Xpath");
               
      AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_Footer_Privacy_Xpath, 41, 6, 41, 5,"Xpath");
    //  ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_HomePage_Page.WISE_HPLogo_Xpath, 41, 6, "Xpath");
      Log.endTestCase("Verify_PrivacyLink_Displayed ends");
}
	@Test(priority = 28)
	public void Verify_Copyright_Displayed() throws Exception
	{
	
	   Log.startTestCase("Verify_Copyright_Displayed started");
	   Thread.sleep(1000);
	    ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   //Click_Action.Btn_Click(PageObjectModal.WISE_HomePage_Page.WISE_SearchPDPLink, 28, 6,"Xpath");
               
       AssertCls.AssertText(PageObjectModal.WISE_HomePage_Page.WISE_Footer_Copyright_Xpath, 42, 6, 42, 5,"Xpath");
     // ObjectFound.ObjectFoundOnThePage(PageObjectModal.WISE_HomePage_Page.WISE_HPLogo_Xpath, 42, 6, "Xpath");
      Log.endTestCase("Verify_Copyright_Displayed ends");
      //driver.close();
      
}
	
	@Test(priority = 29)
	public void Verify_ProdutBuilder_TMS() throws Exception
	{
	//****USING page Factory*****
		
	   Log.startTestCase("Verify_ProdutBuilder_TMS started");
	//LoginToWise();
	  // this.driver.get(Constants.URLHome);
	   //Thread.sleep(1000);
	   
	    //ExcelUtility.getWebDriverfor().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   //Click_Action.Btn_Click(PageObjectModal.WISE_ProductBuilder., 43, 6,"ID");
	  //  PageFactory.initElements(driver, PageObjectModal.WISE_ProductBuilder.class);
         //**Actions_PageFactory PageFactObj=new Actions_PageFactory();
         PageObjectModal.WISE_ProductBuilder cc=PageFactory.initElements(driver, PageObjectModal.WISE_ProductBuilder.class);
         Thread.sleep(1000);
        
        ReusableLibraryActions.Actions_PageFactory.buttonClick_PageFactory(cc.ProductLink, 43, 6);
        ReusableLibraryActions.Actions_PageFactory.Assert_PageFactory(cc.HpPrinterListBoxItem1, 44, 6, 44, 5);
        JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("window.scrollBy(0,100)");
		  Thread.sleep(1000);
        ReusableLibraryActions.Actions_PageFactory.buttonClick_PageFactory(cc.HpPrinterListBoxItem1, 45, 6);
       
       /* if(cc.ProductLink.isDisplayed())
        		{
        	Wait_ElementToBeClickable.CustomExplicitWait(cc.ProductLink, 20,driver);
        	cc.ProductLink.click();
       Thread.sleep(4000);
       System.out.pri444nt("Prod link is displayed="+cc.ProductLink.getText());
     //  ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
       ExcelUtility.setCellData("Passed", 43, 6, "Pass");
        		}
        else
        { System.out.print("Prod link is NOT displayed");
        //ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
           ExcelUtility.setCellData("Failed", 43, 6, "Fail");}
     // ReusableLibraryActions.Actions_PageFactory.buttonClick_PageFactory(cc.ProductLink, 43, 6); */
      Log.endTestCase("Verify_ProdutBuilder_TMS ends");
      //driver.close();
      
}
	
}
