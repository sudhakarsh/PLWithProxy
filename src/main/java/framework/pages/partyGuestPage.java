package framework.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import framework.appInit.Class_initEcomPrac;

public class partyGuestPage extends Class_initEcomPrac {

	partyGuestPage(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
		super();
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.Test = Test;

	}

	
	
	@FindBy(xpath="(//p[@class='guest-name']/a)[2]")
	WebElement hostOfParty;
	public partyHostPage clickPartyHost() {
		//WebElement linkOfHost = null;
		try {
			new WebDriverWait(driver, waitTimeout).until(ExpectedConditions.elementToBeClickable(hostOfParty));
			hostOfParty.click();
		} catch (ElementNotInteractableException |org.openqa.selenium.TimeoutException e) 
			{
			e.getMessage();
			reportStep("The host of the party link displayed is not clickable","warning");
			throw new RuntimeException("he host of the party link displayed is not clickable");
			}
			/*List<WebElement> hostLinks = driver.findElements(By.xpath("//p[@class='guest-name']/a"));
			 //linkOfHost =hostLinks.get(new Random().nextInt(hostLinks.size()));
			linkOfHost= hostLinks.get(1);//to force selection to be always the second host name
			linkOfHost.click();
			}catch(ElementNotInteractableException enie) {	
			new WebDriverWait(driver, waitTimeout).until(ExpectedConditions.elementToBeClickable(linkOfHost));
			try {
				linkOfHost.click();
			} catch(org.openqa.selenium.ElementClickInterceptedException |TimeoutException e1)
			{
				reportStep("Host link found is not clickable", "warning");
				throw new RuntimeException("Host link displayed could not be clicked");
			}
			*/
		
		try {
			return new partyHostPage(driver, Test);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@FindBy(xpath = "((//button[@class='level-top'])[2]/span")
	WebElement btnAddGuest;

	public partyGuestPage clickAddGuestLink() {
		try {
			new WebDriverWait(driver,waitTimeout).until(ExpectedConditions
					.attributeToBe(By.xpath("//body[@data-container='body']"), "aria-busy", "false"));
			//new WebDriverWait(driver,waitTimeout).until(ExpectedConditions.elementToBeClickable(btnAddGuest));	
			
			WebElement refreshedAddGuests = (new WebDriverWait(driver,30)).until(new ExpectedCondition<WebElement>() {

				@Override
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("(//button[@class='level-top'])[2]/.."));
					
				}
				
				
			});
			refreshedAddGuests.click();
	
			/*driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
			//System.out.prinln("before javascript click");
			driver.executeScript("arguments[0].click();", btnAddGuest);
			//System.out.prinln("after javascript click");*/
			//new Actions(driver).click(btnAddGuest).perform();
			//System.out.prinln(driver.getCurrentUrl());
			return this;
		} catch (ElementNotInteractableException | org.openqa.selenium.TimeoutException e1) {
			//System.out.prinln(e1.getMessage());
			btnAddGuest.click();
			reportStep("AddGuest link could not be clicked, not interactable or wait got timedout","warning");
			return null;
		}
		
	}
	
	@FindBy(xpath="//span[contains(text(),'Send Invite')]")
	 WebElement send_invite;
	 public SendInvitePage clickSendInvite(){
		 click(send_invite);
		 try {
				return new SendInvitePage(driver,Test);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return null;
	 }

	@FindBy(id = "contact_firstname")
	WebElement tboxFN;

	public partyGuestPage typeGuestFN(String guestFN) {
		try {
		new WebDriverWait(driver,waitTimeout).until(
				ExpectedConditions.attributeContains(By.xpath("//div[@class='loading-mask']"), "style", "none"));
		new WebDriverWait(driver,waitTimeout).until(
				ExpectedConditions.refreshed(ExpectedConditions.attributeContains(
			
						By.xpath("///body[@aria-busy='false']"), "aria-busy", "false")));
		type(tboxFN, guestFN);
		return this;
		} catch(org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e ) {
			type(tboxFN, guestFN);
			return this;
		}
		
	}

	@FindBy(id = "last_name")
	WebElement tboxLN;

	public partyGuestPage typeGuestLN(String guestLN) {
		type(tboxLN, guestLN);
		return this;
	}

	@FindBy(id = "contact_email")
	WebElement tboxEmail;

	public partyGuestPage typeGuestEmail(String guestEmail) {
		type(tboxEmail, guestEmail);
		return this;
	}

	@FindBy(id = "contact_phone")
	WebElement tboxPhone;

	public partyGuestPage typeGuestPhone(String guestPhone) {
		type(tboxPhone, guestPhone);
		return this;
	}

	@FindBy(xpath = "//label[@for='assign_to_me']")
	WebElement cboxTAC;

	public partyGuestPage clickAgreementToAddToParty() {
		
		click(cboxTAC);
		return this;
	}

	@FindBy(id = "send")
	WebElement btnSubmitGuestDetails;

	public partyGuestPage clickAddGuestButton() {
		click(btnSubmitGuestDetails);
		return this;
	}

}