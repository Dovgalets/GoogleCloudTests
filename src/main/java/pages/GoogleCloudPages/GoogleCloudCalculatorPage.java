package pages.GoogleCloudPages;

import base.EmptyPage;
import enums.NumberOfInstances;
import helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static enums.NumberOfInstances.*;

public class GoogleCloudCalculatorPage extends GoogleCloudAbstractPage {

    @FindBy(xpath = "//*[@id=\"cloud-site\"]/devsite-iframe/iframe")
    private static WebElement frameCalculator;

    @FindBy(xpath = "//iframe[@id=\"myFrame\"]")
    private static WebElement frameMyFrame;

    @FindBy(xpath = "//*[@id=\\\"mainForm\"]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[1]/div[1]/div/div[1]/div/div")
    private WebElement computeEngineButton;

    @FindBy(xpath = "//*[@id=\"input_55\"]")
    private WebElement inputInstancesNumber;

    @FindBy(id = "select_80")
    private WebElement inputMachineType;

    @FindBy(xpath = "//*[@id=\"select_value_label_172\"]/span[1]")
    private WebElement selectLocalSSD;

    @FindBy(xpath = "//*[@id=\"select_option_233\"]/div[1]")
    private WebElement select2_375;

    @FindBy(xpath = "//button[@class=\"md-raised md-primary cpc-button md-button md-ink-ripple\"]")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//*[contains(text(),\"Total Estimated\")]")
    private WebElement textOfLetter;

    @FindBy(id = "email_quote")
    private static WebElement eMailEstimateButton;

    @FindBy(xpath = "//button[contains(text(),\"Send Email\")]")
    private static WebElement sendEmailButton;

    @FindBy(xpath = "//label[contains(text(),\"Email\")]")
    private static WebElement label;

    public void selectComputeEngine() {
        WaitHelper.waitFrameToBeAvailableAndSwitchToIt(getDriver(), frameCalculator);
        WaitHelper.waitFrameToBeAvailableAndSwitchToIt(getDriver(), frameMyFrame);
        WaitHelper.waitElementToBeClickable(getDriver(), computeEngineButton);
        computeEngineButton.click();
    }

    public void inputConfiguration() {
        inputNumberOfInstances(FOUR);
        inputOperatingSystem();
        inputVMClass();
        inputInstanceType();
        addGPUs();
        selectLocalSSD();
        selectDatacenterLocation();
        selectCommitedUsage();
        pressAddToEstimateButton();
    }

    public String getEstimatedPrice() {
        return textOfLetter.getText();
    }

    protected static void sendEmailEstimate(String emailAddress) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", eMailEstimateButton);
        WebElement inputEMail = EmptyPage.getDriver().findElement(By.xpath("//*[@id=\"" + label.getAttribute("for") + "\"]"));
        inputEMail.sendKeys(emailAddress);
        executor.executeScript("arguments[0].click();", sendEmailButton);
        WaitHelper.waitInvisibilityOf(getDriver(), inputEMail);
    }

    protected static void switchToCalculatorFrame(String window) {
        EmptyPage.getDriver().switchTo().window(window).switchTo().frame(frameCalculator).switchTo().frame(frameMyFrame);
    }

    private void inputNumberOfInstances(NumberOfInstances number) {
        WaitHelper.waitVisibilityOf(getDriver(), inputInstancesNumber);
        inputInstancesNumber.sendKeys(number.getKeys());
    }

    private GoogleCloudCalculatorPage inputWhatAreTheseInstancesFor() {
        return this;
    }

    private GoogleCloudCalculatorPage inputOperatingSystem() {
        return this;
    }

    private GoogleCloudCalculatorPage inputVMClass() {
        return this;
    }

    private GoogleCloudCalculatorPage inputInstanceType() {
//        inputMachineType.click();
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//md-option[@id=\"select_option_208\"]/div[1]")));
        return this;
    }

    private GoogleCloudCalculatorPage addGPUs() {
//        WebElement addGPUs = driver.findElement(By.xpath("//*[@id=\"mainForm\"]/div[1]/div/md-card/md-card-content/div/div[1]/form/div[8]/div[1]/md-input-container/md-checkbox/div[1]"));
//        addGPUs.click();
//        WebElement selectGPUs = driver.findElement(By.xpath("//md-select-value[contains(@id,\"select_value_label_350\")]/span[2]"));
//        selectGPUs.click();
//        WebElement select1 = driver.findElement(By.xpath("//div[@class=\"md-text ng-binding\"][text=\"1\"]"));
//        select1.click();
//        WebElement selectGPUType = driver.findElement(By.xpath("//md-select-value[contains(@id,\"select_value_label_351\")]/span[2]"));
//        selectGPUType.click();
//        WebElement selectP100 = driver.findElement(By.xpath("//*[@id=\"select_option_364\"]/div[1]"));
//        selectP100.click();
//        selectGPUs.sendKeys(Keys.ARROW_DOWN);
//        selectGPUs.sendKeys(Keys.ENTER);
        return this;
    }


    private void selectLocalSSD() {
//        waitElementToBeClickable(selectLocalSSD)
//                .click();
//        waitElementToBeClickable(select2_375)
//                .click();
    }

    private void selectDatacenterLocation() {
//        WebElement selectDataCenterLocation = driver.findElement(By.xpath("//*[@id=\"select_value_label_52\"]"));
//        selectDataCenterLocation.click();
//        WebElement selectFrankfurt = driver.findElement(By.xpath("//*[@id=\"select_option_182\"]"));
//        selectFrankfurt.click();
    }

    private void selectCommitedUsage() {
//        WebElement selectCommittedUsage = driver.findElement(By.xpath("//*[@id=\"select_value_label_53\"]/span[1]"));
//        selectCommittedUsage.click();
//        WebElement select1Year = driver.findElement(By.xpath("//*[@id=\"select_option_86\"]"));
//        select1Year.click();
    }

    private void pressAddToEstimateButton() {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", addToEstimateButton);
    }
}
