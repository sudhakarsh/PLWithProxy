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

public class CreatePartyPrevHost_PreviousAddress_PartyLite extends Class_initEcomPrac{

	public CreatePartyPrevHost_PreviousAddress_PartyLite() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeTest(groups= {"Common"})
	public void setData() {
		tcName = "CreatePartyPrevHost_PreviousAddress";
		tcDescription = "Signing in of Consultant and creating a party by previous host - previous address";
		category = "Smokes";
		authors = "Anand";
		testNodes = "Consultant signing-in and creating a party ";
		ExcelFileName="PartyLite_Smokes_Data";
		sheetName = "PartyCreationPrevHost_PA_PL";
	}
	
	@Test(groups= {"PEX", "Smokes"}, dataProvider="CreatePartyDetails")
	public void createPartyPrevHost_PreviousAddress(String consultant_uname, String consultant_password, String partyName, 
			String partyType, String partyDate, String partyTime,String partyHostEmail){
		
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
			//.clickSelectPartyType() - to continue with the existing default selection 
			//.selectPartyType(partyType) -- to continue with the existing default selection 
			.clickForDatePicker()
			.clickDate(partyDate)
			.enterPartyTime(partyTime)
			.enterHostEmail(partyHostEmail)
			.selectHostEmail(partyHostEmail)
			.radioPreviousShippingAddress()
			.clickPreviousShippingAddress()
			.selectPreviousShippingAddress()
			.radioPreviousLocationAddress()
			.clickPreviousLocationAddress()
			.selectPreviousLocationAddress()
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
