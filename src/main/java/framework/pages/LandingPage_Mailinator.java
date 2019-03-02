package framework.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import framework.appInit.Class_initEcomPrac;

public class LandingPage_Mailinator extends Class_initEcomPrac {
	
	
		public LandingPage_Mailinator(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
			super();
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.Test = Test;
		
	}

	
	@FindBy(id="inboxfield")
	WebElement inbox_email;
	public LandingPage_Mailinator openGuestEmail() {
/*		//System.out.prinln(Guest_Email);
		int index=Guest_Email.indexOf("@");
		String guest_email_name=Guest_Email.substring(0, index);
		
		//hardcode value guest email name
		String url="https://www.mailinator.com/v3/index.jsp?zone=public&query=anand#/#inboxpane";
		//System.out.prinln(url);
		driver.navigate().to(url);*/
		type(inbox_email,"testguest");
		return this;
	}
	
	@FindBy(className="input-group-btn")
	WebElement go_button;
	public MailinatorLandingPage clickGoButton() {
		click(go_button);
		try {
			return new MailinatorLandingPage(driver,Test);
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

