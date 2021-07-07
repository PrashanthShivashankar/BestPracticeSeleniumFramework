package com.automation.exceptionHandeling;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automation.pages.BaseClass;
import com.automation.pages.HomePage;
import com.automation.utils.BrowserFactory;

public class HandleException extends BaseClass {

	 HomePage homepage;

	public void afterGettingException() {

		homepage = PageFactory.initElements(driver, HomePage.class);
		homepage.clickOnHomepageButton();
		homepage.clickOnMyNaukri();

		homepage.clickOnSettings();

		homepage.clickReadMoreLink();

		homepage.selectDeleteAccountOption();

		homepage.selectDeleteAccountRadioButton();

		homepage.clickOnDeleteaccountButton();

		homepage.enterpasswordForDeleteAccount("Summer@12345");
		BrowserFactory.quitBrowser(driver);

	}

}
