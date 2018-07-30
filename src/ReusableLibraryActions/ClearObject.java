package ReusableLibraryActions;
import PageObjectModal.ORHomePage_Login;
import PageObjectModal.SearchTextPage;
import java.util.concurrent.TimeUnit;
import Helper.GetElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import UtilitiesHelper.Constants;
import UtilitiesHelper.ExcelUtility;
import org.testng.annotations.Test;
import Helper.GetElement;
//Author: Anuj Sharma
public class ClearObject {
	public static WebElement element= null;
	@Test
  public static void ClearTextField(String TextFieldObjectID,int a,int b,String ObjIdentifier) throws Exception {
	  
	  try{
		  //for non mandatory failure message handle by passing some other column to captre failure- work to make getelement
		  //to accept optional parameter
	  WebElement webElement = GetElement.getWebElement(TextFieldObjectID,2,7,ObjIdentifier); 
	 // webElement.clear();
	  webElement.sendKeys(Keys.CONTROL + "a");
	  webElement.sendKeys(Keys.DELETE);
	  String x=webElement.getClass().toString();
	  System.out.println(x.toString());
	  }
	  catch(Exception ex)
	  {
		  System.out.println("Text Field is NOT Cleared!- object is not found!");
		  ex.getMessage();
	  }
  }
}
