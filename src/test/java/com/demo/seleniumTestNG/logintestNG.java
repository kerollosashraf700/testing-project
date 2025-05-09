package com.demo.seleniumTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class logintestNG {
    WebDriver auto;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kerol\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        auto = new ChromeDriver();
        auto.manage().window().maximize();
        auto.get("https://www.saucedemo.com");
    }

    public void loginWithUser(String username) {
        WebElement usernameField = auto.findElement(By.id("user-name"));
        WebElement passwordField = auto.findElement(By.id("password"));

        usernameField.sendKeys(username);
        passwordField.sendKeys("secret_sauce");

        auto.findElement(By.id("login-button")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void login1_standardUser() {
        loginWithUser("standard_user");
        Assert.assertTrue(auto.getCurrentUrl().contains("inventory.html"), "Login failed for standard_user");
    }

    @Test
    public void login3_problemUser() {
        loginWithUser("problem_user");
        Assert.assertTrue(auto.getCurrentUrl().contains("inventory.html"), "Login failed for problem_user");
    }

    @Test
    public void login4_performanceGlitchUser() {
        loginWithUser("performance_glitch_user");
        Assert.assertTrue(auto.getCurrentUrl().contains("inventory.html"), "Login failed for performance_glitch_user");
    }

    @Test
    public void login5_errorUser() {
        loginWithUser("error_user");
        Assert.assertTrue(auto.getCurrentUrl().contains("inventory.html"), "Login failed for error_user");
    }

    @Test
    public void login6_visualUser() {
        loginWithUser("visual_user");
        Assert.assertTrue(auto.getCurrentUrl().contains("inventory.html"), "Login failed for visual_user");
    }

    @Test
    public void login7_Lockoutuser() {
        loginWithUser("locked_out_user");
        WebElement errorMsg = auto.findElement(By.cssSelector("[data-test='error']"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not shown for locked_out_user");
        Assert.assertEquals(errorMsg.getText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @AfterMethod
    public void closeBrowser() {
        if (auto != null) {
            auto.quit();
        }
    }
}



