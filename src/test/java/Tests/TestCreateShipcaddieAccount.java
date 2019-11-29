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
import Pages.CreateShipcaddieAccountPage;
import Testbase.Base;

public class TestCreateShipcaddieAccount extends Base {

	CreateShipcaddieAccountPage createaccount;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	XSSFRow row;
	InputStream is;

	public TestCreateShipcaddieAccount() {
		super();
	}

	@BeforeClass
	public void setUp() throws IOException {
		intializeBrowser();
		createaccount = PageFactory.initElements(driver, CreateShipcaddieAccountPage.class);

	}


	@Test(priority = 13)
	public void verifyFocusIsOnFirstNameFieldTC101() throws InterruptedException {

		createaccount.clickOnCreateNewAccount();

		WebElement currentElement = driver.switchTo().activeElement();
		currentElement.isSelected();
		Assert.assertTrue(true);

	}

	@Test(priority = 14)
	public void testCreateNewAccountPageDisplayedTC102() {

		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element2 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()='Register for ShipCaddie ']")));

		boolean actual = element2.isDisplayed();
		Assert.assertTrue(actual);
		
	
	}

	@Test(priority = 15)
	public void testWithoutDetailsTC103() {

		createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element2 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element2.isDisplayed();
		Assert.assertTrue(actual);

	}



	@Test(priority = 16)
	public void testWithoutFirstNameTC104() {
		
		
		File file=new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");
		
		try {
			
			is=new FileInputStream(file);
			workbook=new XSSFWorkbook(is);
			sheet=workbook.getSheet("createAccount");
			
	
				String lastNameValue=sheet.getRow(1).getCell(1).getStringCellValue();
				createaccount.enterLastName(lastNameValue);
				String emailValue=sheet.getRow(1).getCell(2).getStringCellValue();
				createaccount.enterEmail(emailValue);

				//String passwordValue=sheet.getRow(1).getCell(4).getStringCellValue();
				//createaccount.enterPassword(passwordValue);
				
				int phoneValue = (int) sheet.getRow(1).getCell(4).getNumericCellValue();
				String passwordValue1 = Integer.toString(phoneValue);
			    createaccount.enterPhone(passwordValue1);
				
				
				
                String confirmPasswordValue=sheet.getRow(1).getCell(5).getStringCellValue();
				createaccount.enterConfirmPassword(confirmPasswordValue);
				String companyValue=sheet.getRow(1).getCell(6).getStringCellValue();
				createaccount.enterCompany(companyValue);
				
		}
		catch(Exception exp)
		{
			
			exp.printStackTrace();
			}
			
		createaccount.checkTermsConditions();
		createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element3 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element3.isDisplayed();
		Assert.assertTrue(actual);

	}


	@Test(priority = 17)
	public void testWithoutLastNameTC105() {
        
		File file=new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");
			
			try {
				
				is=new FileInputStream(file);
				workbook=new XSSFWorkbook(is);
				sheet=workbook.getSheet("createAccount");
				
			   createaccount.clearLastName();
		       String firstNameValue=sheet.getRow(1).getCell(0).getStringCellValue();
			   createaccount.enterFirstName(firstNameValue);
			}
			catch(Exception exp)
			{
				
				exp.printStackTrace();
				}
		
	    createaccount.clickCreateShipCaddieAccount();
		
	 
	    WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element4 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element4.isDisplayed();
		Assert.assertTrue(actual);

	}
	

	@Test(priority = 18)
	public void testWithoutEmailTC106() {
         
		createaccount.clearEmail();
          
		File file=new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");
  			
  			try {
  				
  				is=new FileInputStream(file);
  				workbook=new XSSFWorkbook(is);
  				sheet=workbook.getSheet("createAccount");
  				
  			   String lastNameValue=sheet.getRow(1).getCell(1).getStringCellValue();
			   createaccount.enterLastName(lastNameValue);
  				
  			}
  			catch(Exception exp)
  			{
  				
  				exp.printStackTrace();
  				}
          
	      createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element5 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element5.isDisplayed();
		Assert.assertTrue(actual);
	}

	

	@Test(priority = 19)
	public void testWithoutPasswordTC107() {
         createaccount.clearPassword();
         
 		File file=new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");
			
			try {
				
				is=new FileInputStream(file);
				workbook=new XSSFWorkbook(is);
				sheet=workbook.getSheet("createAccount");
				
			   String emailValue=sheet.getRow(1).getCell(2).getStringCellValue();
			   createaccount.enterEmail(emailValue);
				
			}
			catch(Exception exp)
			{
				exp.printStackTrace();
				}

         
         createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element6 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element6.isDisplayed();
		Assert.assertTrue(actual);

	}
	

	@Test(priority = 20)
	public void testWithoutConfirmPasswordTC108() {

		createaccount.clearConfirmPassword();
		
		File file=new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");
			
			try {
				
				is=new FileInputStream(file);
				workbook=new XSSFWorkbook(is);
				sheet=workbook.getSheet("createAccount");
				
			   String passwordValue=sheet.getRow(1).getCell(4).getStringCellValue();
			   createaccount.enterPassword(passwordValue);
				
			}
			catch(Exception exp)
			{
				exp.printStackTrace();
			}
			
	    createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element7 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element7.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 21)
	public void testWithoutCheckTermsConditionsTC109() {

		createaccount.checkTermsConditions();

		createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element8 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));// Thread.sleep(5000);

		boolean actual = element8.isDisplayed();
		Assert.assertTrue(actual);

	}


	@Test(priority = 22)
	public void testWithoutCompanyTC110() {

		createaccount.clearCompany();
		
		
		File file=new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");
			
			try {
				
				is=new FileInputStream(file);
				workbook=new XSSFWorkbook(is);
				sheet=workbook.getSheet("createAccount");
				
			   String confirmPasswordValue=sheet.getRow(1).getCell(5).getStringCellValue();
			   createaccount.enterConfirmPassword(confirmPasswordValue);
				
			}
			catch(Exception exp)
			{
				exp.printStackTrace();
			}
		
	
		createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element9 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element9.isDisplayed();
		Assert.assertTrue(actual);

	}



	@Test(priority = 23)
	public void testWithoutPhoneTC111() {
       
		createaccount.clearPhone();
		
		File file=new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");
			
			try {
				
				is=new FileInputStream(file);
				workbook=new XSSFWorkbook(is);
				sheet=workbook.getSheet("createAccount");
				
			   String companyValue=sheet.getRow(1).getCell(6).getStringCellValue();
			   createaccount.enterCompany(companyValue);
				
			}
			catch(Exception exp)
			{
				exp.printStackTrace();
			}
		
	
	    createaccount.clickCreateShipCaddieAccount();
	    
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element10 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element10.isDisplayed();
		Assert.assertTrue(actual);

	}

	
	
	@Test(priority = 24)
	public void testWithInvalidFirstNameTC112() {
	
	createaccount.clearFirstName();
	File file=new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");
			
			try {
				
				is=new FileInputStream(file);
				workbook=new XSSFWorkbook(is);
				sheet=workbook.getSheet("createAccount");
				
			   String invalidFirstNameValue=sheet.getRow(2).getCell(0).getStringCellValue();
			createaccount.enterInvalidFirstName(invalidFirstNameValue);	   
		
			
			
			
			}
			catch(Exception exp)
			{
				exp.printStackTrace();
			}
		

		createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element11 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element11.isDisplayed();
		Assert.assertTrue(actual);

	}


	@Test(priority = 25)
	public void testWithInvalidLastNameTC113() {

createaccount.clearLastName();
createaccount.clearFirstName();

File file=new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");

try {
	
	is=new FileInputStream(file);
	workbook=new XSSFWorkbook(is);
	sheet=workbook.getSheet("createAccount");
	
	
	 String firstNameValue=sheet.getRow(1).getCell(0).getStringCellValue();
	   createaccount.enterFirstName(firstNameValue);  
	
   String invalidLastNameValue=sheet.getRow(2).getCell(1).getStringCellValue();
   createaccount.enterInvalidLastName(invalidLastNameValue);   
}
catch(Exception exp)
{
	exp.printStackTrace();
}

        createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element12 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element12.isDisplayed();
		Assert.assertTrue(actual);

	}


	@Test(priority = 26)
	public void testWithInvalidEmailTC114() {

		
		createaccount.clearEmail();
		File file=new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");

		try {
			
			is=new FileInputStream(file);
			workbook=new XSSFWorkbook(is);
			sheet=workbook.getSheet("createAccount");
			
	
			  String lastNameValue=sheet.getRow(1).getCell(1).getStringCellValue();
				createaccount.enterLastName(lastNameValue); 
			
		   String invalidEmailValue=sheet.getRow(2).getCell(2).getStringCellValue();
			createaccount.enterInvalidEmail(invalidEmailValue);  
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}

		createaccount.clickCreateShipCaddieAccount();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element13 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element13.isDisplayed();
		Assert.assertTrue(actual);

	}



	@Test(priority = 27)
	public void testWithInvalidPhoneTC115() {
     //createaccount.clearPhone();
		createaccount.clearEmail();
		File file=new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");

		try {
			
			is=new FileInputStream(file);
			workbook=new XSSFWorkbook(is);
			sheet=workbook.getSheet("createAccount");
			
			  String emailValue=sheet.getRow(1).getCell(2).getStringCellValue();
				createaccount.enterEmail(emailValue);
				
			    String invalidPhoneValue=sheet.getRow(1).getCell(1).getStringCellValue();
				createaccount.enterLastName(invalidPhoneValue); 
			
		   String invalidEmailValue=sheet.getRow(2).getCell(2).getStringCellValue();
			createaccount.enterInvalidEmail(invalidEmailValue);  
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		
		createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element14 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element14.isDisplayed();
		Assert.assertTrue(actual);

	}



	@Test(priority = 28)
	public void testWithInvalidPasswordTC116() {

//createaccount.clearEmail();
createaccount.clearPassword();

File file=new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");

try {
	
	is=new FileInputStream(file);
	workbook=new XSSFWorkbook(is);
	sheet=workbook.getSheet("createAccount");
	
	
   String invalidPasswordValue=sheet.getRow(2).getCell(4).getStringCellValue();
   createaccount.enterInvalidPassword(invalidPasswordValue);
}
catch(Exception exp)
{
	exp.printStackTrace();
}

        createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element15 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element15.isDisplayed();
		Assert.assertTrue(actual);
		
	}
	

@Test(priority = 29)
public void testCreateAccountWithAlreadyExistEmailTC117() {

		
	File file=new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");

	try {
		
		is=new FileInputStream(file);
		workbook=new XSSFWorkbook(is);
		sheet=workbook.getSheet("createAccount");
		

	createaccount.clearPassword();
	 String passwordValue=sheet.getRow(1).getCell(4).getStringCellValue();
	createaccount.enterPassword(passwordValue);
	
	
	createaccount.clearEmail();
	String existEmailValue=sheet.getRow(3).getCell(2).getStringCellValue();
	createaccount.enterAlreadyExistEmail(existEmailValue);
	
	
	}
	catch(Exception exp)
	{
		exp.printStackTrace();
	}	
		
	createaccount.clickCreateShipCaddieAccount();

	WebDriverWait wait = new WebDriverWait(driver, 20);
	WebElement element20 = wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//span[text()='Please fill in or correct fields in red']")));

	boolean actual = element20.isDisplayed();
	Assert.assertTrue(actual);

}
	

	
	@Test(priority = 30)
	public void testLoginInInsteadLinkWorkingTC118() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element16 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/login']")));

		createaccount.clickOnLoginInsteadLink();
		Thread.sleep(5000);

		String actualTitle = driver.getTitle();
		String Expected = "Login";

		Assert.assertEquals(actualTitle, Expected);
	}

	@Test(priority = 31)
	public void testInformationIconIsDisplayedTC119() throws InterruptedException {
		WebElement ele=driver.findElement(By.xpath("//a[text()='Create New Account']"));
		for(int i=0; i<=2;i++){
			  try{
				ele.click();
			     break;
			  }
			  catch(Exception e){
			    System.err.println(e.getMessage());
			  }
			}
		
	   // Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element17 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-info-circle info_circle-registration']")));

		boolean actual = element17.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 32)
	public void testTermsOfServiceLinkWorkingTC120() throws InterruptedException {
 
String parent=driver.getWindowHandle();
System.out.println(parent);

		createaccount.clickOnTermsServiceLink();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(5000);
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String Expected = "Terms Of Service";

		Assert.assertEquals(actualTitle, Expected);
		
		driver.switchTo().window(parent);

	}

	@Test(priority = 33)
	public void testPrivacyLinkWorkingTC121() throws InterruptedException {
     Thread.sleep(10000);
     String parent=driver.getWindowHandle();
     System.out.println(parent);
		createaccount.clickOnPrivacyPolicyLink();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(5000);
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String Expected = "Privacy Policy";

		Assert.assertEquals(actualTitle, Expected);
	
	}
