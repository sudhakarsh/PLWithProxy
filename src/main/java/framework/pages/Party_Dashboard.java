package framework.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import framework.appInit.Class_initEcomPrac;
import framework.utils.MyPageFactory;

public class Party_Dashboard extends Class_initEcomPrac  {

	Party_Dashboard(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
			super();
		MyPageFactory.initElements(driver, this);
		this.driver = driver;
		this.Test = Test;
		
	}
	
	@CacheLookup
	@FindBy(xpath="//div[@class='pslogin-share']//a[text()='✕']")
	WebElement dialogSocialNewAccountLink; 
	public Party_Dashboard closeSocialNewAcctDialog() {
		try {
			
			new WebDriverWait(driver, waitTimeout-reducedTimeout).until(ExpectedConditions.visibilityOf(dialogSocialNewAccountLink));
			click(dialogSocialNewAccountLink);
			
		} catch(org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e){
			reportStep("Display of connect new social sites dialog missing","info");
			return this;
		}
		return this;
	}
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement linkLogout;
	public LandingPage_PartyLite clickLogoutConsultant() {
		try {
			click(linkLogout);
			new WebDriverWait(driver,waitTimeout).until(ExpectedConditions.titleContains("Home page"));
			return new LandingPage_PartyLite(driver, Test);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@FindBy(xpath="//a[@class='action primary show-party-form']")
	WebElement btnCreateParty;
	public PartyCreationPage clickCreateParty() {
		
		click(btnCreateParty);
		try {
			return new PartyCreationPage(driver, Test);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*@FindBy(id="my-parties-table-ongoing")
	WebElement tableOngoingParties;
	public partyDetailsPage selectFirstOngoingPartyListed() {
		
		List<WebElement> partyRows = tableOngoingParties.findElements(By.tagName("tr"));
		//System.out.prinln("Ongoing parties - " + partyRows.size());
		List<WebElement> firstPartyData = partyRows.get(new Random().nextInt(partyRows.size())).findElements(By.tagName("td"));
			//System.out.prinln("the selected parties td count - " + firstPartyData.size());
			//System.out.prinln("randomParty selected - " 
		+ firstPartyData.get(0).findElement(By.xpath(".//span")).getText());
		WebElement linkPartySelected = firstPartyData.get(3);
		Point locationOfLink = firstPartyData.get(3).getLocation();
		//System.out.prinln(locationOfLink);
			//System.out.prinln(linkPartySelected.findElement(By.xpath("./a")).getAttribute("href"));
			try {
			Rectangle rect = linkPartySelected.findElement(By.xpath("./a")).getRect();
			//System.out.prinln("The anchor tag size is " +rect.height +"-" +rect.width);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement anchorParty = linkPartySelected.findElement(By.xpath("./a"));
			driver.executeScript("arguments[0].click();",anchorParty);
			
			//To get Party Number
			Party_Number=driver.getTitle();
			//System.out.prinln(Party_Number);
			String[] splitStr = Party_Number.split("\\s+");
			//System.out.prinln(splitStr[2]);
			
			
			 Rectangle rect1 = linkPartySelected.findElement(By.xpath("./a")).getRect();
				//System.out.prinln("The anchor tag size after javascript modification is " +rect1.height +"-" +rect1.width);
				 //anchorParty.click();
				//linkPartySelected.click();
			} catch(ElementNotInteractableException e) {
				//WebElement partyLink = linkPartySelected.findElement(By.xpath("./a"));
			//Point location = linkPartySelected.findElement(By.xpath("./a")).getLocation();
				new Actions(driver).moveToElement(linkPartySelected, locationOfLink.getX(), locationOfLink.getY()).click().perform();
				}
			try {
				return new partyDetailsPage(driver, Test);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}*/
	
	
	@FindBy(css="#my-parties-table-ongoing a")
	List<WebElement> tableOngoingParties;
	public partyDetailsPage selectFirstOngoingPartyListed() {
		
		String party_url=tableOngoingParties.get(new Random().nextInt(tableOngoingParties.size())).getAttribute("href");
		//System.out.prinln(party_url);

		driver.navigate().to(party_url);
		
		
		//To get Party Number
		Party_Number=driver.getTitle();
		//System.out.prinln(Party_Number);
		String[] splitStr = Party_Number.split("\\s+");
		//System.out.prinln(splitStr[2]);
		
		try {
			return new partyDetailsPage(driver,Test);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	


	@FindBy(xpath="//a[text()='My Business']")
	WebElement linkMyBusiness;
	public LandingPage_PartyLite clickMyBusinessLink() {
		
			try {
				new WebDriverWait(driver,waitTimeout-reducedTimeout).until(ExpectedConditions.invisibilityOf(dialogSocialNewAccountLink));
			click(linkMyBusiness);
			} catch(org.openqa.selenium.TimeoutException e){
				new Actions(driver).click(linkMyBusiness).perform();
			}
		try {
			return new LandingPage_PartyLite(driver, Test);
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