package PageObjectModal;

import org.openqa.selenium.WebElement;

public class WISE_Login_Page {
	
	//Login has three process 1-3
	/*1. On page load navigates to https://login.external.hp.com/idp/startSSO.ping?PartnerSpId=https://uat.support.hp.com/sp
	CLick on email and computer password link
	*/
	//1. Xpath for EMail and Computer password link
	private static WebElement element = null;
	public static  String Email_CompLink_Xpath ="//a[contains(text(),'Email & Computer Password')]";
	
	//2. Navigated page- enter usn and pwd
	
	public static  String WISE_USN_ID ="username";
	public static  String WISE_USN_Xpath ="//input[@id='username']";
	//xpatch://input[@id='username']
	//pwd
	public static  String WISE_PWD_ID ="password";
	public static  String WISE_PWD_Xpath ="//input[@id='password']";
	public static  String WISE_SignOn_Xpath ="//input[@class='btn btn-primary']";
	
	//3.user is logged in
	
	
}
