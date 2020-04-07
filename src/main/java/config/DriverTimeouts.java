package config;

import java.time.Duration;

public class DriverTimeouts {
    public static final Duration SHORT_TIMEOUT = Duration.ofSeconds(5);
    public static final Duration MEDIUM_TIMEOUT = Duration.ofSeconds(10);
    public static final Duration LONG_TIMEOUT = Duration.ofSeconds(20);
}
