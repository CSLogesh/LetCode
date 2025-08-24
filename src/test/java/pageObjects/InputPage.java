package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InputPage extends BasePage
{

	public InputPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//*[text()='Input']")
	WebElement msg_title;
	
	@FindBy(xpath="//*[@id='fullName']")
	WebElement txt_fullname;
	
	public void setFullname(String name)
	{
		txt_fullname.sendKeys(name);
	}
	
	public String getStatus_msg()
	{
		try
		{
			return (msg_title.getText());
		}
		catch(Exception e)
		{
			return null;
		}
		
	}
	
}
