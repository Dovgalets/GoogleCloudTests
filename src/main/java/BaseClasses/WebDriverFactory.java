package BaseClasses;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Objects;

class WebDriverFactory {
    private static final String WEB_DRIVER_FOLDER = "webdrivers";

    static WebDriver createWebDriver() {
        Browser actualBrowser = Browser.fromString("chrome");
        String actualOSFileExtension = System.getProperty("os.name").toLowerCase().contains("win") ? ".exe" : "";
        String driverFileName = actualBrowser.getName() + "driver" + actualOSFileExtension;
        String driverFilePath = getWebDriverFolder(new File("").getAbsolutePath());
        System.setProperty("webdriver." + actualBrowser.getName() + ".driver", driverFilePath + driverFileName);
        return actualBrowser.getDriver();
    }

    private static String getWebDriverFolder(String path) {
        File file = new File(path);
        for (String item : Objects.requireNonNull(file.list())) {
            if (WEB_DRIVER_FOLDER.equals(item)) {
                return file.getAbsolutePath() + "/" + WEB_DRIVER_FOLDER + "/";
            }
        }
        return getWebDriverFolder(file.getParent());
    }
}
