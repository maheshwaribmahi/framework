package com.pages;

import java.text.DecimalFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		this.driver=ldriver;
	}//handle webelement in page object model
	
	@FindBy(id="mobile-num") WebElement phoneNumber;//change it purposfuly phoneNumber to phonenumber1 for to fail test case and screenshot captured on fail		
	
	@FindBy(xpath="//button[@class='button ok-button maxWidth']") WebElement submittButton;
	
	@FindBy(xpath="//span[contains(text(),'I AGREE')]") WebElement agreeCondition;

	@FindBy(id="referral-input") WebElement enterOTP; 
	
   
	@FindBy(xpath="//span[contains(text(),'LOGIN')]") WebElement loginButton;
	
	public void loginToMPL(String NumberforApp,String OTPforApp) throws InterruptedException {
		try {
			Thread.sleep(10000);
		}
		catch(Exception e) {
			
		} 
		//System.out.println("before phone number:"+l);
		//System.out.println("before otp:"+OTPforApp);
		
		//DecimalFormat df = new DecimalFormat("##########"); 
	    //String nr = df.format(OTPforApp); 
	    //String mn = df.format(i);
	    //System.out.println("after phone number:"+mn);
		//System.out.println("after otp:"+nr);
		phoneNumber.sendKeys(NumberforApp);
		submittButton.click();
		agreeCondition.click();
		Thread.sleep(30000);
		enterOTP.sendKeys(OTPforApp);
		Thread.sleep(30000);
		loginButton.click();
		Thread.sleep(3000);
	}

	

	
	

}
