package steps;

import base.AbstractPage;
import base.PageObjectsFactory;
import pages.GoogleProxy;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class GoogleCloudEventsSteps {
//    private GoogleCloudCalculatorPage googleCloud = PageObjectsFactory.createGoogleCloudCalculatorPage();
//    @Given("^I open Google Cloud site$")
//    public void iOpenGoogleCloudSite() {
//        googleCloud.openPage();
//    }
//
//    @When("^I select Pricing and Calculators$")
//    public void iSelectPricingAndCalculators() {
//                googleCloud.selectPricing()
//                .selectCalculators();
//    }
//
//    @When("^I input configuration$")
//    public void iInputConfiguration() {
//                googleCloud.selectComputeEngine()
//                .inputConfiguration()
//                .pressAddToEstimateButton();
//    }
//
//    @Then("^Price from Site and Price from Letter should Coincide$")
//    public void priceFromSiteAndPriceFromLetterShouldCoincide() {
//        String estimatedPriceFromSite = googleCloud.getEstimatedPrice();
//        String estimatedPriceFromLetter = GoogleProxy.getPriceFromLetter(PageObjectsFactory.createEmailAddressProviderPage());
//
//        AbstractPage.quit();
//        assertTrue(estimatedPriceFromSite.contains(estimatedPriceFromLetter));
//    }
}
