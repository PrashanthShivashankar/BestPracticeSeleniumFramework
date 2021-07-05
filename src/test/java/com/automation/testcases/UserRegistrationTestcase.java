package com.automation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;

public class UserRegistrationTestcase extends BaseClass {
	LoginPage loginpage;

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
				"Free Job Alert 2021, Latest Job Alert & Notifications – Naukri.com");
		logger.info("Testcase Ended and closing application");
	}

}
