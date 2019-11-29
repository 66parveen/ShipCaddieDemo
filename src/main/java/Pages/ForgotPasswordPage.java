package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testbase.Base;
import Utility.TimeUtil;

public class ForgotPasswordPage extends Base {

	// LocatorValuesOfEmailForgotPasswordLink
	@FindBy(xpath = "//a[text()='Forgot Password?']")
	@CacheLookup
	WebElement ForgotPasswordLink;

	@FindBy(xpath = "//input[@name='resetPasswordEmail']")
	@CacheLookup
	WebElement email;

	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	WebElement sendPassword;

	// ConstructorForIntializationOfVariableAndMethods
	public ForgotPasswordPage() {
		PageFactory.initElements(driver, this);

	}

	// FunctionToClickOnForgotPasswordLink
	public void clickOnForgotPasswordLink() {
		TimeUtil.clickOn(driver, ForgotPasswordLink, 10);
		// ForgotPasswordLink.click();

	}

	// FunctionToEnterInvalidEmail
	public void enterInvalidEmail(String invalidLoginEmail) {
		TimeUtil.sendKeys(driver, email, 10, invalidLoginEmail);
		// email.sendKeys(invalidLoginEmail);

	}

	// FunctionToEnterValidEmail
	public void enterEmail(String loginEmailValue) {
		TimeUtil.sendKeys(driver, email, 10, loginEmailValue);
		// email.sendKeys(loginEmailValue);

	}

	// FunctionToClickOnSendPasswordButton
	public void clickOnSendPassword() {
		TimeUtil.clickOn(driver, sendPassword, 10);
		// sendPassword.click();

	}

	public void clearEmail() {
		email.clear();
	}

}
