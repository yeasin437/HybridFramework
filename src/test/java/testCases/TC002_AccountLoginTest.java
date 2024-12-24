package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC002_AccountLoginTest extends BaseClass{
	
	@Test(dataProvider="loginData",dataProviderClass=DataProviders.class)
	public void verify_account_login(String email,String password,String status)
	{
		HomePage hp = new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		DashboardPage dp = new DashboardPage(driver);
	
		
		boolean status2 = driver.getCurrentUrl().equalsIgnoreCase("https://tutorialsninja.com/demo/index.php?route=account/account");
		System.out.println("STATUS = "+status2);
		
		if(status.equalsIgnoreCase("passed"))
		{
			
			if(status2==true)
			{
				dp.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			
			
			
		}
		else if(status.equalsIgnoreCase("failed"))
		{
			if(status2==true)
			{
				dp.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
				


			}
		}
		
		
		
		
	}

}
