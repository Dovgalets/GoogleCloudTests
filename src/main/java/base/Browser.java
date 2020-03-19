package base;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public enum Browser {
    FIREFOX("gecko") {
        @Override
        public WebDriver getDriver() {
            webDriverManagerSetUp(DriverManagerType.FIREFOX);
            return new FirefoxDriver();
        }
    },
    IE("ie") {
        @Override
        public WebDriver getDriver() {
            webDriverManagerSetUp(DriverManagerType.IEXPLORER);
            return new InternetExplorerDriver();
        }
    },
    CHROME("chrome") {
        @Override
        public WebDriver getDriver() {
            webDriverManagerSetUp(DriverManagerType.CHROME);
            ChromeOptions options = new ChromeOptions();
            options.addArguments(
                    "start-maximized"
                    , "enable-automation"
//                    ,"--headless"
//                    ,"--proxy-server=http://proxy.lan:3128"
//                    ,"--disable-gpu"
            );
            return new ChromeDriver(options);
        }
    };

    public abstract WebDriver getDriver();
    private String browserName;

    Browser(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserName() {
        return browserName;
    }

    public static Browser fromString(String browserName) {
        for (Browser browser : values()) {
            if (browserName != null && browserName.equalsIgnoreCase(browser.getBrowserName())) {
                return browser;
            }
        }
        throw new IllegalArgumentException("You entered incorrect browser name. Please check.");
    }

    private static void webDriverManagerSetUp(DriverManagerType driverManagerType){
        WebDriverManager.getInstance(driverManagerType)
                .proxy("proxy.lan:3128")
                .setup();
    }
}