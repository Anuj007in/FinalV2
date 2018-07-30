package PageObjectModal;
import org.openqa.selenium.WebElement;

public class WISE_PDPPage_Page {
	
	private static WebElement element = null;
	//***PDP- Object Repo for THree tabs start 
	public static  String PDP_TroubleShoot_CSS =".troubleShootingTab > a:nth-child(1) > span:nth-child(2)";
	public static  String PDP_TroubleShoot_Xpath ="/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/section/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/div[1]/ul/li[1]/a/span";
	public static  String PDP_HowTo_CSS =".howToTab > a:nth-child(1) > span:nth-child(2)";
	public static  String PDP_HowTo_Xpath ="/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/section/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/div[1]/ul/li[2]/a/span";
	public static  String PDP_ProdInfo_CSS =".productInfoTab > a:nth-child(1) > span:nth-child(2)";
	public static  String PDP_ProdInfo_Xpath ="/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/section/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/div[1]/ul/li[3]/a/span";
	//***PDP- Object Repo for THree tabs END
	//#solve-problem-content > div:nth-child(1) > h2:nth-child(1)
	//****PDP three tabs title link start
	public static  String PDP_TroubleShootTitle_CSS ="#solve-problem-content > div:nth-child(1) > h2:nth-child(1)";
	public static  String PDP_TroubleShootTitle_Xpath ="/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/section/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/div[2]/div[1]/div[1]/h2";
	public static  String PDP_HowToTitle_CSS ="#how-to-content > div:nth-child(1) > h2:nth-child(1)";
	public static  String PDP_HowToTitle_Xpath ="/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/section/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/div[2]/div[2]/div[1]/h2";
	public static  String PDP_ProdInfoTitle_CSS ="#product-information-content > div:nth-child(1) > h2:nth-child(1)";
	public static  String PDP_ProdInfoTitle_Xpath ="/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/section/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/div[2]/div[3]/div[1]/h2";
	//****PDP three tabs title link END
	
	
	
}
