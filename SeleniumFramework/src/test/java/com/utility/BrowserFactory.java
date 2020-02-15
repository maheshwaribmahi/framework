package com.utility;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	public class BrowserFactory {
		
		public static WebDriver startApplication (WebDriver driver,String browserName,String url)
		{
			if(browserName.equals("Chrome"))
			{
				
				System.setProperty("webdriver.chrome.driver","/Users/MaheshwariB/eclipse-workspace/MPL/SeleniumFramework/driver/chromedriver" );
				driver=new ChromeDriver();
			}
			else if(browserName.equals("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver","/Users/MaheshwariB/eclipse-workspace/MPL/SeleniumFramework/driver/geckodriver");
				driver=new FirefoxDriver();
			}
			else
			{
				System.out.println("we do not support browser");
			}
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			return driver;
		}
		
		public static void quitBrowser(WebDriver driver) {
			driver.quit();
			
		}

	}
