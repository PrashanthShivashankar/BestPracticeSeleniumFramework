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
	private @FindBy(xpath="//div[normalize-space()='My Naukri']") WebElement myNaukrilink;
	private @FindBy(xpath="//a[normalize-space()='Settings']") WebElement settingsButton;
	private @FindBy(xpath="//a[normalize-space()='Read More']") WebElement readMoreLink;
	private @FindBy(xpath="//input[@id='notLookingFor']") WebElement deactivatedropDownButton;
	private String deactivatedropdownlist="//div[@id='ul_notLooking']/ul/descendant::a";
	private @FindBy(xpath="//input[@id='duplicateAccount' and @type='radio']/following-sibling::label") WebElement duplicateAccountRadioButton;
	private @FindBy(xpath="//button[normalize-space()='DELETE ACCOUNT']") WebElement deleteAccountButton;
	private @FindBy(xpath="//input[@id='passwordField']") WebElement passwordFieldForAccountDeactivation;
	private @FindBy(xpath="//button[@id='passowrdConfirmation']") WebElement deleteAccountLagoutButton;
	private @FindBy(xpath="//button[text()='SKIP AND CONTINUE']") WebElement skipAndContinueButton;
	private @FindBy(xpath="//a[@class='fl nLogo']//img") WebElement homepageButton;
	
	public void clickOnProfile() {
		Helper.explicitWait(driver, profileLink);
		profileLink.click();
		logger4j.info("Clicked on User ProfileLink");
	}

	public String checkFullName() {
		Helper.explicitWait(driver, fullname);
		logger4j.info("User Full name on ProfilePage");
		return fullname.getText();
	}

	public String userLocation() {
		logger4j.info("User Location on ProfilePage");
		return location.getText();
	}

	public String userMobile() {
		logger4j.info("User Mobile Number on ProfilePage");
		return mobile.getText();
		
	}

	public String userExperience() {
		logger4j.info("User Experience on ProfilePage");
		return experience.getText();
	}

	public String userExpectedSalaray() {
		logger4j.info("User Expected Salary on ProfilePage");
		return expectedSalary.getText();
	}

	public String userEmail() {
		logger4j.info("User Email ID on ProfilePage");
		return email.getText();
	}

	public String userProfileStrength() {
		logger4j.info("User Profile Strength on ProfilePage");
		return profileStrength.getText();
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
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			return false;
		}

	}
	
	public void clickOnMyNaukri()
	{
		Helper.mouseOverOnElement(driver, myNaukrilink);
		logger4j.info("User Mouse Over On MyNaukri Link on HomePage");
	}
	
	public void clickOnSettings() {
		Helper.moseOverOnElementAndClick(driver, settingsButton);
		logger4j.info("User Clikced on Setting Button on HomePage");
	}
	
	public void clickReadMoreLink() {
		
		try {
			
			if(skipAndContinueButton.isDisplayed())
			{
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
		
		}
				
	
	}
	
	public void selectDeleteAccountOption() {
		deactivatedropDownButton.click();
		List<WebElement> list=driver.findElements(By.xpath(deactivatedropdownlist));
		for(WebElement temp : list){
			if(temp.getAttribute("innerHTML").contains("Delete")) {
				temp.click();
				logger4j.info("User Choosed Delete Account Option ");
				break;
			}
		}
	}
	
	public void selectDeleteAccountRadioButton() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(
		ExpectedConditions.elementToBeClickable(duplicateAccountRadioButton));
		if(!duplicateAccountRadioButton.isSelected()) {
			duplicateAccountRadioButton.click();
			logger4j.info("User Clikced on RDuplicate Account Radio Button");
		}
		
	}
	
	public void clickOnDeleteaccountButton() {
		
		deleteAccountButton.click();
		logger4j.info("User Clikced on DeleteAccount Button");
	}
	
	public void enterpasswordForDeleteAccount(String password) {
		passwordFieldForAccountDeactivation.sendKeys(password);
		logger4j.info("User Entered Password to delete account");
	}
	
	public String clickOnDeleteAccountAndLagOutButton() {
		
		try {
			deleteAccountLagoutButton.click();
			logger4j.info("User Clikced on Delete And Logout Button and Account Deleted Sucessfully");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return driver.getTitle();
	}
	
	public void clickOnHomepageButton() {
		homepageButton.click();
	}
}
