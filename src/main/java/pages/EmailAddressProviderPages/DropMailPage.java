package pages.EmailAddressProviderPages;

import config.DriverTimeouts;
import helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropMailPage extends EmailAddressProviderPage {
    @FindBy(xpath = "//*[@class=\"email\"]")
    private WebElement address;

    //    @FindBy(xpath = "//span[text()=\"Google Cloud Platform Price Estimate\"]")
    @FindBy(xpath = "//*[@id=\"mail_messages_content\"]/div/div[1]")
    private WebElement newLetter;

    @FindBy(xpath = "//pre[contains(@data-bind,\"html\")]")
    private WebElement letterText;

    @Override
    public String getEMailAddress() {
        WaitHelper.waitVisibilityOf(getDriver(), address);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String eMailAddress = address.getText();
        return eMailAddress;
    }

    @Override
    public String getEMailText() {
        (new WebDriverWait(getDriver(), DriverTimeouts.MEDIUM_TIMEOUT.getSeconds()))
                .until((driver) -> letterText.getText().length() > 0);
        String textLetter = letterText.getText();

        return textLetter;
    }
}
