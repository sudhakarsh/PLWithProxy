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

public class SignIn_PartyLite extends Class_initEcomPrac{
	
	public SignIn_PartyLite() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeTest(groups= {"Common"})
	public void setData() {
		tcName = "Sign-in_PartyLite";
		tcDescription = "Signing in through homepage using Excel";
		category = "Smokes";
		authors = "Anand";
		testNodes = "Signing-in using excel datareader";
		ExcelFileName="PartyLite_Smokes_Data";
		sheetName = "Login_ExistingUser_PL";
		
	}
	
	@Test(groups= {"eShop"}, dataProvider="LoginDetails")
	public void signInToPartyLite(String uname, String password, String Verification_content) {
		
		try {
			
			try {
			
			new LandingPage_PartyLite(driver, Test)
			
			.clickToAllowCookie() //.closeDialogSignUpNewsLetter() 
			.clickSignin()
			.enterEmailName(uname)
			.enterPassword(password)
			.btnClickSignin()
			.verifyUserLogin(Verification_content);
			
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
	
	@DataProvider(name="LoginDetails")
	public  Object[][] getData(){
		try {
			return ExcelDataReader.getData(ExcelFileName, sheetName);		
		}catch(NullPointerException e) {
			reportStep("Excel sheet or file is not available.","fail", false);
			return null;
		}
}
	

}
