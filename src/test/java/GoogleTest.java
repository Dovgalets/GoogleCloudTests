import BaseClasses.PageObjectsFactory;
import GoogleCloud.GoogleCloudCalculatorPage;

import org.junit.*;

import static org.junit.Assert.assertTrue;

public class GoogleTest {
    private GoogleCloudCalculatorPage googleCloud;

    @Before
    public void initClasses() {
        googleCloud = PageObjectsFactory.createGoogleCloudCalculatorPage();
    }

    @Test
    public void openPage() {
        String estimatedPriceFromSite = googleCloud
                .openPage()
                .selectPricing()
                .selectCalculators()
                .selectComputeEngine()
                .inputConfiguration()
                .pressAddToEstimateButton()
                .getEstimatedPrice();

        String estimatedPriceFromLetter = GoogleProxy.getPriceFromLetter(PageObjectsFactory.createEmailAddressProviderPage());

        assertTrue(estimatedPriceFromSite.contains(estimatedPriceFromLetter));
    }

    @After
    public void closeBrowser() {
        googleCloud.quit();
    }

}
