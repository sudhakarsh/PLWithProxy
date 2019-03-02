package framework.pages;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import framework.appInit.Class_initEcomPrac;

public class CheckoutPage extends Class_initEcomPrac  {
	
	Boolean isPageReady;

	CheckoutPage(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
			super();
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.Test = Test;
		
	}
	
	@FindBy(id="customer-email")
	WebElement txtBoxCustomerEmail;
	public CheckoutPage enterCustomerEmail(String email) {
		WebDriverWait wait=new WebDriverWait(driver, waitTimeout);
		wait.until(ExpectedConditions.visibilityOf(txtBoxCustomerEmail));
		type(txtBoxCustomerEmail,email);
		return this;
	}
	
	@FindBy(name="firstname")
	WebElement txtBoxFirstName;
	public CheckoutPage enterCustomerFirstName(String firstname) {
		type(txtBoxFirstName,firstname);
		return this;
	}
	
	@FindBy(name="lastname")
	WebElement txtBoxLastName;
	public CheckoutPage enterCustomerLastName(String lastname) {
		type(txtBoxLastName,lastname);
		return this;
	}
	
	@FindBy(name="street[0]")
	WebElement txtBoxStreetAddress1;
	public CheckoutPage enterCustomerAddress1(String address1) {
		type(txtBoxStreetAddress1,address1);
		return this;
	}
	
	@FindBy(name="street[1]")
	WebElement txtBoxStreetAddress2;
	public CheckoutPage enterCustomerAddress2(String address2) {
		type(txtBoxStreetAddress2,address2);
		return this;
	}
	
	@FindBy(name="street[2]")
	WebElement txtBoxStreetAddress3;
	public CheckoutPage enterCustomerAddress3(String address3) {
		type(txtBoxStreetAddress3,address3);
		return this;
	}
	
	@FindBy(name="postcode")
	WebElement txtBoxZipCode;
	public CheckoutPage enterCustomerZipCode(String zipcode) {
		type(txtBoxZipCode,zipcode);
		return this;
	}
	
	@FindBy(name="city")
	WebElement txtBoxCity;
	public CheckoutPage enterCustomerCity(String city) {
		type(txtBoxCity,city);
		return this;
	}
	
	@FindBy(name="telephone")
	WebElement txtBoxTelephone;
	public CheckoutPage enterCustomerTelephone(String telephone) {
		type(txtBoxTelephone,telephone);
		return this;
	}
	
	
	
