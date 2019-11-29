package tests2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.AddOrderPage;
import Testbase.Base;

public class TestAddOrders2 extends Base {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	XSSFRow row;
	InputStream is;

	AddOrderPage order;
	LoginPage login;

	public TestAddOrders2() {
		super();
	}

	@BeforeClass
	public void setUp() throws IOException {
		intializeBrowser();
		order = new AddOrderPage();

		login = PageFactory.initElements(driver, LoginPage.class);

		File file = new File("./Res/ShipCaddieTestData.xlsx");

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
		order = PageFactory.initElements(driver, AddOrderPage.class);
	}

	@Test(priority = 1)
	public void addOrdersWithFetchingContact()
			throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException {
		Thread.sleep(10000);
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement orders = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Orders']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i=0; i<=2;i++)
		{
		try {
			
	
	
		js.executeScript("arguments[0].click();", orders);
		Thread.sleep(10000);
		break;
		}
		
		catch (Exception exp) {

			exp.printStackTrace();
		}}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement addOrders = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add']")));
		js.executeScript("arguments[0].click();", addOrders);
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("orderNumber")));
		order.orderNumber("demo21511");
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[text()='Select Shipping Site']")).click();
		Thread.sleep(1000);
		order.selectShippingSite();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Select Carrier']")));
		order.shipmentCarrier();
		Thread.sleep(1000);
		order.selectShipmentCarrier();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Select Service']")));
		order.shipmentService();
		Thread.sleep(1000);
		order.selectShipmentService();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Select Packaging']")));
		order.shipmentPackaging();
		Thread.sleep(1000);
		order.selectShipmentPackaging();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dimensionX")));
		WebElement packagingLength = driver.findElement(By.id("dimensionX"));
		packagingLength.sendKeys("1");
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dimensionY")));
		WebElement packagingWidth = driver.findElement(By.id("dimensionY"));
		packagingWidth.sendKeys("1");
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dimensionZ")));
		WebElement packagingHeight = driver.findElement(By.id("dimensionZ"));
		packagingHeight.sendKeys("1");
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("autocomplete-address")));
		order.recipientInformation();
		Thread.sleep(5000);
		driver.findElement(By.name("autocomplete-address")).sendKeys("anil", Keys.DOWN);
		driver.findElement(By.name("autocomplete-address")).sendKeys(Keys.DOWN);
		driver.findElement(By.name("autocomplete-address")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[text()='Use Entered']")).click();
		Thread.sleep(1000);
		js.executeScript("scroll(0, 750);");
		WebElement sku = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchSku")));
		js.executeScript("arguments[0].value='Test Sku'", sku);
		// add.searchSku("Test SKU Test");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement name = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Name\"]")));
		js.executeScript("arguments[0].value='Test Name'", name);
		// add.searchName("Test Name Test");
		Thread.sleep(1000);
		WebElement desc = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Description\"]")));
		js.executeScript("arguments[0].value='Test Desc'", desc);
		// add.searchDesc("Test Description");
		Thread.sleep(1000);
		WebElement itemQty = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Qty\"]")));
		js.executeScript("arguments[0].value='1'", itemQty);
		// add.itemQty("1");
		Thread.sleep(1000);
		js.executeScript("scroll(0, 750);");
		WebElement lbs = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type=\"number\"])[10]")));
		js.executeScript("arguments[0].value='1'", lbs);
		// add.modalWeightLbs("1");
		Thread.sleep(1000);
		WebElement oz = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type=\"number\"])[11]")));
		js.executeScript("arguments[0].value='1'", oz);
		// add.modalWeightOz("1");
		Thread.sleep(1000);
		WebElement tariff = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type=\"text\"])[28]")));
		js.executeScript("arguments[0].value='1'", tariff);
		// add.tariff("1");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement save = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Save']")));
		js.executeScript("arguments[0].click();", save);
		Thread.sleep(10000);
		/*
		 * WebElement
		 * deleteOrders=wait.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("(//input[@type=\"checkbox\"])[3]")));
		 * js.executeScript("arguments[0].click();",deleteOrders);
		 */
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Added Order Successfully']")));
		boolean actual = driver.findElement(By.xpath("//span[text()='Added Order Successfully']")).isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 2)
	public void addOrdersWithoutFetchingContact() throws InterruptedException {
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement addOrders = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", addOrders);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		AddOrderPage add = new AddOrderPage();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("orderNumber")));
		add.orderNumber("demo2164");
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[text()='Select Shipping Site']")).click();
		Thread.sleep(1000);
		add.selectShippingSite();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Select Carrier']")));
		add.shipmentCarrier();
		Thread.sleep(1000);
		add.selectShipmentCarrier();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Select Service']")));
		add.shipmentService();
		Thread.sleep(1000);
		add.selectShipmentService();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Select Packaging']")));
		add.shipmentPackaging();
		Thread.sleep(1000);
		add.selectShipmentPackaging();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dimensionX")));
		WebElement packagingLength = driver.findElement(By.id("dimensionX"));
		packagingLength.sendKeys("1");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dimensionY")));
		WebElement packagingWidth = driver.findElement(By.id("dimensionY"));
		packagingWidth.sendKeys("1");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dimensionZ")));
		WebElement packagingHeight = driver.findElement(By.id("dimensionZ"));
		packagingHeight.sendKeys("1");
		Thread.sleep(1000);
		add.recipient("Smith");
		Thread.sleep(1000);
		add.customerId("367880");

		Thread.sleep(1000);
		add.organization("ShipCaddie");
		Thread.sleep(1000);
		add.addressLine1("E-200");
		Thread.sleep(1000);
		add.addressLine2("phase-8A");
		Thread.sleep(1000);
		add.postalCode("84043");
		Thread.sleep(1000);
		add.city("lehi");
		Thread.sleep(1000);
		add.state();
		Thread.sleep(1000);
		add.selectState();
		Thread.sleep(1000);
		add.phone("9874546641");
		Thread.sleep(1000);
		add.email2("nitasha@csgroupchd.com");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchSku")));
		add.searchSku("Test SKU Test");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Name\"]")));
		add.searchName("Test Name Test");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Description\"]")));
		add.searchDesc("Test Description");
		Thread.sleep(2000);
		WebElement itemQty = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Qty\"]")));
		js.executeScript("arguments[0].value='1'", itemQty);
		// add.itemQty("1");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Use Entered']")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type=\"number\"])[10]")));
		add.modalWeightLbs("1");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type=\"number\"])[11]")));
		add.modalWeightOz("1");
		Thread.sleep(1000);
		WebElement tariff = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.name("modalcustomsHarmonizedCode")));
		js.executeScript("arguments[0].value='1'", tariff);
		Thread.sleep(1000);
		System.out.println("'Tariff' textbox is working");
		driver.findElement(By.xpath("(//i[@class=\"fa fa-trash\"])[2]")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Name\"]")));
		add.searchName("Test Name");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement save = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Save']")));
		js.executeScript("arguments[0].click();", save);
		System.out.println("'Save' button is working");

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Added Order Successfully']")));
		boolean actual = driver.findElement(By.xpath("//span[text()='Added Order Successfully']")).isDisplayed();
		Assert.assertTrue(actual);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
