package com.automation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utils.BrowserFactory;

public class UserRegistrationTestcase extends BaseClass {
	LoginPage loginpage;
	HomePage homepage;

	@DataProvider
	public Object[][] readNewUserdata() {
		Object[][] data = excel.getTestData("NaukriNewEnrollment");
		return data;

	}

	@Test(priority = 1, dataProvider = "readNewUserdata")
	public void verifyNewUsrerRegistration(String name, String userEmail, String pass, String numb, String year,
			String month, String CurDesignation, String CurCompany, String AnaualSalaryInLakh,
			String AnaualSalaryInThousand, String WorkingSinceYear, String WorkingSinceMonth, String WorkingTill,
			String CurCity, String CurNoticePeriod, String Skills, String Industry, String FunctionalArea, String Role,
			String HighestQualification, String Course, String Specialization, String Collage, String PassingYear,
			String CVPath) {
		try {
			
		loginpage = PageFactory.initElements(driver, LoginPage.class);
		logger4j.info("verifyNewUsrerRegistration testcase started");
		logger = report.createTest("Personal Page");
		logger.info("Starting application");
		loginpage.clickOnLoginLink();
		loginpage.clickOnNewRegistration();
		loginpage.clickToChooseProfessional();
		loginpage.enterUserName(name);
		loginpage.enterUserEmail("PPmno1234567890@gmail.com");
		loginpage.enterUserPassword(pass);
		loginpage.enterUserMobile("9731534547");
		loginpage.enterUserExperienceYears("3");
		loginpage.enterUserExperienceMonth("1");
		loginpage.uploadUserCV("F:\\Python-Programs\\SeleniumFrameworkNaukri\\TestData\\PRASHANTH_SELENIUM.pdf");
		loginpage.checkTermCheckBox();
		Assert.assertEquals(loginpage.clickRegisterButton(), driver.getTitle());
		logger4j.info("Experience Page");
		loginpage.chooseCurrentDesignation("Analyst");
		loginpage.chooseCurrentCompany(CurCompany);
		loginpage.chooseAnnualSalaryINR();
		loginpage.chooseAnnualSalaryINLakshs("2");
		loginpage.chooseAnnualSalaryINThousand("10");
		loginpage.chooseWorkingSinceYears("2018");
		loginpage.chooseWorkingSinceMonths("Jan");
		loginpage.chooseWorkingTills(WorkingTill);
		loginpage.choosecurrentCity("Bangalore Rural, Karnataka");
		loginpage.chooseCurrentState("Karnataka");
		loginpage.choosecurrentNoticePeriod(CurNoticePeriod);
		loginpage.choosecurrentSkils(Skills);
		loginpage.choosecurrentIndustry(Industry);
		loginpage.choosecurrentFunctionalArea(FunctionalArea);
		loginpage.choosecurrentRole(Role);
		loginpage.chooseEmployeePageContinueButton();
		logger4j.info("Education Page");
		loginpage.chooseHigestQualification(HighestQualification);
		loginpage.chooseHigestCourse(Course);
		loginpage.chooseSpecialization("Computers");
		loginpage.chooseCollage(Collage);
		loginpage.chooseCourseType();
		loginpage.choosePassingYear("2017");
		loginpage.clickEducationPageContinueButton();
		Assert.assertEquals(loginpage.clickOnProfileComleteSubmitButton(),
			driver.getTitle());
		logger.info("Testcase Ended and closing application");
		} catch(Exception e) {
			System.out.println("Runtime Exception Occured , And closing the Application"+ e.getMessage());
			BrowserFactory.quitBrowser(driver);
		}
		
	}
	
	@Test(priority=2, dependsOnMethods="verifyNewUsrerRegistration")
	public void verifyAccountDeleteFunctionality() {
		try {
			
		homepage = PageFactory.initElements(driver, HomePage.class);
		logger4j.info("verifyAccountDeleteFunctionality testcase started");
		logger = report.createTest("Delete Account Functionality");
		homepage.clickOnMyNaukri();
		logger4j.info("Mynaukri link clicked");
		homepage.clickOnSettings();
		logger4j.info("Setting button link clicked");
		homepage.clickReadMoreLink();
		logger4j.info("ReadMore link clicked");
		homepage.selectDeleteAccountOption();
		logger4j.info("DeleteAccount choosed and clicked");
		homepage.selectDeleteAccountRadioButton();
		logger4j.info("Radio Button link clicked");
		homepage.clickOnDeleteaccountButton();
		logger4j.info("Delete Account button clicked");
		homepage.enterpasswordForDeleteAccount("Summer@12345");
		logger4j.info("Password entered  clicked");
		Assert.assertEquals(homepage.clickOnDeleteAccountAndLagOutButton(), "Jobs - Recruitment - Job Search - Employment -Job Vacancies - Naukri.com");
		logger.info("Delete Account Functionality TestCase Ended and closing application");
		} catch(Exception e) {
			System.out.println("Runtime Exception Occured , And closing the Application"+ e.getMessage());
			BrowserFactory.quitBrowser(driver);
		}
		
		
	}

}
