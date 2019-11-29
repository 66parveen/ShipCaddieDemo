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
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;


	import Pages.LoginPage;
	import Pages.AddProductsPage2;
	import Testbase.Base;

	public class TestAddProducts2 extends Base {

		XSSFWorkbook workbook;
		XSSFSheet sheet;
		XSSFCell cell;
		XSSFRow row;
		InputStream is;

		AddProductsPage2 product;
		LoginPage login;

		public TestAddProducts2() {
			super();

		}


	@BeforeClass
	public void setUp() throws IOException
	{
		intializeBrowser();

		login = PageFactory.initElements(driver, LoginPage.class);
		product=PageFactory.initElements(driver, AddProductsPage2.class);

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



	@Test(priority=1)
	public void testAddNewProductWindowAppearTC71() throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException
	{

	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	WebDriverWait wait=new WebDriverWait(driver, 20);
	WebElement products = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Products']")));
	JavascriptExecutor js=(JavascriptExecutor)driver;

	for(int i=0;i<=2;i++)
{
try {
	js.executeScript("arguments[0].click();", products);
	
	break;
}	
catch(Exception e)
{
	

	e.printStackTrace();
}
}
	

	Thread.sleep(25000);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	WebElement addProducts = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class=\"fa fa-plus\"]")));
	js.executeScript("arguments[0].click();", addProducts);
	Thread.sleep(1000);
	boolean actual=driver.findElement(By.xpath("//span[text()=' Add New Product']")).isDisplayed();
	Assert.assertTrue(actual);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	WebElement closeButton=driver.findElement(By.xpath("//i[@class=\"fa fa-times-circle closebutton\"]"));
	js.executeScript("arguments[0].click();", closeButton);
	Thread.sleep(1000);
	}

	@Test(priority=2)
	public void testEditProductWindowAppearTC72() throws InterruptedException
	{
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	WebDriverWait wait=new WebDriverWait(driver,20);
	WebElement selectProducts=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type=\"checkbox\"])[10]")));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", selectProducts);
	Thread.sleep(1000);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	WebElement editProducts=driver.findElement(By.xpath("//i[@class=\"fa fa-pencil\"]"));
	js.executeScript("arguments[0].click();",editProducts);
	Thread.sleep(1000);
	boolean actual=driver.findElement(By.xpath("//span[text()=' Edit Product']")).isDisplayed();
	Assert.assertTrue(actual);
	WebElement closeButton=driver.findElement(By.xpath("//i[@class=\"fa fa-times-circle closebutton\"]"));
	js.executeScript("arguments[0].click();", closeButton);
	Thread.sleep(1000);
	}

	@Test(priority=3)
	public void testValidationAppearWithoutEnteringDetailsTC73() throws InterruptedException
	{
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	WebDriverWait wait=new WebDriverWait(driver, 20);
	WebElement addProducts=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class=\"fa fa-plus\"]")));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", addProducts);
	Thread.sleep(1000);
	//TestProduct product=new TestProduct(driver);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	WebElement save = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Save']")));
	js.executeScript("arguments[0].click();", save);
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please correct the fields in red']")));
	boolean actual=driver.findElement(By.xpath("//span[text()='Please correct the fields in red']")).isDisplayed();
	Assert.assertTrue(actual);
	WebElement closeButton=driver.findElement(By.xpath("//i[@class=\"fa fa-times-circle closebutton\"]"));
	js.executeScript("arguments[0].click();", closeButton);
	Thread.sleep(1000);
	}

	@Test(priority=4)
	public void testValidationAppearOnEnteringPartialDetailsAndHitSubmitbuttonTC74() throws InterruptedException
	{
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	WebDriverWait wait=new WebDriverWait(driver,20);
	WebElement addProducts=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class=\"fa fa-plus\"]")));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", addProducts);
	Thread.sleep(1000);
	AddProductsPage2 product=new AddProductsPage2(driver);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("sku")));
	product.sku("TEST SKU UAT");
	Thread.sleep(1000);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	WebElement save = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Save']")));
	js.executeScript("arguments[0].click();", save);
	//product.save();
	Thread.sleep(1000);
	boolean actual=driver.findElement(By.xpath("//span[text()='Please correct the fields in red']")).isDisplayed();
	Assert.assertTrue(actual);
	WebElement closeButton=driver.findElement(By.xpath("//i[@class=\"fa fa-times-circle closebutton\"]"));
	js.executeScript("arguments[0].click();", closeButton);
	Thread.sleep(1000);
	}

	@Test(priority=5)
	public void testNewProductIsAddedTC75() throws InterruptedException
	{
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	AddProductsPage2 product=new AddProductsPage2(driver);
	WebDriverWait wait=new WebDriverWait(driver, 20);
	WebElement addProducts=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class=\"fa fa-plus\"]")));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", addProducts);
	Thread.sleep(1000);
	System.out.println("'Add New Product(+)' button is working");

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("sku")));
	product.sku("demo1");
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
	product.name("demo1r");
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Save']")));
	product.save();
	Thread.sleep(3000);
	boolean actual=driver.findElement(By.xpath("//span[text()='Inventory Added Successfully']")).isDisplayed();
	Assert.assertTrue(actual);
	Thread.sleep(1000);
	WebElement sku=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type=\"text\"])[1]")));
	js.executeScript("arguments[0].click();", sku);
	product.sku1("demo1");
	Thread.sleep(1000);
	WebElement selectProducts=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type=\"checkbox\"])[10]")));
	js.executeScript("arguments[0].click();", selectProducts);
	Thread.sleep(1000);
	WebElement deleteProducts=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Delete']")));
	js.executeScript("arguments[0].click();", deleteProducts);
	Thread.sleep(1000);
	product.yes();
	Thread.sleep(3000);
	}

	@Test(priority=6)
	public void testDataIsSavedInAllTheFieldsOfAddedProductTC76() throws InterruptedException
	{
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	WebDriverWait wait=new WebDriverWait(driver,20);
	WebElement addProducts=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class=\"fa fa-plus\"]")));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", addProducts);
	Thread.sleep(1000);
	AddProductsPage2 product=new AddProductsPage2(driver);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("sku")));
	product.sku("demo1");
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
	product.name("demo1R");
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("basePriceEach")));
	product.basePrice("0");
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("insuranceValue")));
	product.insuranceValue("0");
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("description")));
	product.description("Test description");
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("isEnabled")));
	product.isEnabled();
	Thread.sleep(1000);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	WebElement tags = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Select Tag(s)']")));
	js.executeScript("arguments[0].click();", tags);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[text()='Select Tag(s)']")).click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Black Color']")));
	product.selectTags();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("weightLbs")));
	product.weightLbs("1");
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("weightOz")));
	product.weightOz("1");
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Save']")));
	product.save();
	Thread.sleep(2000);
	boolean actual=driver.findElement(By.xpath("//span[text()='Inventory Added Successfully']")).isDisplayed();
	Assert.assertTrue(actual);
	Thread.sleep(1000);
	WebElement sku=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type=\"text\"])[1]")));
	js.executeScript("arguments[0].click();", sku);
	product.sku1("demo1");
	Thread.sleep(1000);
	WebElement selectProducts=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type=\"checkbox\"])[10]")));
	js.executeScript("arguments[0].click();", selectProducts);
	Thread.sleep(2000);
	WebElement deleteProducts=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Delete']")));
	js.executeScript("arguments[0].click();", deleteProducts);
	Thread.sleep(1000);
	product.yes();
	Thread.sleep(3000);
	}

	@Test(priority=7)
	public void testProductIsEditedTC77() throws InterruptedException
	{
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	AddProductsPage2 product=new AddProductsPage2(driver);
	WebDriverWait wait=new WebDriverWait(driver,20);
	WebElement sku=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type=\"text\"])[1]")));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", sku);
	product.sku1("demo");
	WebElement selectProducts=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type=\"checkbox\"])[10]")));
	js.executeScript("arguments[0].click();", selectProducts);
	Thread.sleep(1000);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	WebElement editProducts=driver.findElement(By.xpath("//i[@class=\"fa fa-pencil\"]"));
	js.executeScript("arguments[0].click();", editProducts);
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
	product.name("demo2");
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Save']")));
	product.save();
	Thread.sleep(2000);
	boolean actual=driver.findElement(By.xpath("//span[text()='Inventory Updated Successfully']")).isDisplayed();
	Assert.assertTrue(actual);
	}

	@Test(priority=8)
	public void testAllTheDetailsAreFetchedOnOpeningNewAddedProductOnOrderScreenTC78() throws InterruptedException
	{
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	AddProductsPage2 product=new AddProductsPage2(driver);
	WebDriverWait wait=new WebDriverWait(driver,20);
	WebElement orders=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Orders']")));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", orders);
	Thread.sleep(12000);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	WebElement addOrders = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add']")));
	js.executeScript("arguments[0].click();", addOrders);
	Thread.sleep(1000);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchName")));
	product.productName("electronic");
	Thread.sleep(1000);
	boolean actual=driver.findElement(By.xpath("//span[text()=' Add New Order']")).isDisplayed();
	Assert.assertTrue(actual);
	WebElement closeButton=driver.findElement(By.xpath("//i[@class=\"fa fa-times-circle closebutton\"]"));
	js.executeScript("arguments[0].click();", closeButton);
	Thread.sleep(1000);
	product.yes();
	Thread.sleep(3000);
	}

	@Test(priority=9)
	public void testAllTheDetailsAreFetchedOnOpeningNewAddedProductOnShipmentsScreenTC79() throws InterruptedException
	{
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	AddProductsPage2 product=new AddProductsPage2(driver);
	WebDriverWait wait=new WebDriverWait(driver,20);
	WebElement shipment= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Shipments']")));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",shipment);
	Thread.sleep(4000);
	WebElement addShipment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add']")));
	js.executeScript("arguments[0].click();",addShipment);
	Thread.sleep(3000);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	WebElement contents = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class=\"fa fa-pencil\"]")));
	js.executeScript("arguments[0].click();",contents);
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchName")));
	//Thread.sleep(1000);
	product.productName("electronic");
	Thread.sleep(1000);
	boolean actual=driver.findElement(By.xpath("//span[text()=' Content Details for Package ']")).isDisplayed();
	Assert.assertTrue(actual);
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}




	}

