package tests2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.AddContactPage;
import Pages.AddOrderPage;
import Pages.AddShipmentPage;
import Pages.LoginPage;
import Testbase.Base;

public class TestAddContacts2 extends Base {
	LoginPage login;
	AddContactPage contact;
	AddOrderPage order;
	AddShipmentPage shipments;
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	XSSFRow row;
	InputStream is;
	
	public TestAddContacts2() {
	super();
	}
	
	
	@BeforeClass
	public void setUp() throws IOException
	{
		intializeBrowser();

		login = PageFactory.initElements(driver, LoginPage.class);
		contact = PageFactory.initElements(driver, AddContactPage.class);
		order = PageFactory.initElements(driver, AddOrderPage.class);
		shipments = PageFactory.initElements(driver, AddShipmentPage.class);
		
		File file = new File("E:\\Parveen_New\\ShipCaddieTestData.xlsx");

		try {

			is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheet("login");
		}

		catch (Exception exp) {

			exp.printStackTrace();
		}

		String loginEmailValue = sheet.getRow(1).getCell(0).getStringCellValue();
		String loginPasswordValue = sheet.getRow(1).getCell(1).getStringCellValue();

		login.LoginIntoShipCaddie(loginEmailValue, loginPasswordValue);
		
	
	}
	
	
	
