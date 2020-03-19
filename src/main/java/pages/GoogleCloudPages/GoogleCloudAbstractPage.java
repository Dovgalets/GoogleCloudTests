package pages.GoogleCloudPages;

import base.AbstractPage;
import config.Utils;
import helpers.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class GoogleCloudAbstractPage extends AbstractPage {
    @FindBy(xpath = "//a[@href='/pricing']")
    private WebElement buttonPricing;

    public void openPage() {
        String url = Utils.getBaseUrl();
        open(url);
    }

    public void selectPricing() {
        WaitHelper.waitElementToBeClickable(driver, buttonPricing);
        buttonPricing.click();
    }
}
