package ReusableLibraryActions;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Helper.GetElement;
import UtilitiesHelper.ExcelUtility;

public class ObjectFound {
	
	//public static WebElement ObjectFoundOnThePage(String TextFieldObjectID,String Objidentifier) throws Exception {
		public static boolean ObjectFoundOnThePage(String TextFieldObjectID,int a, int b,String Objidentifier) throws Exception
		{
		WebElement webElement= null;
		//JFrame parent = new JFrame();
		//WebElement webElement= new WebElement();
		 WebDriver driver= ExcelUtility.getWebDriverfor();
		 ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
		// ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
		// boolean exist;
		try{
				if(Objidentifier=="Xpath")
				{
			        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					webElement=driver.findElement(By.xpath(TextFieldObjectID));
			        boolean exist= webElement.isDisplayed();
			            if(exist==true)
			               {
			                   System.out.println("Webelement is"+webElement+"Found on the page");
					           ExcelUtility.setCellData("Passed", a, b,"Pass");
					           Assert.assertTrue(exist, "Assert WebElement object is found-check Xpath or Object is not displayed on the Page!");
								
					         //  assert(true);
					          
			               }
			           return true; 
			      
				}
				
			    /*   else {
			    	   System.out.println("Webelement is NOT Found on the page");
						ExcelUtility.setCellData("Failed", a, b,"Fail");
			            }
				return false;
				} */
				else if(Objidentifier=="ID")
				{
					driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
					webElement=driver.findElement(By.id(TextFieldObjectID));
				       boolean exist= webElement.isDisplayed();
				       if(exist==true)
				       {
				       System.out.println("Webelement is"+webElement+"Found on the page");
						ExcelUtility.setCellData("Passed", a, b,"Pass");
						 Assert.assertTrue(exist, "Assert WebElement object is found-check Xpath or Object is not displayed on the Page!");
							
				       }
						return true;
				
						/*else {
							System.out.println("Webelement is NOT Found on the page");
							ExcelUtility.setCellData("Failed", a, b,"Fail");
							return false;
						}*/
				}
				
				else if(Objidentifier=="CSS")
				{
					driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					webElement=driver.findElement(By.cssSelector(TextFieldObjectID));
				       boolean exist= webElement.isDisplayed();
				       if(exist==true)
				       {
				       System.out.println("Webelement is"+webElement+"Found on the page");
						ExcelUtility.setCellData("Passed", a, b,"Pass");
						 Assert.assertTrue(exist, "Assert WebElement object is found-check Xpath or Object is not displayed on the Page!");
							
						//assert(true);
				       }
						return true;
				}
				else if(Objidentifier=="Class")
				{
					driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
					webElement=driver.findElement(By.xpath(TextFieldObjectID));
				       boolean exist= webElement.isDisplayed();
				       if(exist==true)
				       {
				       System.out.println("Webelement is"+webElement+"Found on the page");
						ExcelUtility.setCellData("Passed", a, b,"Pass");
						 Assert.assertTrue(exist, "Assert WebElement object is found-check Xpath or Object is not displayed on the Page!");
							
				       }
						return true;
				}
							
			/*	else
				{
					//boolean exist=false;
					
					System.out.println("Xpath/CSS/Class/ID may not matched-Webelement is not Found on the page");
					  //ex.printStackTrace();
					 ExcelUtility.setCellData("Failed", a, b,"Fail");
					 return false;
					 
				}*/
				  return true;
				 	
		}
	catch(Exception ex)
			{
				//boolean exist=false;
				//assert(exist);
		        
				System.out.println("Webelement is not Found on the page hence Object is Not found!");
				ex.printStackTrace();
				ExcelUtility.setExcelFile(UtilitiesHelper.Constants.Path_TestData, "Sheet1");
				ExcelUtility.setCellData("Failed", a, b,"Fail");
				
			}
		return false;	
		}
			
		}
			
				
			
			/*  catch(NoSuchElementException ex)
			  {
				  boolean exist=false;
				  System.out.println("Webelement is not Found on the page");
				  ex.printStackTrace();
				 ExcelUtility.setCellData("Failed", a, b,"Fail");
				 return false;
			  } */
			//return false;
			

