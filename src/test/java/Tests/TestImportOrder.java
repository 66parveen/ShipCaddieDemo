package Tests;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.ImportOrderPage;
import Pages.LoginPage;
import Testbase.Base;



public class TestImportOrder extends Base {
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	XSSFRow row;
	InputStream is;
	
	
	ImportOrderPage order;
	LoginPage login;
	
	
	public TestImportOrder() {
		super();
	}

	
@BeforeClass
public void setUp() throws IOException
{
	intializeBrowser();
    order= new ImportOrderPage();
	
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
	order=PageFactory.initElements(driver, ImportOrderPage.class);
}
	
	
@Test(priority=0)
public void testImportOrderTC135() throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException
{
Thread.sleep(20000);
WebDriverWait wait=new WebDriverWait(driver,60);
WebElement orders=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Orders']")));
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].click();",orders);
Thread.sleep(5000);
//boolean actual3=driver.findElement(By.xpath("//h1[text()='Open Orders']")).isDisplayed();
//sert.assertTrue(actual3);
System.out.println("'Orders' button is working");
Thread.sleep(5000);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebElement importOrders=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Import Orders']")));
js.executeScript("arguments[0].click();",importOrders);
Thread.sleep(4000);

//boolean actual4=driver.findElement(By.xpath("//span[text()='Import into Shipcaddie']")).isDisplayed();
//Assert.assertTrue(actual4);
System.out.println("'Import Orders' button is working");
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebElement csv=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Choose CSV File']")));
js.executeScript("arguments[0].scrollIntoView(true);",csv);
csv.click();

Thread.sleep(10000);
//Runtime.getRuntime().exec("D:\\FileUploaderQ1.exe");
Runtime.getRuntime().exec("E:\\Parveen_data\\Shipcaddie-master\\Res\\FileUploaderQ1.exe");
Thread.sleep(4000);
System.out.println("'Choose CSV File' button is working");

//click change button
WebElement change=driver.findElement(By.xpath("//a[text()='change']"));
js.executeScript("arguments[0].scrollIntoView(true)",change);
change.click();
Thread.sleep(1000);
System.out.println("change' button is working");

//click create a new csv mapper button
WebElement newCSV=driver.findElement(By.xpath("//a[text()='create a new csv mapper']"));
js.executeScript("arguments[0].scrollIntoView(true)", newCSV);
newCSV.click();
Thread.sleep(10000);
//boolean actual5=driver.findElement(By.xpath("//span[text()='Import into Shipcaddie']")).isDisplayed();
//Assert.assertTrue(actual5);
System.out.println("'create a new csv mapper' button is working");

//select Order Date
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Choose a Field Name']")));
driver.findElement(By.xpath("//span[text()='Choose a Field Name']")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("(//li[text()='OrderDate'])[2]")).click();
Thread.sleep(2000);
System.out.println("drop down for 'Order Date' is working");

//select Order Number
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("(//li[text()='OrderNumber'])[2]")).click();
Thread.sleep(2000);
System.out.println("drop down for 'Order Number' is working");

//select Attention Of
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='No Mapping'])[10]")));
driver.findElement(By.xpath("(//span[text()='No Mapping'])[10]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("(//li[text()='Name'])[2]")).click();
Thread.sleep(2000);
System.out.println("drop down for 'Attention Of' is working");

//select Company
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='No Mapping'])[10]")));
driver.findElement(By.xpath("(//span[text()='No Mapping'])[10]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("(//li[text()='Company'])[2]")).click();
Thread.sleep(2000);
System.out.println("drop down for 'Company' is working");

//select Phone
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("(//li[text()='PhoneNumber'])[2]")).click();
Thread.sleep(2000);
System.out.println("drop down for 'Phone' is working");

//select Email
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='No Mapping'])[10]")));
driver.findElement(By.xpath("(//span[text()='No Mapping'])[10]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("(//li[text()='Email'])[2]")).click();
Thread.sleep(2000);
System.out.println("drop down for 'Email' is working");

//select Address Line 1
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("(//li[text()='Address1'])[2]")).click();
Thread.sleep(2000);
System.out.println("drop down for 'Address Line 1' is working");

//select Address Line 2
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='No Mapping'])[10]")));
driver.findElement(By.xpath("(//span[text()='No Mapping'])[10]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("(//li[text()='Address2'])[2]")).click();
Thread.sleep(2000);
System.out.println("drop down for 'Address Line 2' is working");

//select City
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("(//li[text()='City'])[2]")).click();
Thread.sleep(2000);
System.out.println("drop down for 'City' is working");

//select Province
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("(//li[text()='state'])[2]")).click();
Thread.sleep(2000);
System.out.println("drop down for 'Province' is working");

//select Postal Code
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("(//li[text()='ZipCode'])[2]")).click();
Thread.sleep(2000);
System.out.println("drop down for 'Postal Code' is working");

//select Country Code
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("(//li[text()='Country'])[2]")).click();
Thread.sleep(2000);
System.out.println("drop down for 'Country Code' is working");

//select Item SKU
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("(//li[text()='ItemSKU'])[2]")).click();
Thread.sleep(2000);
System.out.println("drop down for 'Item Sku' is working");

//select Item Quantity
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("(//li[text()='ItemQTY'])[2]")).click();
Thread.sleep(2000);
System.out.println("drop down for 'Item Quantity' is working");

//select Item Name
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("(//li[text()='ItemName'])[2]")).click();
Thread.sleep(2000);
System.out.println("drop down for 'Item Name' is working");

//enter Mapper Name
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("clientmapname")));
driver.findElement(By.name("clientmapname")).sendKeys("testing_free");
Thread.sleep(2000);
System.out.println("'Mapper Name' textbox is working");

//click Save CSV Mapper button
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Save CSV Mapper']")));
driver.findElement(By.xpath("//span[text()='Save CSV Mapper']")).click();
Thread.sleep(2000);
System.out.println("'Save CSV Mapper' button is working");

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Added new CSV Map']")));
//boolean actual1=driver.findElement(By.xpath("//span[text()='Added new CSV Map']")).isDisplayed();
//Assert.assertTrue(actual1);
System.out.println("verify 'Added new CSV Map' message is pass");

//click Import Orders button
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@rv-show=\"areThereClientMaps\"]")));
driver.findElement(By.xpath("//span[@rv-show=\"areThereClientMaps\"]")).click();
Thread.sleep(5000);
System.out.println("'Import Orders' button is working");



WebDriverWait wait1 = new WebDriverWait(driver,60);
WebElement validation1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		"//span[text()='Successfully Imported Orders']")));

boolean actual = validation1.isDisplayed();
Assert.assertTrue(actual);


System.out.println("verify 'Successfully Imported Orders' message is pass");
}


@AfterClass
public void tearDown()
{	
driver.quit();
}

}




