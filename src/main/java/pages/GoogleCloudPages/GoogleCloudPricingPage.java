package pages.GoogleCloudPages;

import base.AbstractPage;
import base.PageObjectsFactory;
import helpers.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudPricingPage extends GoogleCloudCalculatorPage {

    @FindBy(xpath = "//a[@href=\"/products/calculator\"]")
    private WebElement buttonCalculators;

    public void selectCalculators() {
        WaitHelper.waitElementToBeClickable(driver, buttonCalculators);
        buttonCalculators.click();
    }
}
