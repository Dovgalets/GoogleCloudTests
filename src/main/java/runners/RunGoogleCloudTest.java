package runners;

import base.PageObjectsFactory;

import contexts.ScenarioContext;
import pages.GoogleCloudPages.GoogleCloudPricingPage;
import pages.GoogleProxy;
import org.junit.*;

import static org.junit.Assert.assertTrue;

public class RunGoogleCloudTest {
    private GoogleCloudPricingPage homePage;
    private final ScenarioContext scenarioContext = new ScenarioContext();

    @Before
    public void initClasses() {
        homePage = PageObjectsFactory.createGoogleCloudPricingPage();
        homePage.createDriver();
    }

    @Test
    public void openPage() {
        homePage.openPage();
        homePage.selectPricing();
        homePage.selectCalculators();
        homePage.selectComputeEngine();
        homePage.inputConfiguration();

        String estimatedPriceFromSite = homePage.getEstimatedPrice();
        scenarioContext.addContext(ScenarioContext.Context.PRICE_OF_PLATFORM_FROM_GOOGLE_CLOUD_SITE, estimatedPriceFromSite);

        String estimatedPriceFromLetter = GoogleProxy.getPriceFromLetter(PageObjectsFactory.createEmailAddressProviderPage());
        scenarioContext.addContext(ScenarioContext.Context.PRICE_OF_PLATFORM_FROM_EMAIL, estimatedPriceFromLetter);

        String amountFromSite = scenarioContext.getContext(ScenarioContext.Context.PRICE_OF_PLATFORM_FROM_EMAIL);
        String amountFromLetter = scenarioContext.getContext(ScenarioContext.Context.PRICE_OF_PLATFORM_FROM_EMAIL);

        assertTrue("The prices are not coincide!",amountFromSite.contains(amountFromLetter));
    }

    @After
    public void closeBrowser() {
        homePage.shutUp();
    }

}
