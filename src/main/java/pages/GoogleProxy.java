package pages;

import config.DriverTimeouts;
import helpers.TabsSwitchHelper;
import helpers.WaitHelper;
import pages.EmailAddressProviderPages.EmailAddressProviderPage;
import pages.GoogleCloudPages.GoogleCloudCalculatorPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class GoogleProxy extends GoogleCloudCalculatorPage {
    private static final int AMOUNT_TABS = 2;

    public static String getPriceFromLetter(EmailAddressProviderPage emailProvider) {
        TabsSwitchHelper.openNewTab();

        WaitHelper.waitNumberOfWindowsToBe(getDriver(),AMOUNT_TABS);

        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        TabsSwitchHelper.switchToTab(getDriver(),tabs.get(1));
        emailProvider.openPage();
        String address = emailProvider.getEMailAddress();

        GoogleCloudCalculatorPage.switchToCalculatorFrame(tabs.get(0));
        GoogleCloudCalculatorPage.sendEmailEstimate(address);
        TabsSwitchHelper.switchToTab(getDriver(),tabs.get(1));

        return emailProvider.getEMailText();
    }


}
