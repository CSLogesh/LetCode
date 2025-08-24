package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SelectPage extends BasePage
{

	public SelectPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	// locators 
	
	@FindBy(xpath="//*[@id='fruits']")
	WebElement clickdropdown;
	
	Select select = new Select(clickdropdown);
	
	@FindBy(xpath="//*[text()='You have selected Banana']")
	WebElement txt_message;
	
	public void clickselectdpdwn()
	{
		clickdropdown.click();
	}
	
	public void selectanyfruit(int num)
	{
		select.selectByIndex(num);
	}
	
	public String getverificationmsg()
	{
		try
		{
		 return (txt_message.getText());
		}
		catch (Exception e)
		{
			return null;
		}
	}
}
