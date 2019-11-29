package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testbase.Base;
import Utility.TimeUtil;

public class ImportShipmentPage extends Base{

	//LocatorsValuesForImportShipment
	@FindBy(xpath = "//span[text()='Add']")
	@CacheLookup
	WebElement addShipPlusIcon;
	
    @FindBy(xpath = "//span[text()='Import Shipments']")
    @CacheLookup
	WebElement importShipmentsLink;
    
    @FindBy(xpath = "//a[text()='Cancel']")
    @CacheLookup
	WebElement cancelLink;
    
    @FindBy(xpath = "//i[@class='fa fa-times-circle closebutton']")
    @CacheLookup
	WebElement crossLink;
    
    @FindBy(xpath = "//span[text()='Import ']")
    @CacheLookup
	WebElement importButton;
    
    @FindBy(xpath = "//a[text()='change']")
    @CacheLookup
	WebElement change;
    
    @FindBy(xpath = "//i[@class='fa fa-pencil']")
    @CacheLookup
	WebElement edit;
    
    @FindBy(xpath = "//i[@class='fa fa-trash']")
    @CacheLookup
	WebElement delete;
    
    @FindBy(xpath = "//a[text()='download our CSV Template']")
    @CacheLookup
	WebElement csvDownloadLink;
    
    @FindBy(xpath = "//input[@id='orderNumberReference']")
    @CacheLookup
	WebElement orderReferenceNumber;
    
    @FindBy(xpath = "//span[text()='Print']")
    @CacheLookup
	WebElement printButton;
    
    @FindBy(xpath = "//button[text()='Save for Later']")
    @CacheLookup
	WebElement saveLater;
    
    @FindBy(xpath = "//button[data-api='api/Shipment/820894']")
    @CacheLookup
	WebElement orderDisplay;
    
    @FindBy(xpath = "//button[@id='dimensionX']")
    @CacheLookup
	WebElement length;
    
    @FindBy(xpath = "//button[@id='dimensionY']")
    @CacheLookup
	WebElement width;
    
    @FindBy(xpath = "//button[@id='dimensionZ']")
    @CacheLookup
	WebElement height;
    
    @FindBy(xpath = "//button[@id='weightLbs']")
    @CacheLookup
	WebElement weight;
    
    @FindBy(xpath = "//label[text()='Choose CSV File']")
    @CacheLookup
	WebElement chooseCSVFileButton;
    
    @FindBy(xpath = "//a[text()='create a new csv mapper']")
    @CacheLookup
	WebElement csvMapper;
    

    @FindBy(xpath = "//input[@name='clientmapname']")
    @CacheLookup
	WebElement mapperName;
    
    
    @FindBy(xpath = "//span[text()='Save CSV Mapper']")
    @CacheLookup
	WebElement saveCSVMapper;
    
    
    @FindBy(xpath = "//button[text()='Import without Corrections']")
    @CacheLookup
	WebElement importWithCorrection;
    
    
    
	// ConstructorToInitalizeVarialeAndMethods
	public ImportShipmentPage() {

		PageFactory.initElements(driver, this);

	}

	//FunctionToClickOnAddShipmentIcon
	public void clickOnAddShipPlusIcon() {
    TimeUtil.clickOn(driver, addShipPlusIcon, 20);
	//Helper.Wait.clickOn(driver, addShipPlusIcon, 15);

	}

	//FunctionToClickOnImportShipmentLink
	public void clickOnImportShipmentsLink() {
		   TimeUtil.clickOn(driver, importShipmentsLink, 20);
		//Helper.Wait.clickOn(driver, importShipmentsLink, 3, null);

	}

	//FunctionToClickOnCancelLink
	public void clickOnCancelLink() {
		
		 TimeUtil.clickOn(driver, cancelLink, 30);

	}
	
	//FunctionToClickOnCrossLink
	public void clickOnCrossLink() {
		 TimeUtil.clickOn(driver, crossLink,30);

	}

	//FunctionToClickOnImportButton
	public void clickOnImportButton() {
		 TimeUtil.clickOn(driver, importButton, 10);

	}

	//FunctionToClickOnChangeLink
	public void clickOnChangeLink() {
		 TimeUtil.clickOn(driver, change, 10);

	}

	//FunctionToClickOnEditIcon
	public void clickOnEditIcon() {
		 TimeUtil.clickOn(driver, edit, 10);

	}
	
	//FunctionToClickOnDeleteIcon
	public void clickOnDeleteIcon() {
		 TimeUtil.clickOn(driver, delete, 10);

	}

	//FunctionToClickOnDownloadCSVTemplateLink
	public void clickOnDownloadCSVTemplateLink() {
		 TimeUtil.clickOn(driver, csvDownloadLink, 20);

	}
	
	//FunctionToEnterInvalidReferenceNumber
	public void EnterInvalidReferenceNumber() {
		 TimeUtil.sendKeys(driver, orderReferenceNumber, 10, "Shame");

	}

