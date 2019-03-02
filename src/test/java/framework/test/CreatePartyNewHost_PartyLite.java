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

public class CreatePartyNewHost_PartyLite extends Class_initEcomPrac{
	
	public CreatePartyNewHost_PartyLite() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeTest(groups= {"Common"})
	public void setData() {
		tcName = "CreatePartyNewHost";
		tcDescription = "Signing in of Consultant and creating a party";
		category = "Smokes";
		authors = "Anand";
		testNodes = "Consultant signing-in and creating a party";
		ExcelFileName="PartyLite_Smokes_Data";
		sheetName = "PartyCreationDetails_PL";
		
	}
	
	@Test(groups= {"PEX", "Smokes"}, dataProvider="CreatePartyDetails")
	public void createPartyNewHost(String consultant_uname, String consultant_password, String partyName, 
			String partyType, String partyDate, String partyTime, String hostFirstName, String hostLastName, String hostEmail,
			String hostPhone, String shipAddrLine1, String shipAddrLine2,String shipAddrcity , String shipAddrcountry, 
			String shipAddrpostcode, String partyAddrLine1 , String partyAddrLine2, String partyAddrcity, 
			String partyAddrcountry, String partyAddrpostcode){
		
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
			/*.clickSelectPartyType()
			.selectPartyType(partyType)*/
			.clickForDatePicker()
			.clickDate(partyDate)
			.enterPartyTime(partyTime)
			.selectPartyHost_New()
			.typePartyHost_FN(hostFirstName)
			.typePartyHost_LN(hostLastName)
			.typePartyHost_Email(hostEmail)
			.typePartyHost_Phone(hostPhone)
			.selectNewShippingAddress()
			.typeNewShippingAddressLine1(shipAddrLine1)
			.typeNewShippingAddressLine2(shipAddrLine2)
			.typeNewShippingAddresscity(shipAddrcity)
			.typeNewShippingAddresscountry(shipAddrcountry)
			.typeNewShippingAddresspostcode(shipAddrpostcode)
			.selectNewLocationAddress()
			.typeNewPartyAddressLine1(partyAddrLine1)
			.typeNewPartyAddressLine2(partyAddrLine2)
			.typeNewPartyAddresscity(partyAddrcity)
			.typeNewPartyAddresscountry(partyAddrcountry)
			.typeNewPartyAddresspostcode(partyAddrpostcode)
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
