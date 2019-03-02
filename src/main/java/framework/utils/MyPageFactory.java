package framework.utils;

import java.lang.reflect.Field;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyPageFactory {
    
    public static <T> void initElements(RemoteWebDriver driver, T pageobject){
        
        //first init elements
        PageFactory.initElements(driver, pageobject);
        
        //then access all the WebElements and create a wrapper
        for(Field f:pageobject.getClass().getDeclaredFields()){
            if(f.getType().equals(WebElement.class)){
                boolean accessible = f.isAccessible();
                f.setAccessible(true);
                //reset the webelement with proxy object
                try {
					f.set(pageobject, ElementGuard.guard(driver, (WebElement) f.get(pageobject)));
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                f.setAccessible(accessible);
            }  
        }

    }
    
}