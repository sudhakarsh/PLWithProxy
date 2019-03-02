package framework.pages;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import framework.appInit.Class_initEcomPrac;

public class TestPaymentPage extends Class_initEcomPrac  {

	TestPaymentPage(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
			super();
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.Test = Test;
		
	}
	
	
	@FindBy(xpath="//label[text()='Card number:']/following-sibling::input")
	WebElement txtBoxCardNumber;
	public TestPaymentPage enterCardNumber(String cardNumber) {
		type(txtBoxCardNumber, cardNumber);
		return this;
	}
	
	@FindBy(name="expdatemonth")
	WebElement selectExpMonth;
	public TestPaymentPage enterCardExpMonth(String expMonth) {
		type(selectExpMonth, expMonth);
		return this;
	}
	
	
	
	@FindBy(name="expdateyear")
	WebElement selectExpYear;
	public TestPaymentPage enterCardExpYear(String expYear) {
		type(selectExpYear, expYear);
		return this;
	}
	
	@FindBy(xpath="//fieldset[@class='cvv']/input")
	WebElement txtBoxCVV;
	public TestPaymentPage enterCardCVV(String cardCVV) {
		type(txtBoxCVV, cardCVV);
		return this;
	}
	
	@FindBy(id="submitCC")
	WebElement buttonConfirmCardDetails;
	public OrderCompletionPage clickConfirm() {
		click(buttonConfirmCardDetails);
		try {
			return new OrderCompletionPage(driver, Test);
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