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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.BatchShipmentPage;
import Pages.LoginPage;
import Testbase.Base;

public class TestBatchShipments extends Base {
	
	BatchShipmentPage batchShipments;
	LoginPage login;

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	XSSFRow row;
	InputStream is;
	
	public TestBatchShipments() {
		super();
	}

	@BeforeClass
	public void setUp() throws IOException {
		intializeBrowser();
		
		batchShipments = new BatchShipmentPage();
		
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
	


	
	
	
	@Test(priority=50)
	public void testImportBatchShipements() throws InterruptedException, AWTException
	{
		Thread.sleep(10000);
	//	batchShipments.clickOnShipmentsTab();
		//Thread.sleep(5000);
		batchShipments.clickOnImportShipmentsLink();
		Thread.sleep(5000);
		batchShipments.clickOnChooseCSVFileButton();
		Thread.sleep(5000);
		
	
		StringSelection ss = new StringSelection("C:\\Users\\QA\\Desktop\\NewUpdatedCSV1.csv");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	
		 Thread.sleep(5000);
		
		 
		 batchShipments.clickOnImportShipmentsButton();
		
	   Thread.sleep(10000);
	    batchShipments.clickOnImportShipmentsWithoutCorrectionButton();
		
		
		WebDriverWait wait3 = new WebDriverWait(driver,60);
		WebElement validation1 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//span[text()='Successfully Imported Shipments. Applying Business Rule may take a little longer if it meets the criteria.']")));

		boolean actual = validation1.isDisplayed();
		Assert.assertTrue(actual);
		
	}
	
	@Test(priority=51)
	public void setUpPrinter() throws InterruptedException
	{ 
		Thread.sleep(10000);
		batchShipments.clickOnSettings();
			Thread.sleep(10000);
			batchShipments.clickOnPrinterSetUp();
			Thread.sleep(5000);
			batchShipments.clickOnSettings1();
			Thread.sleep(5000);
			batchShipments.clickOnFourInchOption();
			Thread.sleep(5000);
			batchShipments.clickOnUpdateButton();
			Thread.sleep(5000);
			
			boolean actual=driver.findElement(By.xpath("//span[text()='Successfully Saved Printer Configurations']")).isDisplayed();
			Assert.assertTrue(actual);
			
			//System.out.println("Printer setUp is done.");

		}
	@Test(priority=52)
	public void testBatchPrint() throws InterruptedException, AWTException
	{
		Thread.sleep(5000);
		batchShipments.clickOnShipmentsTab();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id=\"shipping-list\"]/div/div[3]/div[2]/div[1]/div[3]/div/div[1]/div/div[1]/div[1]/input")).click();
	Thread.sleep(2000);
   driver.findElement(By.xpath("//*[@id=\"shipping-list\"]/div/div[3]/div[3]/div[1]/div[3]/div/div[2]/div/div[1]/div[1]/input")).click();;
	
	
	Thread.sleep(5000);
    batchShipments.clickOnShipLink();	
    
	Thread.sleep(10000);
	
    	Robot r = new Robot();
    	r.keyPress(KeyEvent.VK_ESCAPE);
    	r.keyRelease(KeyEvent.VK_ESCAPE);
        Thread.sleep(5000);
    	r.keyPress(KeyEvent.VK_ESCAPE);
    	r.keyRelease(KeyEvent.VK_ESCAPE);
    	
    	Thread.sleep(5000);
    	boolean actual=driver.findElement(By.xpath("//span[text()=' 2 successfully.']")).isDisplayed();
		Assert.assertTrue(actual);
		
		//System.out.println("Batch Shipment is working fine");
    
	}
	
	
@AfterClass
public void tearDown()
{
	driver.quit();

}
}
