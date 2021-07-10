package com.automation.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.FileHelper;
import com.automation.utils.Helper;

public class HomePage {
	WebDriver driver;
	public Logger logger4j;

	public HomePage(WebDriver ldriver) {
		this.driver = ldriver;
		logger4j = Logger.getLogger("LogFileGeneration");
	}

	private @FindBy(xpath = "//div[@class='user-name roboto-bold-text']") WebElement profileLink;
	private @FindBy(xpath = "//span[@class='fullname']") WebElement fullname;
	private @FindBy(xpath = "//span[@name='Location']") WebElement location;
	private @FindBy(xpath = "//span[@name='Mobile']") WebElement mobile;
	private @FindBy(xpath = "//span[@name='Experience']/span") WebElement experience;
	private @FindBy(xpath = "//span[@name='Salary']/span[2]") WebElement expectedSalary;
	private @FindBy(xpath = "//span[@name='Email']") WebElement email;
	private @FindBy(xpath = "//span[@class='right']") WebElement profileStrength;
	private @FindBy(xpath = "//input[@id='attachCV']") WebElement attachResumeButton;
	private @FindBy(xpath = "//div[normalize-space()='My Naukri']") WebElement myNaukrilink;
	private @FindBy(xpath = "//a[normalize-space()='Settings']") WebElement settingsButton;
	private @FindBy(xpath = "//a[normalize-space()='Read More']") WebElement readMoreLink;
	private @FindBy(xpath = "//input[@id='notLookingFor']") WebElement deactivatedropDownButton;
	private String deactivatedropdownlist = "//div[@id='ul_notLooking']/ul/descendant::a";
	private @FindBy(xpath = "//input[@id='duplicateAccount' and @type='radio']/following-sibling::label") WebElement duplicateAccountRadioButton;
	private @FindBy(xpath = "//button[normalize-space()='DELETE ACCOUNT']") WebElement deleteAccountButton;
	private @FindBy(xpath = "//input[@id='passwordField']") WebElement passwordFieldForAccountDeactivation;
	private @FindBy(xpath = "//button[@id='passowrdConfirmation']") WebElement deleteAccountLagoutButton;
	private @FindBy(xpath = "//button[text()='SKIP AND CONTINUE']") WebElement skipAndContinueButton;
	private @FindBy(xpath = "//a[@class='fl nLogo']//img") WebElement homepageButton;

	public void clickOnProfile() {
		try {
			Helper.explicitWait(driver, profileLink);
			profileLink.click();
			logger4j.info("Clicked on User ProfileLink");
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
	}

	public String checkFullName() {
		try {
			Helper.explicitWait(driver, fullname);
			logger4j.info("User Full name on ProfilePage");
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
		return fullname.getText();
	}

	public String userLocation() {
		try {
			logger4j.info("User Location on ProfilePage");
			return location.getText();
		} catch (Exception e) {
			logger4j.error(e.getMessage());
			return null;
		}

	}

	public String userMobile() {
		try {
			logger4j.info("User Mobile Number on ProfilePage");
			return mobile.getText();
		} catch (Exception e) {
			logger4j.error(e.getMessage());
			return null;
		}

	}

	public String userExperience() {
		try {
			logger4j.info("User Experience on ProfilePage");
			return experience.getText();
		} catch (Exception e) {
			logger4j.error(e.getMessage());
			return null;
		}

	}

	public String userExpectedSalaray() {
		try {
			logger4j.info("User Expected Salary on ProfilePage");
			return expectedSalary.getText();
		} catch (Exception e) {
			logger4j.error(e.getMessage());
			return null;
		}
	}

	public String userEmail() {
		try {
			logger4j.info("User Email ID on ProfilePage");
			return email.getText();
		} catch (Exception e) {
			logger4j.error(e.getMessage());
			return null;
		}
	}

	public String userProfileStrength() {
		try {
			logger4j.info("User Profile Strength on ProfilePage");
			return profileStrength.getText();
		} catch (Exception e) {
			logger4j.error(e.getMessage());
			return null;
		}
	}

	public boolean uploadResume(String filePath, String message) {
		try {

			System.out.println(driver.getTitle());

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", attachResumeButton);

			FileHelper.uploadFile(filePath);
			logger4j.info("User Uploaded CV on ProfilePage");
			Thread.sleep(5000);

			return driver.getPageSource().contains(message);
		} catch (Exception e) {
			logger4j.error(e.getMessage());
			return false;
		}

	}

	public void clickOnMyNaukri() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		try {
			Helper.mouseOverOnElement(driver, myNaukrilink);
			logger4j.info("User Mouse Over On MyNaukri Link on HomePage");
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
	}

	public void clickOnSettings() {
		try {
			Helper.moseOverOnElementAndClick(driver, settingsButton);
			logger4j.info("User Clikced on Setting Button on HomePage");
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
	}

	public void clickReadMoreLink() {

		try {

			if (skipAndContinueButton.isDisplayed()) {
				skipAndContinueButton.click();
				clickOnMyNaukri();
				clickOnSettings();
			}
			clickOnMyNaukri();
			clickOnSettings();
			readMoreLink.click();
			logger4j.info("User Clikced on ReadMore Buttonon HomePage");

		}

		catch (StaleElementReferenceException e) {
			readMoreLink.click();
			logger4j.info("User Clikced on ReadMore Buttonon HomePage");

		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}

	}

	public void selectDeleteAccountOption() {
		try {
			deactivatedropDownButton.click();
			List<WebElement> list = driver.findElements(By.xpath(deactivatedropdownlist));
			for (WebElement temp : list) {
				if (temp.getAttribute("innerHTML").contains("Delete")) {
					temp.click();
					logger4j.info("User Choosed Delete Account Option ");
					break;
				}
			}
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
	}

	public void selectDeleteAccountRadioButton() {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(duplicateAccountRadioButton));
			if (!duplicateAccountRadioButton.isSelected()) {
				duplicateAccountRadioButton.click();
				logger4j.info("User Clikced on RDuplicate Account Radio Button");
			}
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}

	}

	public void clickOnDeleteaccountButton() {
		try {
			deleteAccountButton.click();
			logger4j.info("User Clikced on DeleteAccount Button");
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
	}

	public void enterpasswordForDeleteAccount(String password) {
		try {
			passwordFieldForAccountDeactivation.sendKeys(password);
			logger4j.info("User Entered Password to delete account");
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
	}

	public String clickOnDeleteAccountAndLagOutButton() {

		try {
			deleteAccountLagoutButton.click();
			logger4j.info("User Clikced on Delete And Logout Button and Account Deleted Sucessfully");
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}

		return driver.getTitle();
	}

	public void clickOnHomepageButton() {
		try {
			homepageButton.click();
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
	}
}
