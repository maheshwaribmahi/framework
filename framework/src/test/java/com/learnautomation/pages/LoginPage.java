package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		this.driver=ldriver;
	}//handle webelement in page object model
	
	@FindBy(name="username") WebElement uname;//change it purposfuly username to username1 for to fail test case and screenshot captured on failure as if change password in excel to manage it will continue flow and takes screenshot it will simply take screnshot test is passed so to avod this change locator itself- and failure:1 
	
	@FindBy(name="pwd") WebElement password;
	
	@FindBy(xpath="//div[text()='Login ']") WebElement loginButton;
	
	public void loginToCRM(String emailApplication,String passwordApplication) {
		try {
			Thread.sleep(2000);
		}
		catch(Exception e) {
			
		}
		uname.sendKeys(emailApplication);
		password.sendKeys(passwordApplication);
		loginButton.click();
	}

}
