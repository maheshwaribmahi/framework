package com.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.BaseClass;
import com.pages.LoginPage;
import com.utility.BrowserFactory;
import com.utility.ExcelDataProvider;
import com.utility.Helper;

public class loginTestMPL extends BaseClass{
	
	
	@Test
	public void loginPage() throws InterruptedException {
		
		logger=report.createTest("Login to MPLFantasy");//logger responsible for all logging activity in test //have logger.info 
		
		
		
		//create object of exceldataprovide class and call method present in it though object refrence variable of tht class
		ExcelDataProvider excel=new ExcelDataProvider();
		
		
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		//System.out.println(driver.getTitle());
		
		logger.info("Starting Application");
		
		loginpage.loginToMPL(excel.getNumericData("Login",0,0),excel.getNumericData("Login", 0, 1));
		
		logger.pass("Login Success");
		
		//Helper.captureScreenshot(driver);
		
	}
	
	
	
	//@AfterClass
		//public void tearDown() {
			//BrowserFactory.quitBrowser(driver);
	/*@Test(priority=2)
	public void loginAPP1()
	{//it will append it will add two tc login and logout even single step fail in logout it will show fail//we have not ginven dynamic name for report it will overrwrite previous report
		logger=report.createTest("Logout");
		logger.fail("Logout failed");//
	}
	*/
	
	

}
