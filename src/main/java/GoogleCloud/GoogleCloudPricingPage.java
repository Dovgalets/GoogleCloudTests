package GoogleCloud;

import BaseClasses.PageObjectsFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudPricingPage extends GoogleCloudAbstractPage {
    @FindBy(xpath = "//a[@href=\"/products/calculator\"]")
    private WebElement buttonCalculators;

    public GoogleCloudCalculatorPage selectCalculators() {
        waitElementToBeClickable(buttonCalculators).click();
        return PageObjectsFactory.createGoogleCloudCalculatorPage();
    }
}
