package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testbase.Base;
import Utility.TimeUtil;

public class AddShipmentProfile extends Base{

	@FindBy(xpath = "//i[@class='fa fa-wrench fa-fw']")
	@CacheLookup
	WebElement settingsTab;
	
	@FindBy(xpath = "//a[text()='Shipment Profiles']")
	@CacheLookup
	WebElement shipmentProfiletab;
	
	
	@FindBy(xpath = "//button[@type='button']")
	@CacheLookup
	WebElement addShipmentProfileButton;
	
	
	@FindBy(xpath = "//input[@name='shipmentProfileName']")
	@CacheLookup
	WebElement shipmentProfileName;
	
	
	@FindBy(xpath = "//button[text()='Submit']")
	@CacheLookup
	WebElement submitButton;
	
	
	public AddShipmentProfile()
	{
	PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnSettingsTab() throws InterruptedException
	{
        Thread.sleep(10000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", settingsTab);
		
	}
	
	public void clickOnShipmentProfileTab() throws InterruptedException
	{
		Thread.sleep(10000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", shipmentProfiletab);
		
	}
	
	public void clickOnAddShipmentProfileButton() throws InterruptedException
	{
		Thread.sleep(10000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", addShipmentProfileButton);
		
	}
	

	public void enterShipmentProfileName(String shipmentProfileNameVal) throws InterruptedException
	{
		
		TimeUtil.sendKeys(driver, shipmentProfileName, 20, shipmentProfileNameVal);
		
	}
	
	public void clickOnSubmitButton()
	{
		TimeUtil.clickOn(driver, submitButton, 20);
		
	}
	
	
	
	
	
	
	
	
}
