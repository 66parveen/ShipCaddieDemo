package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testbase.Base;
import Utility.TimeUtil;

public class BatchShipmentPage extends Base {
	
	@FindBy(xpath = "//span[text()='Add']")
	@CacheLookup
	WebElement addShipmentIcon;
	
	
	@FindBy(xpath = "//a[text()='Ready to Ship']")
	@CacheLookup
	WebElement readyToShip;
	
	
	@FindBy(xpath = "//input[@id='orderNumberReference']")
	@CacheLookup
	WebElement orderRef;
	
	
	@FindBy(xpath = "//input[@id='checkbox-3']")
	@CacheLookup
	WebElement CODCheck;
	
	
	@FindBy(xpath = "//input[@id='checkbox-4']")
	@CacheLookup
	WebElement deliveryConfirmationCheck;
	
	
	@FindBy(xpath = "//input[@id='checkbox-8']")
	@CacheLookup
	WebElement billingOptionsCheck;
	

	@FindBy(xpath = "//input[@id='autocomplete-address']")
	@CacheLookup
	WebElement contact;
	
	
	@FindBy(xpath = "//input[@id='weightLbs']")
	@CacheLookup
	WebElement weight;
	
	@FindBy(xpath = "//input[@id='dimensionX']")
	@CacheLookup
	WebElement dimX;
	

	@FindBy(xpath = "//input[@id='dimensionY']")
	@CacheLookup
	WebElement dimY;
	
	
	@FindBy(xpath = "//input[@id='dimensionZ']")
	@CacheLookup
	WebElement dimZ;
	
	
	@FindBy(xpath = "//button[text()='Save for Later']")
	@CacheLookup
	WebElement saveForLater;
	
	
	@FindBy(xpath = "//h3[text()='Settings']")
	@CacheLookup
	WebElement settings;
	
	
	@FindBy(xpath = "//a[text()='Printer Setup & Configuration']")
	@CacheLookup
	WebElement printerSetUp;
	
	
	
	@FindBy(xpath = "//input[@id='shipping-list']/div/div[3]/div[2]/div[1]/div[3]/div/div[1]/div/div[1]/div[1]")
	@CacheLookup
	WebElement firstCheckBox;
	
	
	@FindBy(xpath = "//i[@class='fa fa-print']")
	@CacheLookup
	WebElement shipLink;

	
	
	@FindBy(xpath = "//*[@id=\"print-list\"]/div/div/div[1]/div[2]/div[1]/div/div/div[5]/div/a/i")
	@CacheLookup
	WebElement setting1;

	@FindBy(xpath = "//*[@id=\"print-list\"]/div/div/div[1]/div[2]/div[2]/div/div/div[5]/div/a/i")
	@CacheLookup
	WebElement setting2;

	@FindBy(xpath = "//i[@class='fa fa-print']")
	@CacheLookup
	WebElement setting3;

	@FindBy(xpath = "//i[@class='fa fa-print']")
	@CacheLookup
	WebElement setting4;

	@FindBy(xpath = "//i[@class='fa fa-print']")
	@CacheLookup
	WebElement setting5;

	@FindBy(xpath = "//input[@data-templateid='12']")
	@CacheLookup
	WebElement fourInchOptions;
	
	
	@FindBy(xpath = "//button[text()='Update']")
	@CacheLookup
	WebElement updateButton;
	
	
	@FindBy(xpath = "//h3[text()='Shipments']")
	@CacheLookup
	WebElement shipmentsTab;
	
	
	@FindBy(xpath = "//button[text()='Use Entered']")
	@CacheLookup
	WebElement useEnteredButton;
	
	
	
	@FindBy(xpath = "//span[text()='Import Shipments']")
	@CacheLookup
	WebElement ImportShipmentsLink;
	
	
	
	@FindBy(xpath = "//label[text()='Choose CSV File']")
	@CacheLookup
	WebElement chooseCSVFile;
	
	
	@FindBy(xpath = "//span[text()='Import ']")
	@CacheLookup
	WebElement importButton;
	
