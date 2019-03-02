package framework.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import framework.appInit.Class_initEcomPrac;
import framework.utils.MyPageFactory;

public class LandingPage_PartyLite extends Class_initEcomPrac {

	public LandingPage_PartyLite(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
		super();
		MyPageFactory.initElements(driver, this);
		this.driver = driver;
		this.Test = Test;

	}

	/*
	 * @CacheLookup //@FindBy(xpath=
	 * "//div[@class='newsletter-subscribe-modal']//h2[@class='title']") ** to
	 * revert
	 * 
	 * @FindBy(xpath="//div[@class='newsletter-subscribe-modal']")
	 * //"//(//button[@class='action-close'])[2]") WebElement
	 * SignUpToNewsLetterText;
	 */
	/*
	 * @FindBy(xpath ="//button[@id='btn-cookie-allow']") WebElement
	 * btnAcceptCookie; public LandingPage_PartyLite closeDialogSignUpNewsLetter() {
	 * 
	 * try {
	 * 
	 * 
	 * new WebDriverWait(driver,
	 * waitTimeout).until(ExpectedConditions.visibilityOf(SignUpToNewsLetterText));
	 * WebElement closeSignUpDialog =
	 * driver.findElementByXPath("(//button[@class='action-close'])[2]");
	 * click(closeSignUpDialog); } catch(org.openqa.selenium.TimeoutException e e) {
	 * reportStep("Newsletter subscription modal 1st timeout occurred or missing"
	 * ,"info"); try { new WebDriverWait(driver,
	 * waitTimeout).until(ExpectedConditions.visibilityOf(SignUpToNewsLetterText));
	 * WebElement closeSignUpDialog =
	 * driver.findElementByXPath("(//button[@class='action-close'])[2]");
	 * click(closeSignUpDialog); } catch(NoSuchElementException | TimeoutException
	 * e2) { reportStep("Newsletter subscription modal timedout again.","info"); } }
	 * 
	 * 
	 * try { WebElement modalCurtain = driver.findElementByXPath("//aside"); new
	 * WebDriverWait(driver,waitTimeout).until(ExpectedConditions.invisibilityOf(
	 * modalCurtain)); }catch (NullPointerException | NoSuchElementException |
	 * TimeoutException e3) { e3.getMessage(); //do nothing }
	 * 
	 * 
	 * try { WebElement btnAcceptCookie =
	 * driver.findElementByXPath("//button[@id='btn-cookie-allow']");
	 * 
	 * try { click(btnAcceptCookie); return this; } catch (org.openqa.selenium.TimeoutException e e) {
	 * reportStep("Button to allow cookie usage timed out or missing ","info");
	 * return this; }
	 * 
	 * }
	 */

	@FindBy(id = "btn-cookie-allow")
	WebElement btnContinue;
	public LandingPage_PartyLite clickToAllowCookie() {
		try {
			btnContinue.click();
			return this;
		} catch (NullPointerException e) {
			return this;
		}
	}

	@FindBy(id = "search-action")
	WebElement btnSearch;

	public LandingPage_PartyLite clickBtnSearch() {
		click(btnSearch);
		return this;
	}

	@FindBy(id = "search")
	WebElement txtBoxSearch;

	public LandingPage_PartyLite enterSKU(String SKU) {
		type(txtBoxSearch, SKU);
		return this;
	}

	@FindBy(css = ".search-product .image a")
	WebElement linkProductImage;

	public ProductDescriptionPage clickProductImage() {

		try {
			new WebDriverWait(driver, waitTimeout).until(ExpectedConditions.visibilityOf(linkProductImage));
			click(linkProductImage);
			try {
				return new ProductDescriptionPage(driver, Test);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The entered SKU isn't available or invalid", "warnining");
			return null;
		}
		return null;
	}

	@FindBy(xpath = "//li[@class='authorization-link']/a")
	WebElement linkSignIn;

	public CustomerLoginPage clickSignin() {
		click(linkSignIn);
		try {
			return new CustomerLoginPage(driver, Test);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@CacheLookup
	@FindBy(xpath = "(//a[@class='consultant-find'])[1]")
	WebElement linkFindConsultant;

	public FindYourConsultant clickFindConsultant() {
		click(linkFindConsultant);
		try {
			return new FindYourConsultant(driver, Test);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@FindBy(xpath = "//input[@name='email']")
	WebElement tbEmailSubscriptioninDialog;

	public LandingPage_PartyLite enterEmailAddressinDialog(String ExistingUserEmail) {
		//verifyDisplayed(SignUpToNewsLetterText);
		click(tbEmailSubscriptioninDialog);
		type(tbEmailSubscriptioninDialog, ExistingUserEmail);
		return this;
	}

	@FindBy(xpath = "//button[@title='Subscribe']")
	WebElement btnSubscribeEmailinDialog;

	public LandingPage_PartyLite clickSubscribeinDialog() {
		click(btnSubscribeEmailinDialog);
		return this;
	}

	@FindBy(xpath = "//button[@data-role='action']/span[text()='Continue Shopping']")
	WebElement btnContinueShopping;

	public LandingPage_PartyLite clickContinueShopping() {
		click(btnContinueShopping);
		return this;
	}

	@FindBy(xpath = "//button/span[text()='Change']/parent::button")
	WebElement linkMenuExpansion;

	public LandingPage_PartyLite clickMenuExpansionLink() {
		linkMenuExpansion.click();
		return this;
	}

	@FindBy(linkText = "My Party Contacts")
	WebElement linkMyPartyContacts;

	public MyParties_ContactsPage clickLinkMyPartyContacts() {
		click(linkMyPartyContacts);
		try {
			return new MyParties_ContactsPage(driver, Test);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@FindBy(xpath = "(//a[text()[contains(.,'Sign Out')]])[1]")
	WebElement linkSignOut;

	public LandingPage_PartyLite clickSignout() {
		click(linkSignOut);
		return this;
	}

	public LandingPage_PartyLite verifyPLTitle() {
		boolean TitleValidated = driver.getTitle().equals("Home page");
		if (TitleValidated) {
			reportStep("Validated PartyLite home page title  -" + TitleValidated, "pass");
			return this;
		} else {
			reportStep("PartyLite website navigation could not be validated", "warning");
			throw new RuntimeException("Title of PartyLite could not be validated to be \"Home page\".");
		}
	}

	@FindBy(xpath = "//span[@class='customer-name'][@tabindex='0']")
	WebElement linkMyAccount;

	public LandingPage_PartyLite verifyUserLogin(String ContentToVerify) {
		verifyExactText(linkMyAccount, ContentToVerify);
		return this;
	}

	@FindBy(xpath = "//div[@class='pslogin-share']//a[text()='✕']")
	WebElement dialogSocialNewAccountLink;

	public LandingPage_PartyLite closeSocialNewAcctDialog() {
		try {

			new WebDriverWait(driver, waitTimeout - reducedTimeout)
					.until(ExpectedConditions.visibilityOf(dialogSocialNewAccountLink));
			click(dialogSocialNewAccountLink);

		} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
			reportStep("Display of connect new social sites dialog missing", "info");
			return this;
		}
		return this;
	}

	public CustomerAddressPage gotoCustomerAddress() {
		driver.navigate().to(driver.getCurrentUrl() + "customer/address");
		try {
			return new CustomerAddressPage(driver, Test);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
