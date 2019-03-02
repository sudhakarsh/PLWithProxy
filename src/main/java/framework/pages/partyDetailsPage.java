package framework.pages;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import framework.appInit.Class_initEcomPrac;

public class partyDetailsPage extends Class_initEcomPrac  {

	partyDetailsPage(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
			super();
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.Test = Test;
		
	}
	
	public partyDetailsPage verifyPartyDashboardPageTitle() {
		try {
			WebDriverWait wait=new WebDriverWait(driver, waitTimeout);
			wait.until(ExpectedConditions.titleContains("Party #"));
			return this;
		}
		catch(org.openqa.selenium.TimeoutException e) {
			reportStep("Failed to navigate to party details page", "warning");
			return null;
		}
		
	}
	
	@FindBy(className="party-name")
	WebElement partyName;
	public partyDetailsPage verifyPartyName(String verifyName) {
			verifyExactText(partyName, verifyName);
		//System.out.prinln(partyName.getText());
		return this;
	}
	
	@FindBy(linkText="Guests")
	//xpath="(//ul[@role='menu']//a)[2]")
	WebElement linkGuests;
	public partyGuestPage clickGuestsLink() {
		click(linkGuests);
		try {
			return new partyGuestPage(driver, Test);
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