package framework.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import framework.appInit.Class_initEcomPrac;

public class PartyCreationPage extends Class_initEcomPrac  {

	PartyCreationPage(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
			super();
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.Test = Test;
		
	}

	
	@FindBy(id="party-name")
	WebElement txtBoxPartyName;
	public PartyCreationPage typePartyName(String NameOfParty) {
		type(txtBoxPartyName, NameOfParty);
		return this;
	}
	
	
	@FindBy(xpath="//label[@class='select_expandLabel']")
	WebElement partyTypSelector;
	
	public PartyCreationPage clickSelectPartyType() {
		click(partyTypSelector);
		return this;
	}
	
	

	@FindBy(xpath="//li[@class='select_items']//ul")
	WebElement selPartyType;
	public PartyCreationPage selectPartyType(String typeOfParty) {
		/*List<WebElement> partyTypeOptions = driver.findElements(By.xpath("//li[@class='select_items']//ul/li/input"));
		//System.out.prinln(partyTypeOptions.size());
		for(WebElement type : partyTypeOptions) {
			//System.out.prinln(type.getAttribute("value"));
			//System.out.prinln("data read from excel " + typeOfParty);
			if(Integer.parseInt(type.getAttribute("value")) == (int)Double.parseDouble(typeOfParty)) {
				//System.out.prinln("PartyType Text matched");
				int value = Integer.parseInt(type.getAttribute("value"));
				
				WebElement typeLocated = locateElement("xpath", "(//li[@class='select_items']//ul/li)"+"["+value+"]");
				new Actions(driver).moveToElement(typeLocated, 4, 5).click().build().perform();
				return this;
			}
				
		}
		return this;*/
		try {
			WebElement dropDownPartyTypes = (new WebDriverWait(driver,waitTimeout)).until(new ExpectedCondition<WebElement>(){
		

			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.xpath(("//li[@class='select_items']//ul)")));
			}
			
		});
			dropDownPartyTypes.findElement(By.xpath((".(/li))"+"["+typeOfParty+"]"))).click();
			return this;
		}catch(NoSuchElementException e) {
			reportStep("Party types list is not displayed or not selected properly","warning");
			return null;
		}
		
	}

	@FindBy(id="party-date")
	WebElement dateForParty;
	public PartyCreationPage clickForDatePicker() {
		click(dateForParty);
		return this;
	}
	
	@FindBy(className="ui-datepicker-calendar")
	WebElement datepicker;
	public PartyCreationPage clickDate(String userEnteredDate) {
		boolean dateFound =false;
		String[] parsedDateValue = userEnteredDate.split("/");
		String date = parsedDateValue[0];
		//System.out.prinln("date entered in excel - "+parsedDateValue[0]);
		String month = parsedDateValue[1];
		//System.out.prinln("month entered in excel - "+parsedDateValue[1]);
		String year = parsedDateValue[2];
		//System.out.prinln("year entered in excel - "+parsedDateValue[2]);
		
		List<WebElement> dateRows = datepicker.findElements(By.tagName("tr"));
		for(WebElement dateRow : dateRows) {
			List<WebElement> cellDateValues = dateRow.findElements(By.tagName("td"));
			for(WebElement cellDate : cellDateValues) {
				if(date.equals(cellDate.getText().trim())) {
					if(!cellDate.getAttribute("className").contains("unselectable")) {
						click(cellDate);
						dateFound = true;
					}
				}
				
			}
			if(dateFound) {
				break;
		}
		}
		if(!dateFound) {
			throw new RuntimeException("Date entered by user in the excel is incorrect/or refers to past date");
		}
	
		return this;
		}
	
	@CacheLookup
	@FindBy(id="party-time")
	WebElement txtBoxpartyTime;
	public PartyCreationPage enterPartyTime(String partyTime) {
		
		if(p.getProperty("browserApp").equalsIgnoreCase("firefox")) {
			/*System.out.println("Inside actions class for firefox - Create party - time picker field");
			new Actions(driver).click(txtBoxpartyTime).sendKeys
			(Keys.chord(Keys.NUMPAD1, Keys.NUMPAD1,Keys.NUMPAD3, Keys.NUMPAD1)).build();*/
			driver.manage().timeouts().setScriptTimeout(12, TimeUnit.SECONDS);
			driver.executeScript("arguments[0].value='11:22';", txtBoxpartyTime);
			return this;
			
		}
		clear(txtBoxpartyTime);
		click(txtBoxpartyTime);
		type(txtBoxpartyTime, partyTime);
		return this;
	}
	
	
	@FindBy(xpath="//label[contains(@data-bind, 'Previous Host')]")
	WebElement partyHost_PrevHost;
	public PartyCreationPage selectPartyHost_Prev() {
		click(partyHost_PrevHost);
		return this;
	}
	
	
	@FindBy(xpath="//label[contains(@data-bind, 'I will host')]")
	WebElement partyHost_Self;
	public PartyCreationPage selectPartyHost_self() {
		click(partyHost_Self);
		return this;
	}
	
	@FindBy(xpath="//label[contains(@data-bind, 'New Host')]")
	WebElement partyHost_New;
	public PartyCreationPage selectPartyHost_New() {
		click(partyHost_New);
		return this;
	}
	
	@FindBy(id="customer-search")
	WebElement txtBoxHostEmail;
	public PartyCreationPage enterHostEmail(String partyHostEmail) {
		type(txtBoxHostEmail, partyHostEmail);
		return this;
	}
	
	@FindBy(css=".customer-list span")
	WebElement suggestedHostEmail;
	public PartyCreationPage selectHostEmail(String partyHostEmail) {
		try {
			new WebDriverWait(driver, waitTimeout).until(ExpectedConditions.visibilityOf(suggestedHostEmail));
			click(suggestedHostEmail);
			return this;
		}
		catch(RuntimeException e) {
			reportStep("The suggestion of consultant contacts was not displayed initially, email to be re-entered", "warning");
			try {
			txtBoxHostEmail.clear();
			type(txtBoxHostEmail, partyHostEmail);
			}catch(ElementNotInteractableException e11) {
				reportStep("The hostEmail textbox could not be re-entered to initialize auto-suggestion", "warning");
			}
			try {
			new WebDriverWait(driver, waitTimeout).until(ExpectedConditions.visibilityOf(suggestedHostEmail));
			click(suggestedHostEmail);
			return this;
			}
			catch(RuntimeException e2) {
				reportStep("The suggestion of consultant contacts was not displayed again", "warning");
			}	
		}
		return null;
	}
	
	@FindBy(xpath="(//label[contains(@data-bind,'Host Address')])[1]")
	WebElement partyShippingHostAddress;
	public PartyCreationPage selectHostShippingAddress() {
		click(partyShippingHostAddress);
		return this;
				}	
	
	@FindBy(xpath="(//label[contains(@data-bind,'Host Address')])[2]")
	WebElement partyLocationHostAddress;
	public PartyCreationPage selectHostLocationAddress() {
		click(partyLocationHostAddress);
		return this;
				}
	
	@FindBy(xpath="(//label[contains(@data-bind,'Previous Address')])[1]")
	WebElement partyRadioShippingPreviousAddress;
	public PartyCreationPage radioPreviousShippingAddress() {
		click(partyRadioShippingPreviousAddress);
		return this;
				}	
	
	@FindBy(xpath="(//label[contains(@data-bind,'Previous Address')])[2]")
	WebElement partyRadioLocationPreviousAddress;
	public PartyCreationPage radioPreviousLocationAddress() {
		click(partyRadioLocationPreviousAddress);
		return this;
				}
	
	@FindBy(css=".party_shipping_address .select")
	WebElement clickPartyShippingPreviousAddress;
	public PartyCreationPage clickPreviousShippingAddress() {
		click(clickPartyShippingPreviousAddress);
		return this;
				}
	
	@FindBy(css=".party_location .select")
	WebElement clickPartyLocationPreviousAddress;
	public PartyCreationPage clickPreviousLocationAddress() {
		click(clickPartyLocationPreviousAddress);
		return this;
				}
	
	@FindBy(css=".party_shipping_address .select_label span:nth-child(1)")
	WebElement partyShippingPreviousAddress;
	public PartyCreationPage selectPreviousShippingAddress() {
		click(partyShippingPreviousAddress);
		return this;
				}
	
	@FindBy(css=".party_location .select_label span:nth-child(1)")
	WebElement partyLocationPreviousAddress;
	public PartyCreationPage selectPreviousLocationAddress() {
		click(partyLocationPreviousAddress);
		return this;
				}
	
	@FindBy(id="contact_firstname")
	WebElement host_contactFirstName;
	public PartyCreationPage typePartyHost_FN(String hostFirstName) {
		type(host_contactFirstName, hostFirstName);
		return this;
	}
	

	@FindBy(id="last_name")
	WebElement host_contactLastName;
	public PartyCreationPage typePartyHost_LN(String hostLastName) {
		
		type(host_contactLastName, hostLastName);
		return this;
	}
	
	
	@FindBy(id="contact_email")
	WebElement host_contactEmail;
	public PartyCreationPage typePartyHost_Email(String hostEmail) {
		type(host_contactEmail, hostEmail);
		return this;
	}
	
	@FindBy(id="contact_phone")
	WebElement host_contactPhone;
	public PartyCreationPage typePartyHost_Phone(String hostPhone) {
		type(host_contactPhone, hostPhone);
		return this;
	}
	
	
			
	@FindBy(xpath="(//label[contains(@data-bind,'New Address')])[1]")
	WebElement partyShippingNewAddress;
	public PartyCreationPage selectNewShippingAddress() {
	click(partyShippingNewAddress);
	return this;
			}		
	
	
	@FindBy(id="address_line_1")
	WebElement ShippingAddress_newAddressLine1;
	public PartyCreationPage typeNewShippingAddressLine1(String shipAddrLine1) {
		type(ShippingAddress_newAddressLine1, shipAddrLine1);
		return this;
	}
	
	@FindBy(id="address_line_2")
	WebElement ShippingAddress_newAddressLine2;
	public PartyCreationPage typeNewShippingAddressLine2(String shipAddrLine2) {
		type(ShippingAddress_newAddressLine2, shipAddrLine2);
		return this;
	}
	
	
	@FindBy(id="address_city")
	WebElement ShippingAddress_newAddresscity;
	public PartyCreationPage typeNewShippingAddresscity(String shipAddrcity) {
		type(ShippingAddress_newAddresscity, shipAddrcity);
		return this;
	}
	
	
	@FindBy(id="address_country")
	WebElement ShippingAddress_newAddresscountry;
	public PartyCreationPage typeNewShippingAddresscountry(String shipAddrcountry) {
		type(ShippingAddress_newAddresscountry, shipAddrcountry);
		return this;
	}
	
	@FindBy(id="address_postcode")
	WebElement ShippingAddress_newAddresspostcode;
	public PartyCreationPage typeNewShippingAddresspostcode(String shipAddrpostcode) {
		type(ShippingAddress_newAddresspostcode, shipAddrpostcode);
		return this;
	}
	
	
	
	
	@FindBy(id="party_address_line_1")
	WebElement newPartyAddressLine1;
	public PartyCreationPage typeNewPartyAddressLine1(String partyAddrLine1) {
		type(newPartyAddressLine1, partyAddrLine1);
		return this;
	}
	
	@FindBy(id="party_address_line_2")
	WebElement newPartyAddressLine2;
	public PartyCreationPage typeNewPartyAddressLine2(String partyAddrLine2) {
		type(newPartyAddressLine2, partyAddrLine2);
		return this;
	}
	

	@FindBy(id="party_address_city")
	WebElement newPartyAddresscity;
	public PartyCreationPage typeNewPartyAddresscity(String partyAddrcity) {
		type(newPartyAddresscity, partyAddrcity);
		return this;
	}
	
	
	@FindBy(id="party_address_country")
	WebElement newPartyAddresscountry;
	public PartyCreationPage typeNewPartyAddresscountry(String partyAddrcountry) {
		type(newPartyAddresscountry, partyAddrcountry);
		return this;
	}
	
	@FindBy(id="party_address_postcode")
	WebElement newPartyAddresspostcode;
	public PartyCreationPage typeNewPartyAddresspostcode(String partyAddrpostcode) {
		type(newPartyAddresspostcode, partyAddrpostcode);
		return this;
	}
	
	
	
	@FindBy(xpath="(//label[contains(@data-bind,'New Address')])[2]")
	WebElement partyLocationNewAddress;
	public PartyCreationPage selectNewLocationAddress() {
	click(partyLocationNewAddress);
	return this;
	}

	
	
	@FindBy(xpath="//button[@class='action save primary']")
	WebElement btnCreateParty;
	public  partyDetailsPage  clickCreateParty() {
		click(btnCreateParty);
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
	}
}
	
