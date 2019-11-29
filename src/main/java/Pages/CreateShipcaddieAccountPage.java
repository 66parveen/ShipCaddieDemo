package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testbase.Base;
import Utility.TimeUtil;

public class CreateShipcaddieAccountPage extends Base {

	// LocatorValuesForSignUp
	@FindBy(xpath = "//a[@href='/registration']")
	@CacheLookup
	WebElement createNewAccount;

	@FindBy(xpath = "//input[@name='nameFirst']")
	@CacheLookup
	WebElement firstName;

	@FindBy(xpath = "//input[@name='nameLast']")
	@CacheLookup
	WebElement lastName;

	@FindBy(xpath = "//input[@name='userName']")
	@CacheLookup
	WebElement email;

	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//input[@name='passwordVerify']")
	@CacheLookup
	WebElement confirmPassword;

	@FindBy(xpath = "//input[@name='iAgree']")
	@CacheLookup
	WebElement termsConditions;

	@FindBy(xpath = "//input[@name='CompanyName']")
	@CacheLookup
	WebElement company;

	@FindBy(xpath = "//input[@name='phoneNumber']")
	@CacheLookup
	WebElement phone;

	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	WebElement createShipCaddieAccount;

	@FindBy(xpath = "//a[@href='/login']")
	@CacheLookup
	WebElement logInInstead;

	@FindBy(xpath = "//a[@href='/info/termsofservice']")
	@CacheLookup
	WebElement termsOfServices;

	@FindBy(xpath = "//a[@href='/info/privacypolicy']")
	@CacheLookup
	WebElement privacyPolicy;
	
	
	@FindBy(xpath = "//h3[text()='Register']")
	@CacheLookup
	WebElement 	account;
	


	// DeclarationOfGlobalVariableOfWebDriver
	public CreateShipcaddieAccountPage() {
		PageFactory.initElements(driver, this);

	}

	// FunctionToClickonCreateNewAccountLink
	public void clickOnCreateNewAccount() {
		TimeUtil.clickOn(driver, createNewAccount, 20);
		// Helper.Wait.clickOn(driver, createNewAccount, 5);
	}

	// FunctionToEnterFirstName
	public void enterFirstName(String firstNameValue) {
		TimeUtil.sendKeys(driver, firstName, 10, firstNameValue);

		// Helper.Wait.sendKeys(driver, firstName, 5, firstNameValue);
	}

	// FunctionToEnterLastName
	public void enterLastName(String lastNameValue) {
		TimeUtil.sendKeys(driver, lastName, 10, lastNameValue);
		// Helper.Wait.sendKeys(driver, lastName, 5, lastNameValue);
	}

	// FunctionToEnterEmail
	public void enterEmail(String emailValue) {
		// Helper.Wait.sendKeys(driver, email, 5, emailValue);
		TimeUtil.sendKeys(driver, email, 10, emailValue);
	}

	// FunctionToEnterPassword
	public void enterPassword(String passwordValue) {
		TimeUtil.sendKeys(driver, password, 10, passwordValue);

	}

	// FunctionToEnterConfirmPassword
	public void enterConfirmPassword(String confirmPasswordValue) {
		TimeUtil.sendKeys(driver, confirmPassword, 10, confirmPasswordValue);
	}

	// FunctionToClickOnTermsConditionsLink
	public void checkTermsConditions() {

		TimeUtil.clickOn(driver, termsConditions, 10);
	}

	// FunctionToEnterCompany
	public void enterCompany(String companyValue) {
		TimeUtil.sendKeys(driver, company, 10, companyValue);
	}

	//FunctionToEnterPhone
	public void enterPhone(String phoneValue) {
		TimeUtil.sendKeys(driver, phone, 10, phoneValue);
	}

	// FunctionToEnterInvalidFirstName
	public void enterInvalidFirstName(String invalidFirstNameValue) {
		TimeUtil.sendKeys(driver, firstName, 10, invalidFirstNameValue);

	}

	// FunctionToEnterInvalidLastName
	public void enterInvalidLastName(String invalidLastNameValue) {
		TimeUtil.sendKeys(driver, lastName, 10, invalidLastNameValue);

	}

	// FunctionToEnterInvalidEmail
	public void enterInvalidEmail(String emailValue) {
		TimeUtil.sendKeys(driver, email, 10, emailValue);

	}

	// FunctionToEnterAlreadyExistEmail
	public void enterAlreadyExistEmail(String existEmail) {
		TimeUtil.sendKeys(driver, email, 10, existEmail);

	}

	// FunctionToEnterInvalidPassword
	public void enterInvalidPassword(String passwordValue) {
		TimeUtil.sendKeys(driver, password, 10, passwordValue);

	}

	// FunctionToEnterInvalidConfirmPassword
	public void enterInvalidConfirmPassword(String confirmPasswordValue) {
		TimeUtil.sendKeys(driver, confirmPassword, 10, confirmPasswordValue);

	}

	// FunctionToEnterInvalidPhone
	public void enterInvalidPhone(String invalidPhoneValue) {
		TimeUtil.sendKeys(driver, phone, 10, invalidPhoneValue);

	}

	// FunctionToClickonLoginInsteadLink
	public void clickOnLoginInsteadLink() {
		TimeUtil.clickOn(driver, logInInstead, 10);

	}

	// FunctionToClickonTermsAndServiceLink
	public void clickOnTermsServiceLink() {

		TimeUtil.clickOn(driver, termsOfServices, 5);

	}

	// FunctionToClickonPrivacyLink
	public void clickOnPrivacyPolicyLink() {

		TimeUtil.clickOn(driver, privacyPolicy, 10);

	}

	// FunctionToClickonCreateShipCaddieAccountButton
	public void clickCreateShipCaddieAccount() {
		TimeUtil.clickOn(driver, createShipCaddieAccount, 10);
	}
	
	public void clearFirstName()
	{
		firstName.clear();
		
		
	}
	
	public void clearLastName()
	{
		lastName.clear();
	
		
	}
	public void clearEmail()
	{
		email.clear();
	
		
	}
	
	public void clearPassword()
	{
		password.clear();
	
		
	}
	
	
	public void clearConfirmPassword()
	{
		confirmPassword.clear();
	
	}
	
	
	public void clearPhone()
	{
		confirmPassword.clear();
	
	}
	
	
	public void clearCompany() {
		
		company.clear();
		
		
	}
	
	
	public void clickOnAccountTab()
	{
		
		TimeUtil.clickOn(driver, account, 20);
		
		
	}
	
}
