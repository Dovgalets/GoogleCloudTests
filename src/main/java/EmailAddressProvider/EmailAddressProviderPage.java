package EmailAddressProvider;

import BaseClasses.Component;

public abstract class EmailAddressProviderPage extends Component {
    public abstract EmailAddressProviderPage openPage();
    public abstract String getEMailAddress();
    public abstract String getEMailText();
}
