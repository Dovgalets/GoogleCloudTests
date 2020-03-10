package GoogleCloud;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleCloudCalculatorPage extends GoogleCloudAbstractPage {

    @FindBy(xpath = "//*[@id=\"cloud-site\"]/devsite-iframe/iframe")
    @CacheLookup
    private static WebElement frameCalculator;
    @FindBy(xpath = "//iframe[@id=\"myFrame\"]")
    @CacheLookup
    private static WebElement frameMyFrame;
    @FindBy(xpath = "//*[@id=\"mainForm\"]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[1]/div[1]/div/div[1]/div/div")
    private WebElement computeEngineButton;

    public GoogleCloudCalculatorPage selectComputeEngine() {
        waitFrameToBeAvailableAndSwitchToIt(frameCalculator);
        waitFrameToBeAvailableAndSwitchToIt(frameMyFrame);
        waitElementToBeClickable(computeEngineButton)
                .click();
        return this;
    }

    @FindBy(how = How.ID, using = "input_55")
    private WebElement inputInstances;

    public enum NumberOfInstances {
        FOUR(Keys.NUMPAD4);
        private Keys keys;

        NumberOfInstances(Keys keys) {
            this.keys = keys;
        }

        public Keys getKeys() {
            return keys;
        }
    }

    private GoogleCloudCalculatorPage inputNumberOfInstances(NumberOfInstances number) {
        waitVisibilityOf(inputInstances)
                .sendKeys(number.getKeys());
        return this;
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

    @FindBy(id = "select_80")
    private WebElement inputMachineType;

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

    @FindBy(xpath = "//*[@id=\"select_value_label_172\"]/span[1]")
    private WebElement selectLocalSSD;
    @FindBy(xpath = "//*[@id=\"select_option_233\"]/div[1]")
    private WebElement select2_375;

    private GoogleCloudCalculatorPage selectLocalSSD() {
//        waitElementToBeClickable(selectLocalSSD)
//                .click();
//        waitElementToBeClickable(select2_375)
//                .click();
        return this;
    }

    private GoogleCloudCalculatorPage selectDatacenterLocation() {
//        WebElement selectDataCenterLocation = driver.findElement(By.xpath("//*[@id=\"select_value_label_52\"]"));
//        selectDataCenterLocation.click();
//        WebElement selectFrankfurt = driver.findElement(By.xpath("//*[@id=\"select_option_182\"]"));
//        selectFrankfurt.click();
        return this;
    }

    private GoogleCloudCalculatorPage selectCommitedUsage() {
//        WebElement selectCommittedUsage = driver.findElement(By.xpath("//*[@id=\"select_value_label_53\"]/span[1]"));
//        selectCommittedUsage.click();
//        WebElement select1Year = driver.findElement(By.xpath("//*[@id=\"select_option_86\"]"));
//        select1Year.click();
        return this;
    }

    public GoogleCloudCalculatorPage inputConfiguration() {
        return inputNumberOfInstances(GoogleCloudCalculatorPage.NumberOfInstances.FOUR)
                .inputOperatingSystem()
                .inputVMClass()
                .inputInstanceType()
                .addGPUs()
                .selectLocalSSD()
                .selectDatacenterLocation()
                .selectCommitedUsage();
    }

    @FindBy(xpath = "//button[@class=\"md-raised md-primary cpc-button md-button md-ink-ripple\"]")
    private WebElement addToEstimateButton;

    public GoogleCloudCalculatorPage pressAddToEstimateButton() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", addToEstimateButton);
        return this;
    }

    @FindBy(xpath = "//*[contains(text(),\"Total Estimated\")]")
    private WebElement textOfLetter;

    public String getEstimatedPrice() {
        return textOfLetter.getText();
    }

    @FindBy(id = "email_quote")
    private static WebElement eMailEstimateButton;
    @FindBy(xpath = "//button[contains(text(),\"Send Email\")]")
    private static WebElement sendEmailButton;
    @FindBy(xpath = "//label[contains(text(),\"Email\")]")
    private static WebElement label;

    protected static void sendEmailEstimate(String emailAddress) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", eMailEstimateButton);
        WebElement inputEMail = getDriver().findElement(By.xpath("//*[@id=\"" + label.getAttribute("for") + "\"]"));
        inputEMail.sendKeys(emailAddress);
        executor.executeScript("arguments[0].click();", sendEmailButton);
        waitInvisibilityOf(inputEMail);
    }

     protected static void switchToCalculatorFrame(String window) {
        getDriver().switchTo().window(window).switchTo().frame(frameCalculator).switchTo().frame(frameMyFrame);
    }
}
