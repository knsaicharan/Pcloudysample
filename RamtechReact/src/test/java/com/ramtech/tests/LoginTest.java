package com.ramtech.tests;
import java.net.MalformedURLException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ramtech.core.Configreader;
import com.ramtech.pages.LoginPage;
import io.appium.java_client.MobileElement;

public class LoginTest {
	Configreader configFileReader;
	WebElement aboutMe;
	MobileElement nextBtn;
	MobileElement backBtn;
	List<WebElement> editText,sectionList,buttons;
	String Selected_alaram;


	@Test
	public void cal_add() throws MalformedURLException
	{
		try {

			LoginPage Login_obj = new LoginPage();
			configFileReader= new Configreader();
			WebDriver driver = Login_obj.setdriver();
			WebDriverWait wait = new WebDriverWait(driver, 120);


			wait.until(ExpectedConditions.visibilityOf(Login_obj.Signin)).click();
			Login_obj.testLoginWithoutCredentials();

			//Enter the username and password
			editText = (Login_obj.user_pass);
			editText.get(0).sendKeys(configFileReader.getEmail());
			editText.get(1).sendKeys(configFileReader.getPassword());			
			LoginPage.login.click();
			System.err.println("********Waiting for Login*********");
			wait.until(ExpectedConditions.elementToBeClickable(Login_obj.add_btn)).click();   			
			Thread.sleep(1000);

			/*List<WebElement> view = (LoginPage.view_list);
			int i=0;
			for(WebElement element:view){
				System.out.println("Section Tagname "+i+":"+element.getTagName());
				Selected_alaram = view.get(i).getAttribute("content-desc");
				System.out.println(Selected_alaram);
				System.out.println(view.get(i).isSelected());
				System.out.println("Section Class "+i+":"+element.getClass());
				i++;
			}*/


			buttons =(LoginPage.button);
			buttons.get(0).click();
			Thread.sleep(1000);
			sectionList= (Login_obj.checkbox);

			//selecting the location 'Primary Area'
			if(!sectionList.get(1).isSelected())
			{
				sectionList.get(1).click();
				Selected_alaram =sectionList.get(1).getAttribute("content-desc");
				Assert.assertEquals("Primary Area", Selected_alaram);

			}	

			System.err.println("**********Location " +Selected_alaram + " is selected sucessfully**********");
			wait.until(ExpectedConditions.elementToBeClickable(LoginPage.button.get(1))).click(); // clicking on next after selecting location
			Thread.sleep(1000);	
			wait.until(ExpectedConditions.elementToBeClickable(LoginPage.button.get(1))).click();	//Setting the Alaram	
			Thread.sleep(3000);
			Login_obj.allowAppPermission();


		} 
		catch (Exception e) {

			e.printStackTrace();
		}
	}
}