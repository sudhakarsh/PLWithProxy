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

public class NavigateTo_PartyLite extends Class_initEcomPrac{
	
	public NavigateTo_PartyLite() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeTest(groups= {"Common"})
	public void setData() {
		tcName = "NavigateTo_PartyLite";
		tcDescription = "Navigation to landing page and closing signupu letter dialog";
		category = "Smokes";
		authors = "Anand";
		testNodes = "NavigationPartyLite_closeDialogSignup";
		ExcelFileName="PartyLite_Smokes_Data";
		sheetName = "ExistingUser_PL";
		
	}
	
	@Test(groups= {"eShop"})
	public void navigateTo_PL() {
		
			
			try {
				
				try {
				new LandingPage_PartyLite(driver, Test)
				.verifyPLTitle();
				
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
