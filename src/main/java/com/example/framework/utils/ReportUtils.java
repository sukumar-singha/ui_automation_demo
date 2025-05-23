package com.example.framework.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportUtils {
    private static final String SCREENSHOT_DIR = "test-output/screenshots/";
    
    static {
        try {
            Path screenshotDir = Paths.get(SCREENSHOT_DIR);
            if (!Files.exists(screenshotDir)) {
                Files.createDirectories(screenshotDir);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to create screenshots directory", e);
        }
    }
    
    public static String captureScreenshot(WebDriver driver, String testName) {
        if (driver == null) {
            return "No driver instance available for screenshot";
        }
        
        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filename = testName + "_" + timestamp + ".png";
            String filePath = SCREENSHOT_DIR + filename;
            
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destination = new File(filePath);
            Files.copy(source.toPath(), destination.toPath());
            
            return filePath;
        } catch (Exception e) {
            return "Failed to capture screenshot: " + e.getMessage();
        }
    }
    
    public static void logInfo(String message) {
        System.out.println("[INFO] " + message);
    }
    
    public static void logError(String message, Throwable throwable) {
        System.err.println("[ERROR] " + message);
        if (throwable != null) {
            throwable.printStackTrace();
        }
    }
}