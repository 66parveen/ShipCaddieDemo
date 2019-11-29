package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.AddShipmentPage;
import Testbase.Base;

public class TestAddShipment extends Base {

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	XSSFRow row;
	InputStream is;

	AddShipmentPage shipment;
	LoginPage login;

	public TestAddShipment() {
		super();

	}

	@BeforeClass
	public void setUp() throws Exception {
		intializeBrowser();

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

		shipment = PageFactory.initElements(driver, AddShipmentPage.class);
	}

	@Test(priority = 0)
	public void testAddShipmentButtonIsDisplayedTC14() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add']")));

		boolean actual = element.isDisplayed();
		Assert.assertTrue(actual);
	}

	@Test(priority = 1)
	public void testAddShipmentIconFunctionalTC15() throws InterruptedException {
		shipment.clickOnAddShipmentIcon();

		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Ready To Ship";

		Assert.assertEquals(ActualTitle, ExpectedTitle);

	}

	@Test(priority = 2)
	public void testAddShipmentWithInvalidReferenceNoTC16() throws InterruptedException {

		Thread.sleep(10000);

		File file = new File("./Res/ShipCaddieTestData.xlsx");

		try {

			is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheet("addShipment");

			String invalidReferenceNumber = sheet.getRow(2).getCell(0).getStringCellValue();
			shipment.enterInvalidReferenceNumber(invalidReferenceNumber);

			Thread.sleep(3000);
			shipment.tapEnterInReferenceNumberField();
			Thread.sleep(10000);
		}

		catch (Exception exp) {

			exp.printStackTrace();
		}

		

		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Reference number entry not found.']")));

		boolean actual = element.isDisplayed();
		Assert.assertTrue(actual);
	}

	@Test(priority = 3)
	public void testValidationOFPrintButtonWithoutDetailsTC20() throws InterruptedException {
		Thread.sleep(5000);
		shipment.clearReferenceField();
		shipment.clickOnPrintButton();

		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element7 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='blurbtext']")));

		boolean actual = element7.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 4)
	public void testAddShipmentWithoutDetails() throws InterruptedException {

		Thread.sleep(5000);
		shipment.clickOnPrintButton();

		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement errorMessage = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please correct the fields in red']")));

		boolean actual = errorMessage.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 5)
	public void testRateCalWithOverWeight() throws InterruptedException {
		Thread.sleep(5000);

		shipment.enterDimension();
		Thread.sleep(3000);
		shipment.clickOnPrintButton();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement errorMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='blurbtext']")));

		boolean actual = errorMessage.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 6)
	public void testAddShipmentWithoutState() throws InterruptedException {
		Thread.sleep(5000);
		shipment.clearWeightField();

		Thread.sleep(5000);

		File file = new File("./Res/ShipCaddieTestData.xlsx");

		try {

			is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheet("addShipment");

			String referenceNumber = sheet.getRow(1).getCell(0).getStringCellValue();
			shipment.enterOrdRefNo(referenceNumber);
			Thread.sleep(2000);

			String address = sheet.getRow(1).getCell(5).getStringCellValue();
			shipment.enterAddress(address);
			Thread.sleep(2000);

			shipment.clearZipField();
			int zip = (int) sheet.getRow(1).getCell(6).getNumericCellValue();
			String zip1 = Integer.toString(zip);
			shipment.enterZip(zip1);
			Thread.sleep(2000);

			String city1 = sheet.getRow(1).getCell(7).getStringCellValue();
			shipment.enterCity(city1);
			Thread.sleep(2000);

			shipment.clearWeightField();
			Thread.sleep(2000);

			int weight = (int) sheet.getRow(2).getCell(14).getNumericCellValue();
			String weightOZ = Integer.toString(weight);
			shipment.enterWeightOZ(weightOZ);
			Thread.sleep(2000);

		}

		catch (Exception exp) {

			exp.printStackTrace();
		}

		shipment.clickOnPrintButton();

		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement errorMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='blurbtext']")));

		boolean actual = errorMessage.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 7)
	public void testAddShipmentWithoutCity() throws InterruptedException {

		Thread.sleep(5000);
		shipment.selectState();
		Thread.sleep(2000);
		shipment.clearCityField();
		Thread.sleep(3000);
		shipment.clickOnPrintButton();

		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement errorMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='blurbtext']")));

		boolean actual = errorMessage.isDisplayed();
		Assert.assertTrue(actual);
	}

	/*@Test(priority = 8)
	public void testAddShipmentWithoutZip() throws InterruptedException {

		Thread.sleep(5000);

		File file = new File("./Res/ShipCaddieTestData.xlsx");

		try {

			is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheet("addShipment");
			String city1 = sheet.getRow(1).getCell(7).getStringCellValue();
			shipment.enterCity(city1);
			Thread.sleep(2000);
			String company = sheet.getRow(1).getCell(3).getStringCellValue();
			shipment.enterCompany(company);
			Thread.sleep(2000);
			WebElement useEntered=driver.findElement(By.xpath("//button[text()='Use Entered']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", useEntered);
			useEntered.click();
		
			shipment.clearZipField();
			Thread.sleep(3000);

			int zip = (int) sheet.getRow(1).getCell(6).getNumericCellValue();
			String zip1 = Integer.toString(zip);
			shipment.enterZip(zip1);
			Thread.sleep(2000);
			
		
		}

		catch (Exception exp) {

			exp.printStackTrace();
		}
		
		
		/*WebElement print=driver.findElement(By.xpath("//span[text()='Print']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", print);
		print.click();
		
		shipment.clickOnPrintB();
		
	
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement errorMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='blurbtext']")));

		boolean actual = errorMessage.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 9)
	public void testAddShipmentWithoutAddress() throws Exception {
		Thread.sleep(5000);

		shipment.clearAddress();

		Thread.sleep(2000);
	
		shipment.clickOnPrintButton();
		shipment.clickOnUseEnteredButton();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement errorMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='blurbtext']")));

		boolean actual = errorMessage.isDisplayed();
		Assert.assertTrue(actual);

	}
*/
	@Test(priority = 8)
	public void testValidAddShipment() throws Exception {
	Thread.sleep(5000);
    shipment.enterWeightInOZ();
		File file = new File("./Res/ShipCaddieTestData.xlsx");

		try {

			is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheet("addShipment");
			
			String company = sheet.getRow(1).getCell(3).getStringCellValue();
			shipment.enterCompany(company);
			Thread.sleep(2000);
			String city1 = sheet.getRow(1).getCell(7).getStringCellValue();
			shipment.enterCity(city1);
			Thread.sleep(2000);
			
			Thread.sleep(5000);
			WebElement useEntered=driver.findElement(By.xpath("//button[text()='Use Entered']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", useEntered);
			useEntered.click();
			
		}

		catch (Exception exp) {

			exp.printStackTrace();
		}
		
		
		Thread.sleep(5000);
		WebElement save=driver.findElement(By.xpath("//button[text()='Save for Later']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", save);
		save.click();
	
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement successMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Shipment Successfully Added']")));
		
		
		boolean actual = successMessage.isDisplayed();
		Assert.assertTrue(actual);

	}

@AfterClass
	public void tearDown() {

	driver.quit();

	}

}