package com.example.framework.config;

public class FrameworkConfig {
    // Browser configuration
    public static final String BROWSER_TYPE = ConfigReader.getProperty("browser", "chrome");
    public static final boolean HEADLESS = Boolean.parseBoolean(ConfigReader.getProperty("headless", "false"));
    
    // Application URLs
    public static final String BASE_URL = ConfigReader.getProperty("base.url", "https://example.com");
    public static final String LOGIN_URL = BASE_URL + ConfigReader.getProperty("login.path", "/login");
    
    // Timeouts (in seconds)
    public static final int IMPLICIT_WAIT = Integer.parseInt(ConfigReader.getProperty("timeout.implicit", "10"));
    public static final int EXPLICIT_WAIT = Integer.parseInt(ConfigReader.getProperty("timeout.explicit", "20"));
    public static final int PAGE_LOAD_TIMEOUT = Integer.parseInt(ConfigReader.getProperty("timeout.pageload", "30"));
    
    // Test data
    public static final String TEST_USERNAME = ConfigReader.getProperty("test.username", "testuser");
    public static final String TEST_PASSWORD = ConfigReader.getProperty("test.password", "password123");
}