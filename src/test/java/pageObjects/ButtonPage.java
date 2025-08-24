package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonPage extends BasePage 
{

	public ButtonPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//*[@id='home']")
	WebElement btnHome;
	
	public void clickHomeBtn()
	{
		btnHome.click();
	}
}
