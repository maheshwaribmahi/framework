package com.learnautomation.pages;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		//commit
		Reporter.log("Setting up reports and Test is getting ready",true);//custom log its upto you  how you want
		
		excel=new ExcelDataProvider();//if u dont want create object again and again this engough ultimate goal is to get data from excel
		config=new ConfigDataProvider();
		
		
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/actiTIME_"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);//one reporter is done we need to flush i9t
		
		Reporter.log("Setting done-Test can be started",true);
	}
	
	@BeforeClass
	public void setUp() {
		Reporter.log("Trying to start browser and getting applicattion ready",true);//custom log its upto you  how you want
		
		
		//excel=new ExcelDataProvider();//if u dont want create object again and again this engough ultimate goal is to get data from excel
		//config=new ConfigDataProvider();
		//driver=BrowserFactory.startApplication(driver,"Chrome", "https://demo.actitime.com");//hardcoding we can avoid this using config file 
		driver=BrowserFactory.startApplication(driver,config.getBrowser(), config.getStagingURL());
		
		Reporter.log("Browsr and application is up and running",true);//custom log its upto you  how you want
	}
  
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);	
	}
	//it is very much helpful if u want to run every peice of code ater every tc if u want to run 50 tc and want to exceute peice of code after every tc keep this in after method if its screnshot/report ot its upto 8
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		Reporter.log("Test is about  to end",true);//custom log its upto you  how you want
		
		if(result.getStatus()==ITestResult.FAILURE) {
			//Helper.captureScreenshot(driver);//screenshot addd to report
			logger.fail("Test Failed ",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());	//failed test ss as well attach screenshot as well we used class called mediaenitybuilder
		}//enhancement in framework
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());	
		}
		
		report.flush();// it shuld generate report if we have 5 tc it keep on adding test with a single report 
		Reporter.log("Test completed >>> Reports generated ",true);//custom log its upto you  how you want
	}
	
}
