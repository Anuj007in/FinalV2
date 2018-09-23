package Report_extnt;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.ITestResult;
import org.testng.SkipException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;

//import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.sun.jna.platform.FileUtils;

public class ExtentReportsClass {
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	
	@BeforeTest
	public void startReport(){
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/STMExtentReport.html");
		extent = new ExtentReports ();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Deloitte-ClientTest");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "Anuj kumar Sharma");
		
		htmlReporter.config().setDocumentTitle("Automation Testing Report-ExtetReport");
		htmlReporter.config().setReportName("TestAUtomation-Deloitte");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		System.out.println("Test from extentRepo bt");
	}
		
	//This method is to capture the screenshot and return the path of the screenshot.
	 
	 public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
	 String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	 TakesScreenshot ts = (TakesScreenshot) driver;
	 File source = ts.getScreenshotAs(OutputType.FILE);
	                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
	 String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
	 File finalDestination = new File(destination);
	 FileUtils.copyFile(source, finalDestination);
	 return destination;
	 }
	 
	@Test
	public void passTest(){
		logger = extent.createTest("passTest");
		Assert.assertTrue(true);
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
	}
	
	@Test
	public void failTest(){
		logger = extent.createTest("failTest");
		Assert.assertTrue(false);
		logger.log(Status.PASS, "Test Case (failTest) Status is passed");
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case (failTest) Status is passed", ExtentColor.GREEN));
	}
	
	@Test
	public void skipTest(){
		logger = extent.createTest("skipTest");
		throw new SkipException("Skipping - This is not ready for testing ");
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception{
		if(result.getStatus() == ITestResult.FAILURE){
			//logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
			//MarkupHelper is used to display the output in different colors
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			
			String screenshotPath = ExtentReportsClass.getScreenshot(driver, result.getName());
			 //To add it in the extent report 
			// logger.log(Status.FAIL, logger.addScreenCapture(screenshotPath));
			 logger.log(Status.FAIL, (Markup) logger.addScreenCaptureFromPath(screenshotPath));
		}else if(result.getStatus() == ITestResult.SKIP){
			//logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));	
		}
	}
	@AfterTest
	public void endReport(){
		extent.flush();
    }
	/*
	//ExtentReports extent;
	//ExtentReporter extent;
	ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Report_Extent/rep.html");
	ExtentReports extent=new ExtentReports();
   // extent.
	
	//ExtentTest logger;
	//use extent report 3- https://www.youtube.com/watch?v=WdenIgyGDyw
	@BeforeTest
	public void startTest()
	{
		//extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html",true);
     extent=new ExtentReports(System.getProperty("C:/Users/anujksharma/Documents/Eclipse_Workspace/UI_AUtomation_Selenium/test-output/ExtentReport.html"));
	//	extent= new ExtentReports("C:\\Users\\anujksharma\\Documents\\Eclipse_Workspace\\UI_AUtomation_Selenium\\test-output\\ExtentReport.html");
		//extent= new ExtentReports("./ExtentReport.html");
		//extent=new ExtentReports("uri.prop","./ExtentReport.html");
		//extent.addSystemInfo("Environment","Environment Name")
				extent
		                .addSystemInfo("Host Name", "AutomationTest Result")
		                .addSystemInfo("Environment", "HP Automation Testing")
		                .addSystemInfo("User Name", "Anuj Sharma");
		                //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
		                //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
		                extent.loadConfig(new File(System.getProperty("user.dir")+"//extent-config.xml"));
	}
	
	@Test
	public void passTest(){
		//extent.startTest("TestCaseName", "Description")
		//TestCaseName – Name of the test
		//Description – Description of the test
		//Starting test
		logger = extent.startTest("passTest");
		Assert.assertTrue(true);
		//To generate the log when the test case is passed
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
	}
	
	@Test
	public void failTest(){
		logger = extent.startTest("failTest");
		Assert.assertTrue(false);
		logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
		//logger.log(LogStatus.FAIL, details)
	}
	
	@Test
	public void skipTest(){
		logger = extent.startTest("skipTest");
		throw new SkipException("Skipping - This is not ready for testing ");
	}
	
	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
		extent.endTest(logger);
	}
	@AfterTest
	public void endReport(){
		// writing everything to document
		//flush() - to write or update test information to your report. 
                extent.flush();
                //Call close() at the very end of your session to clear all resources. 
                //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
                //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
                //Once this method is called, calling any Extent method will throw an error.
                //close() - To close all the operation
                extent.close();
    }
	*/
}


