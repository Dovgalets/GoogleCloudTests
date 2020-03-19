package steps;

import base.PageObjectsFactory;
import contexts.ScenarioContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.GoogleCloudPages.GoogleCloudPricingPage;
import pages.GoogleProxy;

import static org.junit.Assert.assertTrue;

public class GoogleCloudEventsSteps {
    private final GoogleCloudPricingPage homePage = PageObjectsFactory.createGoogleCloudPricingPage();;
    private final ScenarioContext scenarioContext = new ScenarioContext();

    @Given("^Open Google Cloud site$")
    public void openGoogleCloudSite() {
        homePage.openPage();
    }

    @When("^Select Pricing Calculator for Compute Engine$")
    public void selectPricingCalculatorForComputeEngine() {
        homePage.selectPricing();
        homePage.selectCalculators();
        homePage.selectComputeEngine();
    }

    @When("^Input required configuration$")
    public void inputRequiredConfiguration() {
        homePage.inputConfiguration();
    }

    @When("^Receive Price from the site$")
    public void receivePriceFromTheSite() {
        String estimatedPriceFromSite = homePage.getEstimatedPrice();
        scenarioContext.addContext(ScenarioContext.Context.PRICE_OF_PLATFORM_FROM_GOOGLE_CLOUD_SITE, estimatedPriceFromSite);

    }

    @When("^Receive Price from letter$")
    public void receivePriceFromLetter() {
        String estimatedPriceFromLetter = GoogleProxy.getPriceFromLetter(PageObjectsFactory.createEmailAddressProviderPage());
        scenarioContext.addContext(ScenarioContext.Context.PRICE_OF_PLATFORM_FROM_EMAIL, estimatedPriceFromLetter);
    }

    @Then("^Price from Site and Price from Letter should Coincide$")
    public void priceFromSiteAndPriceFromLetterShouldCoincide() {
        String amountFromSite = scenarioContext.getContext(ScenarioContext.Context.PRICE_OF_PLATFORM_FROM_EMAIL);
        String amountFromLetter = scenarioContext.getContext(ScenarioContext.Context.PRICE_OF_PLATFORM_FROM_EMAIL);

        assertTrue("The prices are not coincide!",amountFromSite.contains(amountFromLetter));
    }
}
