package framework.pages;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import framework.appInit.Class_initEcomPrac;

public class OrderCompletionPage extends Class_initEcomPrac  {

	OrderCompletionPage(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
			super();
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.Test = Test;
		
	}
	
	@FindBy(xpath="//h2[text()='Thanks for shopping!']")
	WebElement confirmOrderSuccess;
	public OrderCompletionPage confirmOrderIsSuccess() {
		try {
			verifyExactText(confirmOrderSuccess, "Thanks for shopping!");
			return this;
		}
		catch(NoSuchElementException e) {
			reportStep("Order Failed", "warning");
			return null;
		}
		
	}
	
}