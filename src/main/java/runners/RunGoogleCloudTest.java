package runners;

import base.PageObjectsFactory;

import helpers.ExcelDataHelper;
import org.apache.commons.math3.util.Pair;
import pages.GoogleCloudPages.GoogleCloudPricingPage;
import pages.GoogleEmailProviderBridge;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class RunGoogleCloudTest {
    private GoogleCloudPricingPage homePage;
    List<Pair<String, String>> testOptionalParameters;
    @Before
    public void initClasses() {
        homePage = PageObjectsFactory.createGoogleCloudPricingPage();
        homePage.createDriver();
        homePage.initElements();
        testOptionalParameters = ExcelDataHelper
                .data(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\testData\\OptionalParameters.xlsx"
                        , "Sheet1", 1);
    }

    @Test
    public void openPage() {
        homePage.openPage();
        homePage.selectPricing();
        homePage.selectCalculators();
        homePage.selectComputeEngine();
        homePage.inputNumberOfInstances(4);
        homePage.inputConfiguration(testOptionalParameters);

        String estimatedPriceFromSite = homePage.getEstimatedPrice();

        String estimatedPriceFromLetter = GoogleEmailProviderBridge.getPriceFromLetter(PageObjectsFactory.createEmailAddressProviderPage());

        assertTrue("The prices are not coincide!", estimatedPriceFromLetter.contains(estimatedPriceFromSite));
    }

    @After
    public void closeBrowser() {
        homePage.tearDown();
    }

}
