package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Testbase.Base;
import Utility.TimeUtil;

public class AddOrderPage extends Base {


@FindBy(xpath="//h3[text()='Orders']")
private WebElement orders;

@FindBy(xpath="//span[text()='Add']")
private WebElement addOrders;

@FindBy(name="orderNumber")
private WebElement orderNumber;


@FindBy(name="autocomplete-address")
private WebElement recipientInformation;
@FindBy(xpath="//div[text()='Select Shipping Site']")
private WebElement shippingSite;
@FindBy(xpath="//div[text()='ABC SITE ']")
private WebElement selectShippingSite;
@FindBy(xpath="//div[text()='Select Carrier']")
private WebElement shipmentCarrier;
@FindBy(xpath="//div[text()='USPS via ShipCaddie (Test Svr:Certify)']")
private WebElement selectShipmentCarrier;
@FindBy(xpath="//div[text()='Select Service']")
private WebElement shipmentService;
@FindBy(xpath="//div[text()='Priority Mail']")
private WebElement selectShipmentService;
@FindBy(xpath="//div[text()='Select Packaging']")
private WebElement shipmentPackaging;
@FindBy(xpath="//div[text()='Custom Packaging']")
private WebElement selectShipmentPackaging;
@FindBy(id="dimensionX")
private WebElement packagingLength;
@FindBy(id="dimensionY")
private WebElement packagingWidth;
@FindBy(id="dimensionZ")
private WebElement packagingHeight;

@FindBy(name="attentionOf")
private WebElement recipient;

@FindBy(name="customerId")
private WebElement customerId;

@FindBy(name="company")
private WebElement organization;

@FindBy(name="addressLine1")
private WebElement addressLine1;


@FindBy(name="addressLine1")
private WebElement address;

@FindBy(name="addressLine2")
private WebElement addressLine2;

@FindBy(name="postalCode")
private WebElement postalCode;


@FindBy(name="postalCode")
private WebElement zip;

@FindBy(name="city")
private WebElement city;

@FindBy(xpath="//div[text()='Select state']")
private WebElement state;
@FindBy(xpath="//div[text()='UT - Utah']")
private WebElement selectState;
@FindBy(name="systemCountryId")
private WebElement country;
@FindBy(name="phone")
private WebElement phone;
@FindBy(name="email")
private WebElement email2;
@FindBy(id="searchSku")
private WebElement searchSku;
@FindBy(xpath="//input[@placeholder=\"Name\"]")
private WebElement searchName;
@FindBy(xpath="//input[@placeholder=\"Description\"]")
private WebElement searchDesc;
@FindBy(xpath="//input[@placeholder=\"Qty\"]")
private WebElement itemQty;
@FindBy(xpath="(//input[@type=\"number\"])[10]")
private WebElement modalWeightLbs;
@FindBy(xpath="(//input[@type=\"number\"])[11]")
private WebElement modalWeightOz;
@FindBy(xpath="(//input[@type=\"text\"])[28]")
private WebElement tariff;
@FindBy(xpath="//button[text()='Save']")
private WebElement save;

@FindBy(xpath = "//h3[text()='Orders']")
@CacheLookup
WebElement ordersTab;

@FindBy(xpath = "//input[@name='saveToAddressBookCheckbox']")
@CacheLookup
WebElement saveToContacts;


@FindBy(xpath = "//span[text()='edit']")
@CacheLookup
WebElement editLink;

@FindBy(xpath = "//button[text()='Save']")
@CacheLookup
WebElement saveOrder;



public AddOrderPage()
{
PageFactory.initElements(driver,this);	
}


public void orders()
{
	orders.click();
}
public void addOrders()
{
	addOrders.click();
}
public void orderNumber(String on)
{
	orderNumber.sendKeys(on);
}
public void shippingSite()
{
	shippingSite.click();
}
public void selectShippingSite()
{
	selectShippingSite.click();
}
public void shipmentCarrier()
{
	shipmentCarrier.click();
}
public void selectShipmentCarrier()
{
	selectShipmentCarrier.click();
}
public void shipmentService()
{
	shipmentService.click();
}
public void selectShipmentService()
{
	selectShipmentService.click();
}
public void shipmentPackaging()
{
	shipmentPackaging.click();
}
public void selectShipmentPackaging()
{
	selectShipmentPackaging.click();
}
public void packagingLength(String l)
{
	packagingLength.sendKeys(l);
}
public void packagingWidth(String w)
{
	packagingWidth.sendKeys(w);
}
public void packagingHeight(String h)
{
	packagingHeight.sendKeys(h);
}
public void recipient(String ss5)
{
	recipient.sendKeys(ss5);
}
public void customerId(String ss6)
{
	customerId.sendKeys(ss6);
}
public void organization(String ss7)
{
    organization.sendKeys(ss7);
}
public void addressLine1(String ss8)
{
	addressLine1.sendKeys(ss8);
}
public void addressLine2(String ss9)
{
	addressLine2.sendKeys(ss9);
}
public void postalCode(String ss10)
{
	postalCode.sendKeys(ss10);
}
public void city(String ss11)
{
	city.sendKeys(ss11);
}
public void state()
{
    state.click();
}
public void selectState()
{
	selectState.click();
}
public void country()
{
	country.click();
}
public void phone(String ss13)
{
	phone.sendKeys(ss13);
}
public void email2(String ss14)
{
	email2.sendKeys(ss14);
}
public void recipientInformation()
{
	recipientInformation.click();
}
public void recipientInformation1(String ri)
{
	recipientInformation.sendKeys(ri);
}
public void searchSku(String sku1)
{
	searchSku.sendKeys(sku1);
}
public void searchName(String name1)
{
	searchName.sendKeys(name1);
}
public void searchDesc(String desc1)
{
	searchDesc.sendKeys(desc1);
}
public void itemQty(String qty1)
{
	itemQty.sendKeys(qty1);
}
public void modalWeightLbs(String mw)
{
	modalWeightLbs.sendKeys(mw);
}
public void modalWeightOz(String mo)
{
	modalWeightOz.sendKeys(mo);
}
public void tariff(String ta)
{
	tariff.sendKeys(ta);
}


public void save()
{
	save.click();
}


public void clickOnOrdersTab()
{
	
	WebDriverWait wait = new WebDriverWait(driver, 100);
	wait.until(ExpectedConditions.visibilityOf(ordersTab));
	
	
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].click();", ordersTab);
	
}


