package com.example.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.framework.config.FrameworkConfig;
import com.example.framework.utils.WaitUtils;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConfig.EXPLICIT_WAIT));
        PageFactory.initElements(driver, this);
    }
    
    protected WebElement waitForElementVisible(By locator) {
        return WaitUtils.waitForElementVisible(driver, locator);
    }
    
    protected WebElement waitForElementClickable(By locator) {
        return WaitUtils.waitForElementClickable(driver, locator);
    }
    
    protected void click(By locator) {
        waitForElementClickable(locator).click();
    }
    
    protected void sendKeys(By locator, String text) {
        WebElement element = waitForElementVisible(locator);
        element.clear();
        element.sendKeys(text);
    }
    
    protected String getText(By locator) {
        return waitForElementVisible(locator).getText();
    }
    
    protected boolean isElementDisplayed(By locator) {
        try {
            return waitForElementVisible(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public abstract boolean isPageLoaded();
}