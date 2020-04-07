package steps;

import base.PageObjectsFactory;
import contexts.ScenarioContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.ExcelDataHelper;
import org.apache.commons.math3.util.Pair;
import pages.GoogleCloudPages.GoogleCloudPricingPage;
import pages.GoogleEmailProviderBridge;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class GoogleCloudEventsSteps {
    private final GoogleCloudPricingPage homePage = PageObjectsFactory.createGoogleCloudPricingPage();
    ;
    private final ScenarioContext scenarioContext = new ScenarioContext();

    @Given("^Open Google Cloud site$")
    public void openGoogleCloudSite() {
        homePage.openPage();
        homePage.initElements();
    }

    @When("^Select Pricing Calculator for Compute Engine$")
    public void selectPricingCalculatorForComputeEngine() {
        homePage.selectPricing();
        homePage.selectCalculators();
        homePage.selectComputeEngine();
    }

    @And("^Input required configuration parameters \"([^\"]*)\"$")
    public void inputRequiredConfigurationParameters(String numberOfInstances) {
        homePage.inputNumberOfInstances(Integer.parseInt(numberOfInstances));
    }

    @When("Input optional configuration parameters from Excel file {string} sheet {string} raw {string}")
    public void input_optional_configuration_parameters_from_Excel_file_sheet_raw(String file, String sheet, String raw) {
        List<Pair<String, String>> testOptionalParameters = ExcelDataHelper
                .data(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\testData\\" + file
                        , sheet, Integer.parseInt(raw) - 1);

        homePage.inputConfiguration(testOptionalParameters);
    }

    @And("^Receive Price from the site$")
    public void receivePriceFromTheSite() {
        String estimatedPriceFromSite = homePage.getEstimatedPrice();
        scenarioContext.addContext(ScenarioContext.Context.PRICE_OF_PLATFORM_FROM_GOOGLE_CLOUD_SITE, estimatedPriceFromSite);

    }

    @And("^Receive Price from letter$")
    public void receivePriceFromLetter() {
        String estimatedPriceFromLetter = GoogleEmailProviderBridge.getPriceFromLetter(PageObjectsFactory.createEmailAddressProviderPage());
        scenarioContext.addContext(ScenarioContext.Context.PRICE_OF_PLATFORM_FROM_EMAIL, estimatedPriceFromLetter);
    }

    @Then("^Price from Site and Price from Letter should Coincide$")
    public void priceFromSiteAndPriceFromLetterShouldCoincide() {
        String amountFromLetter = scenarioContext.getContext(ScenarioContext.Context.PRICE_OF_PLATFORM_FROM_EMAIL);
        String amountFromSite = scenarioContext.getContext(ScenarioContext.Context.PRICE_OF_PLATFORM_FROM_GOOGLE_CLOUD_SITE);
        assertTrue("The prices are not coincide!", amountFromLetter.contains(amountFromSite));
    }
}
