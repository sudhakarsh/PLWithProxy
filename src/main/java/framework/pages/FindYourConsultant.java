	package framework.pages;

	import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
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

	public class FindYourConsultant extends Class_initEcomPrac  {

		public FindYourConsultant(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
				super();
			this.driver = driver;
			this.Test = Test;
			MyPageFactory.initElements(driver, this);
		}

		@FindBy(id="mode_name")
		WebElement radioButtonName;
		public FindYourConsultant clickNameOption() {
			radioButtonName.click();
			return this;
		}
		
		@FindBy(id="firstname")
		WebElement consultantFirstName;
		public FindYourConsultant typeFirstName(String firstName) {
			type(consultantFirstName, firstName);
			return this;
		}
		
		@FindBy(id="lastname")
		WebElement consultantLastName;
		public FindYourConsultant typeLastName(String lastName) {
			type(consultantFirstName, lastName);
			
			return this;
		}
		
		@FindBy(id="city")
		WebElement consultantCity;
		public FindYourConsultant typeCity(String city) {
			type(consultantFirstName, city);
			return this;
		}
		@FindBy(xpath="//label[@for='mode_postcode']")
		WebElement radioButtonPostcode;
		public FindYourConsultant clickPostCodeOption() {
			click(radioButtonPostcode);
			return this;
		}
		
		@FindBy(id="postcode")
		WebElement txtBoxPostcode;
		public FindYourConsultant enterPostCodeValue(String ConsultantPostCode) {
			new WebDriverWait(driver,waitTimeout).until(ExpectedConditions.
					presenceOfElementLocated(By.xpath("//div[@class='field postcode']")));
			//new WebDriverWait(driver,waitTimeout).until(ExpectedConditions.visibilityOf(txtBoxPostcode));
			type(txtBoxPostcode, ConsultantPostCode);
			return this;
		}
		
		@CacheLookup
		@FindBy(xpath="//*[@id=\"consultant-locator-form-postcode\"]/div[2]/div/button")
		WebElement buttonSearch;
		public FindYourConsultant clickSearchButton() {
			buttonSearch.click();
			try {
			if(new WebDriverWait(driver,30).until(ExpectedConditions
					.textToBePresentInElementLocated
					(By.xpath("//div[text()[contains(.,'Consultant create failed')]]"),"Consultant create failed"))) {
				//System.out.prinln("Intermittent error scenario identified");
				WebElement searchButton2 = locateElement("xpath", "//*[@id='consultant-locator-form-postcode']/div[2]/div/button");
				//System.out.prinln("About to click on the search button again");
				searchButton2 .click();
				//System.out.prinln("Clicked the search button again");
				return this;
			}
			} catch(org.openqa.selenium.TimeoutException e) {
				return this;
			}
			return this;
		}
		
		
		
		@FindBy(xpath="//div[@class='consultant-info']/p[1]")
		WebElement txtConsultantName;
		public FindYourConsultant retrieveConsultantName() {
			
			WebDriverWait wait = new WebDriverWait(driver, waitTimeout);
			wait.until(ExpectedConditions.visibilityOf(txtConsultantName));
			
			String consultantName = getText(txtConsultantName);
			StringTokenizer st = new StringTokenizer(consultantName);
			if(st.hasMoreTokens()) {
			ConsultantName = st.nextToken();
			}
			//System.out.prinln("First name of consultant  = "  + ConsultantName);
			return this;
		}
		
		@CacheLookup
		@FindBy(xpath="//span[@class='consultant-name']")
		WebElement findConsultantName;
		public FindYourConsultant validateSelectedConsultant() {
			
			/*try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			ConsultantName = ConsultantName.toUpperCase();
			WebDriverWait wait = new WebDriverWait(driver, waitTimeout);
			wait.until(ExpectedConditions.textToBe(By.xpath("//span[@class='consultant-name']"), ConsultantName));
			verifyPartialText(findConsultantName, ConsultantName);
			return this;
		}
		
		
		
		
		@FindBy(xpath="(((//div[@class='actions-toolbar'])[3])//a)[2]/span")  
		//*[@id="maincontent"]/div[2]/div/div[2]/div[2]/div[1]/div/div/div[2]/div/div/a[2]
		// -- (((//div[@class='actions-toolbar'])[3])//a)[2]/span
		WebElement buttonSelect;
		public FindYourConsultant selectSearchedConsultant() {
			/*WebDriverWait wt2 = new WebDriverWait(driver, waitTimeout);
			WebElement until = wt2.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(buttonSelect)));
			if (until.isEnabled())
			{
			
			driver.manage().timeouts().setScriptTimeout(waitTimeout, TimeUnit.SECONDS);
			int y = buttonSelect.getLocation().getY();
			driver.executeScript("scroll(0,"+y+");");
			*/
			Actions builder = new Actions(driver);
			builder.moveToElement(buttonSelect, 3, 7).click().build().perform();
			//click(selectLink);
			
			
			return this;
		
	}
	}
