package com.example.framework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.framework.config.FrameworkConfig;

import java.time.Duration;

public class WaitUtils {
    
    public static WebElement waitForElementVisible(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConfig.EXPLICIT_WAIT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public static WebElement waitForElementClickable(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConfig.EXPLICIT_WAIT));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    public static boolean waitForUrlToContain(WebDriver driver, String urlFraction) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConfig.EXPLICIT_WAIT));
        return wait.until(ExpectedConditions.urlContains(urlFraction));
    }
    
    public static boolean waitForTitleToContain(WebDriver driver, String titleFraction) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConfig.EXPLICIT_WAIT));
        return wait.until(ExpectedConditions.titleContains(titleFraction));
    }
}