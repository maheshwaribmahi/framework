package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTest {
	WebDriver driver;
	@Given("^Open Chrome and start application$")
	public void Open_firefox_and_start_application() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	   driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://github.com");
	}
	@When("^I enter valid username and valid password$")
	public void I_enter_valid_username_and_valid_password() throws Throwable {
	  //driver.findElement(By.id("user[login]")).sendKeys("maheshwarib83");
	  //driver.findElement(By.id("user[email]")).sendKeys("maheshwarib83@gmail.com");
	  //driver.findElement(By.name("user[password]")).sendKeys("Mahi@1992&");    
		driver.findElement(By.id("user[email]")).sendKeys("maheshwarib83@gmail.com");
	}
	@Then("^user should be able to login successfully$")
	public void user_should_be_able_to_login_successfully() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Sign up for GitHub']")).click();  
	 
	}
}
