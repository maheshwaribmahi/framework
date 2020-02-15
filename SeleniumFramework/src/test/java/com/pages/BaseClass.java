package com.pages;

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
import com.utility.BrowserFactory;
import com.utility.ConfigDataProvider;
import com.utility.ExcelDataProvider;
import com.utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUPSuite(){
		
		Reporter.log("Setting up reports and Test is getting ready",true);//custom log its upto you  how you want//listeners class provide standard reports not like logs ..logs user to get required execution info		
		//can keep create objects reqiured for complete project
		//ExcelDataProvider excel=new ExcelDataProvider();
		//ConfigDataProvider config=new ConfigDataProvider();
		
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/MPLFantasy_"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);//one reporter is done we need to flush i9t
		
		Reporter.log("Setting done-Test can be started",true);
	}
	
	@BeforeClass
	public void setup()
	{
		Reporter.log("Trying to start browser and getting applicattion ready",true);//custom log its upto you  how you want
		
		driver =BrowserFactory.startApplication(driver,"Chrome","https://fantasy.mpl.live/");	
		//to avoid hardcoding of browser and qaurl get from configDataProvider by calling a method present in it by object refrence variable by creating object of it 
		//driver =BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingURL());
		
		Reporter.log("Browser and application is up and running",true);//custom log its upto you  how you want
	}
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		Reporter.log("Test is about  to end",true);//custom log its upto you  how you want
		
		if(result.getStatus()==ITestResult.FAILURE) {
			Helper.captureScreenshot(driver);//screenshot addd to report
			logger.fail("Test Failed ",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());	//failed test ss as well attach screenshot as well we used class called mediaenitybuilder
		}//enhancement in framework
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());	
		}
		
		report.flush();//it will keep on adding reports for every tc
		Reporter.log("Test completed >>> Reports generated ",true);//custom log its upto you  how you want
    }
}