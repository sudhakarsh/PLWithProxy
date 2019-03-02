package framework.pages;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import framework.appInit.Class_initEcomPrac;

public class partyHostPage extends Class_initEcomPrac  {

	partyHostPage(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
			super();
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.Test = Test;
		
	}
		
	@FindBy(id="create-order")
	WebElement btnCreatePaperOrder;
		public ProductSelectionPage clickCreatePaperOrder() {
			
			if(btnCreatePaperOrder.getAttribute("id").equals("create-order")) {
				//System.out.prinln("Insdie actions class");
			
			new Actions(driver).moveToElement(btnCreatePaperOrder, 10, 10).click().build().perform();
			try {
				return new ProductSelectionPage(driver, Test);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			else {
				//System.out.prinln("Unable to locate CreatePaperOder button element");
				throw new RuntimeException("Failed to locate element on the Screen");
				
				}
			return null;
			}
			
		}
		
	