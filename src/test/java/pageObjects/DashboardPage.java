package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage  extends BasePage{
	public DashboardPage(WebDriver driver)
	{
		super(driver);
	}
@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement lnkLogout;

public boolean logoutBtnIsDisplayed()
{
	return lnkLogout.isDisplayed();
}
public void clickLogout()
{
	lnkLogout.click();
}

}