	//FunctionToEnterValidReferenceNumber
	public void EnterValidReferenceNumber() {
		 TimeUtil.sendKeys(driver, orderReferenceNumber, 10, "1881- 1");

	}
	//FunctionToTapInReferenceField
	public void tapEnterInReferenceNumberField() {
		orderReferenceNumber.sendKeys(Keys.ENTER);

	}

	//FunctionToClickOnBlindShip
	public void clickOnBlindShip() {
		orderReferenceNumber.sendKeys(Keys.ENTER);

	}

	//FunctionToClickOnPrintButton
	public void clickOnPrintButton() {
	TimeUtil.clickOn(driver, printButton, 10);


	}

	//FunctionToClearReferenceField
	public void clearReferenceField() {
		orderReferenceNumber.clear();

	}

	//FunctionToClickOnSaveForLater
	public void clickOnSaveForLater() {
		TimeUtil.clickOn(driver, saveLater, 10);
		//saveLater.click();

	}

	//FunctionToClickOnOrderDisplayed
	public void clickOnOrderDisplayed() {
		TimeUtil.clickOn(driver, orderDisplay, 10);
		//orderDisplay.click();

	}

	//FunctionToEnterSizeDetails
	public void enterSizeDetails() {
		 TimeUtil.sendKeys(driver, length, 10, "10");
		 TimeUtil.sendKeys(driver, width, 10, "10");
		 TimeUtil.sendKeys(driver, height, 10, "10");
		
		//length.sendKeys("10");
		//width.sendKeys("10");
		//height.sendKeys("10");

	}

	//FunctionToEnterWeight
	public void enterWeightDetails() {
		 TimeUtil.sendKeys(driver,weight, 10, "10");
		//weight.sendKeys("30");

	}

	//FunctionToClickOnChooseCSVFileButton
	public void clickOnChooseCSVFileButton() {

		TimeUtil.clickOn(driver, chooseCSVFileButton, 10);
		//chooseCSVFileButton.click();
	}
	
	public void enterMapperName()
	{	 TimeUtil.sendKeys(driver,mapperName, 10, "Rafta");
		
		//mapperName.sendKeys("Rafta");
	}
	
	public void clickOnSaveCSVMapper()
	{	
		TimeUtil.clickOn(driver, saveCSVMapper, 10);
		//saveCSVMapper.click();
	}
	
	
	
