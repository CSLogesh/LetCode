package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ButtonPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC03_ButtonPageVerification extends BaseClass
{

	@Test(groups= {"regression","master"})
	public void verifybuttonpage()
	{
		try
		{
		logger.info("Started Execution for TC03...");
		HomePage hp = new HomePage(driver);
		hp.clickButtonBtn();
		
		ButtonPage bp = new ButtonPage(driver);
		bp.clickHomeBtn();
		String title = getTitle();
		System.out.println("TC 03 -> Title of the webpage is "+title);
		logger.info("Completed Execution for TC03...");
		Assert.assertTrue(true);
		
		}
		catch (Exception e)
		{
			logger.error("Execution Failed for TC03...");
			logger.debug("Please refer to logs...");
			Assert.assertTrue(false);
		}
	}
	
	
}
