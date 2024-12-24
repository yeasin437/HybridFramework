package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	By lnkMyaccount = By.xpath("//span[normalize-space()='My Account']");
	By lnkRegister = By.xpath("//a[normalize-space()='Register']");
	By lnkLogin = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']");
	public void clickMyaccount()
	{
		driver.findElement(lnkMyaccount).click();
	}
	public void clickRegister()
	{
		driver.findElement(lnkRegister).click();
	}
	public void clickLogin()
	{
		driver.findElement(lnkLogin).click();
	}

}
