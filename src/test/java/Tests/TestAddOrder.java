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

import Pages.AddOrder;
import Pages.LoginPage;
import Testbase.Base;

public class TestAddOrder extends Base{
	
	
	AddOrder addOrder;
	LoginPage login;

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	XSSFRow row;
	InputStream is;
	
	
	public TestAddOrder() {
	super();
	}

	@BeforeClass
	public void setUp() throws IOException {
		intializeBrowser();
		addOrder = new AddOrder();
		
		login = PageFactory.initElements(driver, LoginPage.class);

		File file=new File("./Res/ShipCaddieTestData.xlsx");

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
	public void testAddOrderWithoutDetails() throws InterruptedException {

		Thread.sleep(10000);
		for (int i = 0; i <= 2; i++)

		{

			try {

				addOrder.clickOnOrdersTab();

				break;
			}

			catch (Exception e) {

				e.printStackTrace();

			}

		}
		Thread.sleep(5000);
		addOrder.clickOnAddOrderIcon();
		addOrder.clickOnSaveButton();
    	
		Thread.sleep(5000);
   
		WebElement validationMessage=driver.findElement(By.xpath("//span[text()='Please correct the fields in red']"));
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(validationMessage));

		boolean actual = validationMessage.isDisplayed();
		Assert.assertTrue(actual);
	}
	
	
	
	@Test(priority = 1)
	public void testAddOrderWithPartialDetails() throws InterruptedException {

		
		File file=new File("./Res/ShipCaddieTestData.xlsx");

		try {

			is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheet("addOrder");

			String orderNumberVal = sheet.getRow(1).getCell(0).getStringCellValue();
			addOrder.enterOrderNumber(orderNumberVal);
			
			Thread.sleep(2000);
			
          String address1 = sheet.getRow(1).getCell(1).getStringCellValue();
      	  addOrder.enterAddress(address1);
			
			Thread.sleep(2000);
			
		
		}

		catch (Exception exp) {

			exp.printStackTrace();
		}
		
		addOrder.clickOnSaveButton();
		
	
		WebElement validationMessage=driver.findElement(By.xpath("//span[text()='Please fill all required details from following: Address, City, State, Zip and Country to verify your address']"));
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(validationMessage));

		boolean actual = validationMessage.isDisplayed();
		Assert.assertTrue(actual);
	}
	
	
	
	@Test(priority = 2)
	public void testAddOrderWithValidDetails() throws InterruptedException {

		
		File file=new File("./Res/ShipCaddieTestData.xlsx");

		try {

			is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheet("addOrder");

			
			Thread.sleep(2000);
			
	          String searchContact = sheet.getRow(1).getCell(2).getStringCellValue();
	      	  addOrder.enterContact(searchContact);
				
				Thread.sleep(2000);
			
				addOrder.tapDownOnContactField();
				Thread.sleep(5000);

		}

		catch (Exception exp) {

			exp.printStackTrace();
		}
		
		addOrder.clickOnSaveButton();
		
		Thread.sleep(10000);
		WebElement validationMessage=driver.findElement(By.xpath("//span[text()='Added Order Successfully']"));
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(validationMessage));

		boolean actual = validationMessage.isDisplayed();
		Assert.assertTrue(actual);

		}
	
	
	@Test(priority=3)
	
	public void testOnClickingShipIconEditScreenDisplayed() throws InterruptedException
	{
		Thread.sleep(10000);
		for (int i = 0; i <= 2; i++)

		{

			try {

				addOrder.clickOnOrdersTab();

				break;
			}

			catch (Exception e) {

				e.printStackTrace();
			}

		}	
	
		Thread.sleep(10000);
		addOrder.clickOnShip();
			
  Thread.sleep(10000);
  String expectedTitle="Edit Shipment";
  String actualTitle=driver.getTitle();
		
	Assert.assertEquals(actualTitle, expectedTitle);	
		
	}
	
	
	@Test(priority=4)
	public void testConversionOfOrderIntoShipment() throws InterruptedException
	{
		Thread.sleep(5000);
         addOrder.clickOnReadyToShip();
		
		Thread.sleep(5000);
		WebElement element=driver.findElement(By.xpath("//div[text()='UATOrder176']"));

		boolean actual = element.isDisplayed();
		Assert.assertTrue(actual);
			
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	

}	

	
	
	
	
	
	
	
	
	


