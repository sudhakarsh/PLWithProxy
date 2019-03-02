package framework.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import framework.appInit.Class_initEcomPrac;

public class ProductDescriptionPage extends Class_initEcomPrac{

	
	ProductDescriptionPage(RemoteWebDriver driver, ExtentTest Test) throws FileNotFoundException, IOException {
		super();
	PageFactory.initElements(driver, this);
	this.driver = driver;
	this.Test = Test;
	
}
	
	@FindBy(id="product-addtocart-button")
	WebElement btnAddToCart;
	public ProductDescriptionPage clickBtnAddToCart() {
		click(btnAddToCart);
		return this;
	}
	
	@FindBy(css=".minicart-wrapper .showcart")
	WebElement btnMiniCart;
	public ProductDescriptionPage clickBtnMiniCart() {
		WebDriverWait wait=new WebDriverWait(driver, waitTimeout);
		wait.until(ExpectedConditions.elementToBeClickable(btnMiniCart));
		click(btnMiniCart);
		return this;
	}
	
	@FindBy(css=".minicart-wrapper .viewcart")
	WebElement btnViewBasket;
	public CartSummaryPage clickBtnViewBasket() {
		click(btnViewBasket);
		try {
			return new CartSummaryPage(driver, Test);
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
