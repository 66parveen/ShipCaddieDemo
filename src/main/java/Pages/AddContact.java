package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Testbase.Base;
import Utility.TimeUtil;

public class AddContact extends Base {

	@FindBy(xpath = "//h3[text()='Contacts']")
	@CacheLookup
	WebElement contactsTab;

	@FindBy(xpath = "//i[@class='fa fa-plus']")
	@CacheLookup
	WebElement addContactIcon;

	@FindBy(xpath = "//input[@id='customerId']")
	@CacheLookup
	WebElement customerID;

	@FindBy(xpath = "//input[@id='attentionOf']")
	@CacheLookup
	WebElement recipient;

	@FindBy(xpath = "//input[@id='company']")
	@CacheLookup
	WebElement organization;

	@FindBy(xpath = "//input[@id='phone']")
	@CacheLookup
	WebElement phone;

	@FindBy(xpath = "//input[@id='email']")
	@CacheLookup
	WebElement email;

	@FindBy(xpath = "//div[text()='	Select Tag(s)']")
	@CacheLookup
	WebElement selectTags;

	@FindBy(xpath = "//button[text()='Verify']")
	@CacheLookup
	WebElement verify;

	@FindBy(xpath = "//input[@id='addressLine1']")
	@CacheLookup
	WebElement contactAddress1;

	@FindBy(xpath = "//input[@id='addressLine2']")
	@CacheLookup
	WebElement contactAddress2;

	@FindBy(xpath = "//input[@id='postalCode']")
	@CacheLookup
	WebElement zip;

	@FindBy(xpath = "//input[@id='city']")
	@CacheLookup
	WebElement city;

	@FindBy(xpath = "//div[text()='Select state']")
	@CacheLookup
	WebElement state;

	@FindBy(xpath = "//button[text()='Use Entered']")
	@CacheLookup
	WebElement useEnteredButton;

	@FindBy(xpath = "//input[@id='isResidential']")
	@CacheLookup
	WebElement isResidentialClick;

	@FindBy(xpath = "//a[@id='tabURL']")
	@CacheLookup
	WebElement urlTab;

	@FindBy(xpath = "//button[text()='Browse Files']")
	@CacheLookup
	WebElement browseFileButton;

	@FindBy(xpath = "//button[@id='btnSubmit']")
	@CacheLookup
	WebElement submitButton;

	@FindBy(xpath = "//a[text()='Delete']")
	@CacheLookup
	WebElement deleteLink;

	@FindBy(xpath = "//*[@id=\"addressbook-list\"]/div/div[2]/div[3]/div[1]/div[3]/div/div[1]/div/div[1]/input")
	@CacheLookup
	WebElement delContact;
	
	
	@FindBy(xpath = "//i[@title='Edit']")
	@CacheLookup
	WebElement editLink;
	
	@FindBy(xpath = "//button[text()='Browse Files']")
	@CacheLookup
	WebElement browseFilesButton;
	
	@FindBy(xpath = "//h3[text()='Shipments']")
	@CacheLookup
	WebElement shipmentsTab;

	public AddContact() {
		PageFactory.initElements(driver, this);

	}

	public void clickOnContactsTab() throws InterruptedException {
	
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOf(contactsTab));
		
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", contactsTab);

	}

	public void clickOnAddContactIcon() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(addContactIcon));
		
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", addContactIcon);

	}

	public void enterCustomerID(String customerIDValue) {

		TimeUtil.sendKeys(driver, customerID, 20, customerIDValue);
	}

	public void enterOrgnization(String company) {
		TimeUtil.sendKeys(driver, organization, 20, company);

	}

	public void enterPhone(String phoneValue1) {
		TimeUtil.sendKeys(driver, phone, 20, phoneValue1);

	}

	public void enterAddress1(String address) {
		TimeUtil.sendKeys(driver, contactAddress1, 20, address);

	}

	public void enterZip(String zipValue1) {
		TimeUtil.sendKeys(driver, zip, 20, zipValue1);

	}

	public void enterCity(String cityValue) {
		TimeUtil.sendKeys(driver, city, 20, cityValue);

	}

	public void clearCustomerID() {
		customerID.clear();

	}

	public void clearRecipient() {
		recipient.clear();

	}

	public void clearPhone() {

		phone.clear();
	}

	public void clearAddress() {
		contactAddress1.clear();

	}

	public void clearZip() {
		zip.clear();

	}

	public void clearCity() {
		city.clear();

	}

	public void clearOrganization() {
		city.clear();

	}

	public void selectState() throws InterruptedException {

		TimeUtil.clickOn(driver, state, 20);
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//div[text()='AA - Armed Forces Americas']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);

	}

	public void clickOnEnteredButton() {
		TimeUtil.clickOn(driver, useEnteredButton, 30);

	}

	public void clickOnSubmitContactButton() throws InterruptedException {
		TimeUtil.clickOn(driver, submitButton, 30);

	}

	public void selectContact() {

		delContact.click();
	}

	public void clickOnDeleteIcon() {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", deleteLink);
	}
	
	
	public void clickOnEditLink() {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", editLink);
	}
	
	
	
	public void selectShipmentProfile()
	{
		Select shipmentProfile = new Select(driver.findElement(By.id("shipmentProfileId")));
		shipmentProfile.selectByVisibleText("UPS TEST");
		
	}
	
	
	public void clickOnBrowseFilesButton()
	{
	
		TimeUtil.clickOn(driver, browseFilesButton, 20);
		
	}
	
	public void clickOnShipmentsTab()
	{
	
		TimeUtil.clickOn(driver, shipmentsTab, 20);
		
	}

}
