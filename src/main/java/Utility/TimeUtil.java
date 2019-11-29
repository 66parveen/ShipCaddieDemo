package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeUtil {

	public static long PageLoadWait = 200;
	public static long ImplicitWait = 100;
	public static WebDriver driver;

	public static WebDriver sendKeys(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
		return driver;

	}
	


	public static WebDriver clickOn(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		return driver;

	}

	public static WebDriver hovef(WebElement ele, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).perform();
		return driver;

	}

	public static void fn_Select1(WebElement WE, String VisibleText) {
		Select selObj = new Select(WE);
		selObj.selectByVisibleText(VisibleText);
	}

	public static void fn_Select2(WebElement WE, int IndexValue) {
		Select selObj = new Select(WE);
		selObj.selectByIndex(IndexValue);
	}

	public static void fn_Select3(WebElement WE, String Value) {
		Select selObj = new Select(WE);
		selObj.selectByValue(Value);
	}
	



}