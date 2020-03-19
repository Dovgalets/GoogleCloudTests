package base;

import pages.EmailAddressProviderPages.EmailAddressProviderPage;
import pages.EmailAddressProviderPages.TenMinuteMail;
import pages.GoogleCloudPages.GoogleCloudPricingPage;

public class PageObjectsFactory {

    public static GoogleCloudPricingPage createGoogleCloudPricingPage() {
        GoogleCloudPricingPage googleCloudPricingPage = new GoogleCloudPricingPage();
        googleCloudPricingPage.createDriver();
        return googleCloudPricingPage;
    }

    public static EmailAddressProviderPage createEmailAddressProviderPage() {
        EmailAddressProviderPage emailAddressProviderPage = new TenMinuteMail();
        emailAddressProviderPage.createDriver();
        return emailAddressProviderPage;
    }
}
