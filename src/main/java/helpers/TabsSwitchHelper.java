package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TabsSwitchHelper {
    public static void openNewTab() {
        Robot rob;
        try {
            rob = new Robot();
            rob.keyPress(KeyEvent.VK_CONTROL);
            rob.keyPress(KeyEvent.VK_T);
            rob.keyRelease(KeyEvent.VK_CONTROL);
            rob.keyRelease(KeyEvent.VK_T);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void switchToTab(WebDriver driver, String window) {
        driver.switchTo().window(window);
    }

    public static void closeCurrentTab(WebDriver driver){
        driver.close();
    }
}
