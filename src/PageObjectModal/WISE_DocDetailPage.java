package PageObjectModal;
import org.openqa.selenium.WebElement;

public class WISE_DocDetailPage {

		
		//Search box -any page
	
	 
	public static String WISE_SearchBox_Xpath="//*[@id=\"searchBox\"]";
	public static  String WISE_SearchMagnifier_Xpath_Generic ="//*[@id=\"btnHeaderSearch\"]";
	
	public static String WISE_SearchResult_ProdDoc_Xpath="//*[@id=\"searchResultsTable\"]/div/div/div[2]";//dociD in search result-whr we are using this?
	public static String WISE_SearchResult_ProdDoc_CSS=".dId";
	
	public static String WISE_ThumpsUP2_Xpath= "//*[@id=\"voteUp\"]/span";
	public static String WISE_ThumpsUP_Xpath= "/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/section/div[2]/div[2]/div/div[1]/div[1]/span/a[1]/span";
	public static String WISE_ThumpsUP_CSS= "span.fa.fa-thumbs-up";
	//span.fa.fa-thumbs-up   //*[@id="top"]
	public static String WISE_DocumentTitleonDetailPage_Xpath="//*[@id=\"top\"]";
		
	}


