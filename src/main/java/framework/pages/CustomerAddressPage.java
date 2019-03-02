package framework.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

import framework.appInit.Class_initEcomPrac;
import framework.utils.MyPageFactory;

public class CustomerAddressPage extends Class_initEcomPrac{
	
	 CustomerAddressPage(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
		super();
	MyPageFactory.initElements(driver, this);
	this.driver = driver;
	this.Test = Test;
	
}
	
	@FindBy(xpath="//button[@title='Add New Address']")
	WebElement add_new_address;
	public CustomerNewAddressPage clickaddNewAddress() {
		click(add_new_address);
		try {
			return new CustomerNewAddressPage(driver,Test);
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
