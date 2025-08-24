package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.InputPage;
import testBase.BaseClass;

@Test
public class TC02_InputPageVerification extends BaseClass
{

	public void verifyinputspage()
	{
		try
		{
		logger.info("Started Execution for TC02...");
		HomePage hp = new HomePage(driver);
		hp.clickInputBtn();
		
		InputPage ip = new InputPage(driver);
		String status_msg = ip.getStatus_msg();
		System.out.println("Subheading of the webpage is "+status_msg);
		ip.setFullname("Logueswar");
		Assert.assertTrue(true);
		}
		catch(Exception e)
		{
			logger.debug("Execution Failed for TC02 - Please refer logs...");
			Assert.assertTrue(false);
		}
	}

	
}
