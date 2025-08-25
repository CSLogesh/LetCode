package testCases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AlertsPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC06_AlertsPageVerification extends BaseClass
{

	@Test
	public void verify_alerts()
	{
		try 
		{
			logger.info("Started Execution for TC06...");
			HomePage hp = new HomePage(driver);
			hp.clickAlertsBtn();
			
			AlertsPage ap = new AlertsPage(driver);
			ap.clickSimpleAlertBtn();
			Alert getalert = ap.getalert();
			String text = getalert.getText();
			System.out.println("TC 06 --> Text displayed in the alert box is : "+text );
			getalert.accept();
			Assert.assertTrue(true);
			logger.info("Completed Execution for TC06...");
		}
		catch(Exception e)
		{
			logger.error("Execution failed for TC06 - Please retry ...");
			Assert.assertTrue(false);
		}
		
	}
	
	
}
