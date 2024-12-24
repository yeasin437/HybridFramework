package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
	public RegisterPage(WebDriver driver)
	{
		super(driver);
	}

@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstname;
@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastname;
@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
@FindBy(xpath="//input[@id='input-telephone']") WebElement txtTelephone;
@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
@FindBy(xpath="//input[@id='input-confirm']") WebElement txtConfirmpassword;
@FindBy(xpath="//input[@name='agree']") WebElement lnkPrivacy;
@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;

public void setFirstname(String firstname)
{
	txtFirstname.sendKeys(firstname);
}
public void setLastname(String lastname)
{
	txtLastname.sendKeys(lastname);
}
public void setEmail(String email)
{
	txtEmail.sendKeys(email);
}
public void setTelephone(String telephone)
{
	txtTelephone.sendKeys(telephone);
}
public void setPassword(String password)
{
	txtPassword.sendKeys(password);
}
public void setConfirmpassword(String confirmpassword)
{
	txtConfirmpassword.sendKeys(confirmpassword);
}
public void clickPrivacylnk()
{
	lnkPrivacy.click();
}
public void clickContinuebtn()
{
	btnContinue.click();
}


}
