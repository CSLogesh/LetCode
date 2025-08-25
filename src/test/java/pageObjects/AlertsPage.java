package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends BasePage
{

	public AlertsPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//*[@id='accept']")
	WebElement simplealert;
	
	public void clickSimpleAlertBtn()
	{
		simplealert.click();
	}
	
	public Alert getalert()
	{
		Alert alert = driver.switchTo().alert();
		return alert;
	}
	
	
}
