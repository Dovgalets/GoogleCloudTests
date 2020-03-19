package pages.GoogleCloudPages;

import helpers.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudPricingPage extends GoogleCloudCalculatorPage {

    @FindBy(xpath = "//a[@href=\"/products/calculator\"]")
    private WebElement buttonCalculators;

    public void selectCalculators() {
        WaitHelper.waitElementToBeClickable(getDriver(), buttonCalculators);
        buttonCalculators.click();
    }
}
