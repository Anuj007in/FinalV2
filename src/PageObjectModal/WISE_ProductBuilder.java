package PageObjectModal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
//using page factory
public class WISE_ProductBuilder {
	WebDriver driver;
	
	@FindBy(how=How.ID,using="header-products-link") public WebElement ProductLink;
	//@FindBy(how=How.XPATH,using="//*[@id=\"header-products-link\"]/a") public WebElement ProductLink;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"productList\"]/a/div/div[1]/ul/li[1]/a") public WebElement HpPrinterListBoxItem1;
	@FindBy(how=How.XPATH,using="//*[@id=\"productList1\"]/a/ul/li[1]/a") public WebElement HPEnvyPrintersubcat2;
	@FindBy(how=How.XPATH,using="//*[@id=\"productList2\"]/a/ul/li[1]/a") public WebElement ProductSubSubCategory3;
	@FindBy(how=How.XPATH,using="//*[@id=\"productList3\"]/a/ul/li[1]/a") public WebElement ProductSeries4;
	@FindBy(how=How.XPATH,using="//*[@id=\"productList4\"]/a/ul/li[1]/a") public WebElement ProductSKU1;
	
	//click launch pdp button
	@FindBy(how=How.ID,using="btnLaunchProductHomepage") WebElement LaunchPDP;
	public WISE_ProductBuilder(WebDriver driver)
	{this.driver=driver;
	// PageFactory.initElements(driver, this);
	 System.out.println("From page factory constructor");
	 
	}
	
}
