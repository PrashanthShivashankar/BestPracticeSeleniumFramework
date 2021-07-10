package com.automation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;

public class NaukriProfilePageTest extends BaseClass
{
	LoginPage loginpage;
	HomePage homepage;
	
	@Test(priority=3)
	public void verifyProfileName()
	{
		logger4j.info("Profilename verify testcase started");
		logger=report.createTest("Login to Naukri Application");
		loginpage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting application");
		loginpage.clickOnLoginLink();
		loginpage.loginToApplication(config.getDataFromConfig("username"),config.getDataFromConfig("password"));
		homepage=PageFactory.initElements(driver, HomePage.class);
		homepage.clickOnProfile();
		Assert.assertEquals(homepage.checkFullName(),"Prashanth S");
		logger4j.info("Profilename verify testcase ended");
		
		
	}
	
	@DataProvider
	public Object[][]  readExcelData()
	{
		Object[][] data=excel.getTestData("./TestData/NaukriEnrollment3.xlsx","NaukriNewEnrollment");
	    return data;
		
	}
	@Test(priority=4, dataProvider="readExcelData", enabled=false)
	public void verify(String username, String location, String mobile, String exp, String email, String expSalary, String profStrength )
	{
		loginpage=PageFactory.initElements(driver, LoginPage.class);
		homepage=PageFactory.initElements(driver, HomePage.class);
		logger4j.info("Profile Detaials verify testcase started");
		logger=report.createTest("Profile1 Details TestCase");
		logger.info("Starting application");
		loginpage.clickOnLoginLink();
		loginpage.loginToApplication(config.getDataFromConfig("username"),config.getDataFromConfig("password"));
		homepage.clickOnProfile();
		Assert.assertEquals(homepage.checkFullName(),username);
		Assert.assertEquals(homepage.userLocation(), location);
		Assert.assertEquals(homepage.userEmail(), email);
		Assert.assertEquals(homepage.userMobile(), mobile);
		Assert.assertTrue(homepage.userExpectedSalaray().contains(expSalary));
		Assert.assertTrue(homepage.userExperience().contains(exp));
		Assert.assertEquals(homepage.userProfileStrength(), profStrength);
		
		logger4j.info("Profile Details verify testcase ended");
		
		
	}
	
	@Test(priority=4, dataProvider="readExcelData")
	public void verify1(String username, String location, String mobile, String exp, String email, String expSalary, String profStrength )
	{
		
		logger4j.info("Profile Detaials verify testcase started");
		logger=report.createTest("Profile1 Details TestCase");
		logger.info("Starting application");		
		Assert.assertEquals(homepage.checkFullName(),username);
		Assert.assertEquals(homepage.userLocation(), location);
		Assert.assertEquals(homepage.userEmail(), email);
		Assert.assertEquals(homepage.userMobile(), mobile);
		Assert.assertTrue(homepage.userExpectedSalaray().contains(expSalary));
		Assert.assertTrue(homepage.userExperience().contains(exp));
		Assert.assertEquals(homepage.userProfileStrength(), profStrength);		
		logger4j.info("Profile Details verify testcase ended");
		
		
	}
	
	@Test(priority=5)
	public void verifyResumeUpload()
	{
		logger4j.info("verifyResumeUpload testcase started");
		logger=report.createTest("verifyResumeUpload TestCase");
		logger.info("Starting application");		
		Assert.assertTrue(homepage.uploadResume("F:\\Python-Programs\\SeleniumFrameworkNaukri\\TestData\\PRASHANTH_SELENIUM.pdf", "Success"));
		logger4j.info("verifyResumeUpload testcase ended");
	}
	
}
