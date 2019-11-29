package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testbase.Base;
import Utility.TimeUtil;

public class AddShipmentPage extends Base {
	// LocatorValuesOfRequiredObjectForAddShipment
	@FindBy(xpath = "//span[text()='Add']")
	@CacheLookup
	WebElement addShipmentIcon;

	// ShipmentLocatorValues
	@FindBy(xpath = "//input[@id='orderNumberReference']")
	@CacheLookup
	WebElement orderNo;

	// RecipientLocatorValues
	@FindBy(xpath = "//input[@id='attentionOf']")
	@CacheLookup
	WebElement recipient;

	@FindBy(xpath = "//input[@id='addressLine1']")
	@CacheLookup
	WebElement address1;

	@FindBy(xpath = "//input[@name='postalCode']")
	@CacheLookup
	WebElement zip;

	@FindBy(xpath = "//input[@name='city']")
	@CacheLookup
	WebElement city;

	@FindBy(xpath = "//div[text()='Select state']")
	@CacheLookup
	WebElement state;

	@FindBy(xpath = "//div[text()='AA - Armed Forces Americas']")
	@CacheLookup
	WebElement selectedValue;

	@FindBy(xpath = "//input[@id='phone']")
	@CacheLookup
	WebElement phone;

	@FindBy(xpath = "//input[@id='autocomplete-address']")
	@CacheLookup
	WebElement searchAddress;

	@FindBy(xpath = "//button[text()='Use Entered']")
	@CacheLookup
	WebElement useEntered;

	@FindBy(xpath = "//a[text()='Save Changes']")
	@CacheLookup
	WebElement saveChanges;
	
	@FindBy(xpath = "//span[text()='remove']")
	WebElement removeAddressLink;

	// LocatrorValuesForPackagingElements
	@FindBy(xpath = "//i[@class='fa fa-calculator']")
	@CacheLookup
	WebElement calcIcon;

	@FindBy(xpath = "//input[@id='weightLbs']")
	@CacheLookup
	WebElement weight1;

	@FindBy(xpath = "//input[@id='dimensionX']")
	@CacheLookup
	WebElement dimensionX;

	@FindBy(xpath = "//input[@id='dimensionY']")
	@CacheLookup
	WebElement dimensionY;

	@FindBy(xpath = "//input[@id='dimensionZ']")
	@CacheLookup
	WebElement dimensionZ;

	@FindBy(xpath = "//i[@class='fa fa-truck']")
	@CacheLookup
	WebElement orangeTruck;

	@FindBy(xpath = "//button[text()='Save for Later']")
	@CacheLookup
	WebElement saveLater;

	@FindBy(xpath = "//a[text()='Save']")
	@CacheLookup
	WebElement savePrinterOptions;

	@FindBy(xpath = "//span[text()='Print']")
	@CacheLookup
	WebElement print;
	
	@FindBy(xpath = "//button[@id='printButton']")
	@CacheLookup
	WebElement print1;
	

	@FindBy(xpath = "//a[text()='Printer Options']")
	@CacheLookup
	WebElement printerOptions;

	// RecipientLocatorValues
	@FindBy(xpath = "//input[@id='postalCode']")
	@CacheLookup
	WebElement postalCode;

	@FindBy(xpath = "//input[@id='city']")
	@CacheLookup
	WebElement cityVal;

	@FindBy(xpath = "//div[@id='usProvinceSelect']")
	@CacheLookup
	WebElement stateVal;

	@FindBy(xpath = "//input[@id='weightOz']")
	@CacheLookup
	WebElement OZ;
	
	@FindBy(xpath = "//input[@id='company']")
	@CacheLookup
	WebElement company;
	
	@FindBy(xpath = "//h3[text()='Shipments']")
	@CacheLookup
	WebElement shipmentsTab;
	
	
	@FindBy(xpath = "//i[@title='edit']")
	@CacheLookup
	WebElement editIcon;
	

	@FindBy(xpath = "//span[text()='edit']")
	@CacheLookup
	WebElement editLink;
	
	

	

	// ConstructorToInitalizeVarialeAndMethods
	public AddShipmentPage() {
		PageFactory.initElements(driver, this);
	}

	// FunctionToClickOnAddShipmentIcon
	public void clickOnAddShipmentIcon() {
		TimeUtil.clickOn(driver, addShipmentIcon, 30);
		// addShipmentIcon.click();
	}


	

