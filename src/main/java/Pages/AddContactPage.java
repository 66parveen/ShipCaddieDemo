package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Testbase.Base;
import Utility.TimeUtil;

public class AddContactPage extends Base {

@FindBy(xpath="//h3[text()='Contacts']")
private WebElement contacts;

@FindBy(xpath="//i[@class=\"fa fa-plus\"]")
private WebElement addContact;
@FindBy(name="customerId")
private WebElement customerId;
@FindBy(name="attentionOf")
private WebElement recipient;
@FindBy(name="company")
private WebElement organization;
@FindBy(name="phone")
private WebElement phone;
@FindBy(name="email")
private WebElement email2;
@FindBy(xpath="//div[text()='Select Tag(s)']")
private WebElement tags;
@FindBy(xpath="//div[text()='Black Color']")
private WebElement selectTags;
@FindBy(name="addressLine1")
private WebElement address1;
@FindBy(name="addressLine2")
private WebElement address2;
@FindBy(name="postalCode")
private WebElement zipCode;
@FindBy(name="city")
private WebElement city;
@FindBy(xpath="//div[text()='Select state']")
private WebElement state;
@FindBy(xpath="//div[text()='UT - Utah']")
private WebElement selectState;
@FindBy(name="systemCountryId")
private WebElement country;
@FindBy(xpath="//option[text()='United States']")
private WebElement selectCountry;
@FindBy(name="shipmentProfileId")
private WebElement shipmentProfile;
@FindBy(xpath="//option[text()='ABC TEST']")
private WebElement selectShipmentProfile;
@FindBy(name="clientAddressId")
private WebElement shippingSite;
@FindBy(xpath="//option[text()='ABC SITE ']")
private WebElement selectShippingSite;
@FindBy(name="carrierClientContractId")
private WebElement carrier;
@FindBy(xpath="//option[text()='USPS via ShipCaddie (Test Svr:Certify)']")
private WebElement selectCarrier;
@FindBy(name="carrierServiceLevelId")
private WebElement serviceLevel;
@FindBy(xpath="//option[text()='Priority Mail']")
private WebElement selectServiceLevel;
@FindBy(name="packagingId")
private WebElement packaging;
@FindBy(xpath="//option[text()='Custom Packaging']")
private WebElement selectPackaging;
@FindBy(xpath="//a[text()='URL']")
private WebElement url;
@FindBy(name="Url")
private WebElement urlName;
@FindBy(xpath="//a[text()='Upload']")
private WebElement upload;
@FindBy(xpath="//button[text()='Browse Files']")
private WebElement browseFiles;
@FindBy(name="autocomplete-address")
private WebElement searchContacts;
@FindBy(xpath="(//input[@type=\"checkbox\"])[7]")
private WebElement selectContacts;
@FindBy(xpath="//a[text()='Delete']")
private WebElement deleteContacts;
@FindBy(xpath="//button[text()='Yes']")
private WebElement yes;
@FindBy(xpath="//span[text()='Successfully Removed Address Entry']")
private WebElement removeContacts;
@FindBy(xpath="//button[text()='Use Entered']")
private WebElement useEntered;
@FindBy(xpath="//span[text()='Please use a unique customer id.']")
private WebElement duplicateCustomerId;
@FindBy(xpath="//i[@class=\"fa fa-pencil\"]")
private WebElement editContacts;
@FindBy(xpath="//i[@class=\"fa fa-times-circle closebutton\"]")
private WebElement closeButton;
@FindBy(xpath="(//input[@type=\"text\"])[5]")
private WebElement customerId2;

@FindBy(xpath="//button[text()='Submit']")
private WebElement submit;


@FindBy(xpath="//*[@id=\"addressbook-list\"]/div/div[2]/div[2]/div[1]/div[2]/div/div[3]/input")
private WebElement searchRecipient;


public AddContactPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}


public void contacts()
{
	contacts.click();
}



public void addContact()
{
	addContact.click();
}
public void customerId(String s1)
{
	customerId.clear();
	customerId.sendKeys(s1);
}
public void customerId2(String ci)
{
	customerId2.sendKeys(ci);
}
public void recipient(String s2)
{
	recipient.clear();
    recipient.sendKeys(s2);
}
public void organization(String s3)
{
	organization.clear();
	organization.sendKeys(s3);
}
public void phone(String s4)
{
	phone.clear();
	phone.sendKeys(s4);
}
public void email2(String s5)
{
	email2.clear();
	email2.sendKeys(s5);
}
public void tags()
{
	tags.click();
}
public void selectTags()
{
	selectTags.click();
}
public void address1(String s6)
{
	address1.clear();
	address1.sendKeys(s6);
}
public void address2(String s7)
{
	address2.clear();
	address2.sendKeys(s7);
}
public void zipCode(String s8)
{
	zipCode.clear();
	zipCode.sendKeys(s8);
}
public void city(String s9)
{
	city.clear();
	city.sendKeys(s9);
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
public void selectCountry()
{
	selectCountry.click();
}
public void shipmentProfile()
{
	shipmentProfile.click();
}
public void selectShipmentProfile()
{
	selectShipmentProfile.click();
}
public void shippingSite()
{
	shippingSite.click();
}
public void selectShippingSite()
{
	selectShippingSite.click();
}
public void carrier()
{
	carrier.click();
}
public void selectCarrier()
{
	selectCarrier.click();
}
public void serviceLevel()
{
	serviceLevel.click();
}
public void selectServiceLevel()
{
	selectServiceLevel.click();
}
public void packaging()
{
	packaging.click();
}
public void selectPackaging()
{
selectPackaging.click();
}
public void url()
{
	url.click();
}
public void urlName(String s11)
{
	urlName.sendKeys(s11);
}
public void upload()
{
	upload.click();
}
public void browseFiles()
{
	browseFiles.click();
}
public void searchContacts(String sc)
{
	searchContacts.sendKeys(sc);
}
public void selectContacts()
{
	selectContacts.click();
}
public void deleteContacts()
{
	deleteContacts.click();
}
public void yes()
{
	yes.click();
}
public void removeContacts()
{
	removeContacts.click();
}
public void useEntered()
{
	useEntered.click();
}
public void duplicateCustomerId()
{
	duplicateCustomerId.click();
}
public void editContacts()
{
	editContacts.click();
}
public void closeButton()
{
	closeButton.click();
}
public void submit()
{
	submit.click();
}

public void clickOnContactsTab()
{
	WebDriverWait wait = new WebDriverWait(driver, 100);
	wait.until(ExpectedConditions.visibilityOf(contacts));
	
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].click();", contacts);

}


public void searchAddedContact(String searchRecipientVal)
{
	TimeUtil.sendKeys(driver, searchRecipient, 12, searchRecipientVal);

}

public void clickOnUseEnteredButton()
{
	TimeUtil.clickOn(driver, useEntered, 10);
}




}

