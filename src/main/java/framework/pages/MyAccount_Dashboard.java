
package framework.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

import framework.appInit.Class_initEcomPrac;
import framework.utils.MyPageFactory;

public class MyAccount_Dashboard extends Class_initEcomPrac  {

	MyAccount_Dashboard(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
			super();
		MyPageFactory.initElements(driver, this);
		this.driver = driver;
		this.Test = Test;
		
	}
		
	@FindBy(xpath="//span[@class='customer-name'][@tabindex='0']")
	WebElement linkMyAccount;
	public MyAccount_Dashboard verifyUserLogin(String ContentToVerify) {
		verifyExactText(linkMyAccount, ContentToVerify);
		return this;
	}
	

}