	// FunctionToEnterDimension
	public void enterDimension() {
		TimeUtil.sendKeys(driver, dimensionX, 20, "10");
		TimeUtil.sendKeys(driver, dimensionY, 20, "10");
		TimeUtil.sendKeys(driver, dimensionZ, 20, "10");

		// dimensionX.sendKeys("10");
		// dimensionY.sendKeys("10");
		// dimensionZ.sendKeys("10");
	}

	// FunctionToClearDimension
	public void clearDimension() {
		dimensionX.clear();
		dimensionY.clear();
		dimensionZ.clear();
	}


	public void clearOZ() {
		OZ.clear();
	}


	// FunctionToTapSelectState
	public void selectState() throws InterruptedException {

		// state.click();
		TimeUtil.clickOn(driver, state, 20);
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//div[text()='AA - Armed Forces Americas']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
	}

	// FunctionToClickOnSearchAddress
	public void clickOnSearchAddress() {
		TimeUtil.clickOn(driver, searchAddress, 20);

	}

	// FunctionToEnterAddress
	public void enterSearchAddress() {

		TimeUtil.sendKeys(driver, searchAddress, 20, "UAT88");
		// searchAddress.sendKeys("654");
	}

	// FunctionToTapSelectedAddress
	public void selectSearchAddress() {
		searchAddress.sendKeys(Keys.ARROW_DOWN);
		searchAddress.sendKeys(Keys.ENTER);
	}

	// FunctionToClickOnUseEntered
	public void clickOnUseEnteredButton() {
		TimeUtil.clickOn(driver, useEntered, 20);
		// useEntered.click();
	}

