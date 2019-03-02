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

	public class FindYourConsultant_ByPostCode_PartyLite  extends Class_initEcomPrac{
		
		public FindYourConsultant_ByPostCode_PartyLite() throws FileNotFoundException, IOException {
			super();
			// TODO Auto-generated constructor stub
		}

		@BeforeTest(groups= {"Common"})
		public void setData() {
			tcName = "FindYourConsultant_ByPostCode";
			tcDescription = "Select consultant by postcode";
			category = "Smokes";
			authors = "Anand";
			testNodes = "Search consultant by postcode";
			ExcelFileName="PartyLite_Smokes_Data";
			sheetName = "SearchConsultant_PL";
			
		}
		
		@Test(groups= {"eShop", "Smokes"}, dataProvider="SearchConsultant")
		public void findYourConsultant_thruPostCode(String consFirstName,	String consLastName, String consCity, String consPostcode) {
			
			try {
				
				try {
					new LandingPage_PartyLite(driver, Test)
					.clickToAllowCookie() //.closeDialogSignUpNewsLetter() 
					.clickFindConsultant()
					.clickPostCodeOption()
					.enterPostCodeValue(consPostcode)
					.clickSearchButton()
					//.verifySearchResult()  --> needs to be refactored 
					.retrieveConsultantName()
					.selectSearchedConsultant()
					.validateSelectedConsultant();
				
					
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
		
		@DataProvider(name="SearchConsultant")
		public  Object[][] getData(){
			try {
				return ExcelDataReader.getData(ExcelFileName, sheetName);		
			}catch(NullPointerException e) {
				reportStep("Excel sheet or file is not available.","fail", false);
				return null;
			}
	}
		

	}


