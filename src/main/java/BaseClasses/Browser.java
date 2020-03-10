package BaseClasses;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public enum Browser {
    FIREFOX {
        @Override
        public WebDriver getDriver() {
            webDriverManagerSetUp(DriverManagerType.FIREFOX);
            return new FirefoxDriver();
        }
    },
    IE {
        @Override
        public WebDriver getDriver() {
            webDriverManagerSetUp(DriverManagerType.IEXPLORER);
            return new InternetExplorerDriver();
        }
    },
    CHROME {
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

    private static void webDriverManagerSetUp(DriverManagerType driverManagerType){
        WebDriverManager.getInstance(driverManagerType)
                .proxy("proxy.lan:3128")
                .setup();
    }



}