package com.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.FileHelper;
import com.automation.utils.Helper;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	private @FindBy(xpath = "//div[@class='user-name roboto-bold-text']") WebElement profileLink;
	private @FindBy(xpath = "//span[@class='fullname']") WebElement fullname;
	private @FindBy(xpath = "//span[@name='Location']") WebElement location;
	private @FindBy(xpath = "//span[@name='Mobile']") WebElement mobile;
	private @FindBy(xpath = "//span[@name='Experience']/span") WebElement experience;
	private @FindBy(xpath = "//span[@name='Salary']/span[2]") WebElement expectedSalary;
	private @FindBy(xpath = "//span[@name='Email']") WebElement email;
	private @FindBy(xpath = "//span[@class='right']") WebElement profileStrength;
	// private @FindBy(xpath="//input[@value='Update Resume']") WebElement
	// attachResumeButton;
	private @FindBy(xpath = "//input[@id='attachCV']") WebElement attachResumeButton;

	public void clickOnProfile() {
		Helper.explicitWait(driver, profileLink);
		profileLink.click();
	}

	public String checkFullName() {
		Helper.explicitWait(driver, fullname);
		return fullname.getText();
	}

	public String userLocation() {
		return location.getText();
	}

	public String userMobile() {
		return mobile.getText();
	}

	public String userExperience() {
		return experience.getText();
	}

	public String userExpectedSalaray() {
		return expectedSalary.getText();
	}

	public String userEmail() {
		return email.getText();
	}

	public String userProfileStrength() {
		return profileStrength.getText();
	}

	public boolean uploadResume(String filePath, String message) {
		try {

			System.out.println(driver.getTitle());

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", attachResumeButton);

			FileHelper.uploadFile(filePath);

			Thread.sleep(5000);

			return driver.getPageSource().contains(message);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			return false;
		}

	}
}
