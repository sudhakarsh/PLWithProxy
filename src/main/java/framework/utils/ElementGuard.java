package framework.utils;

import java.lang.reflect.Proxy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ElementGuard {

    public static WebElement guard(RemoteWebDriver driver, WebElement element) {
        ElementProxy proxy = new ElementProxy(driver, element);
        WebElement wrappdElement = (WebElement) Proxy.newProxyInstance(ElementProxy.class.getClassLoader(),
                                                                       new Class[] { WebElement.class },
                                                                       proxy);
        return wrappdElement;
    }

}