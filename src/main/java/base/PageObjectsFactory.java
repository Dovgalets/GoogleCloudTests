package base;

import pages.EmailAddressProviderPages.DropMailPage;
import pages.EmailAddressProviderPages.EmailAddressProviderPage;
import pages.GoogleCloudPages.GoogleCloudPricingPage;

public class PageObjectsFactory {

    public static GoogleCloudPricingPage createGoogleCloudPricingPage() {
        GoogleCloudPricingPage googleCloudPricingPage = new GoogleCloudPricingPage();
        googleCloudPricingPage.createDriver();
        return googleCloudPricingPage;
    }

    public static EmailAddressProviderPage createEmailAddressProviderPage() {
        EmailAddressProviderPage emailAddressProviderPage = new DropMailPage();
        emailAddressProviderPage.createDriver();
        return emailAddressProviderPage;
    }
}
