package com.ramtech.core;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;

public class Driver extends Basic{
	
	protected AndroidDriver<WebElement> driver;

    public Driver() throws  Exception {
        this.driver = this.setup();
    }

}
