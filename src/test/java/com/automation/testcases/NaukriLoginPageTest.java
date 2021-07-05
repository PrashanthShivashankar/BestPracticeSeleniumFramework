package com.automation.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;




public class NaukriLoginPageTest extends BaseClass
{
	//Logger log = Logger.getLogger(LoginTestCRM.class);
	LoginPage loginpage;
	
	@Test(priority=1)
	public void loginAppTest()
	{
		logger4j.info("Login Testcase started");
		logger=report.createTest("Login to Naukri Application");
		loginpage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application");
		loginpage.clickOnLoginLink();
		Assert.assertEquals(loginpage.loginToApplication(config.getDataFromConfig("username"),config.getDataFromConfig("password")), driver.getTitle());
		logger.pass("Login Validation is Sucessfull");
		logger4j.info("Login Testcase Ended");
	}
	
	
	@Test(priority=2)
	public void verifyMyNaukriLink() throws InterruptedException
	{
		logger4j.info("MyNaukri link Testcase started");
		logger=report.createTest("Login to MyNaukri Link");
		
		logger.info("Starting Application");
		
		loginpage.cickOnMyNaukriButton();
		logger4j.info("MyNaukri Testcase is ended");
		
	}

	
	
	
}
