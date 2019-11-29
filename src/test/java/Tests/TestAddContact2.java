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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.AddContact;
import Pages.LoginPage;
import Testbase.Base;

public class TestAddContact2 extends Base{

	AddContact addContact;
	LoginPage login;

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	XSSFRow row;
	InputStream is;
	
	
	public TestAddContact2() {
		super();
	}
	
	
	@BeforeTest
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
	
  @Test(priority = 1)
	  public void testAddContactWithShipmentProfile() throws
	  InterruptedException { 
		 Thread.sleep(5000);
	addContact.clickOnContactsTab();
	addContact.clickOnAddContactIcon();
		  
		   
	  
	  File file = new File("E:\\Parveen_New\\ShipCaddieTestData.xlsx");
	  
	  try {
	  
	 is = new FileInputStream(file); workbook = new XSSFWorkbook(is); sheet =
	  workbook.getSheet("addContact"); 
	 Thread.sleep(5000);
	  
	  String customerIDValue = sheet.getRow(4).getCell(0).getStringCellValue();
	  addContact.enterCustomerID(customerIDValue);
	  
		String company = sheet.getRow(1).getCell(2).getStringCellValue();
		addContact.enterOrgnization(company);
		Thread.sleep(2000);
	  
	
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
	  
		addContact.selectState();
	 
	  
	  Thread.sleep(2000); addContact.selectShipmentProfile(); 
	  Thread.sleep(2000);
	  
	  addContact.clickOnSubmitContactButton();
	  Thread.sleep(2000);
	  
	  } catch (Exception exp) { exp.printStackTrace(); }
	  
	  WebElement validationMessage = driver
	  .findElement(By.xpath("//span[text()=' contact added']"));
	  
	  WebDriverWait
	  wait1 = new WebDriverWait(driver, 20);
	  wait1.until(ExpectedConditions.visibilityOf(validationMessage));
	  
	  boolean actual = validationMessage.isDisplayed(); Assert.assertTrue(actual);
	  
	  }
	  
	

	@Test(priority = 0) 
	public void testEditContactInformation() throws
 InterruptedException {

	 Thread.sleep(5000);
	 addContact.clickOnEditLink();
 Thread.sleep(5000);

 addContact.clearCustomerID();
	 addContact.clearPhone();

	  
	  File file = new File("E:\\Parveen_New\\ShipCaddieTestData.xlsx");
	  
	  try {
	  
	  is = new FileInputStream(file); workbook = new XSSFWorkbook(is); sheet =
	  workbook.getSheet("addContact"); Thread.sleep(5000);
	  
	 
	  Thread.sleep(5000); String customerIDValue =
	  sheet.getRow(4).getCell(0).getStringCellValue();
	  addContact.enterCustomerID(customerIDValue);
	  
	  Thread.sleep(2000); int phoneValue = (int)
	  sheet.getRow(1).getCell(3).getNumericCellValue();
	  
	  String phoneValue1 = Integer.toString(phoneValue);
	  addContact.enterPhone(phoneValue1);
	  
	  Thread.sleep(2000); addContact.clickOnEnteredButton();
	  
	  addContact.selectShipmentProfile(); Thread.sleep(2000);
	  
	 addContact.clickOnSubmitContactButton(); Thread.sleep(10000);
	  
	 } catch (Exception exp) { exp.printStackTrace(); }
	  
	  WebElement validationMessage = driver
	  .findElement(By.xpath("//span[text()=' test@#11 contact info updated.']"));
	WebDriverWait wait1 = new WebDriverWait(driver, 20);
	  wait1.until(ExpectedConditions.visibilityOf(validationMessage));
	 
	  boolean actual = validationMessage.isDisplayed(); Assert.assertTrue(actual);
	 
	 }
	  
		
}
