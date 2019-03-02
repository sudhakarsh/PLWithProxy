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

public class PaymentMethodsPage extends Class_initEcomPrac  {
	boolean isPageReady;

	PaymentMethodsPage(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
			super();
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.Test = Test;
		
	}
	
	@FindBy(xpath="//*[@id='checkout-payment-method-load']/div/div/div[2]/div[1]/label")
	WebElement radioAllPaymentMethods;
public PaymentMethodsPage clickPaymentMethods() {
		
		try {
			WebElement loader = driver.findElementByXPath("//div[@class='loading-mask']");
			//System.out.prinln("Waiting for loader to finish page rendering.");
			isPageReady = new WebDriverWait(driver, waitTimeout).until(ExpectedConditions.refreshed
					(ExpectedConditions.attributeContains(loader, "style", "none")));
			
			//System.out.prinln("Page rendering is complete.");
		} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e  ) {
			reportStep("Payment method selection failed.","warning");
		}
		if(isPageReady) {
			new WebDriverWait(driver, waitTimeout).until(ExpectedConditions.urlContains("#payment"));
		radioAllPaymentMethods.click();
		return this;
	}
		return this;
	}
	
	@FindBy(id="payment_type")
	WebElement selectPaymentType;
	public PaymentMethodsPage selectTypeOfPayment(String PaymentType) {
		selectDropDownUsingText(selectPaymentType, PaymentType);
		return this;
	}
	
	@FindBy(xpath="(//span[text()='I accept the '])[1]")
	WebElement chkboxAcceptTerms;
	public PaymentMethodsPage clickAcceptTerms() {
		chkboxAcceptTerms.click();
		return this;
	}
	
	@FindBy(xpath="//button[@title='Place Order']")
	WebElement btnPlaceOrder;
	public TestPaymentPage clickPlaceOrderButton() {
		btnPlaceOrder.click();
		try {
			return new TestPaymentPage(driver, Test);
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