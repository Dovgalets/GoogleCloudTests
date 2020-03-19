package pages.EmailAddressProviderPages;

import config.DriverTimeouts;
import config.Utils;
import helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenMinuteMail extends EmailAddressProviderPage {

    @FindBy(id = "mail_address")
    private WebElement address;

    @FindBy(xpath = "//span[text()=\"Google Cloud Platform Price Estimate\"]")
    private WebElement newLetter;

    @FindBy(xpath = "//*[@id=\"mobilepadding\"]/td/table/tbody/tr[2]/td[2]/h3")
    private WebElement letterText;

    public void openPage() {
        String url = Utils.getEMailUrl();
        open(url);
    }

    @Override
    public String getEMailAddress() {
        WaitHelper.waitVisibilityOf(getDriver(), address);
        return address.getAttribute("value");
    }

    @Override
    public String getEMailText() {
        (new WebDriverWait(getDriver(), DriverTimeouts.MEDIUM_TIMEOUT.getSeconds()))
                .until((d) -> d.findElement(By.xpath("//*[@id=\"inbox_count_number\"]")).getText().contains("1"));
        WaitHelper.waitElementToBeClickable(getDriver(),newLetter);
        newLetter.click();
        return letterText.getText();
    }
}
