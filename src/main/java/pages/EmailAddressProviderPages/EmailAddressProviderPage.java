package pages.EmailAddressProviderPages;

import base.EmptyPage;
import config.Utils;

public abstract class EmailAddressProviderPage extends EmptyPage {

    public EmailAddressProviderPage() {
        initElements();
    }

    public void openPage(){
        String url = Utils.getEMailUrl();
        open(url);
    }

    public abstract String getEMailAddress();

    public abstract String getEMailText();
}
