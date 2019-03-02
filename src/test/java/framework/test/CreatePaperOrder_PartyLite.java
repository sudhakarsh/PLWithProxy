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

public class CreatePaperOrder_PartyLite extends Class_initEcomPrac{
	
	public CreatePaperOrder_PartyLite() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeTest(groups= {"Common"})
	public void setData() {
		tcName = "CreatePaperOrder";
		tcDescription = "Creating a paper order";
		category = "Smokes";
		authors = "Anand";
		testNodes = "Paper order";
		ExcelFileName="PartyLite_Smokes_Data";
		sheetName = "PaperOrderCreationDetails_PL";
		
	}
	
	@Test(groups= {"PEX", "Smokes"}, dataProvider="CreatePartyDetails")
	public void createPaperOrder(String consultant_uname, String consultant_password, String productName_SKU, 
			String PaymentType, String cardNumber, String expMonth, String expYear, String cardCVV){
		
		try {
			try {
			new LandingPage_PartyLite(driver, Test)
			.clickToAllowCookie() //.closeDialogSignUpNewsLetter() 
			.clickSignin()
			.enterEmailName(consultant_uname)
			.enterPassword(consultant_password)
			.ConClickSignin()
			//.closeSocialNewAcctDialog()
			.selectFirstOngoingPartyListed()
			.clickGuestsLink()
			.clickPartyHost()
			.clickCreatePaperOrder()
			.enterProductDetail(productName_SKU)
			.clickSearchResultDisplayed()
			.addItemcount()
			.clickAddToBasket()
			.validateProductAdditionToCart()
			.validateCustomername()
			.validateOrderType()
			.clickGoToCheckout()
			.clickDeliveryTypeBox()
			.chooseDeliveryType()
			.clickNextButton()
			.clickPaymentMethods()
			.selectTypeOfPayment(PaymentType)
			.clickAcceptTerms()
			.clickPlaceOrderButton()
			.enterCardNumber(cardNumber)
			.enterCardExpMonth(expMonth)
			.enterCardExpYear(expYear)
			.enterCardCVV(cardCVV)
			.clickConfirm()
			.confirmOrderIsSuccess();
			
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
