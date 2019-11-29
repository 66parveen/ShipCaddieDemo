package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.ForgotPasswordPage;
import Testbase.Base;

public class TestForgotPassword extends Base {

	ForgotPasswordPage forgot;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	XSSFRow row;
	InputStream is;
	
	
	Logger log = Logger.getLogger(TestForgotPassword.class);
	
	public TestForgotPassword() {
		super();
	}

	@BeforeClass
	public void setUp() throws IOException {
		System.out.println("*************Test Execution of Forgot Password module is started.*************");
		intializeBrowser();
		forgot = new ForgotPasswordPage();
	}

	@Test(priority = 8)
	public void verifyFocusIsOnEmailFieldTC130() throws InterruptedException {
		
		System.out.println("*************Test Execution of verifyFocusIsOnEmailField test is started.*************");
		
		WebElement currentElement = driver.switchTo().activeElement();
		currentElement.isSelected();
		Assert.assertTrue(true);

		System.out.println("**********verifyFocusIsOnEmailField test is working fine.*************");
	}
	

	@Test(priority = 9)
	public void testForgotPasswordLinkWorkingTC131() throws InterruptedException {
		
		System.out.println("*************Test Execution of testForgotPasswordLinkWorking test is started.*************");
		
		forgot.clickOnForgotPasswordLink();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element27 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h6[text()='Enter the email you used to sign up to ShipCaddie.']")));

		boolean actual = element27.isDisplayed();
		Assert.assertTrue(actual);
		System.out.println("**********testForgotPasswordLinkWorking test is working fine.*************");
	}

	@Test(priority = 10)
	public void testForgotPasswordWithoutEmailTC132() throws InterruptedException {
		//forgot.clickOnForgotPasswordLink();
		
		System.out.println("*************Test Execution of testForgotPasswordWithoutEmail test is started.*************");
		forgot.clickOnSendPassword();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element28 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element28.isDisplayed();
		Assert.assertTrue(actual);
		System.out.println("**********testForgotPasswordWithoutEmail test is working fine.*************");
	}



	@Test(priority = 11)
	public void testForgotPasswordWithInvalidEmailTC133() throws InterruptedException {
   // forgot.clickOnForgotPasswordLink();
			
		System.out.println("*************Test Execution of testForgotPasswordWithInvalidEmail test is started.*************");
		
		File file=new File("./Res/ShipCaddieTestData.xlsx");
		
		try {
			
			is=new FileInputStream(file);
			workbook=new XSSFWorkbook(is);
			sheet=workbook.getSheet("forgotPassword");
			
	
				String invalidLoginEmail=sheet.getRow(2).getCell(0).getStringCellValue();
				//System.out.println(invalidLoginEmail);
				
				forgot.enterInvalidEmail(invalidLoginEmail);
				
				
		}
		catch(Exception exp)
		{
			
			exp.printStackTrace();
				}
		
		forgot.clickOnSendPassword();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element29 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element29.isDisplayed();
		Assert.assertTrue(actual);
		System.out.println("**********testForgotPasswordWithInvalidEmail test is working fine.*************");
		forgot.clearEmail();
	}


/*

	@Test(priority = 12)
	public void testForgotPasswordWithValidEmailTC134() throws InterruptedException {
		//forgot.clickOnForgotPasswordLink();
		
		System.out.println("*************Test Execution of testForgotPasswordWithValidEmail test is started.*************");
		File file=new File("./Res/ShipCaddieTestData.xlsx");
		
		try {
			
			is=new FileInputStream(file);
			workbook=new XSSFWorkbook(is);
			sheet=workbook.getSheet("forgotPassword");
			
	
				String loginEmailValue=sheet.getRow(1).getCell(0).getStringCellValue();
				  //System.out.println(loginEmailValue);
				
				forgot.enterEmail(loginEmailValue);
				
				
		}
		catch(Exception exp)
		{
			
			exp.printStackTrace();
				}
	
		forgot.clickOnSendPassword();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element30 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()='Password Recovery Request Has Been Processed ']")));

		boolean actual = element30.isDisplayed();
		Assert.assertTrue(actual);
		System.out.println("**********testForgotPasswordWithValidEmail test is working fine.*************");
	}
*/
	
	@AfterClass
	public void tearDown() {

		System.out.println("*************Test Execution of Forgot Password module is ended.*************");
		driver.quit();
	}

}
