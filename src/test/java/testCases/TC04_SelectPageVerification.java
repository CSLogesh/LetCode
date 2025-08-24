package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SelectPage;
import testBase.BaseClass;

public class TC04_SelectPageVerification extends BaseClass
{

	@Test(groups= {"functional","master"})
	public void verifydropdownactions()
	{
		try
		{
			logger.info("Started Execution for TC04....");
			
			HomePage hp = new HomePage(driver);
			hp.clickSelectBtn();
			
			SelectPage sp = new SelectPage(driver);
			sp.clickselectdpdwn();
			sp.selectanyfruit(4);
			String getverificationmsg = sp.getverificationmsg();
			Assert.assertEquals(getverificationmsg, "You have selected Banana");
			System.out.println("TC 04 --> "+getverificationmsg);
			Assert.assertTrue(true);

			
			logger.info("Completed execution for TC04...");
		}
		catch(Exception e)
		{
			logger.error("Execution failed for TC04....");
			Assert.assertTrue(false);
		}
			
	}
	
}
