package framework.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import framework.appInit.Class_initEcomPrac;
import framework.utils.MyPageFactory;

public class CustomerNewAddressPage extends Class_initEcomPrac {
	
	Boolean isPageReady;
	 CustomerNewAddressPage(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
		super();
	MyPageFactory.initElements(driver, this);
	this.driver = driver;
	this.Test = Test;
	
}
	 
	 @FindBy(id="street_1")
		WebElement txtBoxStreetAddress1;
		public CustomerNewAddressPage enterCustomerAddress1(String address1) {
			type(txtBoxStreetAddress1,address1);
			return this;
		}
		
		@FindBy(id="street_2")
		WebElement txtBoxStreetAddress2;
		public CustomerNewAddressPage enterCustomerAddress2(String address2) {
			type(txtBoxStreetAddress2,address2);
			return this;
		}
		
		@FindBy(id="street_3")
		WebElement txtBoxStreetAddress3;
		public CustomerNewAddressPage enterCustomerAddress3(String address3) {
			type(txtBoxStreetAddress3,address3);
			return this;
		}
		
		@FindBy(name="city")
		WebElement txtBoxCity;
		public CustomerNewAddressPage enterCustomerCity(String city) {
			type(txtBoxCity,city);
			return this;
		}
		
		@FindBy(name="postcode")
		WebElement txtBoxZipCode;
		public CustomerNewAddressPage enterCustomerZipCode(String zipcode) {
			type(txtBoxZipCode,zipcode);
			return this;
		}
		
		@FindBy(id="telephone")
		WebElement txtBoxTelephone;
		public CustomerNewAddressPage enterCustomerTelephone(String telephone) {
			type(txtBoxTelephone,telephone);
			return this;
		}
		
		@FindBy(xpath="//span[contains(text(),'Use as my default billing address')]")
		WebElement checkboxBillingAddress;
		public CustomerNewAddressPage clickCheckBoxBillingAddress() {
			click(checkboxBillingAddress);
			return this;
		}
		
		@FindBy(xpath="//span[contains(text(),'Use as my default shipping address')]")
		WebElement checkboxShippingAddress;
		public CustomerNewAddressPage clickCheckBoxShippingAddress() {
			click(checkboxShippingAddress);
			return this;
		}
		
		@FindBy(xpath="//button[@title='Search and Validate']")
		WebElement btnSearchValidate;
		public CustomerNewAddressPage clickbtnSearchValidate() {
			click(btnSearchValidate);
			try {
				WebElement loader = driver.findElementByXPath("//div[@class='loading-mask']");
				//System.out.prinln("Waiting for loader to finish page rendering.");
				isPageReady = new WebDriverWait(driver, 30).until(ExpectedConditions.refreshed
						(ExpectedConditions.attributeContains(loader, "style", "none")));
				
				//System.out.prinln("Page rendering is complete.");
			} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return this;
			}
			return this;
		}
		
		@FindBy(xpath="//label[@for='address_format_0']")
		WebElement selectAddressFormat;
		public CustomerNewAddressPage clickAddressFormat() {
			click(selectAddressFormat);
			try {
				WebElement loader = driver.findElementByXPath("//div[@class='loading-mask']");
				//System.out.prinln("Waiting for loader to finish page rendering.");
				isPageReady = new WebDriverWait(driver, 30).until(ExpectedConditions.refreshed
						(ExpectedConditions.attributeContains(loader, "style", "none")));
				
				//System.out.prinln("Page rendering is complete.");
			} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return this;
			}
			return this;
		}
		
		@FindBy(xpath="//button[@title='Save Address']")
		WebElement btnSaveAddress;
		public CustomerAddressPage clickbtnSaveAddress() {
			click(btnSaveAddress);
			try {
				return new CustomerAddressPage(driver, Test);
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
