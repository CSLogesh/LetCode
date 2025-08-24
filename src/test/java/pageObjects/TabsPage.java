package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TabsPage extends BasePage
{

	public TabsPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//*[@id='multi']")
	WebElement mutiplewindows;
	
	
	public void clickmutiplewindowsbtn()
	{
		mutiplewindows.click();
	}
	
	
	
}
