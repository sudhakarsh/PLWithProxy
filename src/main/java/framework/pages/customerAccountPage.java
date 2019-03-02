package framework.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

import framework.appInit.Class_initEcomPrac;
import framework.utils.MyPageFactory;

public class customerAccountPage extends Class_initEcomPrac  {

		public customerAccountPage(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
		super();
		MyPageFactory.initElements(driver, this);
		this.driver = driver;
		this.Test = Test;
		
	}

		@FindBy(xpath ="//div[text()[contains(., 'Thank you for registering with Party')]]")
		WebElement confirmRegistrationText;
		public customerAccountPage confirmRegistrationText() {
			verifyDisplayed(confirmRegistrationText);
			return this;
		}
		
		@FindBy(xpath="//a[contains(@href, 'forgotpassword')]")
		WebElement errMsgDoubleRegistration;
		public customerAccountPage invalidateDoubleRegistration() {
			verifyDisplayed(errMsgDoubleRegistration);
			//errMsgDoubleRegistration.isDisplayed();
			return this;
		}
		

}
