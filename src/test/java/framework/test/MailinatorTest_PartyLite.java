package framework.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriverException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.appInit.Class_initMailinator;
import framework.pages.LandingPage_Mailinator;
import framework.utils.ExcelDataReader;

public class MailinatorTest_PartyLite extends Class_initMailinator{

	public MailinatorTest_PartyLite() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeTest(groups= {"Common"})
	public void setData() {
		tcName = "MailinatorTest";
		tcDescription = "Open mailinator and click the invitation link";
		category = "Smokes";
		authors = "Anand";
		testNodes = "mailinator link";
		ExcelFileName="PartyLite_Smokes_Data";
		sheetName = "Nanosite_Guest_Order_PL";
	}
	
	@Test(groups= {"PEX"},dataProvider="LoginDetails")
	public void mailinatorTest(String guest_email,String guest_password,String ContentToVerify,String SKU,
			String address1,String address2,String address3,
			String zipcode,String city,String phone,String PaymentType, String cardNumber,
			String expMonth,String expYear,String cardCVV) {
			
		try {
			try {
			new LandingPage_Mailinator(driver, Test)
			.openGuestEmail()
			.clickGoButton()
			.clickPartyLiteMail()
			.clickCreateAnAccountMail()
			.clickToAllowCookie() //.closeDialogSignUpNewsLetter() 
			.clickAttendParty()
			.clickBtnCreateOrder()
			.enterEmailName(guest_email)
			.enterPassword(guest_password)
			.btnClickSigninNanositeGuest()
			.gotoHomepage()
			//.closeSocialNewAcctDialog()
			.verifyUserLogin(ContentToVerify)
			.gotoCustomerAddress()
			.clickaddNewAddress()
			.enterCustomerAddress1(address1)
			.enterCustomerAddress2(address2)
			.enterCustomerAddress3(address3)
			.enterCustomerZipCode(zipcode)
			.enterCustomerCity(city)
			.enterCustomerTelephone(phone)
			.clickCheckBoxBillingAddress()
			.clickCheckBoxShippingAddress()
			.clickbtnSearchValidate()
			.clickAddressFormat()
			.clickbtnSaveAddress()
			.gotoHomepage()
			.clickBtnSearch()
			.enterSKU(SKU)
			.clickProductImage()
			.clickBtnAddToCart()
			.clickBtnMiniCart()
			.clickBtnViewBasket()
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
	}
		catch (FileNotFoundException e) {
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
