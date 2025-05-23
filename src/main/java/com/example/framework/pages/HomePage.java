package com.example.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    // Page locators
    private final By welcomeMessage = By.className("welcome-message");
    private final By logoutButton = By.id("logout");
    private final By userProfileIcon = By.id("user-profile");
    
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public String getWelcomeMessage() {
        return getText(welcomeMessage);
    }
    
    public boolean isUserLoggedIn() {
        return isElementDisplayed(userProfileIcon);
    }
    
    public LoginPage logout() {
        click(logoutButton);
        return new LoginPage(driver);
    }
    
    @Override
    public boolean isPageLoaded() {
        return isElementDisplayed(userProfileIcon);
    }
}