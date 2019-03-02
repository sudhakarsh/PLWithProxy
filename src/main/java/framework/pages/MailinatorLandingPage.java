package framework.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import framework.appInit.Class_initEcomPrac;

public class MailinatorLandingPage extends Class_initEcomPrac{

	MailinatorLandingPage(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
		super();
	PageFactory.initElements(driver, this);
	this.driver = driver;
	this.Test = Test;
	
}
	
	
	public MailinatorLandingPage clickPartyLiteMail() {
		/*
		String from="PartyLite";
		String subject="Party Invitation";
		String received="moments ago";*/
		
		
		List<WebElement> mailRows=driver.findElements(By.xpath("//tr[@class='even pointer ng-scope']"));
		for(WebElement mailRow:mailRows) {
			if(mailRow.getText().contains("PartyLite Party Invitation"))
				{
				//System.out.prinln(mailRow.getText());clickStoreMenu
				click(mailRow);
				break;
				}
				
		}
			
		return this;
		
	}
	
	@FindBy(xpath="//a[contains(text(),'Create an account')]")
	WebElement btn_CreateAnAccount_Mail;
	public NanoSiteLandingPage clickCreateAnAccountMail() {
		
		try {
			driver.switchTo().frame("msg_body");
			String hrefAttribute = driver.findElementByXPath("//img[contains(@src,'see-you-there')]/parent::a").getAttribute("href");
			//System.out.prinln("Retrieved attribute is = " + hrefAttribute);
			if(hrefAttribute.length()!=0) {
			String[] splittedURL = hrefAttribute.split("[=]");
			//System.out.prinln(splittedURL[1]);
			String[] splitURLString = splittedURL[1].split("//");
			
			for(String s : splitURLString)
			{
				//System.out.prinln(s);
			}
			//System.out.prinln(splitURLString[1]);
			splitURLString[1] = "https://"+splitURLString[1];
			//System.out.prinln(splitURLString[1]);
			driver.navigate().to(splitURLString[1]);
					}
			else
			{
				//System.out.prinln("URL could not be parsed");
			}
		
			return new NanoSiteLandingPage(driver,Test);
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
