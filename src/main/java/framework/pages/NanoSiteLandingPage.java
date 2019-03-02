package framework.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import framework.appInit.Class_initEcomPrac;

public class NanoSiteLandingPage extends Class_initEcomPrac {

	NanoSiteLandingPage(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
		super();
	PageFactory.initElements(driver, this);
	this.driver = driver;
	this.Test = Test;
	
}
	
	@CacheLookup
	//@FindBy(xpath="//div[@class='newsletter-subscribe-modal']//h2[@class='title']") ** to revert 
	@FindBy(xpath="//div[@class='newsletter-subscribe-modal']")
			//"//(//button[@class='action-close'])[2]")
	WebElement SignUpToNewsLetterText;
	public NanoSiteLandingPage closeDialogSignUpNewsLetter() {
		new WebDriverWait(driver, waitTimeout).until(ExpectedConditions.visibilityOf(SignUpToNewsLetterText));
		WebElement closeSignUpDialog = driver.findElementByXPath("(//button[@class='action-close'])[2]");
	click(closeSignUpDialog);
	WebElement modalCurtain = driver.findElementByXPath("//aside");
	new WebDriverWait(driver,waitTimeout).until(ExpectedConditions.invisibilityOf(modalCurtain));	
	WebElement btnAcceptCookie = driver.findElementByXPath("//button[@id='btn-cookie-allow']");
	click(btnAcceptCookie);
	return this;
	}	
	
	@FindBy(id="btn-cookie-allow")
	WebElement btnContinue;
	public NanoSiteLandingPage clickToAllowCookie() {
		WebDriverWait wait=new WebDriverWait(driver, waitTimeout);
		wait.until(ExpectedConditions.elementToBeClickable(btnContinue));
		click(btnContinue);
		return this;
	}
	
	@FindBy(id="attendBtn")
	WebElement btnAttendParty;
	public NanoSiteLandingPage clickAttendParty() {
		click(btnAttendParty);
		return this;
	}
	
	@FindBy(id="createOrderLink")
	WebElement btnCreateOrder;
	public CustomerLoginPage clickBtnCreateOrder() {
		click(btnCreateOrder);
		try {
			return new CustomerLoginPage(driver,Test);
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
