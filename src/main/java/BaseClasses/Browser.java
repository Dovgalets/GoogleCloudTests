package BaseClasses;

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
            WebDriverManager.firefoxdriver()
                    .proxy("proxy.lan:3128")
                    .setup();
            return new FirefoxDriver();
        }
    },
    IE("ie") {
        @Override
        public WebDriver getDriver() {
            WebDriverManager.iedriver()
                    .proxy("proxy.lan:3128")
                    .setup();
            return new InternetExplorerDriver();
        }
    },
    CHROME("chrome") {
        @Override
        public WebDriver getDriver() {
            WebDriverManager.chromedriver()
                    .proxy("proxy.lan:3128")
                    .setup();
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

    private String name;

    Browser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Browser fromString(String browserName) {
        for (Browser browser : values()) {
            if (browserName != null && browserName.equalsIgnoreCase(browser.getName())) {
                return browser;
            }
        }
        return CHROME;
    }
}