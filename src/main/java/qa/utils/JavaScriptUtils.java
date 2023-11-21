package qa.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {
	
	

  

    // Method to execute JavaScript code
    public static void executeScript(WebDriver driver ,String script) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(script);
    }
    public static void flash(WebDriver driver ,WebElement element) {
    	
    }

    // Method to click an element using JavaScript
    public static void clickElementByJS(WebDriver driver ,WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    // Method to scroll to an element using JavaScript
    public static void scrollToElement(WebDriver driver ,WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Method to scroll down the page using JavaScript
    public static void scrollPageDown(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    
    // Add more methods for various JavaScript actions as needed

}
