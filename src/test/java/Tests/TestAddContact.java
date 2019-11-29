package Tests;

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
import Pages.AddContact;
import Pages.LoginPage;
import Testbase.Base;

public class TestAddContact extends Base {

	AddContact addContact;
	LoginPage login;

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	XSSFRow row;
	InputStream is;

	public TestAddContact() {
	super();
	}

	@BeforeClass
	public void setUp() throws IOException {
		intializeBrowser();
		addContact = new AddContact();

		login = PageFactory.initElements(driver, LoginPage.class);

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

	@Test(priority = 0)
	public void testAddContactWithoutDetailsTC153() throws InterruptedException {
	
		Thread.sleep(10000);
		
		for (int i = 0; i <=2 ; i++)

		{

		try {

			addContact.clickOnContactsTab();

				break;

		}

			catch (Exception e) {

			e.printStackTrace();

		}

	}
	
		WebElement heading = driver
				.findElement(By.xpath("//h1[text()='Contacts']"));
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOf(heading));
		
		Thread.sleep(10000);
		addContact.clickOnAddContactIcon();
		Thread.sleep(10000);
		addContact.clickOnSubmitContactButton();

		WebElement validationMessage = driver
				.findElement(By.xpath("//span[text()='Please correct the fields in red']"));
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.visibilityOf(validationMessage));

