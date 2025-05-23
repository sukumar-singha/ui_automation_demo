package com.example.framework.driver;

import org.openqa.selenium.WebDriver;
import com.example.framework.config.FrameworkConfig;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static String browserType = FrameworkConfig.BROWSER_TYPE;
    
    private DriverManager() {
        // Private constructor to prevent instantiation
    }
    
    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            WebDriver driver = DriverFactory.createDriver(browserType);
            driverThreadLocal.set(driver);
        }
        return driverThreadLocal.get();
    }
    
    public static void setBrowserType(String browser) {
        browserType = browser;
    }
    
    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}