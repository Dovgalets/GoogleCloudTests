package enums;

import org.openqa.selenium.Keys;

public enum NumberOfInstances {
    FOUR(Keys.NUMPAD4);
    private Keys keys;

    NumberOfInstances(Keys keys) {
        this.keys = keys;
    }

    public Keys getKeys() {
        return keys;
    }
}
