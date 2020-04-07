package pages.EmailAddressProviderPages;

import config.DriverTimeouts;
import config.Utils;
import helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenMinuteMailPage extends EmailAddressProviderPage {

    @FindBy(id = "mail_address")
    private WebElement address;

    //    @FindBy(xpath = "//span[text()=\"Google Cloud Platform Price Estimate\"]")
    @FindBy(xpath = "//*[@id=\"mail_messages_content\"]/div/div[1]")
    private WebElement newLetter;

    @FindBy(xpath = "//*[@id=\"mobilepadding\"]/td/table/tbody/tr[2]/td[2]/h3")
    private WebElement letterText;

    @Override
    public String getEMailAddress() {
        WaitHelper.waitVisibilityOf(getDriver(), address);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String eMailAddress = address.getAttribute("value");
        System.out.println("Address from Page: " + eMailAddress);
        return eMailAddress;
    }

//    @FindBy(xpath = "//*[@id=\"adhesive_banner\"]/div[1]")
//    WebElement banner;

    @Override
    public String getEMailText() {
        (new WebDriverWait(getDriver(), DriverTimeouts.MEDIUM_TIMEOUT.getSeconds()))
                .until((d) -> d.findElement(By.xpath("//*[@id=\"inbox_count_number\"]")).getText().contains("1"));
        WaitHelper.waitElementToBeClickable(getDriver(), newLetter);

        String bannerXpath = "//iframe[contains(@id,\"google_ads_iframe_\")]";

        WebElement element = getDriver().findElement(By.xpath(bannerXpath));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.visibility='hidden'", element);

//        JavascriptExecutor js = null;
//        if (getDriver() instanceof JavascriptExecutor) {
//            js = (JavascriptExecutor) getDriver();
//        }
//        js.executeScript("return document.getElementsByClassName('review-info-star').remove();");
//        String bannerCloseXPath = "//*[@id=\"adhesive_banner\"]/div[1]";
//        if (!getDriver().findElements(By.xpath(bannerXpath)).isEmpty()) {
//            getDriver().findElement(By.xpath(bannerXpath))
//                    .findElement(By.xpath(bannerCloseXPath)).click();
//        }
//        if (!getDriver().findElements(By.xpath("/html/body/iframe[1]")).isEmpty()){
//            getDriver().findElement(By.xpath("/html/body/iframe[1]")).findElement(By.xpath(bannerXPath)).click();
//        }

        Actions actions = new Actions(getDriver());
        actions.moveToElement(newLetter).click().build().perform();

        String textLetter = letterText.getText();
        System.out.println("Text from Letter: " + textLetter);

//        newLetter.click();
        return textLetter;
    }

//    public void closeBanner()
}
