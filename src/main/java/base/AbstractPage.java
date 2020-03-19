package base;

import config.DriverTimeouts;
import config.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {

    protected static WebDriver driver;

    public AbstractPage() {
        if (driver == null) {
            String browserName = Utils.getBrowserName();
            driver = Browser.fromString(browserName).getDriver();
            driver.manage().timeouts().implicitlyWait(DriverTimeouts.MEDIUM_TIMEOUT.getSeconds(), TimeUnit.SECONDS);
        }
        PageFactory.initElements(driver, this);
    }

    public static void close() {
        driver.close();
    }

    public static void quit() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    protected static void open(String url) {
        driver.get(url);
    }
}
