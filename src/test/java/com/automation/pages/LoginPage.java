package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.automation.utils.FileHelper;
import com.automation.utils.Helper;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	private @FindBy(xpath = "//a[@id='login_Layer']") WebElement loginLink;
	private @FindBy(xpath = "//input[@placeholder='Enter your active Email ID / Username']") WebElement userEmail;
	private @FindBy(xpath = "//input[@placeholder='Enter your password']") WebElement password;
	private @FindBy(xpath = "//button[@type='submit']") WebElement loginButton;
	private @FindBy(xpath = "//div[text()='My Naukri']") WebElement myNaukriButton;
	private @FindBy(xpath = "//a[text()='Register for free']") WebElement registerLink;
	private @FindBy(xpath = "//button[@title='I am a Professional']") WebElement professionalButton;
	private @FindBy(id = "fname") WebElement fname;
	private @FindBy(id = "email") WebElement email;
	private @FindBy(name = "password") WebElement passForNewUser;
	private @FindBy(name = "number") WebElement mobileNumber;
	private @FindBy(xpath = "//input[@name='expYear']") WebElement expYear;
	private @FindBy(xpath = "//input[@name='expMonth']") WebElement expMonth;
	private @FindBy(xpath = "//input[@name='uploadCV']") WebElement uploadCV;
	private @FindBy(id = "term") WebElement term;
	private @FindBy(xpath = "//button[text()='Register Now']") WebElement registerNowButton;
	// private
	// @FindBy(xpath="//input[@name='expYear']/ancestor::div[@class='DDwrap']/following-sibling::div/ul/li/div/div/span[1]")
	// WebElement yearsList;
	// private
	// @FindBy(xpath="//input[@name='expMonth']/ancestor::div[@class='DDwrap']/following-sibling::div/ul/li/div/div/span[1]")
	// WebElement monthsList;
	private @FindBy(xpath = "//input[@id='designation_0']") WebElement currentDesignation;
	private String currentDesgnationList = "//suggestor[@options='::designation.config']//ul[@class='sugCont listing']/li/descendant::span";
	private @FindBy(xpath = "//input[@id='company_0']") WebElement currentCompany;
	private String currentCompanyList = "//suggestor[@options='::company.config']//ul[@class='sugCont listing']/li/descendant::span";
	private @FindBy(xpath = "//label[@for='radio1_0']") WebElement currencyRupees;
	private @FindBy(xpath = "//input[@name='salaryLac_0']") WebElement salaryInLakhsButton;
	private String salaryInLakhsListPath = "//div[@selected-id='[salary.salary.lakhs]']//ul[@class='droopeCont listing']/li/descendant::span";
	private @FindBy(xpath = "//input[@name='salaryThou_0']") WebElement salaryInThoundsButton;
	private String salaryInThousandsListPath = "//div[@ng-if='salary.status.showThField']//ul[@class='droopeCont listing']/li/descendant::span";
	private @FindBy(xpath = "//input[@name='startYear_0']") WebElement workingSinceYearButton;
	private String workingSinceYearsListPath = "//div[@selected-id='[duration.fromDate.year]']//ul[@class='droopeCont listing']/li/descendant::span";
	private @FindBy(xpath = "//input[@name='startMonth_0']") WebElement workingSinceMonthButton;
	private String workingSinceMonthsListPath = "//div[@selected-id='[duration.fromDate.month]']//ul[@class='droopeCont listing']/li/descendant::span";
	private @FindBy(xpath = "//input[@name='endYear_0']") WebElement endYearButton;
	private String endYearList = "//div[@selected-id='[duration.toDate.year]']//ul[@class='droopeCont listing']/li/descendant::span";
	private @FindBy(xpath = "//div[@class='inpWrap']//input[@placeholder='Tell us about your current city']") WebElement currentCity;
	private String currentCityList = "//suggestor[@options='::location.config.city']//ul[@class='sugCont listing']/li/descendant::span";
	private @FindBy(xpath = "//input[@placeholder='Select State']") WebElement stateButton;
	private String stateList = "//input[@placeholder='Select State']/ancestor::div[@class='DDwrap']/following-sibling::div/ul/li/descendant::span[1]";
	private @FindBy(xpath = "//input[@placeholder='Enter your areas of expertise/specialization']") WebElement keySkills;
	private String skillsList = "//input[@placeholder='Enter your areas of expertise/specialization']/ancestor::div[@class='sWrap']/following-sibling::ul/li/descendant::span[1]";
	private @FindBy(xpath = "//button[normalize-space()='Continue']") WebElement employeePageContinueButton;
	private @FindBy(xpath = "//input[@placeholder='Select duration of your Notice Period']") WebElement noticePeriodfield;
	private String noticeperiodList = "//div[@selected-id='[form.noticePeriodDurationId]']//ul[@class='droopeCont listing']/li/descendant::span";
	private @FindBy(xpath = "//input[@placeholder='Select the industry your company belongs to']") WebElement curIndustryButton;
	private String curIndustryList = "//div[@id='industry']//ul[@class='droopeCont listing']/li/descendant::span";
	private @FindBy(xpath = "//input[@placeholder='Select the department that you work in']") WebElement functionalAreaButton;
	private String functionalAreaList = "//div[@id='fArea']//ul[@class='droopeCont listing']/li/descendant::span";
	private @FindBy(xpath = "//input[@placeholder='Select the role that you work in']") WebElement roleButton;
	private String roleList = "//div[@id='fRole']//ul[@class='droopeCont listing']/li/descendant::span";
	private @FindBy(xpath = "//input[@placeholder='Select your highest qualification']") WebElement higestQualificationButton;
	private String higestQualificationList = "//div[@droope-callback='qual.callback.onSelect(item)']//ul[@class='droopeCont listing']/li/descendant::span";
	private @FindBy(xpath = "//input[@name='course_0']") WebElement courseButton;
	private String courseList = "//section[@class='mandatory']//edu-course[@placeholder='::eduSection.string.course.placeholder']//ul[@class='droopeCont listing']/li/descendant::span";
	private @FindBy(xpath = "//input[@placeholder='Select specialization']") WebElement specializationButton;
	private String specializationList = "//div[@ng-if='setSpecFlag==true']//div[@class='middle focus']//ul[@class='droopeCont listing']/li/descendant::span[1]";

	private @FindBy(xpath = "//input[@id='institute_0']") WebElement institute;
	private @FindBy(xpath = "//label[@for='couseType_full_0']") WebElement fullTimeButton;
	private @FindBy(xpath = "//input[@name='passingYear_0']") WebElement passingYear;
	private String passingYearList = "//edu-passing[@store='::eduSection.store']//div[@class='middle focus']//ul[@class='droopeCont listing']/li/descendant::span";
	private @FindBy(xpath = "//button[normalize-space()='Continue']") WebElement eduPageContinueButton;
	private @FindBy(xpath = "//a[text()='Skip this step']") WebElement submitButton;

	public void clickOnLoginLink() {
		loginLink.click();
	}

	public String loginToApplication(String username, String pass) {

		userEmail.sendKeys(username);
		password.sendKeys(pass);
		loginButton.click();
		return driver.getTitle();
	}

	public void cickOnMyNaukriButton() {
		myNaukriButton.click();
	}

	public void clickOnNewRegistration() {
		registerLink.click();
	}

	public void clickToChooseProfessional() {
		professionalButton.click();
	}

	public void enterUserName(String name) {
		fname.sendKeys(name);
	}

	public void enterUserEmail(String userEmail) {
		email.sendKeys(userEmail);
	}

	public void enterUserPassword(String pass) {
		passForNewUser.sendKeys(pass);
	}

	public void enterUserMobile(String numb) {
		mobileNumber.sendKeys(numb);
	}

	public void enterUserExperienceYears(String year) {
		expYear.sendKeys(year);
		Helper.selectTheElementFromDropDownList3(driver, "//input[@name='expYear']/ancestor::div[@class='DDwrap']/following-sibling::div/ul/li/div/div/span[1]", year);
		/*List<WebElement> yearsList = driver.findElements(By.xpath(
				"//input[@name='expYear']/ancestor::div[@class='DDwrap']/following-sibling::div/ul/li/div/div/span[1]"));
		for (WebElement temp : yearsList) {
			if (temp.getText().equalsIgnoreCase(year)) {
				temp.click();
				break;
			}
		}*/

	}

	public void enterUserExperienceMonth(String month) {
		expMonth.click();
		Helper.selectTheElementFromDropDownList3(driver, "//input[@name='expMonth']/ancestor::div[@class='DDwrap']/following-sibling::div/ul/li/div/div/span[1]", month);
		/*List<WebElement> monthsList = driver.findElements(By.xpath(
				"//input[@name='expMonth']/ancestor::div[@class='DDwrap']/following-sibling::div/ul/li/div/div/span[1]"));
		for (WebElement temp : monthsList) {
			if (temp.getText().equalsIgnoreCase(month)) {
				temp.click();
				break;
			}
		}*/

	}

	public void uploadUserCV(String filePath) {

		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", uploadCV);
			FileHelper.uploadFile(filePath);

			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

	}

	public void checkTermCheckBox() {
		if (term.isSelected()) {
			System.out.println("Terms CheckBox is already selected ");
		} else {
			term.click();

		}

	}

	public String clickRegisterButton() {
		registerNowButton.click();
		return driver.getTitle();

	}

	public void chooseCurrentDesignation(String desig) {
		Helper.passValueToElementUsingJS(driver, currentDesignation, desig);

	}

	public void chooseCurrentCompany(String comp) {
		Helper.passValueToElementUsingJS(driver, currentCompany, comp);

	}

	public void chooseAnnualSalaryINR() {
		if (!currencyRupees.isSelected()) {
			currencyRupees.click();
		}

	}

	public void chooseAnnualSalaryINLakshs(String slaryInLakh) {
		salaryInLakhsButton.sendKeys(slaryInLakh);
		Helper.selectTheElementFromDropDownList(driver, salaryInLakhsListPath, slaryInLakh);
		

	}

	public void chooseAnnualSalaryINThousand(String slaryInThousand) {
		salaryInThoundsButton.sendKeys(slaryInThousand);
		Helper.selectTheElementFromDropDownList(driver, salaryInThousandsListPath, slaryInThousand);
		

	}

	public void chooseWorkingSinceYears(String year) {
		workingSinceYearButton.sendKeys(year);
		Helper.selectTheElementFromDropDownList(driver, workingSinceYearsListPath, year);

	}

	public void chooseWorkingSinceMonths(String month) {
		workingSinceMonthButton.sendKeys(month);
		Helper.selectTheElementFromDropDownList(driver, workingSinceMonthsListPath, month);

	}

	public void chooseWorkingTills(String year) {
		endYearButton.sendKeys(year);
		Helper.selectTheElementFromDropDownByMouseOver(driver, endYearList, year);

	}

	public void choosecurrentCity(String city) {
		currentCity.sendKeys(city);
		List<WebElement> list = driver.findElements(By.xpath(currentCityList));
		Actions action = new Actions(driver);
		for (WebElement temp : list) {
			if (temp.getAttribute("innerHTML").equalsIgnoreCase(city)) {
				action.moveToElement(temp).click().perform();
				System.out.println("Element clicked" + temp.getAttribute("innerHTML"));
				break;
			}

		}

	}

	public void chooseCurrentState(String State) {
		stateButton.click();
		List<WebElement> list = driver.findElements(By.xpath(stateList));
		Actions action = new Actions(driver);
		for (WebElement temp : list) {
			if (temp.getAttribute("innerHTML").equalsIgnoreCase(State)) {

				temp.click();
				System.out.println("Element clicked" + temp.getAttribute("innerHTML"));
				break;
			}

		}
		
	}

	public void choosecurrentNoticePeriod(String period) {
		noticePeriodfield.click();
		Helper.selectTheElementFromDropDownList(driver, noticeperiodList, period);
		

	}

	public void choosecurrentSkils(String skill) {
		keySkills.sendKeys(skill);
		List<WebElement> list = driver.findElements(By.xpath(skillsList));
		Actions action = new Actions(driver);
		for (WebElement temp : list) {
			if (temp.getAttribute("innerHTML").equalsIgnoreCase(skill)) {
				temp.click();
				System.out.println("Element clicked" + temp.getAttribute("innerHTML"));
			}

		}

	}

	public void choosecurrentIndustry(String industry) {
		curIndustryButton.click();
		Helper.selectTheElementFromDropDownList(driver, curIndustryList, industry);
	}

	public void choosecurrentFunctionalArea(String funcArea) {
		functionalAreaButton.click();
		Helper.selectTheElementFromDropDownList(driver, functionalAreaList, funcArea);
	}

	public void choosecurrentRole(String curRole) {
		roleButton.click();
		Helper.selectTheElementFromDropDownList(driver, roleList, curRole);
		
	}

	public void chooseEmployeePageContinueButton() {
		employeePageContinueButton.click();

	}

	public void chooseHigestQualification(String qualification) {
		higestQualificationButton.click();
		Helper.selectTheElementFromDropDownList2(driver, higestQualificationList, qualification);
		
	}

	public void chooseHigestCourse(String course) {
		courseButton.click();
		Helper.selectTheElementFromDropDownList2(driver, courseList, course);
		

	}

	public void chooseSpecialization(String specialization) {
		try {
			Thread.sleep(3000);
			specializationButton.click();
			Helper.selectTheElementFromDropDownList2(driver, specializationList, specialization);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	public void chooseCollage(String collage) {
		institute.sendKeys(collage);
	}

	public void chooseCourseType() {
		if (!fullTimeButton.isSelected()) {
			fullTimeButton.click();
		}

	}

	public void choosePassingYear(String year) {
		passingYear.click();
		Helper.selectTheElementFromDropDownList(driver, passingYearList, year);
		
	}

	public String clickEducationPageContinueButton() {
		eduPageContinueButton.click();
		return driver.getTitle();

	}

	public String clickOnProfileComleteSubmitButton() {
		submitButton.click();
		return driver.getTitle();
	}

}
