package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class LoginTestCRM extends BaseClass{
	//WebDriver driver;
	
	//@BeforeClass
	//public void setUp() {
	//	driver=BrowserFactory.startApplication(driver,"Chrome", "https://demo.actitime.com");
	//}//if ther are mutiple test scenarios if ther are 50 test case icant copy every time this befor classs and after class code its not a good approach its a code duplication once we gor for maintainne it will be difficult for maintainanace so we cme with base class it contains all the methods of precondition and post condition  required for each and every test cases		
	@Test
	public void loginApp()
	{//new commit
		logger=report.createTest("Login to actiTIME");//logger responsible for all logging activity in test //have logger.info 
		//ExcelDataProvider excel=new ExcelDataProvider();                                
		//driver=BrowserFactory.startApplication(driver,"Chrome", "https://demo.actitime.com");//
		//System.out.println(driver.getTitle());
		LoginPage loginpage=PageFactory.initElements(driver,LoginPage.class);//go to loginpage check all locators and intialize webelement it will return to object of same class 
		//loginpage.loginToCRM("admin","manager" );//hardcoding values we try to avoid in next program//its visible to user we try to obtain thism from config file//unaame and password keep changing for diff user htat we use config file
		logger.info("Starting Appplication");
		loginpage.loginToCRM(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));//if this fails it will not execute nexT STMT
		//Helper.captureScreenshot(driver);//if it fails itit will not execute this stmt if want screnn shot if test fails or success  in that case go to baseclass provide tear down method call after method
		//BrowserFactory.quitBrowser(driver);
		logger.pass("Login Success");
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
