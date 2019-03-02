package framework.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementProxy implements InvocationHandler {

    private final WebElement element;
	public RemoteWebDriver driver;

    public ElementProxy(RemoteWebDriver driver, WebElement element) {
        this.element = element;
        this.driver = driver;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //before invoking actual method check for the popup
        this.checkForPopupAndKill();
        //at this point, popup would have been closed if it had appeared. element action can be called safely now.
        Object result = method.invoke(element, args);
        return result;
    }

    private void checkForPopupAndKill() {
    	try {
    	WebElement randomModal = driver.findElementByXPath("//div[@class='newsletter-subscribe-modal']");
        if (randomModal.isDisplayed()) {
            System.out.println("Newsletter subscription option shown, closing the modal.");
            driver.findElementByXPath("(//button[@class='action-close'])[2]").click();
            try { 
            	WebElement modalCurtain = driver.findElementByXPath("//aside");
            	if(!modalCurtain.equals(null))
            	new WebDriverWait(driver,5).until(ExpectedConditions.invisibilityOf(modalCurtain));
            	else {
            		//do nothing
            	}
            } catch(NullPointerException | org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException elemAside) {
            	//do nothing
            }
} 
        } catch (NoSuchElementException e) {
        	System.out.println("the operation is not blocked by Newsletter subscription modal.");
        }
    }
    
}

