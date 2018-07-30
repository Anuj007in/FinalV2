package PageObjectModal;

import org.openqa.selenium.WebElement;
//Author: Anuj Sharma

public class WISE_HomePage_Page {
	
	private static WebElement element = null;
	//welcome to wise  
	public static  String HomePageTitle_Xpath ="//div[@class='searchWrapper']/div[@class='searchHeader']";
	public static  String HomePageTitle_ClassName ="searchHeader";
	public static  String HomePageTitle_UIExp_Xpath ="//*[@id=\"header\"]/div/div[3]/li/div/a/span";
	
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
	
}
