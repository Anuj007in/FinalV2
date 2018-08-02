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
	
	//UI pop up -anonymous pop up title
	public static  String WISE_Anonymous_PopUp_Xpath ="/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[1]/section/div[2]/div[8]/div/div/div/div/h3";
	public static  String WISE_Anonymous_PopUp_CSS ="div.modal-title:nth-child(2) > h3:nth-child(1)";
	//UI pop up -anonymous pop up selection
		public static  String WISE_Anonymous_PopUp_Selection_Xpath ="//*[@id=\"wiseExperience_dd_headerValue\"]";
		public static  String WISE_Anonymous_PopUp_Selection_CSS ="#wiseExperience_dd_headerValue";
		public static String WISE_Anonymous_PopUp_Commercialoption_Xpath="//*[@id=\"wiseExperience_dd_list\"]/li[1]/a";
	
}
