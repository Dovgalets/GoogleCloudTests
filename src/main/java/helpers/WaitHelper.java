package helpers;

import config.DriverTimeouts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

    public static void waitElementToBeClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, DriverTimeouts.LONG_TIMEOUT.getSeconds())
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitFrameToBeAvailableAndSwitchToIt(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, DriverTimeouts.LONG_TIMEOUT.getSeconds())
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    public static void waitVisibilityOf(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, DriverTimeouts.LONG_TIMEOUT.getSeconds())
                .until(ExpectedConditions.visibilityOf(element));
    }


    public static void waitNumberOfWindowsToBe(WebDriver driver, int amountOfTabs){
        new WebDriverWait(driver, DriverTimeouts.MEDIUM_TIMEOUT.getSeconds())
                .until(ExpectedConditions.numberOfWindowsToBe(amountOfTabs));
    }
}