public void clickOnAddOrderLink()
{
	
TimeUtil.clickOn(driver, addOrders, 10);
	

}


public void enterOrderNumber(String orderNum)
{
	
TimeUtil.sendKeys(driver, orderNumber, 10, orderNum);

}


public void enterRecipientName(String recipientName)
{
	
	TimeUtil.sendKeys(driver, recipient, 10, recipientName);
	
	
}



public void enterOrganization(String organizationName)
{
	
	TimeUtil.sendKeys(driver, organization, 10, organizationName);
	
	
}


public void enterAddress(String addessName)
{
	
	TimeUtil.sendKeys(driver, address, 10, addessName);
	
	
}

public void enterZip(String zipNum)
{
	
	TimeUtil.sendKeys(driver, zip, 10, zipNum);
	
	
}


public void enterCity(String cityName)
{
	
	TimeUtil.sendKeys(driver, city, 10, cityName);
	
	
}


public void selectState1() throws InterruptedException
{
	
	TimeUtil.clickOn(driver, state, 20);
	Thread.sleep(2000);
	WebElement ele = driver.findElement(By.xpath("//div[text()='AA - Armed Forces Americas']"));
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].click();", ele);

}

public void checkSaveToContacts()
{

	TimeUtil.clickOn(driver, saveToContacts, 10);
	
}


public void clickOnEditLink()
{
	
TimeUtil.clickOn(driver, editLink, 20);

}


public void clearRecipient()
{
	recipient.clear();

}


public void enterRecipientName1(String recipientName1)
{

	TimeUtil.sendKeys(driver, recipient, 20, recipientName1);

}


public void clickOnSaveButton()
{
	
TimeUtil.clickOn(driver, saveOrder, 20);

}




}