		boolean actual = validationMessage.isDisplayed();
		Assert.assertTrue(actual);
	}

	@Test(priority = 1)
	public void testAddContactWithPhoneOnlyTC154() throws InterruptedException {

		File file = new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");

		try {

			is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheet("addContact");

			int phoneValue = (int) sheet.getRow(1).getCell(3).getNumericCellValue();

			String phoneValue1 = Integer.toString(phoneValue);
			addContact.enterPhone(phoneValue1);
			addContact.clickOnSubmitContactButton();
		} catch (Exception exp) {

			exp.printStackTrace();
		}

		WebElement validationMessage = driver
				.findElement(By.xpath("//span[text()='Please correct the fields in red']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(validationMessage));

		boolean actual = validationMessage.isDisplayed();
		Assert.assertTrue(actual);
	}

	@Test(priority = 2)
	public void testAddContactWithAddressOnlyTC155() {

		addContact.clearPhone();

		File file = new File("E:\\Parveen_New\\ShipCaddieTestData.xlsx");

		try {

			is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheet("addContact");

			addContact.clickOnSubmitContactButton();

		} catch (Exception exp) {

			exp.printStackTrace();
		}

		WebElement validationMessage = driver
				.findElement(By.xpath("//span[text()='Please correct the fields in red']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(validationMessage));

		boolean actual = validationMessage.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 3)
	public void testAddContactWithZipOnlyTC156() {
		addContact.clearCustomerID();
		addContact.clearPhone();
		addContact.clearAddress();
		addContact.clearCity();

		File file = new File("E:\\Parveen_New\\ShipCaddieTestData.xlsx");

		try {

			is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheet("addContact");

			int zipVal = (int) sheet.getRow(1).getCell(5).getNumericCellValue();

			String zipVal1 = Integer.toString(zipVal);
			addContact.enterZip(zipVal1);
			Thread.sleep(2000);

			addContact.clickOnSubmitContactButton();
		} catch (Exception exp) {

			exp.printStackTrace();
		}

		WebElement validationMessage = driver
				.findElement(By.xpath("//span[text()='Please correct the fields in red']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(validationMessage));

		boolean actual = validationMessage.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 4)
	public void testAddContactWithCityOnlyTC157() throws InterruptedException {

		addContact.clearZip();
		Thread.sleep(5000);
		File file = new File("E:\\Parveen_New\\ShipCaddieTestData.xlsx");

		try {

			is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheet("addContact");

			String city = sheet.getRow(1).getCell(6).getStringCellValue();
			addContact.enterCity(city);
			Thread.sleep(5000);

			addContact.clickOnSubmitContactButton();
			Thread.sleep(5000);

		}

		catch (Exception exp) {

			exp.printStackTrace();
		}

		WebElement validationMessage = driver
				.findElement(By.xpath("//span[text()='Please correct the fields in red']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(validationMessage));

		boolean actual = validationMessage.isDisplayed();
		Assert.assertTrue(actual);

	}
	
	
	
	

	@Test(priority = 5)
	public void testAddContactWithStateOnlyTC158() throws InterruptedException {
		addContact.clearCity();
		Thread.sleep(5000);
		File file = new File("E:\\Parveen_New\\ShipCaddieTestData.xlsx");

		try {

			is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheet("addContact");

			addContact.selectState();
			Thread.sleep(5000);
			addContact.clickOnSubmitContactButton();

			Thread.sleep(5000);

		} catch (Exception exp) {

			exp.printStackTrace();
		}

		WebElement validationMessage = driver
				.findElement(By.xpath("//span[text()='Please correct the fields in red']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(validationMessage));

		boolean actual = validationMessage.isDisplayed();
		Assert.assertTrue(actual);

	}


	@Test(priority = 6)
	public void testAddContactWithoutRecipientAndOrganizationTC159() throws InterruptedException {
		addContact.clearOrganization();
		Thread.sleep(5000);
		File file = new File("E:\\Parveen_New\\ShipCaddieTestData.xlsx");

		try {

			is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheet("addContact");

			String customerIDValue = sheet.getRow(1).getCell(0).getStringCellValue();
			addContact.enterCustomerID(customerIDValue);

			int phoneValue = (int) sheet.getRow(1).getCell(3).getNumericCellValue();

			String phoneValue1 = Integer.toString(phoneValue);
			addContact.enterPhone(phoneValue1);

			String address = sheet.getRow(1).getCell(4).getStringCellValue();
			addContact.enterAddress1(address);
			Thread.sleep(2000);

			int zipVal = (int) sheet.getRow(1).getCell(5).getNumericCellValue();

			String zipVal1 = Integer.toString(zipVal);
			addContact.enterZip(zipVal1);
			Thread.sleep(2000);

			String city = sheet.getRow(1).getCell(6).getStringCellValue();
			addContact.enterCity(city);
			Thread.sleep(2000);

	        addContact.clickOnEnteredButton(); Thread.sleep(5000);
			addContact.clickOnSubmitContactButton();
			Thread.sleep(5000);
		} catch (Exception exp) {

			exp.printStackTrace();
		}

		WebElement validationMessage = driver
				.findElement(By.xpath("//span[text()='Please fill either Recipient or Organization.']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(validationMessage));

		boolean actual = validationMessage.isDisplayed();
		Assert.assertTrue(actual);
	}

	
	
	
	
	/*
	@Test(priority = 7)
	public void testAddContactWithoutPhone() {
		addContact.clearPhone();

		File file = new File("E:\\Parveen_New\\ShipCaddieTestData.xlsx");

		try {

			is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheet("addContact");

			String company = sheet.getRow(1).getCell(2).getStringCellValue();
			addContact.enterOrgnization(company);
			Thread.sleep(2000);

			addContact.clickOnSubmitContactButton();
			Thread.sleep(3000);
		} catch (Exception exp) {

			exp.printStackTrace();
		}

		WebElement validationMessage = driver
				.findElement(By.xpath("//span[text()='Please correct the fields in red']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(validationMessage));

		boolean actual = validationMessage.isDisplayed();
		Assert.assertTrue(actual);
		addContact.clickOnEnteredButton();
	}
	
	

	@Test(priority = 8)
	public void testAddContactWithoutAddress() throws InterruptedException {
		
		 

		File file = new File("E:\\Parveen_New\\ShipCaddieTestData.xlsx");

		try {

			is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheet("addContact");

			int phoneValue = (int) sheet.getRow(1).getCell(3).getNumericCellValue();

			String phoneValue1 = Integer.toString(phoneValue);
			addContact.enterPhone(phoneValue1);
			
			addContact.clickOnEnteredButton();
			addContact.clearAddress();

			addContact.clickOnSubmitContactButton();
			
			Thread.sleep(8000);
		} catch (Exception exp) {

			exp.printStackTrace();
		}

		WebElement validationMessage = driver
				.findElement(By.xpath("//span[text()='Please correct the fields in red']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(validationMessage));

		boolean actual = validationMessage.isDisplayed();
		Assert.assertTrue(actual);
		
		addContact.clickOnEnteredButton();

	}
	

	@Test(priority = 9)
	public void testAddContactWithoutZip() throws InterruptedException {
	
	
		//addContact.clickOnEnteredButton();
	
     	addContact.clearZip();
    	Thread.sleep(2000);
     	addContact.clickOnEnteredButton(); Thread.sleep(2000);

		File file = new File("E:\\Parveen_New\\ShipCaddieTestData.xlsx");

		try {

			is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheet("addContact");

			Thread.sleep(2000);
			//String address = sheet.getRow(1).getCell(4).getStringCellValue();
			//addContact.enterAddress1(address);
			// int phoneValue = (int) sheet.getRow(1).getCell(3).getNumericCellValue();

// String phoneValue1 = Integer.toString(phoneValue);
			// addContact.enterPhone(phoneValue1);

			addContact.clickOnSubmitContactButton();
			Thread.sleep(3000);
		} catch (Exception exp) {

			exp.printStackTrace();
		}

		WebElement validationMessage = driver
				.findElement(By.xpath("//span[text()='Please correct the fields in red']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(validationMessage));

		boolean actual = validationMessage.isDisplayed();
		Assert.assertTrue(actual);

	}
	
	
	

	@Test(priority = 10)
	public void testAddContactWithoutCity() throws InterruptedException {

		addContact.clearCity();
	   	Thread.sleep(2000);
     	addContact.clickOnEnteredButton();

		File file = new File("E:\\Parveen_New\\ShipCaddieTestData.xlsx");

		try {

			is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheet("addContact");

			int zipVal = (int) sheet.getRow(1).getCell(5).getNumericCellValue();

			String zipVal1 = Integer.toString(zipVal);
			addContact.enterZip(zipVal1);
			Thread.sleep(2000);

			addContact.clickOnSubmitContactButton();
			Thread.sleep(8000);
		} catch (Exception exp) {

			exp.printStackTrace();
		}

		WebElement validationMessage = driver
				.findElement(By.xpath("//span[text()='Please correct the fields in red']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(validationMessage));

		boolean actual = validationMessage.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 11)
	public void testAddContactWithValidDetails() throws InterruptedException {

		Thread.sleep(10000);

		File file = new File("E:\\Parveen_New\\ShipCaddieTestData.xlsx");

		try {

			is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheet("addContact");

			String city = sheet.getRow(1).getCell(6).getStringCellValue();
			addContact.enterCity(city);
			 Thread.sleep(5000);
			// addContact.clickOnEnteredButton(); Thread.sleep(2000);
			addContact.clickOnSubmitContactButton();
			Thread.sleep(10000);
		} catch (Exception exp) {
			exp.printStackTrace();
		}

		WebElement validationMessage = driver.findElement(By.xpath("//span[text()=' contact added']"));
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.visibilityOf(validationMessage));

		boolean actual = validationMessage.isDisplayed();
		Assert.assertTrue(actual);
	}
	
	

	@Test(priority = 12)
	public void testDeleteContact() throws InterruptedException, AWTException {

		Thread.sleep(10000);
		driver.findElement(
				By.xpath("//*[@id=\"addressbook-list\"]/div/div[2]/div[2]/div[1]/div[3]/div/div[1]/div/div[1]/input"))
				.click();
		Thread.sleep(5000);
		addContact.clickOnDeleteIcon();
		Thread.sleep(1000);

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(5000);

		WebElement validationMessage = driver
				.findElement(By.xpath("//span[text()='Successfully Removed Address Entry']"));
		boolean actual = validationMessage.isDisplayed();
		Assert.assertTrue(actual);

	}

  @Test(priority = 13) 
  public void testUserIsNotAbleToAddDuplicateContact()
  throws InterruptedException { 
  Thread.sleep(10000); 
  addContact.clickOnAddContactIcon(); 
  Thread.sleep(5000);
  
  File file = new File("E:\\Parveen_New\\ShipCaddieTestData.xlsx");
  
  try {
  
 is = new FileInputStream(file); workbook = new XSSFWorkbook(is); sheet =
 workbook.getSheet("addContact");
 Thread.sleep(5000);
  
  String customerIDValue = sheet.getRow(3).getCell(0).getStringCellValue();
  addContact.enterCustomerID(customerIDValue);
  
  String company = sheet.getRow(1).getCell(2).getStringCellValue();
  addContact.enterOrgnization(company);
  
  int phoneValue = (int) sheet.getRow(1).getCell(3).getNumericCellValue();
  
  String phoneValue1 = Integer.toString(phoneValue);
  addContact.enterPhone(phoneValue1);
  
 Thread.sleep(2000); String address =
  sheet.getRow(1).getCell(4).getStringCellValue();
  addContact.enterAddress1(address);
  
  int zipVal= (int)sheet.getRow(1).getCell(5).getNumericCellValue();
  
  String zipVal1 = Integer.toString(zipVal); addContact.enterZip(zipVal1);
  Thread.sleep(2000); 
  
  String city=  sheet.getRow(1).getCell(6).getStringCellValue(); addContact.enterCity(city);
  Thread.sleep(2000); addContact.selectState();
  
 //addContact.clickOnEnteredButton(); Thread.sleep(2000);
  addContact.clickOnSubmitContactButton();
  Thread.sleep(5000); } catch
  (Exception exp) { exp.printStackTrace(); }
  
  WebElement validationMessage = driver
  .findElement(By.xpath("//span[text()='Please use a unique customer id.']"));
 WebDriverWait wait1 = new WebDriverWait(driver, 20);
 wait1.until(ExpectedConditions.visibilityOf(validationMessage));
 
 boolean actual = validationMessage.isDisplayed(); Assert.assertTrue(actual);
  }

	*/
	
	
	@AfterClass
	public void tearDown()
	{
	
		driver.quit();
	}
	
	
}

