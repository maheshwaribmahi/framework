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
	   driver.get("https://www.gmail.com");
	}
	@When("^I enter valid \"([^\"]*)\" and valid \"([^\"]*)\"$")
	public void I_enter_valid_username_and_valid_password(String username,String password) throws Throwable {
	  driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys(username);
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//span[text()='Next']")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);   
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//span[text()='Next']")).click();
	}
	@Then("^user should be able to login successfully$")
	public void user_should_be_able_to_login_successfully() throws Throwable {
	System.out.println("user should be able to login successfully");
	 
	}
}
