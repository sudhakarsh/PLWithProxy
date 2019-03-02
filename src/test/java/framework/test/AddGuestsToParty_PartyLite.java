package framework.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriverException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.appInit.Class_initEcomPrac;
import framework.pages.LandingPage_PartyLite;
import framework.utils.ExcelDataReader;

public class AddGuestsToParty_PartyLite extends Class_initEcomPrac{
	
	public AddGuestsToParty_PartyLite() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeTest(groups= {"Common"})
	public void setData() {
		tcName = "AddGuestsToParty";
		tcDescription = "Adding guest to a party";
		category = "Smokes";
		authors = "Anand";
		testNodes = "Adding guests";
		ExcelFileName="PartyLite_Smokes_Data";
		sheetName = "AddGuestDetails_PL";
		
	}
	
	@Test(groups= {"PEX", "Smokes"}, dataProvider="AddGuestDetails")
			
	public void addGuestsToAParty(String consultant_uname, String consultant_password, String guestFN, String guestLN, String guestEmail, String guestPhone){
		
		try {
			try {
			
			new LandingPage_PartyLite(driver, Test)
			.clickToAllowCookie() //.closeDialogSignUpNewsLetter() 
			.clickSignin()
			.enterEmailName(consultant_uname)
			.enterPassword(consultant_password)
			.ConClickSignin()
			////.closeSocialNewAcctDialog()
			.selectFirstOngoingPartyListed()
			.clickGuestsLink()
			.clickAddGuestLink()
			.typeGuestFN(guestFN)
			.typeGuestLN(guestLN)
			.typeGuestEmail(guestEmail)
			.typeGuestPhone(guestPhone)
			.clickAgreementToAddToParty()
			.clickAddGuestButton();
			
			} catch(WebDriverException e) {
				e.getMessage();
				reportStep("The test encountered an exception.","warning");
				
			}

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
	}
	
	@DataProvider(name="AddGuestDetails")
	public  Object[][] getData(){
		try {
			return ExcelDataReader.getData(ExcelFileName, sheetName);		
		}catch(NullPointerException e) {
			reportStep("Excel sheet or file is not available.","fail", false);
			return null;
		}
}
	

}
