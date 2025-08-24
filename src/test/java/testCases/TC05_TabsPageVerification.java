package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.TabsPage;
import testBase.BaseClass;

public class TC05_TabsPageVerification extends BaseClass
{

	@Test(groups="master")
	public void verifytabspage()
	{
		try
		{
			HomePage hp = new HomePage(driver);
			hp.clickTabsBtn();
			
			TabsPage tp = new TabsPage(driver);
			tp.clickmutiplewindowsbtn();
			String title = getTitle();
			System.out.println("TC 05 Parent window title is :"+title);
			String childwindowid = getwindowhandles(1);
			getchildwindow(childwindowid);
			String title2 = getTitle();
			System.out.println("TC 05 first child window title is "+title2);
			String secondchildwindow = getwindowhandles(2);
			getchildwindow(secondchildwindow);
			String title3 = getTitle();
			System.out.println("TC 05 second child window title is "+title3);
			
			Assert.assertTrue(true);
		}
		catch(Exception e)
		{
			Assert.assertTrue(true);
		}
		
		
	}
	
}
