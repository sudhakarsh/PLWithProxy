package framework.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

import framework.appInit.Class_initEcomPrac;
import framework.utils.MyPageFactory;

public class CustomerLoginPage extends Class_initEcomPrac  {

		CustomerLoginPage(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
			super();
		MyPageFactory.initElements(driver, this);
		this.driver = driver;
		this.Test = Test;
		
	}
		
	@FindBy(xpath="//input[@id='email']")
	WebElement txtboxEmailID;
	public CustomerLoginPage enterEmailName(String ExistingUserEmail) {
		type(txtboxEmailID, ExistingUserEmail);
		return this;
	}
	
	
	
	@FindBy(xpath="//input[@id='pass'][@title='Password']")
	WebElement txtboxPassword;
	public CustomerLoginPage enterPassword(String ExistingUserPassword) {
		type(txtboxPassword, ExistingUserPassword);
		return this;
	}
	
	
	@FindBy(partialLinkText="Create an Account")
	WebElement linkTxtCreateAnAccount;
	public createNewCustomerAcct clickCreateAnAccount() {
		click(linkTxtCreateAnAccount);
		try {
			return new createNewCustomerAcct(driver, Test);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@FindBy(xpath="//button[@class='action login primary']")
	WebElement btnSignInNanositeGuest;
	public  CartSummaryPage btnClickSigninNanositeGuest() {
		click(btnSignInNanositeGuest);
		try {
			return new CartSummaryPage(driver, Test);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@FindBy(xpath="//button[@class='action login primary']")
	WebElement btnSignIn;
	public  LandingPage_PartyLite btnClickSignin() {
		click(btnSignIn);
		try {
			return new LandingPage_PartyLite(driver, Test);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	@FindBy(xpath="//button[@class='action login primary']")
	WebElement btnConSignIn;
	public  Party_Dashboard ConClickSignin() {
		click(btnConSignIn);
		try {
			return new Party_Dashboard(driver, Test);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
	