	// FunctionToClickOnSaveChanges
	public void clickOnSaveChnages() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", saveChanges);
		// Thread.sleep(3000);
		TimeUtil.clickOn(driver, saveChanges, 20);
		// saveChanges.click();
	}

	// FunctionToClickOnPrinterOptions
	public void clickOnPrinterOptions() {
		TimeUtil.clickOn(driver, printerOptions, 20);
		// printerOptions.click();

	}

	// FunctionToClickOnSavePrinterOptions
	public void clickOnSavePrinterOptions() {
		TimeUtil.clickOn(driver, savePrinterOptions, 20);
		// savePrinterOptions.click();

	}

	// FunctionToClearRemoveAddress
	public void clickOnRemoveAddress() {
		TimeUtil.clickOn(driver, removeAddressLink, 20);
		// removeAddressLink.click();

	}

	// FunctionToClickEnterKey
	public void tapEnter() {
		orderNo.sendKeys(Keys.ENTER);
	}

	// FunctionToEnterCustomerID
	public void addValidCustomerIDForShipment() {
		TimeUtil.sendKeys(driver, searchAddress, 20, "9888");
		// searchAddress.sendKeys("9888");
		searchAddress.sendKeys(Keys.ARROW_DOWN);
		searchAddress.sendKeys(Keys.ENTER);

	}

	// FunctionToClickOnTruckIcon
	public void clickOnOrangeTruckIcon() {
		TimeUtil.clickOn(driver, orangeTruck, 20);
		// orangeTruck.click();
	}



	// FunctionToEnterRecipient

	public void enterRecipient1() {
		TimeUtil.sendKeys(driver, recipient, 20, "UAT88");
		// recipient.sendKeys("dummyRecipient");
	}

	// FunctionToEnterAddress
	

	// FunctionToEnterZip
	public void enterZip1() {
		TimeUtil.sendKeys(driver, postalCode, 20, "84043");
		// postalCode.sendKeys("84043");
	}

	// FunctionToEnterCity
	public void enterCity1() {
		TimeUtil.sendKeys(driver, city, 20, "Lehi");
		// city.sendKeys("Lehi");
	}

	// FunctionToEnterPhone
	public void enterPhone1() {
		TimeUtil.sendKeys(driver, phone, 20, "8264270071");
		// phone.sendKeys("8264270071");
	}

	// FunctionToClearReferenceNumberField
	public void clearOrder() {
		orderNo.clear();
	}


	public void clickOnSaveLater() {
		TimeUtil.clickOn(driver, saveLater, 20);
		
	}


	public void clickOnPrintButton() {
	
		TimeUtil.clickOn(driver, print, 30);
	}
	
	
	public void enterInvalidReferenceNumber(String invalidReferenceNumber)
	{
		TimeUtil.sendKeys(driver, orderNo, 20, invalidReferenceNumber);
		
	}
	
	public void tapEnterInReferenceNumberField() throws InterruptedException
	{
		Thread.sleep(5000);
		orderNo.sendKeys(Keys.ENTER);
	}
	
	public void clearReferenceField() throws InterruptedException
	{
		
		Thread.sleep(2000);
		orderNo.clear();
			
	}
	

	public void enterOrdRefNo(String referenceNumber) {
		TimeUtil.sendKeys(driver, orderNo, 20, referenceNumber);
		
	}
	
	public void enterAddress(String address) {
		TimeUtil.sendKeys(driver, address1, 20, address);
		
	}
	

	public void enterZip(String zip1) {
		TimeUtil.sendKeys(driver, zip, 20, zip1);
		
	}
	
	public void enterCity(String city1) {
		TimeUtil.sendKeys(driver, city, 20, city1);
		
	}

	public void enterWeightOZ(String weightOZ1) {
		TimeUtil.sendKeys(driver, OZ, 20, weightOZ1);
		
	}
	
	

	public void enterDiemensionX(String dimensionX1) {
		TimeUtil.sendKeys(driver, dimensionX, 20, dimensionX1);
		
	}
	
	
	public void enterDiemensionY(String dimensionY1) {
		TimeUtil.sendKeys(driver, dimensionY, 20, dimensionY1);
		
	}
	
	
	public void enterDiemensionZ(String dimensionZ1) {
		TimeUtil.sendKeys(driver, dimensionZ, 20, dimensionZ1);
		
	}
	
	
	public void clearWeightField() throws InterruptedException
	{
		
		Thread.sleep(2000);
	    OZ.clear();
			
	}
	
	public void clearCityField() throws InterruptedException
	{
		
		Thread.sleep(2000);
		city.clear();
			
	}
	public void clearZipField() throws InterruptedException
	{
		
		Thread.sleep(2000);
		zip.clear();
			
	}
	
	
	public void clearAddress() throws InterruptedException
	{
		Thread.sleep(2000);
		address1.clear();
			
	}
	
	
	public void enterCompany(String companyVal) throws InterruptedException
	{
		Thread.sleep(2000);
		TimeUtil.sendKeys(driver, company, 20, companyVal);
			
	}
	
	public  void enterWeightInOZ()
	{
		
		OZ.sendKeys("10");
	}
	
	
	public  void clickOnPrintB()
	{
		
		print1.click();
	}
	
	public void clickOnShipmentsTab()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", shipmentsTab);
		TimeUtil.clickOn(driver, shipmentsTab, 20);
		
	}
	
	public void clearRecipient()
	{for(int i=0; i<=2;i++){
		  try{
			  recipient.clear();
			     break;
			  }
			  catch(Exception e){
			     System.out.println(e.getMessage());
			  }
			}
		
		
	}
	
	public void searchRecipient() {
		TimeUtil.sendKeys(driver, recipient, 20, "UAT88");
		// recipient.sendKeys("dummyRecipient");
	}
	
	public void hoverOnEditShipmentIcon()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(editIcon).build().perform();
		
		
	}
	
	public void clickOnEditShipmentIcon() throws InterruptedException
	{
		   Thread.sleep(10000);
		   JavascriptExecutor executor = (JavascriptExecutor)driver;
		   executor.executeScript("arguments[0].click();", editIcon);
			
	}
	
	
	public void clickOnEditLink() throws InterruptedException
	{
		   Thread.sleep(10000);
		   JavascriptExecutor executor = (JavascriptExecutor)driver;
		   executor.executeScript("arguments[0].click();", editLink);
			
	}
	
	public void enterPhoneNumber()
	{
		
	TimeUtil.sendKeys(driver, phone, 20,"9856235624");
		
			}
	
	
	
	public void clickOnSaveAddress()
	{
		
		TimeUtil.clickOn(driver, saveChanges, 20);
		
		
	}
	
	
	public void clickOnRemoveLink()
	{
		
		TimeUtil.clickOn(driver, removeAddressLink, 20);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
