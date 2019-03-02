package framework.pages;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import framework.appInit.Class_initEcomPrac;

public class CartSummaryPage extends Class_initEcomPrac  {

	CartSummaryPage(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
			super();
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.Test = Test;
		
	}

@FindBy(xpath="//div[text()[contains(., 'You added')]]")
WebElement msgConfirmProductionAddition;
public CartSummaryPage validateProductAdditionToCart() {
	verifyPartialText(msgConfirmProductionAddition, "You added");
	return this;
}

@FindBy(xpath="//li[@class='customer data']/child::a")
WebElement txtCustName;
public CartSummaryPage validateCustomername() {
	String HostName = getText(txtCustName);
	//System.out.prinln("The order has following hostname " + HostName);
	return this;
}

@FindBy(xpath="//li[@class='order data']/child::span")
WebElement txtOrderType;
public CartSummaryPage validateOrderType() {
	verifyPartialText(txtOrderType, "Paper Order");
	return this;
	
}

@FindBy(id="giftcard-code")
WebElement txtboxGiftCardNumber;
public CartSummaryPage typeGiftCardNumber(String gift_card_number) {
	type(txtboxGiftCardNumber, gift_card_number);
	return this;
	
}

@FindBy(id="giftcard-pin")
WebElement txtboxGiftCardPIN;
public CartSummaryPage typeGiftCardPIN(String gift_card_pin) {
	type(txtboxGiftCardPIN, gift_card_pin);
	return this;
	
}

@FindBy(xpath="//button[@value='Add Gift Card']")
WebElement apply_btn;
public CartSummaryPage clickApplyButton() {
	click(apply_btn);
	return this;
	
}

@FindBy(xpath="//div[contains(text(),'Gift card has been added to your cart.')]")
WebElement gc_apply_msg;
public CartSummaryPage verifyGiftAddedMessage() {
	verifyExactText(gc_apply_msg, "Gift card has been added to your cart.");
	return this;
}

@FindBy(xpath="//button[@title='Go to Checkout']")
WebElement btnGoToCheckout;
public CheckoutPage clickGoToCheckout() {
	WebDriverWait wait=new WebDriverWait(driver, waitTimeout);
	wait.until(ExpectedConditions.elementToBeClickable(btnGoToCheckout));
	click(btnGoToCheckout);
	
	try {
		return new CheckoutPage(driver, Test);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
}

@FindBy(xpath="//a[@title='PartyLite']")
WebElement partylite_logo;
public LandingPage_PartyLite gotoHomepage() {
	click(partylite_logo);
	try {
		return new LandingPage_PartyLite(driver,Test);
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