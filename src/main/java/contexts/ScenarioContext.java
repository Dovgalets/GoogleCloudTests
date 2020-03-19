package contexts;

import java.util.HashMap;
import java.util.Map;

import static java.util.Optional.ofNullable;

public class ScenarioContext {

    private Map<Context, Object> context;

    public ScenarioContext() {
        context = new HashMap<>();
    }

    public <T> void addContext(Context key, T value) {
        context.put(key, value);
    }

    public <T> T getContext(Context key) {
        return (T) ofNullable(context.get(key)).orElse(null);
    }

    public enum Context {
        PRICE_OF_PLATFORM_FROM_GOOGLE_CLOUD_SITE,
        PRICE_OF_PLATFORM_FROM_EMAIL;
    }
}
