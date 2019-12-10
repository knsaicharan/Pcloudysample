package com.ramtech.pages;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ramtech.core.Driver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class LoginPage extends Driver{
	//ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
	WebDriverWait wait = new WebDriverWait(driver, 120);

	@FindBy(xpath = "//*[contains(@content-desc, 'SIGN')]")
	public WebElement  Signin;
	
	@FindBy(xpath = "//*[contains(@content-desc, ' Signout')]")
	public static WebElement  Signout;


	@FindBy(xpath = "//*[contains(@content-desc, 'close add')]")
	public WebElement  add_btn;


	@FindBy(className = "android.widget.EditText")
	public List<WebElement> user_pass;


	@FindBy(xpath = " //*[@class='android.widget.CheckBox']")
	public List<WebElement> checkbox;


	@FindBy(xpath = "//*[@class = 'android.widget.Image' and @content-desc =  'REACT']")
	public WebElement login_logo;


	@FindBy(xpath = "//*[contains(@content-desc,  'LOG IN     log in ')]")
	public static WebElement login;


	@FindBy(xpath = "//*[contains(@content-desc, 'Email is required.')]")
	public static WebElement Email_required;


	@FindBy(xpath = "//*[contains(@content-desc, 'Password is required.')]")
	public static WebElement pass_required;


	@FindBy(className = "android.view.View")
	public static  List<WebElement> view_list;


	@FindBy(xpath = "//*[@class='android.widget.Button']")
	public static List<WebElement> button;



	public LoginPage() throws Exception {

		//this.driver = driver;
		super();
		PageFactory.initElements(driver, this);


	}

	public WebDriver setdriver() {
		return driver;

	}

	@Test
	public boolean testLoginWithoutCredentials() throws InterruptedException {
		boolean loginStatus = false;
	

		wait.until(ExpectedConditions.elementToBeClickable(LoginPage.login)).click();

		if (( LoginPage.Email_required).getText().contains("Email is required")) {
			System.out.println((LoginPage.Email_required).getText());
			loginStatus = true;
		}

		if (( LoginPage.pass_required).getText().contains("Password is required")) {
			loginStatus = true;
		}
		return loginStatus;


	}


	public void allowAppPermission() throws InterruptedException{
		
		List<WebElement> view = (LoginPage.view_list);
		Thread.sleep(3000);
		if(!LoginPage.button.isEmpty()){			
			wait.until(ExpectedConditions.elementToBeClickable(LoginPage.view_list.get(0))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(LoginPage.Signout)).click();
			System.err.println("**********Signout Sucessfull***********");
			
			
		}
		else {
		
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		}
	}



}