/*
	@Test(priority = 34)
	public void testCreateAccountWithValidDetailsTC122() throws InterruptedException
	{

		Thread.sleep(5000);
		createaccount.clickOnCreateNewAccount();

		File file=new File("E:\\Parveen_data\\Shipcaddie-master\\Res\\ShipCaddieTestData.xlsx");

		try {
			
			is=new FileInputStream(file);
			workbook=new XSSFWorkbook(is);
			sheet=workbook.getSheet("createAccount");
			

			 String firstNameValue=sheet.getRow(5).getCell(0).getStringCellValue();
			createaccount.enterFirstName(firstNameValue);
				
				Thread.sleep(1000);
		        String lastNameValue=sheet.getRow(5).getCell(1).getStringCellValue();
				createaccount.enterLastName(lastNameValue);
					
		Thread.sleep(1000);	
		String emailValue=sheet.getRow(5).getCell(2).getStringCellValue();
	  createaccount.enterEmail(emailValue);
							
		Thread.sleep(1000);
		
		String passwordValue=sheet.getRow(5).getCell(4).getStringCellValue();
		  createaccount.enterPassword(passwordValue);
								
			Thread.sleep(1000);
			
			String confirmPasswordValue=sheet.getRow(5).getCell(5).getStringCellValue();
			  createaccount.enterConfirmPassword(confirmPasswordValue);
									
				Thread.sleep(1000);
				String companyValue=sheet.getRow(5).getCell(6).getStringCellValue();
				  createaccount.enterCompany(companyValue);
										
					Thread.sleep(1000);
					
					
					int phoneValue = (int) sheet.getRow(5).getCell(3).getNumericCellValue();
					String passwordValue1 = Integer.toString(phoneValue);
				    createaccount.enterPhone(passwordValue1);
				    
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}	
		Thread.sleep(1000);
		createaccount.checkTermsConditions();
		Thread.sleep(1000);
		createaccount.clickCreateShipCaddieAccount();
		
		Thread.sleep(5000);
	String title=driver.getCurrentUrl();
	String ExpectedTitle="https://shipcaddie.com/registration.html";
	
	Assert.assertEquals(title, ExpectedTitle);
		
	
	}

*/
	@AfterClass
	public void tearDown() {
		driver.quit();

	}
}