package com.automation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.exceptionHandeling.HandleException;
import com.automation.pages.BaseClass;
import com.automation.pages.BaseClassForRegression;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utils.BrowserFactory;

public class UserRegistrationTestcaseForRegressionE2E extends BaseClassForRegression {
	LoginPage loginpage;
	HomePage homepage;

	@DataProvider
	public Object[][] readNewUserdata() {
		Object[][] data = excel.getTestData("./TestData/NaukriEnrollment3.xlsx","NaukriNewEnrollment");
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
			logger4j.info("Personal Details Tab");
			loginpage.clickOnLoginLink();
			loginpage.clickOnNewRegistration();
			loginpage.clickToChooseProfessional();
			loginpage.enterUserName(name);
			loginpage.enterUserEmail(userEmail);
			loginpage.enterUserPassword(pass);
			loginpage.enterUserMobile(numb);
			loginpage.enterUserExperienceYears(year);
			loginpage.enterUserExperienceMonth(month);
			loginpage.uploadUserCV1(CVPath);
			loginpage.checkTermCheckBox();
			Assert.assertEquals(loginpage.clickRegisterButton(), driver.getTitle());
			logger4j.info("Experience Details Tab");
			loginpage.chooseCurrentDesignation(CurDesignation);
			loginpage.chooseCurrentCompany(CurCompany);
			loginpage.chooseAnnualSalaryINR();
			loginpage.chooseAnnualSalaryINLakshs(AnaualSalaryInLakh);
			loginpage.chooseAnnualSalaryINThousand(AnaualSalaryInThousand);
			loginpage.chooseWorkingSinceYears(WorkingSinceYear);
			loginpage.chooseWorkingSinceMonths(WorkingSinceMonth);
			loginpage.chooseWorkingTills(WorkingTill);
			loginpage.choosecurrentCity(CurCity);
			loginpage.chooseCurrentState("Karnataka");
			loginpage.choosecurrentNoticePeriod(CurNoticePeriod);
			loginpage.choosecurrentSkils(Skills);
			loginpage.choosecurrentIndustry(Industry);
			loginpage.choosecurrentFunctionalArea(FunctionalArea);
			loginpage.choosecurrentRole(Role);
			loginpage.chooseEmployeePageContinueButton();
			logger4j.info("Education Details Tab");
			loginpage.chooseHigestQualification(HighestQualification);
			loginpage.chooseHigestCourse(Course);
			loginpage.chooseSpecialization(Specialization);
			loginpage.chooseCollage(Collage);
			loginpage.chooseCourseType();
			loginpage.choosePassingYear(PassingYear);
			loginpage.clickEducationPageContinueButton();
			Assert.assertEquals(loginpage.clickOnProfileComleteSubmitButton(), driver.getTitle());
			logger.info("User Registed Sucessfully");
			logger.info("Starting to delete the registered user");
			homepage = PageFactory.initElements(driver, HomePage.class);
			logger4j.info("verifyAccountDeleteFunctionality testcase started");
			homepage.clickOnMyNaukri();
			homepage.clickOnSettings();
			homepage.clickReadMoreLink();
			homepage.selectDeleteAccountOption();
			homepage.selectDeleteAccountRadioButton();
			homepage.clickOnDeleteaccountButton();
			homepage.enterpasswordForDeleteAccount(pass);
			Assert.assertEquals(homepage.clickOnDeleteAccountAndLagOutButton(),
					"Jobs - Recruitment - Job Search - Employment -Job Vacancies - Naukri.com");
			logger.info("Delete Account Functionality TestCase Ended and closing application");
			logger4j.info("verifyAccountDeleteFunctionality testcase Ended");
		} catch (Exception e) {
			logger4j.error(e.getMessage());
			HandleException obj = new HandleException();
			obj.afterGettingException();
		}

	}

	
}
