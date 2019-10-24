package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//screenshot,alerts,frames,windows,sync issues,javascrip Executor
public static String captureScreenshot(WebDriver driver)
{//new commit
	
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String screenshotPath=System.getProperty("user.dir")+"/Screenshots/actiTIME_"+Helper.getCurrentDateTime()+".png";//void previous for getting path secify retun type as string to avoid this define it
	try {
		//FileHandler.copy(src,new File("./Screenshots/actiTIME_"+getCurrentDateTime()+"Login.png"));//override previous screenshot so we use date bsed on date gives  scrrenshot
		FileHandler.copy(src,new File(screenshotPath));
		System.out.println("Screenshot captured");
	}
		catch(IOException e)
		{
			System.out.println("unable to capture screenshot"+e.getMessage());
		}
	//cature ss and return path of screnshot as well
	return screenshotPath;
}

	public static String getCurrentDateTime() {////override previous screenshot so we use date bsed on date gives scrrenshot so if we have multiple tc for to take screenshot then u n
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return customFormat.format(currentDate);		
        }
}
