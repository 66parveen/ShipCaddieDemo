package Tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
import Pages.ImportShipmentPage;
import Testbase.Base;

public class TestImportShipment extends Base {

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	XSSFRow row;
	InputStream is;

	ImportShipmentPage ship;
	LoginPage login;

	public TestImportShipment() {
		super();
	}


	@BeforeClass
	public void setUp() throws IOException, InterruptedException {
		
		intializeBrowser();
		ship = new ImportShipmentPage();
		
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
		ship = PageFactory.initElements(driver, ImportShipmentPage.class);

	}

	@Test(priority = 35)
	public void testImportShipmentsLinkDisplayedTC136() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Import Shipments']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 36)
	public void testImportShipmentsLinkWorkingTC137() throws InterruptedException {
		ship.clickOnImportShipmentsLink();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Import into Shipcaddie']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 37)
	public void testChooseCSVFileLinkDisplayedTC138() {
		//ship.clickOnImportShipmentsLink();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Choose CSV File']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 38)
	public void testCrossCloseIconFunctionalTC139() throws InterruptedException {
		//ship.clickOnImportShipmentsLink();

		WebDriverWait wait = new WebDriverWait(driver, 60);
		Thread.sleep(3000);
		ship.clickOnCrossLink();

		WebElement element1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Ready To Ship']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);
	}
	
	

	@Test(priority = 39)
	public void testCancelIconFunctionalTC140() throws InterruptedException {
		
		WebElement element = driver.findElement(By.xpath("//span[text()='Import Shipments']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Thread.sleep(3000);
		ship.clickOnCancelLink();

		WebElement element1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Ready To Ship']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);
	}
	
	
	
	

		@Test(priority = 40)
	public void testShipementNotImportedWithoutCSVTC141() throws InterruptedException {

			
WebElement element = driver.findElement(By.xpath("//span[text()='Import Shipments']"));
JavascriptExecutor executor = (JavascriptExecutor)driver;
executor.executeScript("arguments[0].click()", element);	
			
			
			Thread.sleep(5000);
		ship.clickOnImportButton();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please choose a CSV file to upload first']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 41)
	public void testChangeLinkIsDisplayedTC142() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='change']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 42)
	public void testChangeLinkIsFunctionalTC143() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver, 60);
		ship.clickOnChangeLink();
		WebElement element1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='create a new csv mapper']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 43)
	public void testDownloadOurCSVTemplateDisplayedTC144() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement downloadLink = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='download our CSV Template']")));

		boolean actual = downloadLink.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 44)
	public void testImportShipmentButtonIsDisplayedTC145() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement importButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Import ']")));

		boolean actual = importButton.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 45)
	public void testEditIconDisplayedOnClickingChangeLinkTC146() throws InterruptedException {
		ship.clickOnChangeLink();
		boolean actual = driver.findElement(By.xpath("//i[@class='fa fa-pencil']")).isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 46)
	public void testDeleteIconDisplayedOnClickingChangeLinkTC147() throws InterruptedException {
		ship.clickOnChangeLink();

		boolean actual = driver.findElement(By.xpath("//i[@class='fa fa-trash']")).isDisplayed();
		Assert.assertTrue(actual);

	}

	/*	@Test(priority = 12)
	public void testDeleteIconFunctional() throws InterruptedException {
		ship.clickOnChangeLink();
		ship.clickOnDeleteIcon();
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Confirm']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);
	
		
	}

	@Test(priority = 13)
	public void testMappingIsNotEditedWithoutUploadCSV() throws InterruptedException {
		Thread.sleep(5000);
		 Alert alert = driver.switchTo().alert();
	
		WebElement element=driver.findElement(By.xpath("//a[text()='change']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		element.click();
	Thread.sleep(5000);
		WebElement element1 = driver.findElement(By.xpath("//a[text()='create a new csv mapper']"));
        js.executeScript("arguments[0].scrollIntoView();", element1);
		element1.click();

		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[text()='Please choose a CSV file first.']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);

	}*/

	/*@Test(priority = 47)
	public void testCSVTemplateIsDownloaded() throws InterruptedException {
		
		
	ship.clickOnDownloadCSVTemplateLink();

		File f = new File("E:\\Parveen_New\\ShipmentTemplate.csv");
		Thread.sleep(5000);

		if (f.exists()) {
			System.out.println("CSV template file is downloaded.");

			Assert.assertTrue(f.exists());

			if (f.delete()) {
				System.out.println("CSV template file is deleted.");
			}
		}

	}
	
	


	@Test(priority = 15)
	public void testUploadCSVFile() throws InterruptedException, IOException, AWTException {
		ship.clickOnImportShipmentsLink();
		ship.clickOnChooseCSVFileButton();
		Thread.sleep(5000);
		// Runtime.getRuntime().exec("C:\\Users\\QA\\Desktop\\AutoIT\\file.exe");
		Thread.sleep(5000);

		StringSelection ss = new StringSelection("/home/php/Public/Parveen_data/Fortest.csv");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Fortest.csv']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 16)
	public void testImportshipmentWithoutCorrection() throws InterruptedException, IOException, AWTException {
		ship.clickOnImportShipmentsLink();
		ship.clickOnChooseCSVFileButton();
		Thread.sleep(5000);
		// Runtime.getRuntime().exec("C:\\Users\\QA\\Desktop\\AutoIT\\file.exe");
		StringSelection ss = new StringSelection("/home/php/Public/Parveen_data/Fortest.csv");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(5000);
		ship.clickOnImportShipmentbutton();

		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Invalid Shipments']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);
	}

	@Test(priority = 17)
	public void testImportshipmentWithCorrection() throws InterruptedException, IOException, AWTException {
		ship.clickOnImportShipmentsLink();
		ship.clickOnChooseCSVFileButton();
		Thread.sleep(5000);
		// Runtime.getRuntime().exec("C:\\Users\\QA\\Desktop\\AutoIT\\file.exe");
		StringSelection ss = new StringSelection("/home/php/Public/Parveen_data/Fortest.csv");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(5000);
		ship.clickOnImportShipmentbutton();
		Thread.sleep(10000);
		// ship.clickOnImportWithCorrection();
		WebElement element = driver.findElement(By.xpath("//button[text()='Import without Corrections']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		element.click();
		// ship.clickOnImportWithCorrection();
		// Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//span[text()='Successfully Imported Shipments. Applying Business Rule may take a little longer if it meets the criteria.']")));

		boolean actual = header.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 15)
	public void testImportShipmentWithMapping() throws InterruptedException, IOException, AWTException {
		Thread.sleep(10000);
		WebElement importShipments= driver.findElement(By.xpath("//span[text()='Import Shipments']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", importShipments);	
		
		
		//ship.clickOnImportShipmentsLink();
		ship.clickOnChooseCSVFileButton();
		Thread.sleep(5000);
		// Runtime.getRuntime().exec("C:\\Users\\QA\\Desktop\\AutoIT\\file.exe");

		StringSelection ss = new StringSelection("/home/php/Public/Parveen_data/Fortest.csv");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(5000);
		ship.clickOnChangeLink();
		WebElement element = driver.findElement(By.xpath("//a[text()='create a new csv mapper']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		Thread.sleep(2000);
		element.click();
		Thread.sleep(5000);
		ship.selectCarrierOption();
		ship.selectAttentionOfOption();
		ship.selectPhone();
		ship.selectReference();
		ship.selectAddress();
		ship.selectCity();
		ship.selectZip();
		ship.selectCountry();
		ship.selectState();
		ship.selectLength();
		ship.selectWidth();
		ship.selectHeight();
		ship.selectWeight();
		ship.enterMapperName();

		ship.clickOnSaveCSVMapper();
		System.out.println("CSV map is added.");

		ship.clickOnImportShipmentbutton();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//span[text()='Successfully Imported Shipments. Applying Business Rule may take a little longer if it meets the criteria.']")));

		boolean actual = successMessage.isDisplayed();
		Assert.assertTrue(actual);

	}
*/
	
	@Test(priority = 48)
	public void testImportShipmentWithValidCSVFileTC148() throws InterruptedException, AWTException {

		/*Thread.sleep(10000);
		WebElement elem1 = driver.findElement(By.xpath("//a[text()='Ready to Ship']"));
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", elem1);
			 Alert alert = driver.switchTo().alert();
	      alert.accept();


		} catch (Exception e) {
	
			elem1.click();
		}
		
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		  WebElement chooseCSVFileButton= wait1
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Choose CSV File']")));
		   
			JavascriptExecutor executor2 = (JavascriptExecutor) driver;
			executor2.executeScript("arguments[0].click();", chooseCSVFileButton);
			   Thread.sleep(10000);
	
		
		WebElement importShipments= wait1
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Import Shipments']")));


		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", importShipments);
		   Thread.sleep(15000);
*/
		Thread.sleep(10000);
		ship.clickOnChooseCSVFileButton();
		Thread.sleep(10000);
		
		
		
		StringSelection ss = new StringSelection("E:\\Data2\\Fortest.csv");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	
		 Thread.sleep(5000);
		
	ship.clickOnImportShipmentbutton();
	 Thread.sleep(5000);
	 ship.clickOnImportWithCorrection();
	 Thread.sleep(5000);	
		WebDriverWait wait3 = new WebDriverWait(driver,60);
		WebElement validation1 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//span[text()='Successfully Imported Shipments. Applying Business Rule may take a little longer if it meets the criteria.']")));

		boolean actual = validation1.isDisplayed();
		Assert.assertTrue(actual);

	}

	
	@AfterClass
	public void tearDown() {

		driver.quit();
	}

}
