package com.ramtech.core;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Basic extends ExtentReport {



	private static AndroidDriver<WebElement> androidDriver = null;

	@BeforeClass
	public AndroidDriver<WebElement> setup() throws Exception{
		initDriver();
		System.out.println("Driver in initdriver is : " +androidDriver);
		return androidDriver;
	}

	private void initDriver() throws MalformedURLException{
		System.out.println("Inside initDriver method");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Pixel");
		capabilities.setCapability("VERSION", "8.1.0"); 
		capabilities.setCapability("deviceName","Emulator");
		capabilities.setCapability("platformName","Android");	
		capabilities.setCapability("gpsEnabled", true);
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("appPackage", "com.dev.react");	
		capabilities.setCapability("appActivity","com.dev.react.MainActivity"); 

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		try
		{
			System.out.println("Argument to driver object : " + url);
			androidDriver=new AndroidDriver<WebElement>(url,capabilities);


		}
		catch (NullPointerException ex) {
			throw new RuntimeException("appium driver could not be initialised for device ");

		}


	}

	@AfterClass
	public void tearDown(){
		androidDriver.quit();
	}
}
