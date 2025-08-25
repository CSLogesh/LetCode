package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.POMProductsPage;
import testBase.BaseClass;

public class TC01_ProductsPageVerification extends BaseClass
{

	
	
	@Test(groups= {"sanity","regression"})
	public void verifyproductspage()
	{
		try
		{
		logger.info("Started Execution for TC01....");
		HomePage hp = new HomePage(driver);
		hp.clickPOMBtn();
		
		POMProductsPage pp = new POMProductsPage(driver);
		boolean getstatus = pp.getstatus();
		Assert.assertTrue(getstatus);
		String title = getTitle();
		System.out.println("TC 01 --> title of webpage is "+title);
		logger.info("Completed Execution for TC01...");
		}
		catch(Exception e)
		{
			logger.debug("Execution Failed for TC01 - Please refer logs...");
			Assert.assertTrue(false);
		}
		
	}
	
}
