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

import Pages.AddProducts;
import Pages.LoginPage;
import Testbase.Base;

public class TestAddProducts extends Base {

	AddProducts addProducts;
	LoginPage login;

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	XSSFRow row;
	InputStream is;

	public TestAddProducts() {
	super();
	}

	@BeforeClass
	public void setUp() throws IOException, InterruptedException {
		intializeBrowser();
		addProducts = new AddProducts();

		login = PageFactory.initElements(driver, LoginPage.class);

		File file = new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");

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
		Thread.sleep(20000);
	}

	@Test(priority = 0)
	public void testAddProductsWithoutDetailsTC149() throws InterruptedException {
		Thread.sleep(10000);
	
	for (int i = 0; i <=2 ; i++)

		{

		try {

				addProducts.clickOnProductsTab();

				break;

		}

			catch (Exception e) {

			e.printStackTrace();

		}

	}
	WebElement heading = driver
			.findElement(By.xpath("//h1[text()='My Products']"));
	WebDriverWait wait = new WebDriverWait(driver, 60);
	wait.until(ExpectedConditions.visibilityOf(heading));
	
	Thread.sleep(10000);
		addProducts.clickOnAddProductIcon();
		Thread.sleep(5000);
		addProducts.clickOnSaveButton();
		
		Thread.sleep(5000);

		WebElement validationMessage = driver
				.findElement(By.xpath("//span[text()='Please correct the fields in red']"));
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.visibilityOf(validationMessage));

		boolean actual = validationMessage.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 1)
	public void testAddProductsWithoutSKUTC150() throws InterruptedException {

		File file = new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");

		try {

			is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheet("addProducts");

			String productName = sheet.getRow(1).getCell(1).getStringCellValue();
			addProducts.enterProductName(productName);
			Thread.sleep(2000);

		}

		catch (Exception exp) {

			exp.printStackTrace();
		}

		addProducts.clickOnSaveButton();
		Thread.sleep(5000);

		WebElement validationMessage = driver
				.findElement(By.xpath("//span[text()='Please correct the fields in red']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(validationMessage));

		boolean actual = validationMessage.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 2)
	public void testAddProductsWithoutNameTC151() throws InterruptedException {
		
		Thread.sleep(5000);
		addProducts.clearProductName();
		File file = new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");

		try {

			is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheet("addProducts");

			String SKU = sheet.getRow(1).getCell(0).getStringCellValue();
			addProducts.enterSKU(SKU);
			Thread.sleep(2000);

			//String productName = sheet.getRow(1).getCell(1).getStringCellValue();
		//	addProducts.enterProductName(productName);
			//Thread.sleep(2000);

		}

		catch (Exception exp) {

			exp.printStackTrace();
		}

		addProducts.clickOnSaveButton();
		Thread.sleep(3000);

		WebElement validationMessage = driver
				.findElement(By.xpath("//span[text()='Please correct the fields in red']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(validationMessage));

		boolean actual = validationMessage.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 3)
	public void testAddProductsWithValidDetailsTC152() throws InterruptedException {
		Thread.sleep(5000);
		File file = new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");

		try {

			is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheet("addProducts");

			String productName = sheet.getRow(1).getCell(1).getStringCellValue();
			addProducts.enterProductName(productName);
	         Thread.sleep(2000);

		}

		catch (Exception exp) {

			exp.printStackTrace();
		}

		addProducts.clickOnSaveButton();
		Thread.sleep(2000);

		WebElement validationMessage = driver.findElement(By.xpath("//span[text()='Inventory Added Successfully']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(validationMessage));

		boolean actual = validationMessage.isDisplayed();
		Assert.assertTrue(actual);

	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
		
	}
	
}
