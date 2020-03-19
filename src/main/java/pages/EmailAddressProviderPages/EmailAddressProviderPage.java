package pages.EmailAddressProviderPages;

import base.AbstractPage;

public abstract class EmailAddressProviderPage extends AbstractPage {
    public abstract void openPage();
    public abstract String getEMailAddress();
    public abstract String getEMailText();
}
