package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import com.example.framework.config.ConfigReader;
import com.example.framework.data.UserData;
import com.example.framework.driver.DriverManager;
import com.example.framework.pages.HomePage;
import com.example.framework.pages.LoginPage;
import com.example.framework.utils.ReportUtils;

public class LoginTest {
    private WebDriver driver;
    
    @BeforeMethod
    public void setUp() {
        // Initialize configuration
        ConfigReader.initialize();
        
        // Get WebDriver instance
        driver = DriverManager.getDriver();
    }
    
    @Test
    public void testSuccessfulLogin() {
        // Log test start
        ReportUtils.logInfo("Starting successful login test");
        
        // Get test data using Builder Pattern
        UserData user = UserData.getStandardUser();
        
        // Use Page Object Model for test steps
        LoginPage loginPage = new LoginPage(driver);
        
        // Navigate to login page
        loginPage.open();
        
        // Verify login page is loaded
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded properly");
        
        // Perform login action
        HomePage homePage = loginPage
            .enterUsername(user.getUsername())
            .enterPassword(user.getPassword())
            .clickLoginButton();
        
        // Verify successful login
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded after login");
        Assert.assertTrue(homePage.isUserLoggedIn(), "User is not logged in successfully");
        
        String welcomeMessage = homePage.getWelcomeMessage();
        Assert.assertTrue(welcomeMessage.contains(user.getFirstName()), 
            "Welcome message does not contain user's first name");
        
        // Log test completion
        ReportUtils.logInfo("Login test completed successfully");
    }
    
    @AfterMethod
    public void tearDown() {
        // Quit WebDriver
        DriverManager.quitDriver();
    }
}