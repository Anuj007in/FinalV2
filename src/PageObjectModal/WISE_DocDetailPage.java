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
	
	//Feedback pop up
	public static String WISE_FeedbackBtn_CSS="#content-feedback-button";
	//*[@id="content-feedback-button"]
	public static String WISE_FeedbackPopUP_PD_Xpath="/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/section/div[2]/div[4]/div";
	public static String WISE_FeedbackPopUP_PD_CSS=".modal-lg";
	//public static String WISE_FeedbackPopUP_PD_Xpath="//*[@id="dl-mgr-1"]";
	public static String WISE_FeedbackPopUP_DocTitle_Xpath="/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/section/div[2]/div[4]/div/div/div[1]/div/h2";
	public static String WISE_FeedbackPopUP_DocTitle_CSS=".pTopic";	
	//FB form fields
	public static String WISE_FeedbackPopUP_Reason_CSS="#content-feedback-form > div:nth-child(1) > div:nth-child(2) > div:nth-child(2)";
	public static String WISE_FeedbackPopUP_Reason_Xpath="/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/section/div[2]/div[4]/div/div/div[2]/div/div/form/div[1]/div/div";
	public static String WISE_FeedbackPopUP_Title_Xpath="//*[@id=\"content-feedback-form\"]/div[2]/input";
	public static String WISE_FeedbackPopUP_Title_CSS="#content-feedback-form > div:nth-child(2) > input";
	public static String WISE_FeedbackPopUP_Detail_Xpath="//*[@id=\"content-feedback-form\"]/div[3]/div/div[3]";
	public static String WISE_FeedbackPopUP_Detail_CSS=".jqte_editor";
	public static String WISE_FeedbackPopUP_Submit_Xpath="//*[@id=\"btnSubmitContentFeedback\"]";
	public static String WISE_FeedbackPopUP_Submit_CSS="#btnSubmitContentFeedback";
	public static String WISE_FeedbackPopUP_Reason_Input_Xpath="/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/section/div[2]/div[4]/div/div/div[2]/div/div/form/div[1]/div/ul/li[2]";
	///html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/section/div[2]/div[4]/div/div/div[2]/div/div/form/div[1]/div/ul/li[2]
	//   //*[@id="dl-mgr-1"]/div/div/h3
	public static String WISE_Feedback_Success_Xpath="/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/section/div[2]/div[5]/div/div/div/div/h3";
	//*[@id="dl-mgr-1"]/div/div/h3
	
}