	@FindBy(xpath="//*[@id='checkout-shipping-method-load']/div/div[1]")
	WebElement DeliveryType;
	public CheckoutPage clickDeliveryTypeBox() {
		try {
			WebElement loader = driver.findElementByXPath("//div[@class='loading-mask']");
			//System.out.prinln("Waiting for loader to finish page rendering.");
			isPageReady = new WebDriverWait(driver, waitTimeout).until(ExpectedConditions.refreshed
					(ExpectedConditions.attributeContains(loader, "style", "none")));
			
			//System.out.prinln("Page rendering is complete to click on delivery type selection dropdown.");
		} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
			
			// TODO Auto-generated catch block
			click(DeliveryType);
			return this;
		}
		if(isPageReady) {
		
		click(DeliveryType);
		}
		return this;
		
		
	}
	
	@FindBy(xpath="//*[@id='checkout-shipping-method-load']/div/div[1]/div[1]/label")
	WebElement selectDeliveryType;
	public CheckoutPage chooseDeliveryType() {
		try {
			
			WebElement loader = driver.findElementByXPath("//div[@class='loading-mask']");
			//System.out.prinln("Waiting for loader to finish page rendering.");
			isPageReady = new WebDriverWait(driver, waitTimeout).until(ExpectedConditions.refreshed
					(ExpectedConditions.attributeContains(loader, "style", "none")));
			if(isPageReady) {
				
				if(!(selectDeliveryType.getText().startsWith("Free")))
					click(selectDeliveryType);
				
				}
			//System.out.prinln("Page rendering is complete to choose delivery type.");
				return this;
			
		} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e ) {
			if(!(selectDeliveryType.getText().startsWith("Free")))
				click(selectDeliveryType);
			return this;
			// TODO Auto-generated catch block
			
		}
		
	}
	
	@FindBy(xpath="(//label[contains(@data-bind, 'address_format')])[1]")
	WebElement selectAddress_Format;
	public CheckoutPage selectAddressFormat() {
		try {
			WebElement loader = driver.findElementByXPath("//div[@class='loading-mask']");
			WebElement bodyContainer = driver.findElementByXPath("//body[@data-container='body']");
			Boolean isDOMReady = new WebDriverWait(driver,waitTimeout).until(ExpectedConditions.
					refreshed(ExpectedConditions.attributeToBe(bodyContainer, "aria-busy", "false")));
			//System.out.prinln("Waiting for loader to finish page rendering before selecting address suggestions.");
			isPageReady = new WebDriverWait(driver, waitTimeout).until(ExpectedConditions.attributeContains(loader, "style", "none"));
			//System.out.prinln("the switche page is with value  -"+isPageReady );
			//System.out.prinln("the switche DOM is with value  -"+isDOMReady );
			if(isPageReady && isDOMReady) {
			click(selectAddress_Format);
				}
			//System.out.prinln("Page rendering is complete and address suggested is accepted.");
				return this;
			
		} catch (org.openqa.selenium.StaleElementReferenceException| org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
			// TODO Auto-generated catch block
			selectAddress_Format.click();
			reportStep("One of the addresses made available by the system got selected successfully", "info");
			return this;
		}
		
		
	}
	
	
	
	@FindBy(xpath="//*[@id='shipping-method-buttons-container']/div/button")
	WebElement nextButtonGuest;
	public CheckoutPage clickNextButtonGuest() {
		try {
			WebElement loader = driver.findElementByXPath("//div[@class='loading-mask']");
			//System.out.prinln("Waiting for loader to finish page before next button guest click.");
			isPageReady = new WebDriverWait(driver, waitTimeout).until(ExpectedConditions.refreshed
					(ExpectedConditions.attributeContains(loader, "style", "none")));
			
			//System.out.prinln("Page rendering is complete for clicking on the next button guest.");
		} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
			// TODO Auto-generated catch block
			click(nextButtonGuest);
			return this;
		}
		
		if(isPageReady) {
		click(nextButtonGuest);
		}
		
		return this;
		
	}
	
	@FindBy(xpath="//*[@id='shipping-method-buttons-container']/div/button")
	WebElement nextButton;
	public PaymentMethodsPage clickNextButton() {
		WebElement loader = null;
		try {
			loader = driver.findElementByXPath("//div[@class='loading-mask']");
			//System.out.prinln("Waiting for loader to finish page rendering before clicking on next button.");
			isPageReady = new WebDriverWait(driver, waitTimeout).until(ExpectedConditions.refreshed
					(ExpectedConditions.attributeContains(loader, "style", "none")));
			
			//System.out.prinln("Page rendering is complete to click on next button.");
		} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
			// TODO Auto-generated catch block
			click(nextButton);
			try {
				return new PaymentMethodsPage(driver, Test);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		
		
		
		if(isPageReady) {
			
		click(nextButton);
		loader = driver.findElementByXPath("//div[@class='loading-mask']");
		//System.out.prinln("Waiting for loader to finish page rendering after clicking on next button.");
		new WebDriverWait(driver, waitTimeout).until
				(ExpectedConditions.attributeContains(loader, "style", "none"));
		WebElement bodyContainer = driver.findElementByXPath("//body[@data-container='body']");
		new WebDriverWait(driver,waitTimeout).until(ExpectedConditions.attributeToBe(bodyContainer, "aria-busy", "false"));
		//System.out.prinln("Page is now will navigate to payments method");
		}
		try {
			return new PaymentMethodsPage(driver, Test);
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