package com.example.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.example.framework.config.FrameworkConfig;

public class LoginPage extends BasePage {
    // Page locators
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login");
    private final By errorMessage = By.id("error-message");
    private final By loginForm = By.id("login-form");
    
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    public LoginPage open() {
        driver.get(FrameworkConfig.LOGIN_URL);
        return this;
    }
    
    public LoginPage enterUsername(String username) {
        sendKeys(usernameField, username);
        return this;
    }
    
    public LoginPage enterPassword(String password) {
        sendKeys(passwordField, password);
        return this;
    }
    
    public HomePage clickLoginButton() {
        click(loginButton);
        return new HomePage(driver);
    }
    
    public HomePage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        return clickLoginButton();
    }
    
    public String getErrorMessage() {
        return getText(errorMessage);
    }
    
    public boolean isLoginErrorDisplayed() {
        return isElementDisplayed(errorMessage);
    }
    
    @Override
    public boolean isPageLoaded() {
        return isElementDisplayed(loginForm);
    }
}