package com.example.framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();
    private static boolean isInitialized = false;

    private ConfigReader() {
        // Private constructor to prevent instantiation
    }

    public static void initialize() {
        if (!isInitialized) {
            try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties")) {
                properties.load(fileInputStream);
                isInitialized = true;
            } catch (IOException e) {
                throw new RuntimeException("Failed to load config.properties file", e);
            }
        }
    }

    public static String getProperty(String key) {
        if (!isInitialized) {
            initialize();
        }
        String property = properties.getProperty(key);
        if (property == null) {
            throw new RuntimeException("Property " + key + " not found in config.properties");
        }
        return property;
    }

    public static String getProperty(String key, String defaultValue) {
        if (!isInitialized) {
            initialize();
        }
        return properties.getProperty(key, defaultValue);
    }
}