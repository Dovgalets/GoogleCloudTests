package pages;

import config.DriverTimeouts;
import helpers.TabsSwitchHelper;
import helpers.WaitHelper;
import pages.EmailAddressProviderPages.EmailAddressProviderPage;
import pages.GoogleCloudPages.GoogleCloudCalculatorPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.GoogleCloudPages.GoogleCloudPricingPage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class GoogleEmailProviderBridge extends GoogleCloudPricingPage {
    private static final int AMOUNT_OF_TABS = 2;

    public static String getPriceFromLetter(EmailAddressProviderPage emailProvider) {
        TabsSwitchHelper.openNewTab();

        WaitHelper.waitNumberOfWindowsToBe(getDriver(),AMOUNT_OF_TABS);

        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        TabsSwitchHelper.switchToTab(getDriver(),tabs.get(1));
        emailProvider.openPage();
        String address = emailProvider.getEMailAddress();

        switchToCurrentFrame(tabs.get(0));
        sendEmailEstimate(address);
        TabsSwitchHelper.switchToTab(getDriver(),tabs.get(1));

        return emailProvider.getEMailText();
    }


}
