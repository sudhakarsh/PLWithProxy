package framework.pages;


	import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import framework.appInit.Class_initEcomPrac;

	public class MyParties_ContactsPage extends Class_initEcomPrac  {

		MyParties_ContactsPage(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
				super();
			PageFactory.initElements(driver, this);
			this.driver = driver;
			this.Test = Test;
			
		}
	
	@FindBy(xpath="//a[@class='addcontacts']")
	WebElement btnCreateContact;
	public MyParties_ContactsPage clickCreateContact() {
		btnCreateContact.click();
		return this;
	}
		
	@FindBy(id="contact_firstname")
	WebElement txtFirstName;
	public MyParties_ContactsPage typeFirstName(String ContactsFN) {
		type(txtFirstName, ContactsFN);
		return this;
	}
	
	
	@FindBy(id="last_name")
	WebElement txtLastName;
	public MyParties_ContactsPage typeLastName(String ContactsLN) {
		type(txtLastName, ContactsLN);
		return this;
	}
	
	@FindBy(id="contact_email")
	WebElement txtEmail;
	public MyParties_ContactsPage typeEmail(String ContactsEmail) {
		type(txtEmail, ContactsEmail);
		return this;
	}
	
	@FindBy(id="contact_phone")
	WebElement txtPhone;
	public MyParties_ContactsPage typePhone(String ContactsPhone) {
		type(txtPhone, ContactsPhone);
		return this;
	}
	
	@CacheLookup
	@FindBy(id="send")
	WebElement btnSaveContact;
	public MyParties_ContactsPage clickSaveContact() {
		click(btnSaveContact);
		try {
		new WebDriverWait(driver,waitTimeout).until(ExpectedConditions.invisibilityOf(btnSaveContact));
		new WebDriverWait(driver,waitTimeout)
		.until(ExpectedConditions.refreshed
				(ExpectedConditions.urlContains("/party/contact/dashboard/")));
		} catch(org.openqa.selenium.TimeoutException e) {
			reportStep("Save contacts action took longer than usual.","info");
			
		}
		
				
		return this;
	}
		
	}
			
