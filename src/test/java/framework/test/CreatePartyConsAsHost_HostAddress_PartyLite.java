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

public class CreatePartyConsAsHost_HostAddress_PartyLite extends Class_initEcomPrac{

	public CreatePartyConsAsHost_HostAddress_PartyLite() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeTest(groups= {"Common"})
	public void setData() {
		tcName = "CreatePartyConsAsHost_HostAddress";
		tcDescription = "Signing in of Consultant and creating a party by assigning consultant as host - host address";
		category = "Smokes";
		authors = "Anand";
		testNodes = "Consultant signing-in and creating a party";
		ExcelFileName="PartyLite_Smokes_Data";
		sheetName = "PartyCreationConsAsHost_HA_PL";
	}
	
	@Test(groups= {"PEX", "Smokes"}, dataProvider="CreatePartyDetails")
	public void createPartyConsAsHost_HostAddress(String consultant_uname, String consultant_password, String partyName, 
			String partyType, String partyDate, String partyTime){
		
		try {
			try {
			
			new LandingPage_PartyLite(driver, Test)
			
			.clickToAllowCookie() //.closeDialogSignUpNewsLetter() 
			.clickSignin()
			.enterEmailName(consultant_uname)
			.enterPassword(consultant_password)
			.ConClickSignin()
			//.closeSocialNewAcctDialog()
			.clickCreateParty()
			.typePartyName(partyName)
			/*.clickSelectPartyType()  -- to allow the default selection to be used
			.selectPartyType(partyType)
			*/.clickForDatePicker()
			.clickDate(partyDate)
			.enterPartyTime(partyTime)
			.selectPartyHost_self()
			.selectHostShippingAddress()
			.selectHostLocationAddress()
			.clickCreateParty()
			.verifyPartyDashboardPageTitle()
			.verifyPartyName(partyName);
			
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
	
	@DataProvider(name="CreatePartyDetails")
	public  Object[][] getData(){
		try {
			return ExcelDataReader.getData(ExcelFileName, sheetName);		
		}catch(NullPointerException e) {
			reportStep("Excel sheet or file is not available.","fail", false);
			return null;
		}
}
	
}
