package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductsPage2 {
@FindBy(name="email")
private WebElement email;
@FindBy(name="password")
private WebElement password;
@FindBy(xpath="//button[text()='Sign In']")
private WebElement signIn;
@FindBy(xpath="//h3[text()='Products']")
private WebElement products;
@FindBy(xpath="//i[@class=\"fa fa-plus\"]")
private WebElement addProducts;
@FindBy(xpath="(//input[@type=\"checkbox\"])[10]")
private WebElement selectProducts;
@FindBy(xpath="//i[@class=\"fa fa-pencil\"]")
private WebElement editProducts;
@FindBy(name="sku")
private WebElement sku;
@FindBy(name="name")
private WebElement name;
@FindBy(name="basePriceEach")
private WebElement basePrice;
@FindBy(name="insuranceValue")
private WebElement insuranceValue;
@FindBy(name="description")
private WebElement description;
@FindBy(name="isEnabled")
private WebElement isEnabled;
@FindBy(xpath="//div[text()='Select Tag(s)']")
private WebElement tags;
@FindBy(xpath="//div[text()='Black Color']")
private WebElement selectTags;
@FindBy(name="weightLbs")
private WebElement weightLbs;
@FindBy(name="weightOz")
private WebElement weightOz;
@FindBy(xpath="(//input[@type=\"text\"])[1]")
private WebElement sku1;
@FindBy(xpath="//button[text()='Yes']")
private WebElement yes;
@FindBy(id="searchName")
private WebElement productName;
@FindBy(xpath="//button[text()='Save']")
private WebElement save;


public AddProductsPage2(WebDriver driver)
{
	PageFactory.initElements(driver,this);
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
public void products()
{
	products.click();
}
public void addProducts()
{
	addProducts.click();
}
public void selectProducts()
{
	selectProducts.click();
}
public void editProducts()
{
	editProducts.click();
}
public void sku(String s1)
{
	sku.sendKeys(s1);
}
public void name(String s2)
{
	name.clear();
	name.sendKeys(s2);
}
public void basePrice(String s3)
{
	basePrice.sendKeys(s3);
}
public void insuranceValue(String s4)
{
	insuranceValue.sendKeys(s4);
}
public void description(String s5)
{
	description.sendKeys(s5);
}
public void isEnabled()
{
	isEnabled.click();
}
public void tags()
{
	tags.click();
}
public void selectTags()
{
	selectTags.click();
}
public void weightLbs(String s6)
{
	weightLbs.sendKeys(s6);
}
public void weightOz(String s7)
{
	weightOz.sendKeys(s7);
}
public void sku1(String ss)
{
	sku1.clear();
	sku1.sendKeys(ss);
}
public void yes()
{
	yes.click();
}
public void productName(String pn)
{
	productName.sendKeys(pn);
}
public void save()
{
	save.click();
}
}