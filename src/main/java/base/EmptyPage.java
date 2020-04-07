package base;

import config.DriverTimeouts;
import config.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class EmptyPage {

    private static WebDriver driver;

    public void createDriver() {
        if (driver == null) {
            driver = Browser.fromString(Utils.getBrowserName()).getDriver();
            driver.manage().timeouts().implicitlyWait(DriverTimeouts.MEDIUM_TIMEOUT.getSeconds(), TimeUnit.SECONDS);
        }
    }

    public void tearDown() {
        driver.quit();
        driver = null;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    protected void open(String url) {
        driver.get(url);
    }

    public void initElements() {
        PageFactory.initElements(driver, this);
    }
}
