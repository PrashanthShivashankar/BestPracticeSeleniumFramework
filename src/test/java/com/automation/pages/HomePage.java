package com.automation.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
	
	public void clickOnMyNaukri()
	{
		Helper.mouseOverOnElement(driver, myNaukrilink);
	}
	
	public void clickOnSettings() {
		Helper.moseOverOnElementAndClick(driver, settingsButton);
	}
	
	public void clickReadMoreLink() {
		
		try {
			/*WebDriverWait wait = new WebDriverWait(driver, 10);
			 wait.until(
			ExpectedConditions.elementToBeClickable(skipAndContinueButton));*/
			if(skipAndContinueButton.isDisplayed())
			{
				skipAndContinueButton.click();
				clickOnMyNaukri();
				clickOnSettings();
			}
			clickOnMyNaukri();
			clickOnSettings();
			readMoreLink.click();
			System.out.println("Element Selected ");
			
		}
			
		catch (StaleElementReferenceException e) {
			readMoreLink.click();
			System.out.println("Element Selected ");
		
		}
				
	
	}
	
	public void selectDeleteAccountOption() {
		deactivatedropDownButton.click();
		List<WebElement> list=driver.findElements(By.xpath(deactivatedropdownlist));
		for(WebElement temp : list){
			if(temp.getAttribute("innerHTML").contains("Delete")) {
				temp.click();
			}
		}
	}
	
	public void selectDeleteAccountRadioButton() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(
		ExpectedConditions.elementToBeClickable(duplicateAccountRadioButton));
		if(!duplicateAccountRadioButton.isSelected()) {
			duplicateAccountRadioButton.click();
		}
		
	}
	
	public void clickOnDeleteaccountButton() {
		
		deleteAccountButton.click();
	}
	
	public void enterpasswordForDeleteAccount(String password) {
		passwordFieldForAccountDeactivation.sendKeys(password);
	}
	
	public String clickOnDeleteAccountAndLagOutButton() {
		
		try {
			deleteAccountLagoutButton.click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.getTitle();
	}
}
