package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Testbase.Base;
import Utility.TimeUtil;

public class AddProducts extends Base {
	
	

	@FindBy(xpath = "//h3[text()='Products']")
	@CacheLookup
	WebElement productsTab;
	
	
	@FindBy(xpath = "//i[@class='fa fa-plus']")
	@CacheLookup
	WebElement addProductIcon;
	
	
	@FindBy(xpath = "//input[@id='sku']")
	@CacheLookup
	WebElement sku;
	
	@FindBy(xpath = "//input[@id='name']")
	@CacheLookup
	WebElement name;
	
	
	@FindBy(xpath = "//button[@type='button']")
	@CacheLookup
	WebElement saveButton;
	
	
	
	public AddProducts()
	{
	PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnProductsTab() throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(productsTab));
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", productsTab);
		
	}
	
	public void clickOnAddProductIcon() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(addProductIcon));
		
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", addProductIcon);
		
	}
	
	
	public void enterSKU(String SKU)
	{
		
	TimeUtil.sendKeys(driver, sku, 20, SKU);
	}
	
	
	public void enterProductName(String productName)
	{
		
		TimeUtil.sendKeys(driver, name, 20, productName);
		
	}
	
	
	public void clearProductName()
	{
		
		name.clear();
		
	}
	
	
	public void clickOnSaveButton()
	{
		
		TimeUtil.clickOn(driver, saveButton, 20);
		
	}
	
}
