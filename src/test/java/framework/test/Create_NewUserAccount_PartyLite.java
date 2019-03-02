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

public class Create_NewUserAccount_PartyLite extends Class_initEcomPrac {

	public Create_NewUserAccount_PartyLite() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeTest(groups = { "Common" })
	public void setData() {
		tcName = "Create_NewUserAccount";
		tcDescription = "New user account creation";
		category = "Smokes";
		authors = "Anand";
		testNodes = "Account creation - new user";
		ExcelFileName = "PartyLite_Smokes_Data";
		sheetName = "CreateAccount_NewUser_PL";

	}

	@Test(groups= {"eShop", "Smokes"}, dataProvider="NewUserDetails")
		public void create_NewUserAccounts(String firstname,	String lastname, String	email,	String confEmail,	
				String password,	String confpassword) {
			
			try {
				try {
				new LandingPage_PartyLite(driver, Test)
				.clickToAllowCookie() //.closeDialogSignUpNewsLetter() 
				.clickSignin()
				.clickCreateAnAccount()
				.enterFirstname(firstname)
				.enterLastname(lastname)
				.enterEmail(email)
				.enterEmailConf(email)
				.enterPassword(password)
				.enterPasswordConf(password)
				.clickTermsConditions()
				.clickCreateAnAccount()
				.confirmRegistrationText();
				
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

	@DataProvider(name = "NewUserDetails")
	public Object[][] getData() {
		try {
			return ExcelDataReader.getData(ExcelFileName, sheetName);		
		}catch(NullPointerException e) {
			reportStep("Excel sheet or file is not available.","fail", false);
			return null;
		}
}

}