	/*
	@Test(priority=1)
public void testAddContactWindowAppearTC55()throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException
{
	Thread.sleep(10000);
		
		for (int i = 0; i <=2 ; i++)

		{

		try {

			WebDriverWait wait=new WebDriverWait(driver,60);
			WebElement contacts = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Contacts']")));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",contacts);

				break;

		}

			catch (Exception e) {

			e.printStackTrace();

		}

	}
		
		
		WebDriverWait wait=new WebDriverWait(driver,60);
		JavascriptExecutor js=(JavascriptExecutor)driver;
//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
///WebDriverWait wait=new WebDriverWait(driver,60);
//WebElement contacts = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Contacts']")));
//JavascriptExecutor js=(JavascriptExecutor)driver;
//js.executeScript("arguments[0].click();",contacts);
//Thread.sleep(25000);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebElement addContact = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class=\"fa fa-plus\"]")));
js.executeScript("arguments[0].click();", addContact);
Thread.sleep(10000);
boolean actual=driver.findElement(By.xpath("//span[text()=' Add New Contact']")).isDisplayed();
Assert.assertTrue(actual);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebElement closeButton = driver.findElement(By.xpath("//i[@class=\"fa fa-times-circle closebutton\"]"));
js.executeScript("arguments[0].click();", closeButton);
Thread.sleep(1000);
}

@Test(priority=2)
public void testValidationAppearWithoutEnteringDetailsTC56() throws InterruptedException
{
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebDriverWait wait=new WebDriverWait(driver,20);
WebElement addContact = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class=\"fa fa-plus\"]")));
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].click();",addContact);
Thread.sleep(1000);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
js.executeScript("arguments[0].click();", submit);
Thread.sleep(1000);
boolean actual=driver.findElement(By.xpath("//span[text()='Please correct the fields in red']")).isDisplayed();
Assert.assertTrue(actual);
WebElement closeButton = driver.findElement(By.xpath("//i[@class=\"fa fa-times-circle closebutton\"]"));
js.executeScript("arguments[0].click();", closeButton);
Thread.sleep(1000);
}

@Test(priority=3)
public void testAllFieldsEnableTC57() throws IOException, InterruptedException
{
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebDriverWait wait=new WebDriverWait(driver,20);
WebElement addContact = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class=\"fa fa-plus\"]")));
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].click();",addContact);
Thread.sleep(1000);

AddContactPage contact=new AddContactPage(driver);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customerId")));
contact.customerId("Test CustomerId");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("attentionOf")));
contact.recipient("Test Recipient");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("company")));
contact.organization("Test Organization");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("phone")));
contact.phone("123456789");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
contact.email2("test@gmail.com");
Thread.sleep(1000);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
driver.findElement(By.xpath("//div[text()='Select Tag(s)']")).click();
WebElement tags = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Select Tag(s)']")));
js.executeScript("arguments[0].click();", tags);
Thread.sleep(1000);
contact.selectTags();
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("addressLine1")));
contact.address1("E-200");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("addressLine2")));
contact.address2("Phase 8A");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("postalCode")));
contact.zipCode("84043");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("city")));
contact.city("Lehi");
Thread.sleep(1000);
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
WebElement state=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Select state']")));
js.executeScript("arguments[0].click();",state);
driver.findElement(By.xpath("//div[text()='Select state']")).click();
Thread.sleep(1000);
contact.selectState();
Thread.sleep(1000);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebElement country = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("systemCountryId")));
js.executeScript("arguments[0].click();",country);
Thread.sleep(1000);
contact.selectCountry();
Thread.sleep(1000);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebElement shipmentProfile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("shipmentProfileId")));
js.executeScript("arguments[0].click();",shipmentProfile);
Thread.sleep(1000);
contact.selectShipmentProfile();
Thread.sleep(1000);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebElement shippingSite=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("clientAddressId")));
js.executeScript("arguments[0].click();",shippingSite);
Thread.sleep(1000);
contact.selectShippingSite();
Thread.sleep(1000);
//driver.findElement(By.xpath("//button[text()='Use Entered']")).click();
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebElement carrier=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("carrierClientContractId")));
js.executeScript("arguments[0].click();", carrier);
Thread.sleep(1000);
contact.selectCarrier();
Thread.sleep(1000);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebElement serviceLevel=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("carrierServiceLevelId")));
js.executeScript("arguments[0].click();", serviceLevel);
Thread.sleep(1000);
contact.selectServiceLevel();
Thread.sleep(1000);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebElement packaging=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("packagingId")));
js.executeScript("arguments[0].click();", packaging);
Thread.sleep(1000);
contact.selectPackaging();
Thread.sleep(1000);
//driver.findElement(By.xpath("//button[text()='Use Entered']")).click();
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebElement url = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='URL']")));
js.executeScript("arguments[0].click();",url);
Thread.sleep(1000);
contact.urlName("dev.app.shipcaddie.com");
contact.upload();
Thread.sleep(1000);
//WebElement browseFiles=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Browse Files']")));
//js.executeScript("arguments[0].scrollIntoView(true);",browseFiles);
//browseFiles.click();
//Thread.sleep(2000);
//Runtime.getRuntime().exec("D:\\FileUploaderQ1.exe");
Thread.sleep(1000);
boolean actual=driver.findElement(By.xpath("//span[text()=' Add New Contact']")).isDisplayed();
Assert.assertTrue(actual);
WebElement closeButton = driver.findElement(By.xpath("//i[@class=\"fa fa-times-circle closebutton\"]"));
js.executeScript("arguments[0].click();", closeButton);
Thread.sleep(1000);
}

@Test(priority=4)
public void testContactIsAddedTC58() throws InterruptedException
{
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebDriverWait wait=new WebDriverWait(driver,20);
WebElement addContact=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class=\"fa fa-plus\"]")));
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].click();", addContact);
Thread.sleep(1000);
AddContactPage contact=new AddContactPage(driver);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customerId")));
contact.customerId("Test CustomerId");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("addressLine1")));
contact.address1("E-200");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("postalCode")));
contact.zipCode("84043");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("city")));
contact.city("Lehi");
Thread.sleep(1000);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
contact.state();
Thread.sleep(1000);
contact.selectState();
Thread.sleep(1000);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebElement country=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("systemCountryId")));
js.executeScript("arguments[0].click();",country);
Thread.sleep(1000);
contact.selectCountry();
//driver.findElement(By.xpath("//button[text()='Use Entered']")).click();
//contact.useEntered();
WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
js.executeScript("arguments[0].click();", submit);
Thread.sleep(1000);
boolean actual=driver.findElement(By.xpath("//span[text()='Please correct the fields in red']")).isDisplayed();
Assert.assertTrue(actual);
Thread.sleep(1000);
WebElement closeButton = driver.findElement(By.xpath("//i[@class=\"fa fa-times-circle closebutton\"]"));
js.executeScript("arguments[0].click();", closeButton);
Thread.sleep(1000);
}

@Test(priority=5)
public void testContactIsEditedTC59() throws InterruptedException
{
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
AddContactPage contact=new AddContactPage(driver);
WebDriverWait wait=new WebDriverWait(driver,20);
WebElement customerId=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type=\"text\"])[5]")));
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].click();",customerId);
contact.customerId2("demo");
Thread.sleep(1000);
WebElement selectContacts=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type=\"checkbox\"])[7]")));
js.executeScript("arguments[0].click();",selectContacts);
Thread.sleep(1000);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebElement editContacts=driver.findElement(By.xpath("//i[@class=\"fa fa-pencil\"]"));
js.executeScript("arguments[0].click();", editContacts);
Thread.sleep(2000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customerId")));
Thread.sleep(1000);
contact.customerId("demotest1");
Thread.sleep(1000);
WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
js.executeScript("arguments[0].click();", submit);
Thread.sleep(4000);
boolean actual=driver.findElement(By.xpath("//span[text()='Test47 contact info updated.']")).isDisplayed();
Assert.assertTrue(actual);
WebElement selectContacts1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type=\"checkbox\"])[7]")));
js.executeScript("arguments[0].click();",selectContacts1);
}

@Test(priority=6)
public void testDuplicateContactIsNotAddedTC60() throws InterruptedException
{
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
AddContactPage contact=new AddContactPage(driver);
WebDriverWait wait=new WebDriverWait(driver,20);
WebElement addContacts=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class=\"fa fa-plus\"]")));
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].click();",addContacts);
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customerId")));
contact.customerId("demotest12");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("attentionOf")));
contact.recipient("Test47");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("company")));
contact.organization("Test47");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("phone")));
contact.phone("8923654651");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
contact.email2("test47@gmail.com");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("addressLine1")));
contact.address1("Test47");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("addressLine2")));
contact.address2("Test47");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("postalCode")));
contact.zipCode("84043");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("city")));
contact.city("Lehi");
Thread.sleep(1000);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
contact.state();
Thread.sleep(5000);
contact.selectState();
Thread.sleep(1000);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebElement country = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("systemCountryId")));
js.executeScript("arguments[0].click();",country);
Thread.sleep(1000);
contact.selectCountry();
//driver.findElement(By.xpath("//button[text()='Use Entered']")).click();
Thread.sleep(1000);
WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
js.executeScript("arguments[0].click();", submit);
Thread.sleep(5000);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebElement addContacts1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class=\"fa fa-plus\"]")));
js.executeScript("arguments[0].click();",addContacts1);
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customerId")));
contact.customerId("demotest1");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("attentionOf")));
contact.recipient("Test47");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("company")));
contact.organization("Test47");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("phone")));
contact.phone("8923654651");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
contact.email2("test47@gmail.com");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("addressLine1")));
contact.address1("Test47");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("addressLine2")));
contact.address2("Test47");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("postalCode")));
contact.zipCode("84043");
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("city")));
contact.city("Lehi");
Thread.sleep(1000);
contact.state();
Thread.sleep(1000);
contact.selectState();
Thread.sleep(1000);
WebElement country1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("systemCountryId")));
js.executeScript("arguments[0].click();",country1);
Thread.sleep(1000);
contact.selectCountry();
//driver.findElement(By.xpath("//button[text()='Use Entered']")).click();
Thread.sleep(1000);
WebElement submit1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
js.executeScript("arguments[0].click();", submit1);
Thread.sleep(5000);
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please use a unique customer id.']")));
boolean actual=driver.findElement(By.xpath("//span[text()='Please use a unique customer id.']")).isDisplayed();
Assert.assertTrue(actual);
Thread.sleep(5000);
WebElement closeButton = driver.findElement(By.xpath("//i[@class=\"fa fa-times-circle closebutton\"]"));
js.executeScript("arguments[0].click();", closeButton);
Thread.sleep(1000);
}

@Test(priority=7)
public void testContactIsDeletedTC61() throws InterruptedException
{
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
AddContactPage contact=new AddContactPage(driver);
WebDriverWait wait=new WebDriverWait(driver,60);
WebElement selectContacts=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type=\"checkbox\"])[7]")));
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].click();", selectContacts);
Thread.sleep(1000);
WebElement selectContacts1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type=\"checkbox\"])[8]")));
js.executeScript("arguments[0].click();", selectContacts1);
Thread.sleep(1000);
WebElement deleteContacts = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Delete']")));
js.executeScript("arguments[0].click();", deleteContacts);
Thread.sleep(1000);
contact.yes();
Thread.sleep(5000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Successfully Removed Address Entry']")));
boolean actual=driver.findElement(By.xpath("//span[text()='Successfully Removed Address Entry']")).isDisplayed();
Assert.assertTrue(actual);
System.out.println("verify 'Successfully Removed Address Entry' message is pass");
}

@Test(priority=8)
public void testContactIsFetchedOnOrderScreenTC62() throws InterruptedException
{
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
AddContactPage contact=new AddContactPage(driver);
WebDriverWait wait=new WebDriverWait(driver,20);
WebElement orders = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Orders']")));
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].click();", orders);
Thread.sleep(15000);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebElement addOrders = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add']")));
js.executeScript("arguments[0].click();", addOrders);
Thread.sleep(1000);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("autocomplete-address")));
contact.searchContacts("test test");
Thread.sleep(5000);
boolean actual=driver.findElement(By.xpath("//span[text()=' Add New Order']")).isDisplayed();
Assert.assertTrue(actual);
Thread.sleep(5000);
WebElement closeButton=driver.findElement(By.xpath("//i[@class=\"fa fa-times-circle closebutton\"]"));
js.executeScript("arguments[0].click();", closeButton);
Thread.sleep(1000);

}

*/

	
@Test(priority=9)
public void testContactIsSavedFromAddOrderScreenTC63() throws InterruptedException
{
	Thread.sleep(10000);
	for (int i = 0; i <=2 ; i++)

	{

	try {

	order.clickOnOrdersTab();

			break;

	}
		catch (Exception e) {

		e.printStackTrace();

	}

}

	WebElement heading = driver
			.findElement(By.xpath("//h1[text()='Open Orders']"));
	WebDriverWait wait = new WebDriverWait(driver, 100);
	wait.until(ExpectedConditions.visibilityOf(heading));
	
    order.clickOnAddOrderLink();
    
    Thread.sleep(5000);
    File file = new File("E:\\Parveen_New\\55517920.xlsx");

	try {

		is = new FileInputStream(file);
		workbook = new XSSFWorkbook(is);
		sheet = workbook.getSheet("addContact");
		
		
		String orderNum=sheet.getRow(1).getCell(7).getStringCellValue();
		order.enterOrderNumber(orderNum);
		
		String recipientName=sheet.getRow(1).getCell(1).getStringCellValue();
	    order.enterRecipientName(recipientName);
	    
		String organizationName=sheet.getRow(1).getCell(2).getStringCellValue();
	    order.enterOrganization(organizationName);
	    
		String addessName=sheet.getRow(1).getCell(4).getStringCellValue();
		order.enterAddress(addessName);
	    
	    int zip1 = (int) sheet.getRow(1).getCell(5).getNumericCellValue();
		String zipNum = Integer.toString(zip1);
		order.enterZip(zipNum);
		
		String cityName=sheet.getRow(1).getCell(6).getStringCellValue();
		order.enterCity(cityName);
		
		order.selectState1();
		

		order.checkSaveToContacts();
		Thread.sleep(2000);
		order.save();
		
		contact.clickOnUseEnteredButton();
		
		contact.clickOnContactsTab();
		Thread.sleep(10000);
		
		String searchRecipientVal=sheet.getRow(1).getCell(1).getStringCellValue();
		contact.searchAddedContact(searchRecipientVal);

		
	} catch (Exception exp) {

		exp.printStackTrace();
	}
    
	boolean actual=driver.findElement(By.xpath("//span[text()='UAT67']")).isDisplayed();
     Assert.assertTrue(actual);
	
}


@Test(priority=10)
public void testContactIsEditedFromAddOrderScreenTC64() throws InterruptedException
{
	Thread.sleep(5000);
	order.clickOnOrdersTab();
	
	WebDriverWait wait=new WebDriverWait(driver,60);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Open Orders']")));
	Thread.sleep(10000);

	
	
	driver.findElement(By.xpath("//*[@id=\"orderlist\"]/div/div[3]/div[2]/div[1]/div[3]/div/div[1]/div/div[1]/div[2]/input")).click();
	
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//a[text()='Edit']")).click();
	
	Thread.sleep(5000);
	
	order.clickOnEditLink();
	order.clearRecipient();
	
	
	  File file = new File("E:\\Parveen_New\\55517920.xlsx");

		try {

			is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheet("addContact");
	String recipientName1=sheet.getRow(2).getCell(1).getStringCellValue();
	order.enterRecipientName1(recipientName1);
	
		} catch (Exception exp) {

			exp.printStackTrace();
		}
		
		order.clickOnSaveButton();
	  Thread.sleep(5000);
	
	boolean actual=driver.findElement(By.xpath("//span[text()='UAT88']")).isDisplayed();
    Assert.assertTrue(actual);
	
}



@Test(priority=11)
public void testContactIsRemovedFromTheShipmentsScreenTC68() throws InterruptedException
{
	Thread.sleep(10000);
	for (int i = 0; i <=2 ; i++)

	{

	try {

   shipments.clickOnShipmentsTab();
	Thread.sleep(10000);
	//WebElement element=driver.findElement(By.xpath("//h1[text()='Ready To Ship']"));
	//WebDriverWait wait=new WebDriverWait(driver,60);
		//wait.until(ExpectedConditions.visibilityOf(element));
	

			break;

	}

		catch (Exception e) {

		e.printStackTrace();
 
	}
	
	shipments.enterSearchAddress();
	Thread.sleep(5000);
	shipments.selectSearchAddress();
	Thread.sleep(5000);
	shipments.clickOnRemoveLink();
	Thread.sleep(5000);
	
	boolean actual=driver.findElement(By.xpath("//input[@id='attentionOf']")).isDisplayed();
	Assert.assertTrue(actual);
	
	}
}


@Test(priority=12)
public void testContactIsFetchedFromAddShipmentsScreenTC65() throws InterruptedException
{
	Thread.sleep(10000);
	for (int i = 0; i <=2 ; i++)

	{

	try {

   shipments.clickOnShipmentsTab();
	Thread.sleep(10000);
	//WebElement element=driver.findElement(By.xpath("//h1[text()='Ready To Ship']"));
	//WebDriverWait wait=new WebDriverWait(driver,60);
		//wait.until(ExpectedConditions.visibilityOf(element));
	

			break;

	}

		catch (Exception e) {

		e.printStackTrace();
 
	}

}
	
   shipments.clickOnAddShipmentIcon();
   Thread.sleep(5000);

	
	shipments.enterSearchAddress();
	Thread.sleep(3000);
	shipments.selectSearchAddress();
	
	Thread.sleep(3000);
		
 boolean actual=driver.findElement(By.xpath("//span[text()='remove']")).isDisplayed();
  Assert.assertTrue(actual);
		
}


@Test(priority=13)
public void testContactIsSavedFromAddShipmentsScreenTC66() throws InterruptedException
{
Thread.sleep(5000);
shipments.clickOnRemoveLink();
//shipments.clearRecipient();
Thread.sleep(5000);
shipments.searchRecipient();
Thread.sleep(2000);
shipments.selectSearchAddress();
Thread.sleep(2000);
shipments.clickOnSaveLater();

Thread.sleep(10000);

for (int i = 0; i <=2 ; i++)

{

try {

contact.clickOnContactsTab();


		break;

}

	catch (Exception e) {

	e.printStackTrace();

}
Thread.sleep(5000);
driver.findElement(By.xpath("//*[@id=\"addressbook-list\"]/div/div[2]/div[2]/div[1]/div[2]/div/div[3]/input")).sendKeys("UATuser45");

Thread.sleep(5000);

boolean actual=driver.findElement(By.xpath("//span[text()='UATuser45']")).isDisplayed();
Assert.assertTrue(actual);


}
	
}

@Test(priority=14)
public void testContactIsEditedFromAddShipmentsScreenTC67() throws InterruptedException
{ 
	
	Thread.sleep(10000);

	for (int i = 0; i <=2 ; i++)

	{

	try {

		shipments.clickOnShipmentsTab();


			break;

	}

		catch (Exception e) {

		e.printStackTrace();

	}
	

	Thread.sleep(10000);
    shipments.clickOnAddShipmentIcon();
    
    Thread.sleep(1000);
	shipments.enterSearchAddress();
	
	Thread.sleep(2000);
	shipments.selectSearchAddress();
	
	WebDriverWait wait=new WebDriverWait(driver,100);
   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Save for Later']")));
	shipments.clickOnSaveLater();
	//Thread.sleep(2000);
	//shipments.clickOnUseEnteredButton();
	
	Thread.sleep(5000);

	
boolean actual=driver.findElement(By.xpath("//button[text()='Shipments Successfully Added']")).isDisplayed();
Assert.assertTrue(actual);
}
	}



@AfterClass
public void tearDown()
{
driver.quit();	
}
}

