package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;

public class Helper {


	public static String captureScreenshot(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir") + "/Screenshots/Naukri_" + getCurrentDateTime() + ".png";
		try {
			FileHandler.copy(src, new File(screenshotPath));
			System.out.println("Screenshot captured");
		} catch (IOException e) {

			System.out.println("Unable to capture the screenshot " + e.getMessage());
		}
		return screenshotPath;

	}

	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);

	}

	public static void closeMultipleChildWindow(WebDriver driver) {
		try {
			Thread.sleep(1000);
			String mainWindowHandle = driver.getWindowHandle();
			Set<String> allWindowHandles = driver.getWindowHandles();
			Iterator<String> iterator = allWindowHandles.iterator();

			while (iterator.hasNext()) {
				String ChildWindow = iterator.next();
				if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
					driver.switchTo().window(ChildWindow).close();
				}
			}
			driver.switchTo().window(mainWindowHandle);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		

	}

	public static void explicitWait(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void mouseOverOnElement(WebDriver driver, WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();;
	}
	public static void moseOverOnElementAndClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	/*public static void mauseOverOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}*/

	public static void selectTheElementFromDropDownList(WebDriver driver, String elementXpath, String searchText) {

		List<WebElement> yearsList = driver.findElements(By.xpath(elementXpath));
		for (WebElement temp : yearsList) {
			if (temp.getText().equalsIgnoreCase(searchText)) {
				try {
					temp.click();
					break;
				} catch (StaleElementReferenceException e) {
					temp.click();
					break;
				}
			}

		}

	}
/*
	public static void selectTheElementFromDropDownList1(WebDriver driver, String elementXpath, String searchText) {

		List<WebElement> yearsList = driver.findElements(By.xpath(elementXpath));
		for (WebElement temp : yearsList) {
			if (temp.getText().contains(searchText)) {
				try {
					temp.click();
					break;
				} catch (StaleElementReferenceException e) {
					temp.click();
					break;
				}
			}
		}
	}
*/
	public static void selectTheElementFromDropDownList2(WebDriver driver, String elementXpath, String searchText) {

		List<WebElement> yearsList = driver.findElements(By.xpath(elementXpath));
		for (WebElement temp : yearsList) {
			if (temp.getAttribute("innerHTML").equalsIgnoreCase(searchText)) {
				try {
					temp.click();
					break;
				} catch (StaleElementReferenceException e) {
					temp.click();
					break;
				}
			}
		}
	}

	public static void selectTheElementFromDropDownList3(WebDriver driver, String elementXpath, String searchText) {

		List<WebElement> list = driver.findElements(By.xpath(elementXpath));
		for (WebElement temp : list) {
			if (temp.getText().equalsIgnoreCase(searchText)) {
				temp.click();
				break;
			}
		}
	}


	public static void selectTheElementFromDropDownByMouseOver(WebDriver driver, String elementXpath,
			String searchText) {
		Actions action = new Actions(driver);
		List<WebElement> yearsList = driver.findElements(By.xpath(elementXpath));
		for (WebElement temp : yearsList) {
			if (temp.getAttribute("innerHTML").equalsIgnoreCase(searchText)) {
				try {
					action.moveToElement(temp).click().perform();
					break;
				} catch (StaleElementReferenceException e) {
					action.moveToElement(temp).click().perform();
					break;
				}
			}
		}
	}

	public static void passValueToElementUsingJS(WebDriver driver, WebElement element, String searhText) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String temp = "arguments[0].value='" + searhText + "'";

		jsExecutor.executeScript(temp, element);
	}

}
