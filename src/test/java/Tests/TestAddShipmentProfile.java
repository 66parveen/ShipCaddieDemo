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

import Pages.AddShipmentProfile;
import Pages.LoginPage;
import Testbase.Base;

public class TestAddShipmentProfile extends Base {

	
	AddShipmentProfile shipmentProfile;
	LoginPage login;

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	XSSFRow row;
	InputStream is;

	public TestAddShipmentProfile() {
		super();
	}

	@BeforeTest
	public void setUp() throws IOException {
		intializeBrowser();
		shipmentProfile = new AddShipmentProfile();

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
	public void testAddShipmentProfielWithoutDetails() throws InterruptedException {

		Thread.sleep(10000);
		for (int i = 0; i <= 2; i++)

		{

			try {

				shipmentProfile.clickOnSettingsTab();

				break;

			}

			catch (Exception e) {

				e.printStackTrace();

			}

		}
		Thread.sleep(5000);
		shipmentProfile.clickOnShipmentProfileTab();
		shipmentProfile.clickOnAddShipmentProfileButton();

		shipmentProfile.clickOnSubmitButton();

		WebElement validationMessage = driver
				.findElement(By.xpath("//span[text()='Please correct the fields in red']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(validationMessage));

		boolean actual = validationMessage.isDisplayed();
		Assert.assertTrue(actual);

	}
	
	
	@Test(priority =1)
	public void testAddShipmentProfielWithoutShipmentProfileName() throws InterruptedException {

		File file = new File("E:\\Parveen_New\\ShipCaddieTestData.xlsx");

		try {

			is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheet("addShipmentProfileName");

			String shipmentProfileNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
			shipmentProfile.enterShipmentProfileName(shipmentProfileNameVal);
			Thread.sleep(2000);

		}

		catch (Exception exp) {

			exp.printStackTrace();
		}
		
		shipmentProfile.clickOnSubmitButton();
        Thread.sleep(3000);
		WebElement validationMessage = driver
				.findElement(By.xpath("//span[text()='Shipment Profile Added Successfully']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(validationMessage));

		boolean actual = validationMessage.isDisplayed();
		Assert.assertTrue(actual);

	}
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
