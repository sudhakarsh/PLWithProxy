package framework.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import framework.appInit.Class_initEcomPrac;
import framework.utils.MyPageFactory;

public class ManagePartiesPage extends Class_initEcomPrac {

	boolean isPageReady;
	ManagePartiesPage(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
		super();
	MyPageFactory.initElements(driver, this);
	this.driver = driver;
	this.Test = Test;
	
}
	
	@FindBy(className="admin__data-grid-wrap")
	 WebElement parties_grid;
	 public ManagePartiesPage verifyPartyGrid(){
		 try {
				WebElement loader = driver.findElementByXPath("//div[@data-component='mw2_party_party_listing.mw2_party_party_listing.mw2_party_party_columns']");
				//System.out.prinln("Waiting for loader to finish page rendering.");
				isPageReady = new WebDriverWait(driver, 30).until(ExpectedConditions.refreshed
						(ExpectedConditions.attributeContains(loader, "style", "none")));
				
				//System.out.prinln("Page rendering is complete.");
			} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e ) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return this;
	 }
	 
	 @FindBy(className="action-default")
	 WebElement filter;
	 public ManagePartiesPage clickFilter(){
		 click(filter);
		 return this;
	 }
	 
	 @FindBy(name="party_number")
	 WebElement party_number;
	 public ManagePartiesPage typePartyNumber(){
		 WebDriverWait wait=new WebDriverWait(driver, waitTimeout);
		 wait.until(ExpectedConditions.visibilityOf(party_number));
		 String[] splitStr = Party_Number.split("\\s+");
			//System.out.prinln(splitStr[2]);
		 clear(party_number);
		 type(party_number,splitStr[2]);
		 return this;
	 }
	
	 @FindBy(xpath="//button[@data-action='grid-filter-apply']")
	 WebElement apply_filter;
	 public ManagePartiesPage clickApplyFilter(){
		 click(apply_filter);
		 return this;
	 }
	 
	 @FindBy(xpath="//a[contains(text(),'Edit')]")
	 WebElement edit_party;
	 public EditPartyPage_Admin clickEditParty(){
		 try {
			 WebElement loader = driver.findElementByXPath("//div[@data-component='mw2_party_party_listing.mw2_party_party_listing.mw2_party_party_columns']");
				//System.out.prinln("Waiting for loader to finish page rendering.");
				isPageReady = new WebDriverWait(driver, 30).until(ExpectedConditions.refreshed
						(ExpectedConditions.attributeContains(loader, "style", "none")));
				
				//System.out.prinln("Page rendering is complete.");
				
				click(edit_party);
				
				return new EditPartyPage_Admin(driver,Test);
			} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e ) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return null;
	 }
	 
	 
	 @FindBy(className="admin-user-account-text")
	 WebElement user_account;
	 public ManagePartiesPage clickUserAccount(){
		 
		 try {
			 WebElement loader = driver.findElementByXPath("//div[@data-component='mw2_party_party_listing.mw2_party_party_listing.mw2_party_party_columns']");
				//System.out.prinln("Waiting for loader to finish page rendering.");
				isPageReady = new WebDriverWait(driver, 30).until(ExpectedConditions.refreshed
						(ExpectedConditions.attributeContains(loader, "style", "none")));
				
				//System.out.prinln("Page rendering is complete.");
				click(user_account);
				 
		 }
		 catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e  ) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return this;
	 }
	 
	 @FindBy(className="account-signout")
	 WebElement signout;
	 public AdminLandingPage clickSignOut() {
		 
		 click(signout);
		 try {
			return new AdminLandingPage(driver, Test);
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
