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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Testbase.Base;
public class TestLogin extends Base {
	
LoginPage login;
XSSFWorkbook workbook;
XSSFSheet sheet;
XSSFCell cell;
XSSFRow row;
InputStream is;


//private static Logger log = Logger.getLogger(TestLogin.class.getName());

	public TestLogin() {
		super();
	}

	

	@BeforeClass
	public void setUp() throws IOException {
	System.out.println("************Starting test execution of the Login module.**************");
		intializeBrowser();
		login = new LoginPage();
		
	
	}



	@Test(priority = 0)
	public void verifyFocusIsOnEmailFieldTC122() throws InterruptedException {
		System.out.println("*************Execution of verifyFocusIsOnEmailField test is started.*************");
		
		WebElement currentElement = driver.switchTo().activeElement();
		currentElement.isSelected();
		Assert.assertTrue(true);
		
		System.out.println("**********verifyFocusIsOnEmailField test is working fine.*************");
	
	}

	@Test(priority = 1)
	public void testLoginWithoutDetailsTC123() {
		
		System.out.println("***********Execution of testLoginWithoutDetails test is started.**************");
		login.clickOnLoginButton();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element21 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element21.isDisplayed();
		Assert.assertTrue(actual);
		
		System.out.println("*************testLoginWithoutDetails test is working fine.*************");
	}
	
	@Test(priority = 2)
	public  void testLoginWithoutEmailTC124() throws Exception {

	/*CSVReader reader = new CSVReader(new FileReader("/home/php/Desktop/LoginTestData.csv"));
			 String [] csvCell=null;
			  while ((csvCell = reader.readNext()) != null) {   
			 String passwordValue = csvCell[1];*/
		
		System.out.println("************Execution of testLoginWithoutEmail test is started.*************");
		
		File file=new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");
		
		try {
			
			is=new FileInputStream(file);
			workbook=new XSSFWorkbook(is);
			sheet=workbook.getSheet("login");
			
	
				String passwordValue=sheet.getRow(1).getCell(1).getStringCellValue();
				//System.out.println(passwordValue);
				login.enterPassword(passwordValue);
				
				
				login.clickOnLoginButton();
				
				WebDriverWait wait1 = new WebDriverWait(driver, 20);
				WebElement element22 = wait1.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

				boolean actual = element22.isDisplayed();
			Assert.assertTrue(actual);
			System.out.println("*************testLoginWithoutEmail test is working fine.********************");
				login.clearPassword();  
			
			
		
		}
		catch(Exception exp)
		{
			
			exp.printStackTrace();
				}}

	@Test(priority = 3)
	public void testLoginWithoutPasswordTC125() 
	{
		
		System.out.println("***************Execution of testLoginWithoutPassword test is started.*****************");
		
		File file=new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");
		
		try {
			
			is=new FileInputStream(file);
			workbook=new XSSFWorkbook(is);
			sheet=workbook.getSheet("login");
			
	
				String emailValue=sheet.getRow(1).getCell(0).getStringCellValue();
				//System.out.println(emailValue);
				login.enterEmail(emailValue);
				
				login.clickOnLoginButton();
				
				WebDriverWait wait1 = new WebDriverWait(driver, 20);
				WebElement element22 = wait1.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

				boolean actual = element22.isDisplayed();
			Assert.assertTrue(actual);
			System.out.println("*************testLoginWithoutPassword test is working fine.*****************");
			login.clearEmail();  
			
	}
		catch(Exception exp)
		{
			
			exp.printStackTrace();
				}}
		



	@Test(priority = 4)
	public void testLoginWithInvalidEmailTC126() 
	{
		System.out.println("***********Execution of testLoginWithInvalidEmail test is started.************");
		
		
		File file=new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");
		
		try {
			
			is=new FileInputStream(file);
			workbook=new XSSFWorkbook(is);
			sheet=workbook.getSheet("login");
			
	
				String loginInvalidEmail=sheet.getRow(2).getCell(0).getStringCellValue();
				login.enterInvalidEmail(loginInvalidEmail);
				
				String passwordValue=sheet.getRow(2).getCell(1).getStringCellValue();
				login.enterPassword(passwordValue);
				
				login.clickOnLoginButton();

				WebDriverWait wait1 = new WebDriverWait(driver, 20);
				WebElement element23 = wait1.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

				boolean actual = element23.isDisplayed();
				Assert.assertTrue(actual);
				System.out.println("**************testLoginWithInvalidEmail test is working fine.***************");
				Thread.sleep(5000);
				login.clearEmail();
				login.clearPassword();
			
	}
		catch(Exception exp)
		{
			
			exp.printStackTrace();
				}}	

	@Test(priority = 5)
	public void testLoginWithInvalidPasswordTC127() {
		
		System.out.println("**************Execution of testLoginWithInvalidPassword test is started.*********************");
		
		File file=new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");
		
		try {
			
			is=new FileInputStream(file);
			workbook=new XSSFWorkbook(is);
			sheet=workbook.getSheet("login");
			
	
				String emailValue=sheet.getRow(3).getCell(0).getStringCellValue();
				login.enterEmail(emailValue);
				
				String loginInvalidPassword=sheet.getRow(3).getCell(1).getStringCellValue();
				login.enterInvalidPassword(loginInvalidPassword);
				
				login.clickOnLoginButton();

				WebDriverWait wait1 = new WebDriverWait(driver, 20);
				WebElement element25 = wait1.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//span[text()='The username or password is incorrect.']")));

				boolean actual = element25.isDisplayed();
				Assert.assertTrue(actual);
				
				System.out.println("***************testLoginWithInvalidPassword test is working fine.**************");
				Thread.sleep(5000);
				login.clearEmail();
				login.clearPassword();
			
	}
		catch(Exception exp)
		{
			
			exp.printStackTrace();
		}}	
		

	@Test(priority = 6)
	public void testLoginWithValidDetailsTC128() 
	{
	
		System.out.println("********Execution of testLoginWithValidDetails test is started.**********************");
		
		File file=new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");
		
			try {
				
				is=new FileInputStream(file);
				workbook=new XSSFWorkbook(is);
				sheet=workbook.getSheet("login");
				
		
					String emailValue=sheet.getRow(1).getCell(0).getStringCellValue();
					login.enterEmail(emailValue);
					
					String passwordValue=sheet.getRow(1).getCell(1).getStringCellValue();
					login.enterPassword(passwordValue);
					
					login.clickOnLoginButton();
					Thread.sleep(5000);
					String actual=driver.getTitle();

					String expected="Login";
					Assert.assertEquals(actual, expected);
					
					System.out.println("**********testLoginWithValidDetails test is working fine.***********");
				
		}
			catch(Exception exp)
			{
				
				exp.printStackTrace();
			}}	


	@Test(priority = 7)
	public void testLogOutFunctinalityTC129()
			throws InterruptedException {
		
		System.out.println("********Execution of testLogOutFunctinality test is started.**********************");
    WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement logOut = wait

				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-sign-out signout']")));
		Thread.sleep(10000);

	logOut.click();
	

	
	WebDriverWait wait1 = new WebDriverWait(driver,60);
	WebElement validation1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			"//input[@name='email']")));

	boolean actual = validation1.isDisplayed();
	Assert.assertTrue(actual);
	
	System.out.println("**********testLogOutFunctinality test is working fine.***********");
	}

	
	
@AfterClass
public void tearDown() {
		driver.quit();
		
		System.out.println("**********Test Execution of Login module is ended.******************");	}
}	
	



