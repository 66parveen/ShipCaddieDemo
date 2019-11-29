package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testbase.Base;

public class ImportOrderPage extends Base {
@FindBy(name="email")
private WebElement email;
@FindBy(name="password")
private WebElement password;
@FindBy(xpath="//button[text()='Sign In']")
private WebElement signIn;
@FindBy(xpath="//h3[text()='Orders']")
private WebElement orders;
@FindBy(xpath="//span[text()='Import Orders']")
private WebElement importOrders;
@FindBy(xpath="//label[text()='Choose CSV File']")
private WebElement csvFile;
@FindBy(xpath="//a[text()='change']")
private WebElement change;
@FindBy(xpath="//a[text()='create a new csv mapper']")
private WebElement newCSVMapper;
@FindBy(xpath="(//span[text()='Choose a Field Name'])[1]")
private WebElement fieldName;
@FindBy(xpath="(//span[text()='No Mapping'])[10]")
private WebElement noMapping;
@FindBy(xpath="(//li[text()='OrderDate'])[2]")
private WebElement selectOrderDate;
@FindBy(xpath="(//li[text()='OrderNumber'])[2]")
private WebElement selectOrderNumber;
@FindBy(xpath="(//li[text()='Name'])[2]")
private WebElement selectAttentionOf;
@FindBy(xpath="(//li[text()='Company'])[2]")
private WebElement selectCompany;
@FindBy(xpath="(//li[text()='PhoneNumber'])[2]")
private WebElement selectPhoneNumber;
@FindBy(xpath="(//li[text()='Email'])[2]")
private WebElement selectEmail;
@FindBy(xpath="(//li[text()='Address1'])[2]")
private WebElement selectAddressLine1;
@FindBy(xpath="(//li[text()='Address2'])[2]")
private WebElement selectAddressLine2;
@FindBy(xpath="(//li[text()='City'])[2]")
private WebElement selectCity;
@FindBy(xpath="(//li[text()='state'])[2]")
private WebElement selectProvince;
@FindBy(xpath="(//li[text()='ZipCode'])[2]")
private WebElement selectPostalCode;
@FindBy(xpath="(//li[text()='Country'])[2]")
private WebElement selectCountryCode;
@FindBy(xpath="(//li[text()='ItemSKU'])[2]")
private WebElement selectItemSKU;
@FindBy(xpath="(//li[text()='ItemQTY'])[2]")
private WebElement selectItemQuantity;
@FindBy(xpath="(//li[text()='ItemName'])[2]")
private WebElement selectItemName;
@FindBy(name="clientmapname")
private WebElement mapperName;
@FindBy(xpath="//span[text()='Save CSV Mapper']")
private WebElement saveCSVMapper;
@FindBy(xpath="//span[@rv-show=\"areThereClientMaps\"]")
private WebElement importOrders2;

public ImportOrderPage()
{
	PageFactory.initElements(driver, this);
}

public void email(String un)
{
	email.sendKeys(un);
}
public void password(String pw)
{
	password.sendKeys(pw);
}
public void signIn()
{
	signIn.click();
}
public void orders()
{
	orders.click();
}
public void importOrders()
{
	importOrders.click();
}
public void csvFile()
{
	csvFile.click();
}
public void change()
{
	change.click();
}
public void newCSVMapper()
{
	newCSVMapper.click();
}
public void fieldName()
{
	fieldName.click();
}
public void noMapping()
{
	noMapping.click();
}
public void selectOrderDate()
{
	selectOrderDate.click();
}
public void selectOrderNumber()
{
	selectOrderNumber.click();
}
public void selectAttentionOf()
{
	selectAttentionOf.click();
}
public void selectCompany()
{
	selectCompany.click();
}
public void selectPhoneNumber()
{
	selectPhoneNumber.click();
}
public void selectEmail()
{
	selectEmail.click();
}
public void selectAddressLine1()
{
	selectAddressLine1.click();
}
public void selectAddressLine2()
{
	selectAddressLine2.click();
}
public void selectCity()
{
	selectCity.click();
}
public void selectProvince()
{
	selectProvince.click();
}
public void selectPostalCode()
{
	selectPostalCode.click();
}
public void selectCountryCode()
{
	selectCountryCode.click();
}
public void selectItemSKU()
{
	selectItemSKU.click();
}
public void selectItemQuantity()
{
	selectItemQuantity.click();
}
public void selectItemName()
{
	selectItemName.click();
}
public void mapperName(String mn)
{
	mapperName.sendKeys(mn);
}
public void saveCSVMapper()
{
	saveCSVMapper.click();
}
public void importOrders2()
{
	importOrders2.click();
}
}
