package base;

import pages.EmailAddressProviderPages.EmailAddressProviderPage;
import pages.EmailAddressProviderPages.TenMinuteMail;
import pages.GoogleCloudPages.GoogleCloudCalculatorPage;
import pages.GoogleCloudPages.GoogleCloudPricingPage;

public class PageObjectsFactory {

    public static GoogleCloudPricingPage createGoogleCloudPricingPage() {
        return new GoogleCloudPricingPage();
    }

    public static EmailAddressProviderPage createEmailAddressProviderPage() {
        return new TenMinuteMail();
    }
}
