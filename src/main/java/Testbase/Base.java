package Testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Utility.TimeUtil;

public class Base {

	public static WebDriver driver;
	public static Properties prop;



	public Base() {

	
		try {
			prop = new Properties();

		
			FileInputStream fis = new FileInputStream("E:\\Parveen_data\\Shipcaddie-master\\src\\main\\java\\Resources\\data.properties");

			prop.load(fis);
			


		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e)

		{
			e.printStackTrace();
		}

	}

	public static void intializeBrowser() throws IOException

	{

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome"))

		{
			//String path = System.getProperty("user.dir");
			//System.setProperty("webdriver.chrome.driver", path+"\\driver\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "E:\\Parveen_data\\Shipcaddie-master\\driver\\chromedriver.exe");
			

			driver = new ChromeDriver();
		}

		else if (browserName.equals("firefox"))

		{

			System.setProperty("", "");

			driver = new FirefoxDriver();

		}

		else if (browserName.equals("IE"))

		{
			System.setProperty("", "");

			driver = new InternetExplorerDriver();

		}

	
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TimeUtil.PageLoadWait, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TimeUtil.ImplicitWait,TimeUnit.SECONDS);
		//driver.findElement(By.xpath(prop.getProperty("email")));
		//driver.findElement(By.xpath(prop.getProperty("password")));
	}
	
	
	
	
	

}
