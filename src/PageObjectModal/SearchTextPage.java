package PageObjectModal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchTextPage {
	private static WebElement element = null;
	public static WebElement ORSearchBox(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id='lst-ib']"));
		//.//*[@id='gs_htif0'] .//*[@id='lst-ib']
		return element;
	}

	public static WebElement ORSearchBtn(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id='sblsbb']/button"));
		//.//*[@id='tsf']/div[2]/div[3]/center/input[1]
		//element=driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[3]/center/input[1]"));
		return element;
		
	}
}