	@FindBy(xpath = "//button[text()='Import without Corrections']")
	@CacheLookup
	WebElement importWithoutCorrectionButton;
	

	public BatchShipmentPage()
	{
	PageFactory.initElements(driver, this);
		
	}
	
	
	public void clickOnAddShipment()
	{
		
		TimeUtil.clickOn(driver, addShipmentIcon, 20);
		
	}
	
	
	public void clickOnReadyToShip()
	{
		
		TimeUtil.clickOn(driver, readyToShip, 20);
		
	}
	
	public void enterOrderReferenceNumber1(String OrderReferenceNumber1)
	{
		
		TimeUtil.sendKeys(driver, orderRef, 20, OrderReferenceNumber1);
		
	}
	
	public void enterOrderReferenceNumber2(String OrderReferenceNumber2)
	{
		
		TimeUtil.sendKeys(driver, orderRef, 20, OrderReferenceNumber2);
	}


	public void checkCODCheck()
	{
		TimeUtil.clickOn(driver, CODCheck, 20);
		
	}
	
	public void deliveryConfirmationCheck()
	{
		
		TimeUtil.clickOn(driver, deliveryConfirmationCheck, 20);
	}
	
	
	public void billingOptionsCheck()
	{
		TimeUtil.clickOn(driver, billingOptionsCheck, 20);
		
	}
	
	public void enterSearchContact(String searchContact)
	{
		
		TimeUtil.sendKeys(driver, contact, 20, searchContact);
	}
	
	
	public void selectContact()
	{
		contact.sendKeys(Keys.DOWN);
		contact.sendKeys(Keys.ENTER);
		
		
	}
	
	public void clickOnUseEnteredButton()
	{
		
		TimeUtil.clickOn(driver, useEnteredButton, 20);
		
	}
	
	public void enterWeight(String weightVal)
	{
		
		TimeUtil.sendKeys(driver, weight, 20, weightVal);
	}
	
	public void enterDimensionX(String dimensionX)
	{
		TimeUtil.sendKeys(driver, dimX, 20, dimensionX);
		
	}
	
	public void enterDimensionY(String dimensionY)
	{
		
		TimeUtil.sendKeys(driver, dimY, 20, dimensionY);
		
	}
	
	public void enterDimensionZ(String dimensionZ)
	{
		
		TimeUtil.sendKeys(driver, dimZ, 20, dimensionZ);
	
	}
	
	public void clickOnSaveForLater() throws InterruptedException
	{
		Thread.sleep(5000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", saveForLater);
	
	}
	
	
public void clickOnSettings()
{
	
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].click();", settings);

}
	
	

public void clickOnPrinterSetUp()
{
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].click();", printerSetUp);


}
	public void clickOnShipLink()
	{
		TimeUtil.clickOn(driver, shipLink, 20);
		
	}
	
	
	public void clickOnSettings1()
	{

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", setting1);
		
	}
	
	public void clickOnSettings2()
	{
		TimeUtil.clickOn(driver, setting2, 20);
	}
	
	public void clickOnFourInchOption()
	{

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", fourInchOptions);
		

	}
	
	public void clickOnUpdateButton()
	{

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", updateButton);
		

	}
	
	public void clickOnShipmentsTab()
	{
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", shipmentsTab);
		
		
	}
	
	
	
	public void clickOnImportShipmentsLink()
	{
		TimeUtil.clickOn(driver, ImportShipmentsLink, 20);

		
		
	}
	
	
	public void clickOnChooseCSVFileButton()
	{
		TimeUtil.clickOn(driver, chooseCSVFile, 20);

	}
	
	
	public void clickOnImportShipmentsButton()
	{
		TimeUtil.clickOn(driver, importButton, 20);

	}
	
	public void clickOnImportShipmentsWithoutCorrectionButton()
	{
		TimeUtil.clickOn(driver, importWithoutCorrectionButton, 20);

	}
	
}
