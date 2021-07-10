package com.automation.pages;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
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
	public Logger logger4j;

	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
		logger4j = Logger.getLogger("LogFileGeneration");
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
		try {
			loginLink.click();
			logger4j.info("Clicked on Login Link");
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}

	}

	public String loginToApplication(String username, String pass) {
		try {
			userEmail.sendKeys(username);
			password.sendKeys(pass);
			loginButton.click();

		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
		return driver.getTitle();

	}

	public void cickOnMyNaukriButton() {
		try {
			myNaukriButton.click();
			logger4j.info("Clicked on MyNauri Link Button");
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
	}

	public void clickOnNewRegistration() {
		try {
			registerLink.click();
			logger4j.info("Clicked on Register Link Button");
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
	}

	public void clickToChooseProfessional() {
		try {
			professionalButton.click();
			logger4j.info("Clicked on Professinal Option Button");
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
	}

	public void enterUserName(String name) {
		fname.sendKeys(name);
		logger4j.info("User Name Entered " + name);
	}

	public void enterUserEmail(String userEmail) {
		try {
			email.sendKeys(userEmail);
			logger4j.info("User Email ID Entered " + userEmail);
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
	}

	public void enterUserPassword(String pass) {
		try {
			passForNewUser.sendKeys(pass);
			logger4j.info("User password Entered " + pass);
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
	}

	public void enterUserMobile(String numb) {
		try {
			mobileNumber.sendKeys(numb);
			logger4j.info("User Mobile Number Entered " + numb);
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
	}

	public void enterUserExperienceYears(String year) {
		try {
			expYear.sendKeys(year);
			Helper.selectTheElementFromDropDownList3(driver,
					"//input[@name='expYear']/ancestor::div[@class='DDwrap']/following-sibling::div/ul/li/div/div/span[1]",
					year);
			logger4j.info("User Experience Years Selected  " + year);
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}

	}

	public void enterUserExperienceMonth(String month) {
		try {
			expMonth.click();
			Helper.selectTheElementFromDropDownList3(driver,
					"//input[@name='expMonth']/ancestor::div[@class='DDwrap']/following-sibling::div/ul/li/div/div/span[1]",
					month);
			logger4j.info("User Experience month Selected  " + month);
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
	}

	public void uploadUserCV(String filePath) {

		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", uploadCV);
			FileHelper.uploadFile(filePath);
			logger4j.info("User CV uploaded Sucessfully  " + filePath);
			Thread.sleep(1000);
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}

	}

	public void uploadUserCV1(String filePath) {

		try {
			File file = new File(filePath);
			uploadCV.sendKeys(file.getAbsolutePath());
			logger4j.info("User CV uploaded Sucessfully  " + filePath);

		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}

	}

	public void checkTermCheckBox() {
		try {
			if (term.isSelected()) {
				logger4j.info("Check Box Already Selected");
			} else {
				term.click();
				logger4j.info("Check Box now Selected");
			}
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}

	}

	public String clickRegisterButton() {
		try {
			registerNowButton.click();
			logger4j.info("Register bitton clicked in Personal Details Page");
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
		return driver.getTitle();

	}

	public void chooseCurrentDesignation(String desig) {
		try {
			Helper.passValueToElementUsingJS(driver, currentDesignation, desig);
			logger4j.info("User Current Designation is selected: " + desig);
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}

	}

	public void chooseCurrentCompany(String comp) {
		try {
			Helper.passValueToElementUsingJS(driver, currentCompany, comp);
			logger4j.info("User Current Company is selected: " + comp);
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}

	}

	public void chooseAnnualSalaryINR() {
		try {
			if (!currencyRupees.isSelected()) {
				currencyRupees.click();
				logger4j.info("Annual Slary Ruppees Sysbol is selected");
			}
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}

	}

	public void chooseAnnualSalaryINLakshs(String slaryInLakh) {
		try {
			salaryInLakhsButton.sendKeys(slaryInLakh);
			Helper.selectTheElementFromDropDownList(driver, salaryInLakhsListPath, slaryInLakh);
			logger4j.info("Annual Slary in Lakhs selected " + slaryInLakh);
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}

	}

	public void chooseAnnualSalaryINThousand(String slaryInThousand) {
		try {
			salaryInThoundsButton.sendKeys(slaryInThousand);
			Helper.selectTheElementFromDropDownList(driver, salaryInThousandsListPath, slaryInThousand);
			logger4j.info("Annual Slary in Lakhs selected " + slaryInThousand);
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}

	}

	public void chooseWorkingSinceYears(String year) {
		try {
			workingSinceYearButton.sendKeys(year);
			Helper.selectTheElementFromDropDownList(driver, workingSinceYearsListPath, year);
			logger4j.info("User Work Experience Year selected  " + year);
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}

	}

	public void chooseWorkingSinceMonths(String month) {
		try {
			workingSinceMonthButton.sendKeys(month);
			Helper.selectTheElementFromDropDownList(driver, workingSinceMonthsListPath, month);
			logger4j.info("User Work Experience month selected  " + month);
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}

	}

	public void chooseWorkingTills(String year) {
		try {
			endYearButton.sendKeys(year);
			Helper.selectTheElementFromDropDownByMouseOver(driver, endYearList, year);
			logger4j.info("User Work Experience Till Year selected  " + year);
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}

	}

	public void choosecurrentCity(String city) {
		try {
			currentCity.sendKeys(city);
			List<WebElement> list = driver.findElements(By.xpath(currentCityList));
			Actions action = new Actions(driver);
			for (WebElement temp : list) {
				if (temp.getAttribute("innerHTML").equalsIgnoreCase(city)) {
					action.moveToElement(temp).click().perform();
					logger4j.info("User Current City selected  " + temp.getAttribute("innerHTML"));
					break;
				}

			}
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}

	}

	public void chooseCurrentState(String State) {
		try {
			stateButton.click();
			List<WebElement> list = driver.findElements(By.xpath(stateList));
			Actions action = new Actions(driver);
			for (WebElement temp : list) {
				if (temp.getAttribute("innerHTML").equalsIgnoreCase(State)) {

					temp.click();
					logger4j.info("User Current State selected  " + temp.getAttribute("innerHTML"));
					break;
				}

			}
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}

	}

	public void choosecurrentNoticePeriod(String period) {
		try {
			noticePeriodfield.click();
			Helper.selectTheElementFromDropDownList(driver, noticeperiodList, period);
			logger4j.info("User Current Notice Period selected  " + period);
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}

	}

	public void choosecurrentSkils(String skill) {
		try {
			keySkills.sendKeys(skill);
			List<WebElement> list = driver.findElements(By.xpath(skillsList));
			Actions action = new Actions(driver);
			for (WebElement temp : list) {
				if (temp.getAttribute("innerHTML").equalsIgnoreCase(skill)) {
					temp.click();
					logger4j.info("User Current Skill selected  " + temp.getAttribute("innerHTML"));
				}

			}
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}

	}

	public void choosecurrentIndustry(String industry) {
		try {
			curIndustryButton.click();
			Helper.selectTheElementFromDropDownList(driver, curIndustryList, industry);
			logger4j.info("User Current Industry  selected  " + industry);
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
	}

	public void choosecurrentFunctionalArea(String funcArea) {
		try {
			functionalAreaButton.click();
			Helper.selectTheElementFromDropDownList(driver, functionalAreaList, funcArea);
			logger4j.info("User Current Industry  selected  " + funcArea);
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
	}

	public void choosecurrentRole(String curRole) {
		try {
			roleButton.click();
			Helper.selectTheElementFromDropDownList(driver, roleList, curRole);
			logger4j.info("User Current Industry  selected  " + curRole);
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
	}

	public void chooseEmployeePageContinueButton() {
		employeePageContinueButton.click();
		logger4j.info("Clicked on Continue Button in Experience Page");

	}

	public void chooseHigestQualification(String qualification) {
		try {
			higestQualificationButton.click();
			Helper.selectTheElementFromDropDownList2(driver, higestQualificationList, qualification);
			logger4j.info("User Highest Qualification Selected " + qualification);
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
	}

	public void chooseHigestCourse(String course) {
		try {
			courseButton.click();
			Helper.selectTheElementFromDropDownList2(driver, courseList, course);
			logger4j.info("User Course Selected " + course);
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}

	}

	public void chooseSpecialization(String specialization) {
		try {
			Thread.sleep(3000);
			specializationButton.click();
			Helper.selectTheElementFromDropDownList2(driver, specializationList, specialization);
			logger4j.info("User Specialization Selected " + specialization);
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
	}

	public void chooseCollage(String collage) {
		try {
			institute.sendKeys(collage);
			logger4j.info("User Collage Selected " + collage);
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
	}

	public void chooseCourseType() {
		try {
			if (!fullTimeButton.isSelected()) {
				fullTimeButton.click();
				logger4j.info("User Type of Course Selected");
			}
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}

	}

	public void choosePassingYear(String year) {
		try {
			passingYear.click();
			Helper.selectTheElementFromDropDownList(driver, passingYearList, year);
			logger4j.info("User Year of Passing Selected " + year);
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}

	}

	public String clickEducationPageContinueButton() {
		try {
			eduPageContinueButton.click();
			logger4j.info("Cliked on Continue button in Educaition Page");
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
		return driver.getTitle();

	}

	public String clickOnProfileComleteSubmitButton() {
		try {
			submitButton.click();
			logger4j.info("Clicked on Profile Complete Submit Button");
		} catch (Exception e) {
			logger4j.error(e.getMessage());
		}
		return driver.getTitle();
	}

}
