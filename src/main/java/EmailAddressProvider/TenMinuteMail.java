package EmailAddressProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenMinuteMail extends EmailAddressProviderPage {

    public EmailAddressProviderPage openPage() {
        open("https://10minutemail.com");
        return this;
    }

    @FindBy(id = "mail_address")
    private WebElement address;

    @Override
    public String getEMailAddress() {
        return waitVisibilityOf(address)
                .getAttribute("value");
    }

    @FindBy(xpath = "//span[text()=\"Google Cloud Platform Price Estimate\"]")
    private WebElement newLetter;
    @FindBy(xpath = "//*[@id=\"mobilepadding\"]/td/table/tbody/tr[2]/td[2]/h3")
    private WebElement letterText;

    @Override
    public String getEMailText() {
        (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until((d) -> d.findElement(By.xpath("//*[@id=\"inbox_count_number\"]")).getText().contains("1"));
        newLetter.click();
        return letterText.getText();
    }
}
