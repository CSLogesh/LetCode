package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POMProductsPage extends BasePage
{

	public POMProductsPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//*[text()='Fake Store']")
	WebElement msg_status;
	
	public boolean getstatus()
	{
		try
		{
			return (msg_status.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
