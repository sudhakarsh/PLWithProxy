	package framework.pages;

	import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

import framework.appInit.Class_initEcomPrac;
import framework.utils.MyPageFactory;

	public class createNewCustomerAcct extends Class_initEcomPrac  {
		String genEmail= null;

			public createNewCustomerAcct(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
			super();
			MyPageFactory.initElements(driver, this);
			this.driver = driver;
			this.Test = Test;
			
		}
			
			@FindBy(id="firstname")
			WebElement txtboxfirstname;
			public createNewCustomerAcct enterFirstname(String firstname) {
				type(txtboxfirstname, firstname);
				return this;
			}
			
			
			@FindBy(id="lastname")
			WebElement txtboxlastname;
			public createNewCustomerAcct enterLastname(String lastname) {
				type(txtboxlastname, lastname);
				return this;
			}
			
			@FindBy(id="email_address")
			WebElement txtboxEmail;
			public createNewCustomerAcct enterEmail(String Email) {
				long randomNum = (long)Math.floor(Math.random()*9000000000L)+8888888888888L;
				genEmail= Email+randomNum+"@mailinator.com";
				
				////System.out.prinln(genEmail);
				type(txtboxEmail, genEmail);
				return this;
			}
			
			@FindBy(id="email_address_confirmation")
			WebElement txtboxEmailConf;
			public createNewCustomerAcct enterEmailConf(String EmailConf) {
				type(txtboxEmailConf, genEmail);
				return this;
			}
			
			@FindBy(id="email_address")
			WebElement txtboxExistingEmail;
			public createNewCustomerAcct enterExistingEmail(String ExistingEmail) {
				type(txtboxExistingEmail, ExistingEmail);
				return this;
			}
			
			@FindBy(id="email_address_confirmation")
			WebElement txtboxExistingEmailConf;
			public createNewCustomerAcct enterExistingEmailConf(String ExistingEmailConf) {
				type(txtboxExistingEmailConf, ExistingEmailConf);
				return this;
			}
			
			@FindBy(id="password")
			WebElement txtPassword;
			public createNewCustomerAcct enterPassword(String Password) {
				type(txtPassword, Password);
				return this;
			}
			
			@FindBy(id="password-confirmation")
			WebElement txtPasswordConfirmation;
			public createNewCustomerAcct enterPasswordConf(String PasswordConf) {
				type(txtPasswordConfirmation, PasswordConf);
				return this;
			}
			
			@FindBy(xpath="//label[@for='is_terms_conditions']")
			WebElement labelTermsConditions;
			public createNewCustomerAcct clickTermsConditions() {
				labelTermsConditions.click();
				return this;
			}
			
			@FindBy(xpath="//button[@title='Create an Account']")
			WebElement buttonCreateAccount;
			public customerAccountPage clickCreateAnAccount() {
				
				click(buttonCreateAccount);
				try {
					return new customerAccountPage(driver, Test);
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
