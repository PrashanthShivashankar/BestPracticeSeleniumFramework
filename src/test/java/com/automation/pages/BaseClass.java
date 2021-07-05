package com.automation.pages;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.automation.utils.BrowserFactory;
import com.automation.utils.ConfigDataProvider;
import com.automation.utils.ExcelDataProvider;
import com.automation.utils.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	public Logger logger4j;
	public ExtentHtmlReporter extent;

	@BeforeSuite
	public void setUpSuite() {
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		extent = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Reports/Naukri_" + Helper.getCurrentDateTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		logger4j = Logger.getLogger("LogFileGeneration");
		PropertyConfigurator.configure("Log4j.properties");

	}

	@BeforeClass
	public void setUp() {
		driver = BrowserFactory.startApplication(driver, config.getDataFromConfig("browser"),
				config.getDataFromConfig("url"));
		logger4j.info("Application Strated");
	}

	@AfterClass
	public void tearDown() {
		logger4j.info("Closing Application");
		BrowserFactory.quitBrowser(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {

			logger.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test Passs",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.skip("Test Skipped",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}

		report.flush();
		logger4j.info("After Test method excecuted");

	}

}