	//FunctionToClickOnImportShipmentButton
	public void clickOnImportShipmentbutton()
	{
		TimeUtil.clickOn(driver, importButton, 30);
		
		//importButton.click();
		
	}

	
	//FunctionToClickOnImportWithCorrection
	public void clickOnImportWithCorrection()
	{
		WebElement element=driver.findElement(By.xpath("//button[text()='Import without Corrections']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		TimeUtil.clickOn(driver, element,50);
		
	}
	
	public void selectCarrierOption() throws InterruptedException {
		driver.findElements(By.xpath("//a[@class='displayasselect']")).get(0).click();

		List<WebElement> mapList = driver.findElements(By.xpath("//div[@class='clientheaderslist']//li"));
		System.out.println(mapList.size());

		Thread.sleep(3000);

		for (int i = 0; i < mapList.size(); i++) {
			System.out.println(mapList.get(i).getText());
			if (mapList.get(i).getText().equals("Carrier")) {

				mapList.get(i).click();
				break;
			}
		}
	}

	public void selectAttentionOfOption() throws InterruptedException {
		driver.findElements(By.xpath("//a[@class='displayasselect']")).get(1).click();

		List<WebElement> mapList = driver.findElements(By.xpath("//div[@class='clientheaderslist']//li"));
		System.out.println(mapList.size());

		Thread.sleep(3000);

		for (int i = 0; i < mapList.size(); i++) {
			System.out.println(mapList.get(i).getText());
			if (mapList.get(i).getText().equals("Recipient")) {

				mapList.get(i).click();
				break;
			}
		}

	}

	public void selectPhone() throws InterruptedException {
		driver.findElements(By.xpath("//a[@class='displayasselect']")).get(3).click();

		List<WebElement> mapList = driver.findElements(By.xpath("//div[@class='clientheaderslist']//li"));
		System.out.println(mapList.size());

		Thread.sleep(3000);

		for (int i = 0; i < mapList.size(); i++) {
			System.out.println(mapList.get(i).getText());
			if (mapList.get(i).getText().equals("Phone")) {

				mapList.get(i).click();
				break;
			}
		}

	}

	public void selectReference() throws InterruptedException {
		driver.findElements(By.xpath("//a[@class='displayasselect']")).get(6).click();

		List<WebElement> mapList = driver.findElements(By.xpath("//div[@class='clientheaderslist']//li"));
		System.out.println(mapList.size());

		Thread.sleep(3000);

		for (int i = 0; i < mapList.size(); i++) {
			System.out.println(mapList.get(i).getText());
			if (mapList.get(i).getText().equals("Reference#")) {

				mapList.get(i).click();
				break;
			}
		}

	}

	public void selectAddress() throws InterruptedException {
		driver.findElements(By.xpath("//a[@class='displayasselect']")).get(7).click();

		List<WebElement> mapList = driver.findElements(By.xpath("//div[@class='clientheaderslist']//li"));
		System.out.println(mapList.size());

		Thread.sleep(3000);

		for (int i = 0; i < mapList.size(); i++) {
			System.out.println(mapList.get(i).getText());
			if (mapList.get(i).getText().equals("Address")) {

				mapList.get(i).click();
				break;
			}
		}

	}

	public void selectCity() throws InterruptedException {
		driver.findElements(By.xpath("//a[@class='displayasselect']")).get(9).click();

		List<WebElement> mapList = driver.findElements(By.xpath("//div[@class='clientheaderslist']//li"));
		System.out.println(mapList.size());

		Thread.sleep(3000);

		for (int i = 0; i < mapList.size(); i++) {
			System.out.println(mapList.get(i).getText());
			if (mapList.get(i).getText().equals("City")) {

				mapList.get(i).click();
				break;
			}
		}

	}

	public void selectState() throws InterruptedException {
		driver.findElements(By.xpath("//a[@class='displayasselect']")).get(10).click();

		List<WebElement> mapList = driver.findElements(By.xpath("//div[@class='clientheaderslist']//li"));
		System.out.println(mapList.size());

		Thread.sleep(3000);

		for (int i = 0; i < mapList.size(); i++) {
			System.out.println(mapList.get(i).getText());
			if (mapList.get(i).getText().equals("State")) {

				mapList.get(i).click();
				break;
			}
		}

	}

	public void selectZip() throws InterruptedException {
		driver.findElements(By.xpath("//a[@class='displayasselect']")).get(11).click();

		List<WebElement> mapList = driver.findElements(By.xpath("//div[@class='clientheaderslist']//li"));
		System.out.println(mapList.size());

		Thread.sleep(3000);

		for (int i = 0; i < mapList.size(); i++) {
			System.out.println(mapList.get(i).getText());
			if (mapList.get(i).getText().equals("Zip")) {

				mapList.get(i).click();
				break;
			}
		}

	}

	public void selectCountry() throws InterruptedException {
		driver.findElements(By.xpath("//a[@class='displayasselect']")).get(12).click();

		List<WebElement> mapList = driver.findElements(By.xpath("//div[@class='clientheaderslist']//li"));
		System.out.println(mapList.size());

		Thread.sleep(3000);

		for (int i = 0; i < mapList.size(); i++) {
			System.out.println(mapList.get(i).getText());
			if (mapList.get(i).getText().equals("Country")) {

				mapList.get(i).click();
				break;
			}
		}

	}

	public void selectLength() throws InterruptedException {
		driver.findElements(By.xpath("//a[@class='displayasselect']")).get(13).click();

		List<WebElement> mapList = driver.findElements(By.xpath("//div[@class='clientheaderslist']//li"));
		System.out.println(mapList.size());

		Thread.sleep(3000);

		for (int i = 0; i < mapList.size(); i++) {
			System.out.println(mapList.get(i).getText());
			if (mapList.get(i).getText().equals("DomensionX")) {

				mapList.get(i).click();
				break;
			}
		}

	}

	public void selectWidth() throws InterruptedException {
		driver.findElements(By.xpath("//a[@class='displayasselect']")).get(14).click();

		List<WebElement> mapList = driver.findElements(By.xpath("//div[@class='clientheaderslist']//li"));
		System.out.println(mapList.size());

		Thread.sleep(3000);

		for (int i = 0; i < mapList.size(); i++) {
			System.out.println(mapList.get(i).getText());
			if (mapList.get(i).getText().equals("DomensionY")) {

				mapList.get(i).click();
				break;
			}
		}

	}

	public void selectHeight() throws InterruptedException {
		driver.findElements(By.xpath("//a[@class='displayasselect']")).get(15).click();

		List<WebElement> mapList = driver.findElements(By.xpath("//div[@class='clientheaderslist']//li"));
		System.out.println(mapList.size());

		Thread.sleep(5000);

		for (int i = 0; i < mapList.size(); i++) {
			System.out.println(mapList.get(i).getText());
			if (mapList.get(i).getText().equals("DomensionZ")) {

				mapList.get(i).click();
				break;
			}
		}

	}

	public void selectWeight() throws InterruptedException {
		driver.findElements(By.xpath("//a[@class='displayasselect']")).get(16).click();

		List<WebElement> mapList = driver.findElements(By.xpath("//div[@class='clientheaderslist']//li"));
		System.out.println(mapList.size());

		Thread.sleep(5000);

		for (int i = 0; i < mapList.size(); i++) {
			System.out.println(mapList.get(i).getText());
			if (mapList.get(i).getText().equals("Weight")) {

				mapList.get(i).click();
				break;
			}
		}

	}
}
