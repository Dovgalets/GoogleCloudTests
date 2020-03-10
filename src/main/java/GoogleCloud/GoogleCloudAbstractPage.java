package GoogleCloud;

import BaseClasses.Component;
import BaseClasses.PageObjectsFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class GoogleCloudAbstractPage extends Component {

    public GoogleCloudAbstractPage openPage() {
        open("https://cloud.google.com/");
        return this;
    }

    @FindBy(xpath = "//a[@href='/pricing']")
    private WebElement buttonPricing;

    public GoogleCloudPricingPage selectPricing() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(buttonPricing));
        buttonPricing.click();
        return PageObjectsFactory.createGoogleCloudPricingPage();
    }
}
