package ReusableLibraryActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait_ElementToBeClickable {
	//WebElement objectIdentifier;giving maven build error
	public static WebDriver driver;
	public static void CustomExplicitWait(WebElement objectIdentifier, int duration, WebDriver driver) throws Exception
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.elementToBeClickable(objectIdentifier));
		
		
	}

}
