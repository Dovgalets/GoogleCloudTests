package BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class Component {

    protected static final int WAIT_TIMEOUT_SECONDS = 30;
    protected static WebDriver driver;

    public Component() {
        if (driver == null) {
            driver = WebDriverFactory.createWebDriver();
            driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        }
        PageFactory.initElements(driver, this);
    }

    protected static void open(String url) {
        driver.get(url);
    }

    protected static WebElement waitElementToBeClickable(WebElement element) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected static WebElement waitFrameToBeAvailableAndSwitchToIt(WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        return element;
    }

    protected static WebElement waitVisibilityOf(WebElement element) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected static void waitInvisibilityOf(WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.invisibilityOf(element));
    }

    public static WebElement waitElementToBeSelected(WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeSelected(element));
        return element;
    }

    public static void close() {
        getDriver().close();
    }

    public static void quit() {
        getDriver().quit();
    }

    protected static WebDriver getDriver() {
        return driver;
    }

    protected static void switchToTab(String window) {
        getDriver().switchTo().window(window);
    }
}
