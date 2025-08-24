package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//*[text()=' Page Object Model ']")
	WebElement clickPOM;
	
	@FindBy(xpath="//*[text()=' Edit ']")
	WebElement clickInput;
	
	@FindBy(xpath="//*[text()=' Click ']")
	WebElement clickButton;
	
	@FindBy(xpath="//*[text()=' Drop-Down ']")
	WebElement clickSelect;
	
	@FindBy(xpath="//*[text()=' Tabs ']")
	WebElement clickTabs;
	
	public void clickPOMBtn()
	{
		clickPOM.click();
	}
	
	public void clickInputBtn()
	{
		clickPOM.click();
	}
	
	public void clickButtonBtn()
	{
		clickButton.click();
	}
	
	public void clickSelectBtn()
	{
		clickSelect.click();
	}
	
	public void clickTabsBtn()
	{
		clickTabs.click();
	}
}
