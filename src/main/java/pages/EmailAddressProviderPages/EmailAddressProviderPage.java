package pages.EmailAddressProviderPages;

import base.EmptyPage;

public abstract class EmailAddressProviderPage extends EmptyPage {
    
    public EmailAddressProviderPage() {
        initElements(this);
    }

    public abstract void openPage();

    public abstract String getEMailAddress();

    public abstract String getEMailText();
}
