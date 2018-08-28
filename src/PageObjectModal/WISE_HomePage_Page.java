package PageObjectModal;

import org.openqa.selenium.WebElement;
//Author: Anuj Sharma

public class WISE_HomePage_Page {
	
	private static WebElement element = null;
	//welcome to wise  
	public static  String HomePageTitle_Xpath ="//div[@class='searchWrapper']/div[@class='searchHeader']";
	public static  String HomePageTitle_ClassName ="searchHeader";
	public static  String HomePageTitle_UIExp_Xpath ="//*[@id=\"header\"]/div/div[3]/li/div/a/span";
	public static String HomePageTitle_UIExp_Consumer_Drop_CSS="li.changeAgentExperienceConsumer:nth-child(2) > a:nth-child(1)";
	public static String HomePageTitle_UIExp_Consumer_Drop_Xpath="//*[@id=\"header\"]/div/div[3]/li/div/ul/li[2]/a";
	public static String HomePageTitle_UIExp_Commercial_Drop_Xpath="//*[@id=\"header\"]/div/div[3]/li/div/ul/li[1]/a";
	
	//public static  String HomePageTitle_Xpath ="//*[@id=\"layoutContainers\"]/div/div[2]/div/div[1]/section/div[2]/div[4]/div/div[1]";
	//-- //*[@id="layoutContainers"]/div/div[2]/div/div[1]/section/div[2]/div[4]/div/div[1]
	public static  String WISE_SearchBox ="//*[@id=\"searchBox\"]";
	public static  String WISE_SearchMagnifier ="//*[@id=\"btnHeaderSearch\"]";
	////section/div[2]/div[2]/div/div/div/div[2]/div[1]/div[2]/div[2]/div/a
	public static  String WISE_SearchPDPLink ="//section/div[2]/div[2]/div/div/div/div[2]/div[1]/div[2]/div[2]/div/a";
	public static  String WISE_PDPProdName ="//*[@id=\"productName\"]";
	
	//Generic HomePage logo Object
	
    public static  String WISE_HomePageLogo_CSS ="div.header-search:nth-child(3) > a:nth-child(1) > img:nth-child(1)";
	public static  String WISE_WelcomeToWise_CSS =".searchFooter > i:nth-child(1)";
	public static String WISE_Tool_CSS="li.parent-dropdown:nth-child(3) > a:nth-child(1) > span:nth-child(1)";
	public static String WISE_Tool_Xpath="/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[1]/section/div[2]/div[3]/div/div[2]/ul/li[3]/a/span";
	public static String WISE_Link_CSS="li.parent-dropdown:nth-child(4) > a:nth-child(1) > span:nth-child(1)";
	public static String WISE_Link_Xpath="/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[1]/section/div[2]/div[3]/div/div[2]/ul/li[4]/a/span";
	public static String WISE_ProcessTab_Xpath="//*[@id=\"header-processes-link\"]/a";
	public static String WISE_ProductTab_Xpath="//*[@id=\"header-products-link\"]/a";
	public static String WISE_HPLogo_Xpath="//*[@id=\"header\"]/div/div[1]/a/img";
	public static String WISE_Footer_SiteMap_Xpath="//*[@id=\"footer\"]/div/ul/li[2]/a";
	public static String WISE_Footer_TermOfUse_Xpath="//*[@id=\"footer\"]/div/ul/li[3]/a";
	public static String WISE_Footer_Privacy_Xpath="//*[@id=\"footer\"]/div/ul/li[4]/a";
	public static String WISE_Footer_Copyright_Xpath="//*[@id=\"footer\"]/div/div/p";
	public static String WISE_Footer_Xpath="//*[@id=\"footer\"]";
}
