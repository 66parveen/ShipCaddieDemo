package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testbase.Base;
import Utility.TimeUtil;

public class AddOrder extends Base {
	
	
	@FindBy(xpath = "//a[text()='Ready to Ship']")
	@CacheLookup
	WebElement readyToShip;
	
	
	@FindBy(xpath = "//i[@class='fa fa-shopping-cart fa-fw']")
	@CacheLookup
	WebElement ordersTab;
	
	
	@FindBy(xpath = "//span[text()='Add']")
	@CacheLookup
	WebElement addOrderIcon;
	
	
	@FindBy(xpath = "//input[@id='orderNumber']")
	@CacheLookup
	WebElement orderNumber;
	
	@FindBy(xpath = "//input[@id='addressLine1']")
	@CacheLookup
	WebElement address1;
	
	
	@FindBy(xpath = "//input[@id='autocomplete-address']")
	@CacheLookup
	WebElement searchContactslink;
	
	@FindBy(xpath = "//div[@class='rt-expander']")
	@CacheLookup
	WebElement shipLinkhover;
	

	@FindBy(xpath = "//i[@title='ship']")
	@CacheLookup
	WebElement shipLink;
	
	
	@FindBy(xpath = "//button[text()='Save']")
	@CacheLookup
	WebElement saveButton;
	
	

	public AddOrder()
	{
	PageFactory.initElements(driver, this);
		
	}
	
	
	public void clickOnReadyToShip() throws InterruptedException
	{
		
		 Thread.sleep(10000);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", readyToShip);
	}
	

	public void clickOnOrdersTab() throws InterruptedException
	{
		 Thread.sleep(10000);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ordersTab);
	}
	
	
	public void clickOnAddOrderIcon() throws InterruptedException
	{
		    Thread.sleep(10000);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", addOrderIcon);	
	}
	
	
	public void enterOrderNumber(String orderNumberVal)
	{
		
		TimeUtil.sendKeys(driver, orderNumber, 20, orderNumberVal);	
	}
	

	public void enterContact(String searchContact)
	{
		
		TimeUtil.sendKeys(driver, searchContactslink, 20, searchContact);
		
	}
	
	public void tapDownOnContactField()
	{
		
		searchContactslink.sendKeys(Keys.DOWN);
		searchContactslink.sendKeys(Keys.ENTER);
			
	}
	
	public void enterAddress(String address)
	{
		TimeUtil.sendKeys(driver, address1, 20, address);
			
	}
		
	public void hoverOnShip()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(shipLinkhover).build().perform();
		
	}
	
	public void clickOnShip() throws InterruptedException
	{
		   Thread.sleep(10000);
		   JavascriptExecutor executor = (JavascriptExecutor)driver;
		   executor.executeScript("arguments[0].click();", shipLink);
		
	}
	public void clickOnSaveButton()
	{
		TimeUtil.clickOn(driver, saveButton, 20);
		
	}
	

}
