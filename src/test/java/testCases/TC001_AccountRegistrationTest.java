package testCases;



import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;
import utilities.ExcelUtility2;

public class TC001_AccountRegistrationTest extends BaseClass {
	private static final Logger logger = LogManager.getLogger(TC001_AccountRegistrationTest.class);
	@Test
	public void verify_account_registration() throws IOException, InterruptedException
	{
		//logger.trace("going to click the myaccount link");
		HomePage homePage = new HomePage(driver);
		homePage.clickMyaccount();
		//logger.info("clicked the myaccount link");
		//logger.info("Going to click register link");
		homePage.clickRegister();
		RegisterPage registerPage = new RegisterPage(driver);
		ExcelUtility2 utils = new ExcelUtility2(".//testdata//test.xlsx");
		String firstname = randomStringGenerator();
		registerPage.setFirstname(firstname);
		//System.out.println(utils.getRowCount("Sheet1"));
		try {
			
			utils.setCellData("Sheet1",0,0,firstname);
		}catch(Exception e)
		{
			
		}
		
		//logger.info("set first name");
		registerPage.setLastname(randomStringGenerator());
		registerPage.setEmail(randomStringGenerator()+"@gmail.com");
		registerPage.setTelephone(randomNumberGenerator()+randomNumberGenerator());
		String password = randomStringGenerator()+"#$%"+randomNumberGenerator();
		System.out.println(password);
		registerPage.setPassword(password);
		registerPage.setConfirmpassword(password);
		registerPage.clickPrivacylnk();
		registerPage.clickContinuebtn();
	}

}
