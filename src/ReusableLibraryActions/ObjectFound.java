package ReusableLibraryActions;

import java.util.NoSuchElementException;

import javax.swing.JFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Helper.GetElement;
import UtilitiesHelper.ExcelUtility;

public class ObjectFound {
	
	//public static WebElement ObjectFoundOnThePage(String TextFieldObjectID,String Objidentifier) throws Exception {
		public static boolean ObjectFoundOnThePage(String TextFieldObjectID,int a, int b,String Objidentifier) throws Exception {
		WebElement webElement= null;
		JFrame parent = new JFrame();
		//WebElement webElement= new WebElement();
		 WebDriver driver= ExcelUtility.getWebDriverfor();
			try{
				if(Objidentifier=="Xpath")
				{
			       webElement=driver.findElement(By.xpath(TextFieldObjectID));
			       boolean exist=true;
				}
				else if(Objidentifier=="ID")
				{
					webElement=driver.findElement(By.id(TextFieldObjectID));
					boolean exist=true;
				}
				else if(Objidentifier=="CSS")
				{
					webElement=driver.findElement(By.cssSelector(TextFieldObjectID));
					boolean exist=true;
				}
				else if(Objidentifier=="Class")
				{
					webElement=driver.findElement(By.className(TextFieldObjectID));
					boolean exist=true;
				}
				System.out.println("Webelement is"+webElement+"Found on the page");
				ExcelUtility.setCellData("Passed", a, b,"Pass");
				return true;
				
				
			}
			  catch(NoSuchElementException ex)
			  {
				  boolean exist=false;
				  System.out.println("Webelement is not Found on the page");
				  ex.printStackTrace();
				 ExcelUtility.setCellData("Failed", a, b,"Fail");
			  }
			return false;
			}
}
