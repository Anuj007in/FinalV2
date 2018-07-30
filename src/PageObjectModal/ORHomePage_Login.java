package PageObjectModal;

import org.openqa.selenium.By;
import UtilitiesHelper.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ORHomePage_Login {
	
	private static WebElement element = null;
	public static  String WebSignInBtn ="//*[@id='gb_70']";
	public static  String NextButton ="//*[@id='next']"; 
	public static  String SignINButton ="//*[@id='signIn']";
	public static String UserNameBox= "//*[@id='Email']";
	public static String PasswordBox= "//*[@id='Passwd']";
	
	//Test Case 01- Series Search
	//html/body/div[1]/div[1]/div[2]/div/div[3]/div/div[3]/div/div/div[2]/section/div[2]/div[2]/div/div[1]/h2/text()
	public static  String HomePageHPLogo ="//a[@href='http://www8.hp.com/us/en/home.html']";
    public static  String HomePageSEarchTextBox ="(//input[@id='search-input'])[2]";
    //public static String HomePageSEarchTextBox= ".//*[@id='search-input']";
	public static  String HomePageSearchBtn ="(//button[@id='btnSplitSearchSubmit'])[2]";
	//public static  String SeriesTextLabel ="html/body/div[1]/div[1]/div[2]/div/div[3]/div/div[3]/div/div/div[2]/section/div[2]/div[2]/div/div[1]/h2/text()";
	public static  String SeriesTextLabel ="//div/div/h2";
	public static String ModalTextLabel="//div/div/h2";
		
	public static  WebElement WebSignInBtn(WebDriver driver)
	
	{
			
		element=driver.findElement(By.id("gb_70"));
		return element;
		
	}
	
  public static WebElement UserNameBox(WebDriver driver)
{
 element=driver.findElement(By.xpath("//*[@id='Email']"));
		 
 return element;
 
}
  public static WebElement NextBtnLogin(WebDriver driver)
  {
	  element= driver.findElement(By.xpath("//*[@id='next']"));
	  return element;
  }
	 
  public static WebElement PasswordBox(WebDriver driver)
  {
	  element= driver.findElement(By.xpath("//*[@id='Passwd']"));
	  return element;
  }
  
  public static WebElement SignInBtn(WebDriver driver)
  {
	  element= driver.findElement(By.xpath("//*[@id='signIn']"));
	  return element;
  }
  
  public static WebElement VerifyloggedIn(WebDriver driver)
  {
	  element=driver.findElement(By.xpath("//*[@id='lst-ib']"));
	  return element;
  }
 /* public class ORHomePage_HPPPSHomePage {
		
		
		public static  String HomePageHPLogo ="//a[@href='http://www8.hp.com/us/en/home.html']";
		public static  String HomePageSEarchTextBox ="//form[@id='original-support']/div[2]/input";
		public static  String HomePageSearchBtn ="(//button[@id='btnSplitSearchSubmit'])[2]";
		//xpath=(//button[@id='btnSplitSearchSubmit'])[2]
  }
  */
}
