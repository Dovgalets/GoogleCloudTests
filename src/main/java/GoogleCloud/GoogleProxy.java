package GoogleCloud;

import EmailAddressProvider.EmailAddressProviderPage;
import GoogleCloud.GoogleCloudCalculatorPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class GoogleProxy extends GoogleCloudCalculatorPage {
    private static final int AMOUNT_TABS = 2;
    private static final int WAIT_TABS_SECONDS = 10;

    public static String getPriceFromLetter(EmailAddressProviderPage emailProvider) {
        openNewTab();

        new WebDriverWait(getDriver(), WAIT_TABS_SECONDS)
                .until(ExpectedConditions.numberOfWindowsToBe(AMOUNT_TABS));

        List<String> tads = new ArrayList<>(getDriver().getWindowHandles());
        switchToTab(tads.get(1));

        String address = emailProvider.openPage().getEMailAddress();

        switchToCalculatorFrame(tads.get(0));
        sendEmailEstimate(address);
        switchToTab(tads.get(1));

        return emailProvider.getEMailText();
    }

    private static void openNewTab() {
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


}
