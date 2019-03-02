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

public class SendInvitePage extends Class_initEcomPrac {
	
	Boolean isPageReady;

	SendInvitePage(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
		super();
	PageFactory.initElements(driver, this);
	this.driver = driver;
	this.Test = Test;
	
}
	
	@FindBy(id="customer-search")
	WebElement email_search;
	public SendInvitePage typeEmail(String guest_email) {
		Guest_Email=guest_email;
		//System.out.prinln(Guest_Email);
		type(email_search,guest_email);
		return this;
	}
	
	@FindBy(css=".customer-list span")
	WebElement selectEmail;
	public SendInvitePage selectEmail() {
		try {
			WebDriverWait wait=new WebDriverWait(driver, waitTimeout);
			wait.until(ExpectedConditions.visibilityOf(selectEmail));
			click(selectEmail);
			click(selectEmail);
			return this;
		}
		catch(RuntimeException e) {
			reportStep("The given host email is not present in the consultant contact", "warning");
			return null;
		}
		
	}
	
	@FindBy(css=".add-btn a")
	WebElement addGuest;
	public SendInvitePage clickAddButton() {
			click(addGuest);
			 try {
					WebElement loader = driver.findElementByXPath("//div[@class='loading-mask']");
					//System.out.prinln("Waiting for loader to finish page rendering.");
					isPageReady = new WebDriverWait(driver, 30).until(ExpectedConditions.refreshed
							(ExpectedConditions.attributeContains(loader, "style", "none")));
					
					//System.out.prinln("Page rendering is complete.");
				} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return this;
		
	}
	
	@FindBy(xpath="//span[contains(text(),'All guests have been informed that they are going to be invited to this party')]")
	 WebElement check_box;
	 public SendInvitePage clickCheckBox(){
		 click(check_box);
		 return this;
	 }
	 
	 @FindBy(xpath="//button[contains(text(),'Send Invitations')]")
	 WebElement send_invitations;
	 public SendInvitePage clickSendInvitations(){
		 click(send_invitations);
		 try {
				WebElement loader = driver.findElementByXPath("//div[@class='loading-mask']");
				//System.out.prinln("Waiting for loader to finish page rendering.");
				isPageReady = new WebDriverWait(driver, 30).until(ExpectedConditions.refreshed
						(ExpectedConditions.attributeContains(loader, "style", "none")));
				
				//System.out.prinln("Page rendering is complete.");
			} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return this;
	 }

}
