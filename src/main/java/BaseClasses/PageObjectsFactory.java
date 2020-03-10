package BaseClasses;

import EmailAddressProvider.EmailAddressProviderPage;
import EmailAddressProvider.TenMinuteMail;
import GoogleCloud.GoogleCloudCalculatorPage;
import GoogleCloud.GoogleCloudHomePage;
import GoogleCloud.GoogleCloudPricingPage;

public class PageObjectsFactory {
    public static GoogleCloudHomePage createGoogleCloudHomePage() {
        return new GoogleCloudHomePage();
    }

    public static GoogleCloudCalculatorPage createGoogleCloudCalculatorPage() {
        return new GoogleCloudCalculatorPage();
    }

    public static GoogleCloudPricingPage createGoogleCloudPricingPage() {
        return new GoogleCloudPricingPage();
    }

    public static EmailAddressProviderPage createEmailAddressProviderPage() {
        return new TenMinuteMail();
    }
}
