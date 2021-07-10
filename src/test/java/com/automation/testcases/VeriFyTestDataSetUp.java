package com.automation.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.utils.ExcelDataProvider;

public class VeriFyTestDataSetUp 
{
	public ExcelDataProvider excel;
	@DataProvider
	public Object[][]  readExcelData()
	{
		excel=new  ExcelDataProvider();
		Object[][] data=excel.getTestData("./TestData/NaukriEnrollment3.xlsx","NaukriNewEnrollment");
	    return data;
		
	}

	@Test(priority=4, dataProvider="readExcelData")
	public void verify(String username, String location, String mobile, String exp, String email, String expSalary, String profStrength )
	{
		System.out.println(username);
	}
	
	
	
	
}
